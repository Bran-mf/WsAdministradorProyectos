/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(name = "PRY_ID_GENERATOR", sequenceName = "SEQ_PROYECTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRY_ID_GENERATOR")
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

    public Proyecto(Long pryId, String pryNombre, String pryPatrocinador, String pryLiderusuario, String pyrLidertecnico, Date pyrInicioesperado, Date pryInicioreal, Date pryFinalesperado, Date pryFinalreal, String pryEstado, String pryCorreousuario, String pryCorreotenico, String pryCorreopatrocinador, Long pryVersion, List<Actividades> actividadesList, List<Seguimiento> seguimientoList) {
        this.pryId = pryId;
        this.pryNombre = pryNombre;
        this.pryPatrocinador = pryPatrocinador;
        this.pryLiderusuario = pryLiderusuario;
        this.pyrLidertecnico = pyrLidertecnico;
        this.pyrInicioesperado = pyrInicioesperado;
        this.pryInicioreal = pryInicioreal;
        this.pryFinalesperado = pryFinalesperado;
        this.pryFinalreal = pryFinalreal;
        this.pryEstado = pryEstado;
        this.pryCorreousuario = pryCorreousuario;
        this.pryCorreotenico = pryCorreotenico;
        this.pryCorreopatrocinador = pryCorreopatrocinador;
        this.pryVersion = pryVersion;
        this.actividadesList = actividadesList;
        this.seguimientoList = seguimientoList;
    }

    

    public void actualizarProyecto(ProyectoDto proyectoDto){
    
        this.pryCorreopatrocinador = proyectoDto.getProCorreopatrocinador();
        this.pryCorreotenico = proyectoDto.getProCorreotecnico();
        this.pryCorreousuario = proyectoDto.getProCorreousuario();
        this.pryEstado = proyectoDto.getProEstado();
        
        LocalDate fechFinal = LocalDate.parse(proyectoDto.getProFechafinal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechFinalReal = LocalDate.parse(proyectoDto.getProFechafinreal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechIni = LocalDate.parse(proyectoDto.getProFechainicio(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechIniReal = LocalDate.parse(proyectoDto.getProFechainireal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        this.pryFinalreal = Date.from(fechFinalReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.pryInicioreal =  Date.from(fechIniReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.pyrInicioesperado = Date.from(fechFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.pyrInicioesperado = Date.from(fechIni.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        this.pryId = proyectoDto.getProId();
        this.pryLiderusuario = proyectoDto.getProLiderusuario();
        this.pryNombre = proyectoDto.getProNombre();
        this.pryPatrocinador = proyectoDto.getProPatrocinador();
        this.pryVersion = proyectoDto.getProVersion();
        this.pyrLidertecnico = proyectoDto.getProLidertecnico();
        //this.actividadesList
        //this.seguimientoList
    }
    public Proyecto( ProyectoDto proyectoDto ){
    
        this.pryId = proyectoDto.getProId();
        actualizarProyecto(proyectoDto);
        
    }
    
    public Long getProId() {
        return pryId;
    }

    public void setProId(Long pryId) {
        this.pryId = pryId;
    }

    public String getProNombre() {
        return pryNombre;
    }

    public void setProNombre(String pryNombre) {
        this.pryNombre = pryNombre;
    }

    public String getProPatrocinador() {
        return pryPatrocinador;
    }

    public void setProPatrocinador(String pryPatrocinador) {
        this.pryPatrocinador = pryPatrocinador;
    }

    public String getProLiderusuario() {
        return pryLiderusuario;
    }

    public void setProLiderusuario(String pryLiderusuario) {
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

    public Date getProInicioreal() {
        return pryInicioreal;
    }

    public void setProInicioreal(Date pryInicioreal) {
        this.pryInicioreal = pryInicioreal;
    }

    public Date getProFinalesperado() {
        return pryFinalesperado;
    }

    public void setProFinalesperado(Date pryFinalesperado) {
        this.pryFinalesperado = pryFinalesperado;
    }

    public Date getProFinalreal() {
        return pryFinalreal;
    }

    public void setProFinalreal(Date pryFinalreal) {
        this.pryFinalreal = pryFinalreal;
    }

    public String getProEstado() {
        return pryEstado;
    }

    public void setProEstado(String pryEstado) {
        this.pryEstado = pryEstado;
    }

    public String getProCorreousuario() {
        return pryCorreousuario;
    }

    public void setProCorreousuario(String pryCorreousuario) {
        this.pryCorreousuario = pryCorreousuario;
    }

    public String getProCorreotenico() {
        return pryCorreotenico;
    }

    public void setProCorreotenico(String pryCorreotenico) {
        this.pryCorreotenico = pryCorreotenico;
    }

    public String getProCorreopatrocinador() {
        return pryCorreopatrocinador;
    }

    public void setProCorreopatrocinador(String pryCorreopatrocinador) {
        this.pryCorreopatrocinador = pryCorreopatrocinador;
    }

    public Long getProVersion() {
        return pryVersion;
    }

    public void setProVersion(Long pryVersion) {
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
