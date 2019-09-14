/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author Bran
 */
@Entity
@Table(name = "TBL_ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdministrador.findAll", query = "SELECT t FROM TblAdministrador t")
    , @NamedQuery(name = "TblAdministrador.findByAdmId", query = "SELECT t FROM TblAdministrador t WHERE t.admId = :admId")
    , @NamedQuery(name = "TblAdministrador.findByAmdNombre", query = "SELECT t FROM TblAdministrador t WHERE t.amdNombre = :amdNombre")
    , @NamedQuery(name = "TblAdministrador.findByAdmPapellido", query = "SELECT t FROM TblAdministrador t WHERE t.admPapellido = :admPapellido")
    , @NamedQuery(name = "TblAdministrador.findByAdmSapellido", query = "SELECT t FROM TblAdministrador t WHERE t.admSapellido = :admSapellido")
    , @NamedQuery(name = "TblAdministrador.findByAdmCorreo", query = "SELECT t FROM TblAdministrador t WHERE t.admCorreo = :admCorreo")
    , @NamedQuery(name = "TblAdministrador.findByAmdUsuario", query = "SELECT t FROM TblAdministrador t WHERE t.amdUsuario = :amdUsuario")
    , @NamedQuery(name = "TblAdministrador.findByAmdClave", query = "SELECT t FROM TblAdministrador t WHERE t.amdClave = :amdClave")
    , @NamedQuery(name = "TblAdministrador.findByAmdEstado", query = "SELECT t FROM TblAdministrador t WHERE t.amdEstado = :amdEstado")
    , @NamedQuery(name = "TblAdministrador.findByAmdVersion", query = "SELECT t FROM TblAdministrador t WHERE t.amdVersion = :amdVersion")})
public class TblAdministrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private BigDecimal admId;
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
    private BigInteger amdVersion;

    public TblAdministrador() {
    }

    public TblAdministrador(BigDecimal admId) {
        this.admId = admId;
    }

    public TblAdministrador(BigDecimal admId, String amdNombre, String admPapellido, String admSapellido, String admCorreo, String amdUsuario, String amdClave, String amdEstado, BigInteger amdVersion) {
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

    public BigDecimal getAdmId() {
        return admId;
    }

    public void setAdmId(BigDecimal admId) {
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

    public BigInteger getAmdVersion() {
        return amdVersion;
    }

    public void setAmdVersion(BigInteger amdVersion) {
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
        if (!(object instanceof TblAdministrador)) {
            return false;
        }
        TblAdministrador other = (TblAdministrador) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.TblAdministrador[ admId=" + admId + " ]";
    }
    
}
