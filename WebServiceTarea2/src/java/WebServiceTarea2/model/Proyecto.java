/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Jose Pablo Bermudez
 */
@Entity
@Table(name = "TBL_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByPryId", query = "SELECT p FROM Proyecto p WHERE p.pryId = :pryId")
    , @NamedQuery(name = "Proyecto.findByPryNombre", query = "SELECT p FROM Proyecto p WHERE p.pryNombre = :pryNombre")
    , @NamedQuery(name = "Proyecto.findByPryPatrocinador", query = "SELECT p FROM Proyecto p WHERE p.pryPatrocinador = :pryPatrocinador")
    , @NamedQuery(name = "Proyecto.findByPryLiderusuario", query = "SELECT p FROM Proyecto p WHERE p.pryLiderusuario = :pryLiderusuario")
    , @NamedQuery(name = "Proyecto.findByPyrLidertecnico", query = "SELECT p FROM Proyecto p WHERE p.pyrLidertecnico = :pyrLidertecnico")
    , @NamedQuery(name = "Proyecto.findByPyrInicioesperado", query = "SELECT p FROM Proyecto p WHERE p.pyrInicioesperado = :pyrInicioesperado")
    , @NamedQuery(name = "Proyecto.findByPryInicioreal", query = "SELECT p FROM Proyecto p WHERE p.pryInicioreal = :pryInicioreal")
    , @NamedQuery(name = "Proyecto.findByPryFinalesperado", query = "SELECT p FROM Proyecto p WHERE p.pryFinalesperado = :pryFinalesperado")
    , @NamedQuery(name = "Proyecto.findByPryFinalreal", query = "SELECT p FROM Proyecto p WHERE p.pryFinalreal = :pryFinalreal")
    , @NamedQuery(name = "Proyecto.findByPryEstado", query = "SELECT p FROM Proyecto p WHERE p.pryEstado = :pryEstado")
    , @NamedQuery(name = "Proyecto.findByPryCorreousuario", query = "SELECT p FROM Proyecto p WHERE p.pryCorreousuario = :pryCorreousuario")
    , @NamedQuery(name = "Proyecto.findByPryCorreotenico", query = "SELECT p FROM Proyecto p WHERE p.pryCorreotenico = :pryCorreotenico")
    , @NamedQuery(name = "Proyecto.findByPryCorreopatrocinador", query = "SELECT p FROM Proyecto p WHERE p.pryCorreopatrocinador = :pryCorreopatrocinador")
    , @NamedQuery(name = "Proyecto.findByPryVersion", query = "SELECT p FROM Proyecto p WHERE p.pryVersion = :pryVersion")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRY_ID")
    private Long pryId;
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
    private Long pryVersion;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Actividades> actividadesList;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;

    public Proyecto() {
    }

    public Proyecto(Long pryId) {
        this.pryId = pryId;
    }

    public Proyecto(Long pryId, String pryNombre, String pryPatrocinador, String pryLiderusuario, String pyrLidertecnico, Date pyrInicioesperado, Date pryFinalesperado, String pryEstado, String pryCorreousuario, String pryCorreotenico, String pryCorreopatrocinador, Long pryVersion) {
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

    public void actualizarProyecto(ProyectoDto proyectoDto){
    
        this.pryCorreopatrocinador = proyectoDto.getCorreoPatrocinador();
        this.pryCorreotenico = proyectoDto.getCorreoLiderTecnico();
        this.pryCorreousuario = proyectoDto.getCorreoLiderUsuario();
        this.pryEstado = proyectoDto.getEstado();
        this.pryFinalesperado = proyectoDto.getFinalEsperado();
        this.pryFinalreal = proyectoDto.getInicioReal();
        this.pryId = proyectoDto.getId();
        this.pryInicioreal = proyectoDto.getInicioReal();
        this.pryLiderusuario = proyectoDto.getLiderUsuario();
        this.pryNombre = proyectoDto.getNombre();
        this.pryPatrocinador = proyectoDto.getPatrocinador();
        this.pryVersion = proyectoDto.getVersion();
        this.pyrInicioesperado = proyectoDto.getInicioEsperado();
        this.pyrLidertecnico = proyectoDto.getLiderTectnico();
        //this.actividadesList
        //this.seguimientoList
    }
    public Proyecto( ProyectoDto proyectoDto ){
    
        this.pryId = proyectoDto.getId();
        actualizarProyecto(proyectoDto);
        
    }
    
    public Long getPryId() {
        return pryId;
    }

    public void setPryId(Long pryId) {
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

    public Long getPryVersion() {
        return pryVersion;
    }

    public void setPryVersion(Long pryVersion) {
        this.pryVersion = pryVersion;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.pryId == null && other.pryId != null) || (this.pryId != null && !this.pryId.equals(other.pryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebServiceTarea2.model.Proyecto[ pryId=" + pryId + " ]";
    }
    
}
