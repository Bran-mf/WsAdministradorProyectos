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
public class ActividadesDto {
    private BigDecimal id;
    private String descripcion;
    private String estado;
    private Date inicioEsperado;
    private Date finalEsperado;
    private BigInteger orden;
    private BigInteger version;
    private Date finalReal;
    private Date inicioReal;
    //metodos
    //get and set

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Date getInicioEsperado() {
        return inicioEsperado;
    }

    public void setInicioEsperado(Date inicioEsperado) {
        this.inicioEsperado = inicioEsperado;
    }

    public Date getFinalEsperado() {
        return finalEsperado;
    }

    public void setFinalEsperado(Date finalEsperado) {
        this.finalEsperado = finalEsperado;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Date getFinalReal() {
        return finalReal;
    }

    public void setFinalReal(Date finalReal) {
        this.finalReal = finalReal;
    }

    public Date getInicioReal() {
        return inicioReal;
    }

    public void setInicioReal(Date inicioReal) {
        this.inicioReal = inicioReal;
    }
    //constructores

    public ActividadesDto() {
    }

    public ActividadesDto(BigDecimal id, String descripcion, String estado, Date inicioEsperado, Date finalEsperado, BigInteger orden, BigInteger version) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.inicioEsperado = inicioEsperado;
        this.finalEsperado = finalEsperado;
        this.orden = orden;
        this.version = version;
    }
    public ActividadesDto(Actividades actividades){
        this.id =  actividades.getActId();
        this.descripcion = actividades.getActDescripcion();
        this.estado = actividades.getActEstado();
        this.inicioEsperado = actividades.getActInicioesperado();
        this.finalEsperado = actividades.getActFinalesperado();
        this.orden = actividades.getActOrden();
        this.version = actividades.getActVersion();
    }
    public Actividades getModel(){
        return new Actividades(id, descripcion, estado, estado, inicioEsperado, finalEsperado, orden, version);
    }
}
