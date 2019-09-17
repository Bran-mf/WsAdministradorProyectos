/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import WebServiceTarea2.util.LocalDateAdapter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class ActividadesDto {
    private Long id;
    private String descripcion;
    private String encargado;
    private String estado;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate inicioEsperado;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate finalEsperado;
    private Integer orden;
    private Long version;
    private ProyectoDto proyecto;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate finalReal;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate inicioReal;
    //metodos
    //get and set

    
    public ActividadesDto(Long id, String descripcion, String estado, LocalDate inicioEsperado, LocalDate finalEsperado, Integer orden, Long version) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.inicioEsperado = inicioEsperado;
        this.finalEsperado = finalEsperado;
        this.orden = orden;
        this.version = version;
    }
    //constructores
    public ActividadesDto() {
    }
    public ActividadesDto(Actividades actividades){
        this.id =  actividades.getActId();
        this.descripcion = actividades.getActDescripcion();
        this.estado = actividades.getActEstado();
        this.inicioEsperado = actividades.getActInicioesperado().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.finalEsperado = actividades.getActFinalesperado().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.finalReal = actividades.getActFinalreal().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.inicioReal = actividades.getActInicioreal().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.orden = actividades.getActOrden();
        this.version = actividades.getActVersion();
        this.encargado = actividades.getActEncargado();
        this.proyecto = new ProyectoDto(actividades.getPryId());
    }
    /*public Actividades getModel(){
        return new Actividades(id, descripcion, estado, estado, inicioEsperado, finalEsperado, orden, version);
    }*/

    public ProyectoDto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDto proyecto) {
        this.proyecto = proyecto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getFinalReal() {
        return finalReal;
    }

    public void setFinalReal(LocalDate finalReal) {
        this.finalReal = finalReal;
    }

    public LocalDate getInicioReal() {
        return inicioReal;
    }

    public void setInicioReal(LocalDate inicioReal) {
        this.inicioReal = inicioReal;
    }
    

    
    
}
