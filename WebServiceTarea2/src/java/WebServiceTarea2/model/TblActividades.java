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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bran
 */
@Entity
@Table(name = "TBL_ACTIVIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblActividades.findAll", query = "SELECT t FROM TblActividades t")
    , @NamedQuery(name = "TblActividades.findByActId", query = "SELECT t FROM TblActividades t WHERE t.actId = :actId")
    , @NamedQuery(name = "TblActividades.findByActDescripcion", query = "SELECT t FROM TblActividades t WHERE t.actDescripcion = :actDescripcion")
    , @NamedQuery(name = "TblActividades.findByActEncargado", query = "SELECT t FROM TblActividades t WHERE t.actEncargado = :actEncargado")
    , @NamedQuery(name = "TblActividades.findByActEstado", query = "SELECT t FROM TblActividades t WHERE t.actEstado = :actEstado")
    , @NamedQuery(name = "TblActividades.findByActInicioreal", query = "SELECT t FROM TblActividades t WHERE t.actInicioreal = :actInicioreal")
    , @NamedQuery(name = "TblActividades.findByActInicioesperado", query = "SELECT t FROM TblActividades t WHERE t.actInicioesperado = :actInicioesperado")
    , @NamedQuery(name = "TblActividades.findByActFinalreal", query = "SELECT t FROM TblActividades t WHERE t.actFinalreal = :actFinalreal")
    , @NamedQuery(name = "TblActividades.findByActFinalesperado", query = "SELECT t FROM TblActividades t WHERE t.actFinalesperado = :actFinalesperado")
    , @NamedQuery(name = "TblActividades.findByActOrden", query = "SELECT t FROM TblActividades t WHERE t.actOrden = :actOrden")
    , @NamedQuery(name = "TblActividades.findByActVersion", query = "SELECT t FROM TblActividades t WHERE t.actVersion = :actVersion")})
public class TblActividades implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private BigDecimal actId;
    @Basic(optional = false)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Basic(optional = false)
    @Column(name = "ACT_ENCARGADO")
    private String actEncargado;
    @Basic(optional = false)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @Column(name = "ACT_INICIOREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actInicioreal;
    @Basic(optional = false)
    @Column(name = "ACT_INICIOESPERADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actInicioesperado;
    @Column(name = "ACT_FINALREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFinalreal;
    @Basic(optional = false)
    @Column(name = "ACT_FINALESPERADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFinalesperado;
    @Basic(optional = false)
    @Column(name = "ACT_ORDEN")
    private BigInteger actOrden;
    @Basic(optional = false)
    @Column(name = "ACT_VERSION")
    private BigInteger actVersion;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne
    private TblProyecto pryId;

    public TblActividades() {
    }

    public TblActividades(BigDecimal actId) {
        this.actId = actId;
    }

    public TblActividades(BigDecimal actId, String actDescripcion, String actEncargado, String actEstado, Date actInicioesperado, Date actFinalesperado, BigInteger actOrden, BigInteger actVersion) {
        this.actId = actId;
        this.actDescripcion = actDescripcion;
        this.actEncargado = actEncargado;
        this.actEstado = actEstado;
        this.actInicioesperado = actInicioesperado;
        this.actFinalesperado = actFinalesperado;
        this.actOrden = actOrden;
        this.actVersion = actVersion;
    }

    public BigDecimal getActId() {
        return actId;
    }

    public void setActId(BigDecimal actId) {
        this.actId = actId;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActEncargado() {
        return actEncargado;
    }

    public void setActEncargado(String actEncargado) {
        this.actEncargado = actEncargado;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public Date getActInicioreal() {
        return actInicioreal;
    }

    public void setActInicioreal(Date actInicioreal) {
        this.actInicioreal = actInicioreal;
    }

    public Date getActInicioesperado() {
        return actInicioesperado;
    }

    public void setActInicioesperado(Date actInicioesperado) {
        this.actInicioesperado = actInicioesperado;
    }

    public Date getActFinalreal() {
        return actFinalreal;
    }

    public void setActFinalreal(Date actFinalreal) {
        this.actFinalreal = actFinalreal;
    }

    public Date getActFinalesperado() {
        return actFinalesperado;
    }

    public void setActFinalesperado(Date actFinalesperado) {
        this.actFinalesperado = actFinalesperado;
    }

    public BigInteger getActOrden() {
        return actOrden;
    }

    public void setActOrden(BigInteger actOrden) {
        this.actOrden = actOrden;
    }

    public BigInteger getActVersion() {
        return actVersion;
    }

    public void setActVersion(BigInteger actVersion) {
        this.actVersion = actVersion;
    }

    public TblProyecto getPryId() {
        return pryId;
    }

    public void setPryId(TblProyecto pryId) {
        this.pryId = pryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblActividades)) {
            return false;
        }
        TblActividades other = (TblActividades) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.TblActividades[ actId=" + actId + " ]";
    }
    
}
