/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

/**
 * Jersey REST client generated for REST resource:we [emailAutomatizado]<br>
 * USAGE:
 * <pre>
 *        EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author josel
 */
public class EmailAutomaticoJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:43232/BiblioUpoRESTful/webresources/";

    public EmailAutomaticoJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("emailAutomatizado");
    }

    /**
     * @param responseType Class representing the response
     * @param destinatario query parameter
     * @param asunto query parameter
     * @param texto query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T enviarCorreo(Class<T> responseType, String destinatario, String asunto, String texto) throws ClientErrorException {
        String[] queryParamNames = new String[]{"destinatario", "asunto", "texto"};
        String[] queryParamValues = new String[]{destinatario, asunto, texto};
        ;
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        return webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(responseType);
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }
    
}
