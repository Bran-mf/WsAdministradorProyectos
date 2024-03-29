/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.util.ArrayList;
import java.util.List;
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
    private Long adnId;
    private String adnNombre;
    private String adnPapellido;
    private String adnSapellido;
    private String adnCedula;
    private String adnCorreo;
    private String adnUsuario;
    private String adnContrasena;
    private String adnEstado;
    private Long adnVersion;
    private List <ProyectoDto> proyectos;

    public AdministradorDto() {
        proyectos = new ArrayList<>();
    }
    
    public AdministradorDto(Long adnId, String adnNombre, String adnPapellido, String adnSapellido, String adnCedula, String adnCorreo, String adnUsuario, String adnContrasena, String adnEstado, Long adnVersion) {
        this();
        this.adnId = adnId;
        this.adnNombre = adnNombre;
        this.adnPapellido = adnPapellido;
        this.adnSapellido = adnSapellido;
        this.adnCedula = adnCedula;
        this.adnCorreo = adnCorreo;
        this.adnUsuario = adnUsuario;
        this.adnContrasena = adnContrasena;
        this.adnEstado = adnEstado;
        this.adnVersion = adnVersion;
    }

    public AdministradorDto(Administrador admin) {
        this();
        this.adnCedula = admin.getAdnCedula();
        this.adnContrasena = admin.getAdnContrasena();
        this.adnCorreo = admin.getAdnCorreo();
        this.adnEstado = admin.getAdnEstado();
        this.adnId = admin.getAdnId();
        this.adnNombre =  admin.getAdnNombre();
        this.adnPapellido = admin.getAdnPapellido();
        this.adnSapellido = admin.getAdnSapellido();
        this.adnUsuario = admin.getAdnUsuario();
        this.adnVersion = admin.getAdnVersion();
        if(admin.getProyectoList() != null){
            for (Proyecto p : admin.getProyectoList()){
                ProyectoDto proy = new ProyectoDto(p);
                //proy.setProAdmin(this);
                this.proyectos.add(proy);
            }
        }
        /*if(admin.getProyectoList()!=null && !admin.getProyectoList().isEmpty()){
            admin.getProyectoList().forEach(x->{
                ProyectoDto pro = new ProyectoDto(x);
                pro.setProAdmin(this);
                this.proyectos.add(pro);
            });
        }*/
    }

    public Long getAdnId() {
        return adnId;
    }

    public void setAdnId(Long adnId) {
        this.adnId = adnId;
    }

    public String getAdnNombre() {
        return adnNombre;
    }

    public void setAdnNombre(String adnNombre) {
        this.adnNombre = adnNombre;
    }

    public String getAdnPapellido() {
        return adnPapellido;
    }

    public void setAdnPapellido(String adnPapellido) {
        this.adnPapellido = adnPapellido;
    }

    public String getAdnSapellido() {
        return adnSapellido;
    }

    public void setAdnSapellido(String adnSapellido) {
        this.adnSapellido = adnSapellido;
    }

    public String getAdnCedula() {
        return adnCedula;
    }

    public void setAdnCedula(String adnCedula) {
        this.adnCedula = adnCedula;
    }

    public String getAdnCorreo() {
        return adnCorreo;
    }

    public void setAdnCorreo(String adnCorreo) {
        this.adnCorreo = adnCorreo;
    }

    public String getAdnUsuario() {
        return adnUsuario;
    }

    public void setAdnUsuario(String adnUsuario) {
        this.adnUsuario = adnUsuario;
    }

    public String getAdnContrasena() {
        return adnContrasena;
    }

    public void setAdnContrasena(String adnContrasena) {
        this.adnContrasena = adnContrasena;
    }

    public String getAdnEstado() {
        return adnEstado;
    }

    public void setAdnEstado(String adnEstado) {
        this.adnEstado = adnEstado;
    }

    public Long getAdnVersion() {
        return adnVersion;
    }

    public void setAdnVersion(Long adnVersion) {
        this.adnVersion = adnVersion;
    }
    
    public void addProyecto(ProyectoDto p){
        this.proyectos.add(p);
    }

    public List<ProyectoDto> getProyectos() {
        return proyectos;
    }
    
    public List<Proyecto> getProyectosToDB(){
        List<Proyecto> prs = new ArrayList<>();
        for (ProyectoDto p : proyectos){
            prs.add(new Proyecto(p));
        }
        return prs;
    }

    public void setProyectos(List<ProyectoDto> proyectos) {
        this.proyectos = proyectos;
    }
    
}