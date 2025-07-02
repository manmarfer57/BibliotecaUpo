/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author josel
 */
@Path("emailAutomatizado")
public class EmailAutomatizado {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmailAutomatizado
     */
    public EmailAutomatizado() {
    }

    /**
     * Retrieves representation of an instance of servicios.EmailAutomatizado
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String enviarCorreo(@QueryParam(value = "destinatario") String destinatario, @QueryParam(value = "asunto") String asunto, @QueryParam(value = "texto") String texto) {
        //TODO return proper representation object
        // Información de autenticación
        final String username = "biblioupo44@gmail.com";
        final String password = "isoa glst pkmx osiq";

        // Propiedades de la sesión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crear una sesión con autenticación
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(texto);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("¡El correo fue enviado correctamente!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "<h1></h1>";
    }

}
