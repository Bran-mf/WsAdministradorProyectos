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
@Table(name = "TBL_SEGUIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSeguimiento.findAll", query = "SELECT t FROM TblSeguimiento t")
    , @NamedQuery(name = "TblSeguimiento.findBySegId", query = "SELECT t FROM TblSeguimiento t WHERE t.segId = :segId")
    , @NamedQuery(name = "TblSeguimiento.findBySegFecha", query = "SELECT t FROM TblSeguimiento t WHERE t.segFecha = :segFecha")
    , @NamedQuery(name = "TblSeguimiento.findBySegAvance", query = "SELECT t FROM TblSeguimiento t WHERE t.segAvance = :segAvance")
    , @NamedQuery(name = "TblSeguimiento.findBySegVersion", query = "SELECT t FROM TblSeguimiento t WHERE t.segVersion = :segVersion")})
public class TblSeguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SEG_ID")
    private BigDecimal segId;
    @Basic(optional = false)
    @Column(name = "SEG_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date segFecha;
    @Basic(optional = false)
    @Column(name = "SEG_AVANCE")
    private BigInteger segAvance;
    @Basic(optional = false)
    @Column(name = "SEG_VERSION")
    private BigInteger segVersion;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne
    private TblProyecto pryId;

    public TblSeguimiento() {
    }

    public TblSeguimiento(BigDecimal segId) {
        this.segId = segId;
    }

    public TblSeguimiento(BigDecimal segId, Date segFecha, BigInteger segAvance, BigInteger segVersion) {
        this.segId = segId;
        this.segFecha = segFecha;
        this.segAvance = segAvance;
        this.segVersion = segVersion;
    }

    public BigDecimal getSegId() {
        return segId;
    }

    public void setSegId(BigDecimal segId) {
        this.segId = segId;
    }

    public Date getSegFecha() {
        return segFecha;
    }

    public void setSegFecha(Date segFecha) {
        this.segFecha = segFecha;
    }

    public BigInteger getSegAvance() {
        return segAvance;
    }

    public void setSegAvance(BigInteger segAvance) {
        this.segAvance = segAvance;
    }

    public BigInteger getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(BigInteger segVersion) {
        this.segVersion = segVersion;
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
        hash += (segId != null ? segId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSeguimiento)) {
            return false;
        }
        TblSeguimiento other = (TblSeguimiento) object;
        if ((this.segId == null && other.segId != null) || (this.segId != null && !this.segId.equals(other.segId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.TblSeguimiento[ segId=" + segId + " ]";
    }
    
}
