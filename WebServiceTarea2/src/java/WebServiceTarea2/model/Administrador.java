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
    , @NamedQuery(name = "Administrador.findByAmdNombre", query = "SELECT a FROM Administrador a WHERE a.amdNombre = :amdNombre")
    , @NamedQuery(name = "Administrador.findByAdmPapellido", query = "SELECT a FROM Administrador a WHERE a.admPapellido = :admPapellido")
    , @NamedQuery(name = "Administrador.findByAdmSapellido", query = "SELECT a FROM Administrador a WHERE a.admSapellido = :admSapellido")
    , @NamedQuery(name = "Administrador.findByAdmCorreo", query = "SELECT a FROM Administrador a WHERE a.admCorreo = :admCorreo")
    , @NamedQuery(name = "Administrador.findByAmdUsuario", query = "SELECT a FROM Administrador a WHERE a.amdUsuario = :amdUsuario")
    , @NamedQuery(name = "Administrador.findByAmdClave", query = "SELECT a FROM Administrador a WHERE a.amdClave = :amdClave")
    , @NamedQuery(name = "Administrador.findByAmdEstado", query = "SELECT a FROM Administrador a WHERE a.amdEstado = :amdEstado")
    , @NamedQuery(name = "Administrador.findByAmdVersion", query = "SELECT a FROM Administrador a WHERE a.amdVersion = :amdVersion")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private Long admId;
    @Basic(optional = false)
    @Column(name = "AMD_NOMBRE")
    private String amdNombre;
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
    @Column(name = "AMD_USUARIO")
    private String amdUsuario;
    @Basic(optional = false)
    @Column(name = "AMD_CLAVE")
    private String amdClave;
    @Basic(optional = false)
    @Column(name = "AMD_ESTADO")
    private String amdEstado;
    @Basic(optional = false)
    @Column(name = "AMD_VERSION")
    private Long amdVersion;

    public Administrador() {
    }

    public Administrador(Long admId) {
        this.admId = admId;
    }

    public Administrador(Long admId, String amdNombre, String admPapellido, String admSapellido, String admCorreo, String amdUsuario, String amdClave, String amdEstado, Long amdVersion) {
        this.admId = admId;
        this.amdNombre = amdNombre;
        this.admPapellido = admPapellido;
        this.admSapellido = admSapellido;
        this.admCorreo = admCorreo;
        this.amdUsuario = amdUsuario;
        this.amdClave = amdClave;
        this.amdEstado = amdEstado;
        this.amdVersion = amdVersion;
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getAmdNombre() {
        return amdNombre;
    }

    public void setAmdNombre(String amdNombre) {
        this.amdNombre = amdNombre;
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

    public String getAmdUsuario() {
        return amdUsuario;
    }

    public void setAmdUsuario(String amdUsuario) {
        this.amdUsuario = amdUsuario;
    }

    public String getAmdClave() {
        return amdClave;
    }

    public void setAmdClave(String amdClave) {
        this.amdClave = amdClave;
    }

    public String getAmdEstado() {
        return amdEstado;
    }

    public void setAmdEstado(String amdEstado) {
        this.amdEstado = amdEstado;
    }

    public Long getAmdVersion() {
        return amdVersion;
    }

    public void setAmdVersion(Long amdVersion) {
        this.amdVersion = amdVersion;
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
