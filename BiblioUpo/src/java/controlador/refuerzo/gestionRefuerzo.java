/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.refuerzo;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Recurso;
import entidades.Refuerzo;
import entidades.Sala;
import entidades.Usuario;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.core.GenericType;
import servicios.RefuerzoJerseyClient;
import servicios.SalaJerseyClient;
import servicios.UsuarioJerseyClient;

/**
 *
 * @author Jose
 */
public class gestionRefuerzo extends ActionSupport{

    private String operacion;
    
    private RefuerzoJerseyClient refuerzoClient = new RefuerzoJerseyClient();
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private SalaJerseyClient salaClient = new SalaJerseyClient();
    
    private Refuerzo refuerzo;

    private String id;
    private String descripcion;
    private String asigantura;
    private String tipo;
    private Recurso recurso;
    private Usuario usuario;
    private Sala sala;

    private String idRecurso;
    private String dniUsuario;
    private String idSala;

    private List<Refuerzo> refuerzos;
    private List<Usuario> usuarios;
    private List<Sala> salas;

    GenericType<List<Usuario>> gtu = new GenericType<List<Usuario>>() {};
    GenericType<List<Refuerzo>> gtr = new GenericType<List<Refuerzo>>() {};
    GenericType<List<Sala>> gts = new GenericType<List<Sala>>() {};

    public gestionRefuerzo() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsigantura() {
        return asigantura;
    }

    public void setAsigantura(String asigantura) {
        this.asigantura = asigantura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public List<Refuerzo> getRefuerzos() {
        return refuerzos;
    }

    public void setRefuerzos(List<Refuerzo> refuerzos) {
        this.refuerzos = refuerzos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public GenericType<List<Usuario>> getGtu() {
        return gtu;
    }

    public void setGtu(GenericType<List<Usuario>> gtu) {
        this.gtu = gtu;
    }

    public GenericType<List<Refuerzo>> getGtr() {
        return gtr;
    }

    public void setGtr(GenericType<List<Refuerzo>> gtr) {
        this.gtr = gtr;
    }

    public GenericType<List<Sala>> getGts() {
        return gts;
    }

    public void setGts(GenericType<List<Sala>> gts) {
        this.gts = gts;
    }

    public RefuerzoJerseyClient getRefuerzoClient() {
        return refuerzoClient;
    }

    public void setRefuerzoClient(RefuerzoJerseyClient refuerzoClient) {
        this.refuerzoClient = refuerzoClient;
    }

    public UsuarioJerseyClient getUsuarioClient() {
        return usuarioClient;
    }

    public void setUsuarioClient(UsuarioJerseyClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public SalaJerseyClient getSalaClient() {
        return salaClient;
    }

    public void setSalaClient(SalaJerseyClient salaClient) {
        this.salaClient = salaClient;
    }

    public String execute() throws Exception {
        salas = (List<Sala>)salaClient.findAll_XML(gts.getClass());
        usuarios = (List<Usuario>)usuarioClient.findAll_XML(gtu.getClass());
        if (getId() != null) {
            refuerzo = refuerzoClient.find_XML(Refuerzo.class, getId());
        }
        return operacion;
    }
    
    public String alta() throws ParseException {
        
        refuerzoClient.create_XML("<refuerzo>"
            + "<id>"+getId()+"</id>"
            + "<descripcion>"+getDescripcion()+"</descripcion>"    
            + "<asignatura>"+getAsigantura()+"</asignatura>"  
            + "<tipo>"+getTipo()+"</tipo>" 
            + "<id_recurso>"+getRecurso().getId()+"</id_recurso>"
            + "<dni_usuario>"+getUsuario().getDni()+"</dni_usuario>"
            + "<nombre_sala>"+getSala().getNombre()+"</nombre_sala>" 
            + "</refuerzo>"
        );
        
        refuerzos = (List<Refuerzo>)refuerzoClient.findAll_XML(gtr.getClass());
        
        return SUCCESS;
    }
    
    public String baja() {
        refuerzoClient.remove(getId());
        
        refuerzos = (List<Refuerzo>)refuerzoClient.findAll_XML(gtr.getClass());
        
        return SUCCESS;
    }

    public String consultar() {
        refuerzo = refuerzoClient.find_XML(Refuerzo.class, getId());
        return SUCCESS;
    }
    
    public String modificar() throws ParseException {
        refuerzo = refuerzoClient.find_XML(Refuerzo.class, getId());
        
        refuerzo.setAsignatura(getAsigantura());
        refuerzo.setDescripcion(getDescripcion());
        refuerzo.setTipo(getTipo());
        refuerzo.setDniUsuario(getUsuario());
        refuerzo.setIdRecurso(getRecurso());
        refuerzo.setNombreSala(getSala());
        
        refuerzos = (List<Refuerzo>)refuerzoClient.findAll_XML(gtr.getClass());
        return SUCCESS;
    }
}
