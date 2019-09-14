/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class SeguimientoDto {
    private BigDecimal id;
    private Date fecha; //dia en que se hizo el seguimiento
    private BigInteger avanse; //% del avanse
    private BigInteger version;
    Proyecto proyecto;
    //metodos
    //get and set

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getAvanse() {
        return avanse;
    }

    public void setAvanse(BigInteger avanse) {
        this.avanse = avanse;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    //constructores

    public SeguimientoDto() {
    }

    public SeguimientoDto(BigDecimal id, Date fecha, BigInteger avanse, BigInteger version, Proyecto proyecto) {
        this.id = id;
        this.fecha = fecha;
        this.avanse = avanse;
        this.version = version;
        this.proyecto = proyecto;
    }
    public SeguimientoDto(Seguimiento seguimiento){
        this.id=seguimiento.getSegId();
        this.fecha = seguimiento.getSegFecha();
        this.avanse= seguimiento.getSegAvance();
        this.version= seguimiento.getSegVersion();
        this.proyecto= seguimiento.getPryId();
    }
    public Seguimiento getModel(){
        return new Seguimiento(id, fecha, avanse, version);
    }
    
}
