/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "ProyectoDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ProyectoDto {
    private Long id;
    private String nombre;
    private String patrocinador;
    private String liderUsuario;
    private String liderTectnico;
    private String inicioEsperado;
    private String finalEsperado;
    private String estado;
    private String correoLiderUsuario;
    private String correoLiderTecnico;
    private String correoPatrocinador;
    private Long version;
    private String inicioReal;
    private String finalReal;
    
    
    //constructores

    public ProyectoDto() {
    }

    public ProyectoDto(Long id, String nombre, String patrocinador, String liderUsuario, String liderTectnico, String inicioEsperado, String finalEsperado, String estado, String correoLiderUsuario, String correoLiderTecnico, String correoPatrocinador, Long version, String inicioReal, String finalReal) {
        this.id = id;
        this.nombre = nombre;
        this.patrocinador = patrocinador;
        this.liderUsuario = liderUsuario;
        this.liderTectnico = liderTectnico;
        this.inicioEsperado = inicioEsperado;
        this.finalEsperado = finalEsperado;
        this.estado = estado;
        this.correoLiderUsuario = correoLiderUsuario;
        this.correoLiderTecnico = correoLiderTecnico;
        this.correoPatrocinador = correoPatrocinador;
        this.version = version;
        this.inicioReal = inicioReal;
        this.finalReal = finalReal;
    }

    
    public ProyectoDto(Proyecto proyecto){
        this.id = proyecto.getPryId();
        this.nombre = proyecto.getPryNombre();
        this.patrocinador = proyecto.getPryPatrocinador();
        this.liderUsuario = proyecto.getPryLiderusuario();
        this.liderTectnico = proyecto.getPyrLidertecnico();
        if (proyecto.getPryInicioreal()!= null && proyecto.getPryFinalesperado()!= null && proyecto.getPryFinalesperado()!= null) {
            LocalDateTime localDateTime = proyecto.getPryFinalesperado().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            this.finalEsperado = localDateTime.toLocalTime().toString();

            LocalDateTime localDateTime2 = proyecto.getPryFinalreal().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            this.finalReal = localDateTime2.toLocalTime().toString();
            
            LocalDateTime localDateTime3 = proyecto.getPryInicioreal().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            this.inicioReal = localDateTime3.toLocalTime().toString();
            
            LocalDateTime localDateTime4 = proyecto.getPyrInicioesperado().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            this.inicioEsperado = localDateTime3.toLocalTime().toString();
        }
        this.correoLiderTecnico= proyecto.getPryCorreotenico();
        this.correoLiderUsuario = proyecto.getPryCorreousuario();
        this.correoPatrocinador = proyecto.getPryCorreopatrocinador();
        this.version = proyecto.getPryVersion();
        this.estado= proyecto.getPryEstado();           
    }
    /*public Proyecto getModel(){
        return new Proyecto(id, nombre, patrocinador, liderUsuario, liderTectnico, inicioEsperado, finalEsperado, estado, correoLiderUsuario, correoLiderTecnico, correoPatrocinador, version);
    }*/
    
    
    //metodos
    //get and set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getLiderUsuario() {
        return liderUsuario;
    }

    public void setLiderUsuario(String liderUsuario) {
        this.liderUsuario = liderUsuario;
    }

    public String getLiderTectnico() {
        return liderTectnico;
    }

    public void setLiderTectnico(String liderTectnico) {
        this.liderTectnico = liderTectnico;
    }

    public String getInicioEsperado() {
        return inicioEsperado;
    }

    public void setInicioEsperado(String inicioEsperado) {
        this.inicioEsperado = inicioEsperado;
    }

    public String getFinalEsperado() {
        return finalEsperado;
    }

    public void setFinalEsperado(String finalEsperado) {
        this.finalEsperado = finalEsperado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreoLiderUsuario() {
        return correoLiderUsuario;
    }

    public void setCorreoLiderUsuario(String correoLiderUsuario) {
        this.correoLiderUsuario = correoLiderUsuario;
    }

    public String getCorreoLiderTecnico() {
        return correoLiderTecnico;
    }

    public void setCorreoLiderTecnico(String correoLiderTecnico) {
        this.correoLiderTecnico = correoLiderTecnico;
    }

    public String getCorreoPatrocinador() {
        return correoPatrocinador;
    }

    public void setCorreoPatrocinador(String correoPatrocinador) {
        this.correoPatrocinador = correoPatrocinador;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getInicioReal() {
        return inicioReal;
    }

    public void setInicioReal(String inicioReal) {
        this.inicioReal = inicioReal;
    }

    public String getFinalReal() {
        return finalReal;
    }

    public void setFinalReal(String finalReal) {
        this.finalReal = finalReal;
    }
    
    
}
