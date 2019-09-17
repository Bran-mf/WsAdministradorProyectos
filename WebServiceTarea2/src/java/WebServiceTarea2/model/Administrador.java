/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Pablo Bermudez
 */
@Entity
@Table(name = "TBL_ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByAdmId", query = "SELECT a FROM Administrador a WHERE a.admId = :admId")
    , @NamedQuery(name = "Administrador.findByAdmNombre", query = "SELECT a FROM Administrador a WHERE a.admNombre = :AdmNombre")
    , @NamedQuery(name = "Administrador.findByAdmPapellido", query = "SELECT a FROM Administrador a WHERE a.admPapellido = :admPapellido")
    , @NamedQuery(name = "Administrador.findByAdmSapellido", query = "SELECT a FROM Administrador a WHERE a.admSapellido = :admSapellido")
    , @NamedQuery(name = "Administrador.findByAdmCorreo", query = "SELECT a FROM Administrador a WHERE a.admCorreo = :admCorreo")
    , @NamedQuery(name = "Administrador.findByAdmUsuario", query = "SELECT a FROM Administrador a WHERE a.admUsuario = :AdmUsuario")
    , @NamedQuery(name = "Administrador.findByAdmClave", query = "SELECT a FROM Administrador a WHERE a.admClave = :AdmClave")
    , @NamedQuery(name = "Administrador.findByAdmEstado", query = "SELECT a FROM Administrador a WHERE a.admEstado = :AdmEstado")
    , @NamedQuery(name = "Administrador.findByAdmVersion", query = "SELECT a FROM Administrador a WHERE a.admVersion = :AdmVersion")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private Long admId;
    @Basic(optional = false)
    @Column(name = "Adm_NOMBRE")
    private String AdmNombre;
    @Basic(optional = false)
    @Column(name = "ADM_PAPELLIDO")
    private String admPapellido;
    @Basic(optional = false)
    @Column(name = "ADM_SAPELLIDO")
    private String admSapellido;
    @Basic(optional = false)
    @Column(name = "ADM_CORREO")
    private String admCorreo;
    @Basic(optional = false)
    @Column(name = "Adm_USUARIO")
    private String AdmUsuario;
    @Basic(optional = false)
    @Column(name = "Adm_CLAVE")
    private String AdmClave;
    @Basic(optional = false)
    @Column(name = "Adm_ESTADO")
    private String AdmEstado;
    @Basic(optional = false)
    @Column(name = "Adm_VERSION")
    private Long AdmVersion;

    public Administrador() {
    }

    public Administrador(Long admId) {
        this.admId = admId;
    }

    public Administrador(Long admId, String AdmNombre, String admPapellido, String admSapellido, String admCorreo, String AdmUsuario, String AdmClave, String AdmEstado, Long AdmVersion) {
        this.admId = admId;
        this.AdmNombre = AdmNombre;
        this.admPapellido = admPapellido;
        this.admSapellido = admSapellido;
        this.admCorreo = admCorreo;
        this.AdmUsuario = AdmUsuario;
        this.AdmClave = AdmClave;
        this.AdmEstado = AdmEstado;
        this.AdmVersion = AdmVersion;
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getAdmNombre() {
        return AdmNombre;
    }

    public void setAdmNombre(String AdmNombre) {
        this.AdmNombre = AdmNombre;
    }

    public String getAdmPapellido() {
        return admPapellido;
    }

    public void setAdmPapellido(String admPapellido) {
        this.admPapellido = admPapellido;
    }

    public String getAdmSapellido() {
        return admSapellido;
    }

    public void setAdmSapellido(String admSapellido) {
        this.admSapellido = admSapellido;
    }

    public String getAdmCorreo() {
        return admCorreo;
    }

    public void setAdmCorreo(String admCorreo) {
        this.admCorreo = admCorreo;
    }

    public String getAdmUsuario() {
        return AdmUsuario;
    }

    public void setAdmUsuario(String AdmUsuario) {
        this.AdmUsuario = AdmUsuario;
    }

    public String getAdmClave() {
        return AdmClave;
    }

    public void setAdmClave(String AdmClave) {
        this.AdmClave = AdmClave;
    }

    public String getAdmEstado() {
        return AdmEstado;
    }

    public void setAdmEstado(String AdmEstado) {
        this.AdmEstado = AdmEstado;
    }

    public Long getAdmVersion() {
        return AdmVersion;
    }

    public void setAdmVersion(Long AdmVersion) {
        this.AdmVersion = AdmVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.Administrador[ admId=" + admId + " ]";
    }
    
}
