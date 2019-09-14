/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bran
 */
@Entity
@Table(name = "TBL_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProyecto.findAll", query = "SELECT t FROM TblProyecto t")
    , @NamedQuery(name = "TblProyecto.findByPryId", query = "SELECT t FROM TblProyecto t WHERE t.pryId = :pryId")
    , @NamedQuery(name = "TblProyecto.findByPryNombre", query = "SELECT t FROM TblProyecto t WHERE t.pryNombre = :pryNombre")
    , @NamedQuery(name = "TblProyecto.findByPryPatrocinador", query = "SELECT t FROM TblProyecto t WHERE t.pryPatrocinador = :pryPatrocinador")
    , @NamedQuery(name = "TblProyecto.findByPryLiderusuario", query = "SELECT t FROM TblProyecto t WHERE t.pryLiderusuario = :pryLiderusuario")
    , @NamedQuery(name = "TblProyecto.findByPyrLidertecnico", query = "SELECT t FROM TblProyecto t WHERE t.pyrLidertecnico = :pyrLidertecnico")
    , @NamedQuery(name = "TblProyecto.findByPyrInicioesperado", query = "SELECT t FROM TblProyecto t WHERE t.pyrInicioesperado = :pyrInicioesperado")
    , @NamedQuery(name = "TblProyecto.findByPryInicioreal", query = "SELECT t FROM TblProyecto t WHERE t.pryInicioreal = :pryInicioreal")
    , @NamedQuery(name = "TblProyecto.findByPryFinalesperado", query = "SELECT t FROM TblProyecto t WHERE t.pryFinalesperado = :pryFinalesperado")
    , @NamedQuery(name = "TblProyecto.findByPryFinalreal", query = "SELECT t FROM TblProyecto t WHERE t.pryFinalreal = :pryFinalreal")
    , @NamedQuery(name = "TblProyecto.findByPryEstado", query = "SELECT t FROM TblProyecto t WHERE t.pryEstado = :pryEstado")
    , @NamedQuery(name = "TblProyecto.findByPryCorreousuario", query = "SELECT t FROM TblProyecto t WHERE t.pryCorreousuario = :pryCorreousuario")
    , @NamedQuery(name = "TblProyecto.findByPryCorreotenico", query = "SELECT t FROM TblProyecto t WHERE t.pryCorreotenico = :pryCorreotenico")
    , @NamedQuery(name = "TblProyecto.findByPryCorreopatrocinador", query = "SELECT t FROM TblProyecto t WHERE t.pryCorreopatrocinador = :pryCorreopatrocinador")
    , @NamedQuery(name = "TblProyecto.findByPryVersion", query = "SELECT t FROM TblProyecto t WHERE t.pryVersion = :pryVersion")})
public class TblProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRY_ID")
    private BigDecimal pryId;
    @Basic(optional = false)
    @Column(name = "PRY_NOMBRE")
    private String pryNombre;
    @Basic(optional = false)
    @Column(name = "PRY_PATROCINADOR")
    private String pryPatrocinador;
    @Basic(optional = false)
    @Column(name = "PRY_LIDERUSUARIO")
    private String pryLiderusuario;
    @Basic(optional = false)
    @Column(name = "PYR_LIDERTECNICO")
    private String pyrLidertecnico;
    @Basic(optional = false)
    @Column(name = "PYR_INICIOESPERADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pyrInicioesperado;
    @Column(name = "PRY_INICIOREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryInicioreal;
    @Basic(optional = false)
    @Column(name = "PRY_FINALESPERADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFinalesperado;
    @Column(name = "PRY_FINALREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFinalreal;
    @Basic(optional = false)
    @Column(name = "PRY_ESTADO")
    private String pryEstado;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOUSUARIO")
    private String pryCorreousuario;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOTENICO")
    private String pryCorreotenico;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOPATROCINADOR")
    private String pryCorreopatrocinador;
    @Basic(optional = false)
    @Column(name = "PRY_VERSION")
    private BigInteger pryVersion;
    @OneToMany(mappedBy = "pryId")
    private List<TblActividades> tblActividadesList;
    @OneToMany(mappedBy = "pryId")
    private List<TblSeguimiento> tblSeguimientoList;

    public TblProyecto() {
    }

    public TblProyecto(BigDecimal pryId) {
        this.pryId = pryId;
    }

    public TblProyecto(BigDecimal pryId, String pryNombre, String pryPatrocinador, String pryLiderusuario, String pyrLidertecnico, Date pyrInicioesperado, Date pryFinalesperado, String pryEstado, String pryCorreousuario, String pryCorreotenico, String pryCorreopatrocinador, BigInteger pryVersion) {
        this.pryId = pryId;
        this.pryNombre = pryNombre;
        this.pryPatrocinador = pryPatrocinador;
        this.pryLiderusuario = pryLiderusuario;
        this.pyrLidertecnico = pyrLidertecnico;
        this.pyrInicioesperado = pyrInicioesperado;
        this.pryFinalesperado = pryFinalesperado;
        this.pryEstado = pryEstado;
        this.pryCorreousuario = pryCorreousuario;
        this.pryCorreotenico = pryCorreotenico;
        this.pryCorreopatrocinador = pryCorreopatrocinador;
        this.pryVersion = pryVersion;
    }

    public BigDecimal getPryId() {
        return pryId;
    }

    public void setPryId(BigDecimal pryId) {
        this.pryId = pryId;
    }

    public String getPryNombre() {
        return pryNombre;
    }

    public void setPryNombre(String pryNombre) {
        this.pryNombre = pryNombre;
    }

    public String getPryPatrocinador() {
        return pryPatrocinador;
    }

    public void setPryPatrocinador(String pryPatrocinador) {
        this.pryPatrocinador = pryPatrocinador;
    }

    public String getPryLiderusuario() {
        return pryLiderusuario;
    }

    public void setPryLiderusuario(String pryLiderusuario) {
        this.pryLiderusuario = pryLiderusuario;
    }

    public String getPyrLidertecnico() {
        return pyrLidertecnico;
    }

    public void setPyrLidertecnico(String pyrLidertecnico) {
        this.pyrLidertecnico = pyrLidertecnico;
    }

    public Date getPyrInicioesperado() {
        return pyrInicioesperado;
    }

    public void setPyrInicioesperado(Date pyrInicioesperado) {
        this.pyrInicioesperado = pyrInicioesperado;
    }

    public Date getPryInicioreal() {
        return pryInicioreal;
    }

    public void setPryInicioreal(Date pryInicioreal) {
        this.pryInicioreal = pryInicioreal;
    }

    public Date getPryFinalesperado() {
        return pryFinalesperado;
    }

    public void setPryFinalesperado(Date pryFinalesperado) {
        this.pryFinalesperado = pryFinalesperado;
    }

    public Date getPryFinalreal() {
        return pryFinalreal;
    }

    public void setPryFinalreal(Date pryFinalreal) {
        this.pryFinalreal = pryFinalreal;
    }

    public String getPryEstado() {
        return pryEstado;
    }

    public void setPryEstado(String pryEstado) {
        this.pryEstado = pryEstado;
    }

    public String getPryCorreousuario() {
        return pryCorreousuario;
    }

    public void setPryCorreousuario(String pryCorreousuario) {
        this.pryCorreousuario = pryCorreousuario;
    }

    public String getPryCorreotenico() {
        return pryCorreotenico;
    }

    public void setPryCorreotenico(String pryCorreotenico) {
        this.pryCorreotenico = pryCorreotenico;
    }

    public String getPryCorreopatrocinador() {
        return pryCorreopatrocinador;
    }

    public void setPryCorreopatrocinador(String pryCorreopatrocinador) {
        this.pryCorreopatrocinador = pryCorreopatrocinador;
    }

    public BigInteger getPryVersion() {
        return pryVersion;
    }

    public void setPryVersion(BigInteger pryVersion) {
        this.pryVersion = pryVersion;
    }

    @XmlTransient
    public List<TblActividades> getTblActividadesList() {
        return tblActividadesList;
    }

    public void setTblActividadesList(List<TblActividades> tblActividadesList) {
        this.tblActividadesList = tblActividadesList;
    }

    @XmlTransient
    public List<TblSeguimiento> getTblSeguimientoList() {
        return tblSeguimientoList;
    }

    public void setTblSeguimientoList(List<TblSeguimiento> tblSeguimientoList) {
        this.tblSeguimientoList = tblSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pryId != null ? pryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProyecto)) {
            return false;
        }
        TblProyecto other = (TblProyecto) object;
        if ((this.pryId == null && other.pryId != null) || (this.pryId != null && !this.pryId.equals(other.pryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.TblProyecto[ pryId=" + pryId + " ]";
    }
    
}
