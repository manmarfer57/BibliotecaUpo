/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author josel
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entidades.service.AutorFacadeREST.class);
        resources.add(entidades.service.CategoriaFacadeREST.class);
        resources.add(entidades.service.EditorialFacadeREST.class);
        resources.add(entidades.service.IdiomaFacadeREST.class);
        resources.add(entidades.service.LibroFacadeREST.class);
        resources.add(entidades.service.OrdenadorFacadeREST.class);
        resources.add(entidades.service.PortatilFacadeREST.class);
        resources.add(entidades.service.RecursoFacadeREST.class);
        resources.add(entidades.service.RefuerzoFacadeREST.class);
        resources.add(entidades.service.ReservaFacadeREST.class);
        resources.add(entidades.service.RolFacadeREST.class);
        resources.add(entidades.service.SalaFacadeREST.class);
        resources.add(entidades.service.SistemaOperativoFacadeREST.class);
        resources.add(entidades.service.UsuarioFacadeREST.class);
        resources.add(servicios.EmailAutomatizado.class);
    }
    
}
