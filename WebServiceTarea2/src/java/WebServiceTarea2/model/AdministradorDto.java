/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "AdministradorDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AdministradorDto {
    
    private Long ID;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String cedula;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    private Long version;
    
    public AdministradorDto(){
        
    }
   
    public AdministradorDto(Administrador adm){
        this.ID = adm.getAdmId();
        this.clave = adm.getAdmClave();
        this.correo = adm.getAdmCorreo();
        this.estado = adm.getAdmEstado();
        this.nombre = adm.getAdmNombre();
        this.pApellido = adm.getAdmPapellido();
        this.sApellido = adm.getAdmSapellido();
        this.usuario = adm.getAdmUsuario();
        this.version = adm.getAdmVersion();
        this.cedula = adm.getAdmCedula();
    }

    public Long getID() {
        return ID;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    
}
