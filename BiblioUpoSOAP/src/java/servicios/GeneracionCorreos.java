package servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.QueryParam;

@WebService(serviceName = "GeneracionCorreos")
public class GeneracionCorreos {
    

    @WebMethod(operationName = "generarCorreo")
    public String generarCorreo(@QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos, @QueryParam("rol") String rol) {
        String inicialesNombre = obtenerIniciales(nombre);

        String tresLetrasApellidos = obtenerTresLetras(apellidos);

        String dominio = obtenerDominioPorRol(rol);

        String correo = inicialesNombre + tresLetrasApellidos + "@" + dominio;

        return correo;
    }

    private String obtenerIniciales(String nombre) {
        StringBuilder iniciales = new StringBuilder();
        for (String parte : nombre.split(" ")) {
            if (!parte.isEmpty()) {
                iniciales.append(parte.charAt(0));
            }
        }
        return iniciales.toString().toLowerCase();
    }

    private String obtenerTresLetras(String apellidos) {
        StringBuilder tresLetras = new StringBuilder();
        for (String parte : apellidos.split(" ")) {
            if (parte.length() >= 3) {
                tresLetras.append(parte.substring(0, 3));
            } else {
                tresLetras.append(parte);
            }
        }
        return tresLetras.toString().toLowerCase();
    }

    private String obtenerDominioPorRol(String rol) {
        switch (rol) {
            case "Administrador":
                return "admin.upo.es";
            case "Estudiante":
                return "alu.upo.es";
            case "Profesor":
                return "prof.upo.es";
            case "Empleado":
                return "emp.upo.es";
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }
    }
    
    @WebMethod(operationName = "subirImagen")
    public String subirImagen(@QueryParam("isbn") String isbn, @QueryParam("imagen") File imagen) {

        String ruta = "/images";

        String nombreImagen = isbn + ".jpg";
        File archivoDestino = new File(ruta, nombreImagen);

        try {
            File directory = new File(ruta);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Guardar el archivo
            try (FileOutputStream fos = new FileOutputStream(archivoDestino);
                    FileInputStream fis = new FileInputStream(imagen)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }

            return "Archivo subido exitosamente";
        } catch (IOException e) {
            return "Error al subir el archivo: " + e.getMessage();
        }
    }
}
