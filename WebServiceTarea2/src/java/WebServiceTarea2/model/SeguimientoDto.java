/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.util.Date;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class SeguimientoDto {
    private Long id;
    private Date fecha; //dia en que se hizo el seguimiento
    private Double avance; //% del avance
    private Long version;
    ProyectoDto proyecto;

    //constructores

    public SeguimientoDto() {
    }

    public SeguimientoDto(Long id, Date fecha, Double avance, Long version, ProyectoDto proyecto) {
        this.id = id;
        this.fecha = fecha;
        this.avance = avance;
        this.version = version;
        this.proyecto = proyecto;
    }
    public SeguimientoDto(Seguimiento seguimiento){
        this.id=seguimiento.getSegId();
        this.fecha = seguimiento.getSegFecha();
        this.avance= seguimiento.getSegAvance();
        this.version= seguimiento.getSegVersion();
        this.proyecto=  new ProyectoDto(seguimiento.getPryId());
    }
    public Seguimiento getModel(){
        return new Seguimiento(id, fecha, avance, version);
    }
    //metodos
    //get and set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getAvance() {
        return avance;
    }

    public void setAvance(Double avance) {
        this.avance = avance;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ProyectoDto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDto proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
