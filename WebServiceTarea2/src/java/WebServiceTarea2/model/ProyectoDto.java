/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.time.LocalDate;
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
    private LocalDate inicioEsperado;
    private LocalDate finalEsperado;
    private String estado;
    private String correoLiderUsuario;
    private String correoLiderTecnico;
    private String correoPatrocinador;
    private Long version;
    private LocalDate inicioReal;
    private LocalDate finalReal;
    
    
    //constructores

    public ProyectoDto() {
    }

    public ProyectoDto(Long id, String nombre, String patrocinador, String liderUsuario, String liderTectnico, LocalDate inicioEsperado, LocalDate finalEsperado, String estado, String correoLiderUsuario, String correoLiderTecnico, String correoPatrocinador, Long version, LocalDate inicioReal, LocalDate finalReal) {
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
        this.finalEsperado = proyecto.getPryFinalesperado().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.finalReal = proyecto.getPryFinalreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.inicioReal = proyecto.getPryInicioreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.inicioEsperado = proyecto.getPyrInicioesperado().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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

    public LocalDate getInicioEsperado() {
        return inicioEsperado;
    }

    public void setInicioEsperado(LocalDate inicioEsperado) {
        this.inicioEsperado = inicioEsperado;
    }

    public LocalDate getFinalEsperado() {
        return finalEsperado;
    }

    public void setFinalEsperado(LocalDate finalEsperado) {
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

    public LocalDate getInicioReal() {
        return inicioReal;
    }

    public void setInicioReal(LocalDate inicioReal) {
        this.inicioReal = inicioReal;
    }

    public LocalDate getFinalReal() {
        return finalReal;
    }

    public void setFinalReal(LocalDate finalReal) {
        this.finalReal = finalReal;
    }
    
    
}
