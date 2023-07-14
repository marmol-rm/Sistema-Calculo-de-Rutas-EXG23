package com.exg.cdr.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author molin
 */
@Entity
@Table(name = "cdr_rutas", catalog = "db_rutas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdrRutas.findAll", query = "SELECT c FROM CdrRutas c"),
    @NamedQuery(name = "CdrRutas.findByRutId", query = "SELECT c FROM CdrRutas c WHERE c.rutId = :rutId"),
    @NamedQuery(name = "CdrRutas.findByRutCoordenadasPartida", query = "SELECT c FROM CdrRutas c WHERE c.rutCoordenadasPartida = :rutCoordenadasPartida"),
    @NamedQuery(name = "CdrRutas.findByRutCoordenadasDestino", query = "SELECT c FROM CdrRutas c WHERE c.rutCoordenadasDestino = :rutCoordenadasDestino"),
    @NamedQuery(name = "CdrRutas.findByRutHoraInicio", query = "SELECT c FROM CdrRutas c WHERE c.rutHoraInicio = :rutHoraInicio"),
    @NamedQuery(name = "CdrRutas.findByRutHoraFin", query = "SELECT c FROM CdrRutas c WHERE c.rutHoraFin = :rutHoraFin"),
    @NamedQuery(name = "CdrRutas.findByRutGuardada", query = "SELECT c FROM CdrRutas c WHERE c.rutGuardada = :rutGuardada"),
    @NamedQuery(name = "CdrRutas.findByRutFecha", query = "SELECT c FROM CdrRutas c WHERE c.rutFecha = :rutFecha"),
    @NamedQuery(name = "CdrRutas.findByRutDistancia", query = "SELECT c FROM CdrRutas c WHERE c.rutDistancia = :rutDistancia"),
    @NamedQuery(name = "CdrRutas.findByRutTipo", query = "SELECT c FROM CdrRutas c WHERE c.rutTipo = :rutTipo")})
public class CdrRutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rut_id")
    private Integer rutId;
    @Basic(optional = false)
    @Column(name = "rut_coordenadas_partida")
    private String rutCoordenadasPartida;
    @Basic(optional = false)
    @Column(name = "rut_coordenadas_destino")
    private String rutCoordenadasDestino;
    @Basic(optional = false)
    @Column(name = "rut_hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rutHoraInicio;
    @Basic(optional = false)
    @Column(name = "rut_hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rutHoraFin;
    @Basic(optional = false)
    @Column(name = "rut_guardada")
    private boolean rutGuardada;
    @Basic(optional = false)
    @Column(name = "rut_fecha")
    @Temporal(TemporalType.DATE)
    private Date rutFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rut_distancia")
    private BigDecimal rutDistancia;
    @Basic(optional = false)
    @Column(name = "rut_tipo")
    private Character rutTipo;
    @JoinColumn(name = "rut_ubi_destino", referencedColumnName = "ubi_id")
    @ManyToOne(optional = false)
    private CdrUbicacion rutUbiDestino;
    @JoinColumn(name = "rut_ubi_partida", referencedColumnName = "ubi_id")
    @ManyToOne(optional = false)
    private CdrUbicacion rutUbiPartida;
    @JoinColumn(name = "rut_usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private CdrUsuario rutUsuId;

    public CdrRutas() {
    }

    public CdrRutas(Integer rutId) {
        this.rutId = rutId;
    }

    public CdrRutas(Integer rutId, String rutCoordenadasPartida, String rutCoordenadasDestino, Date rutHoraInicio, Date rutHoraFin, boolean rutGuardada, Date rutFecha, Character rutTipo) {
        this.rutId = rutId;
        this.rutCoordenadasPartida = rutCoordenadasPartida;
        this.rutCoordenadasDestino = rutCoordenadasDestino;
        this.rutHoraInicio = rutHoraInicio;
        this.rutHoraFin = rutHoraFin;
        this.rutGuardada = rutGuardada;
        this.rutFecha = rutFecha;
        this.rutTipo = rutTipo;
    }

    public Integer getRutId() {
        return rutId;
    }

    public void setRutId(Integer rutId) {
        this.rutId = rutId;
    }

    public String getRutCoordenadasPartida() {
        return rutCoordenadasPartida;
    }

    public void setRutCoordenadasPartida(String rutCoordenadasPartida) {
        this.rutCoordenadasPartida = rutCoordenadasPartida;
    }

    public String getRutCoordenadasDestino() {
        return rutCoordenadasDestino;
    }

    public void setRutCoordenadasDestino(String rutCoordenadasDestino) {
        this.rutCoordenadasDestino = rutCoordenadasDestino;
    }

    public Date getRutHoraInicio() {
        return rutHoraInicio;
    }

    public void setRutHoraInicio(Date rutHoraInicio) {
        this.rutHoraInicio = rutHoraInicio;
    }

    public Date getRutHoraFin() {
        return rutHoraFin;
    }

    public void setRutHoraFin(Date rutHoraFin) {
        this.rutHoraFin = rutHoraFin;
    }

    public boolean getRutGuardada() {
        return rutGuardada;
    }

    public void setRutGuardada(boolean rutGuardada) {
        this.rutGuardada = rutGuardada;
    }

    public Date getRutFecha() {
        return rutFecha;
    }

    public void setRutFecha(Date rutFecha) {
        this.rutFecha = rutFecha;
    }

    public BigDecimal getRutDistancia() {
        return rutDistancia;
    }

    public void setRutDistancia(BigDecimal rutDistancia) {
        this.rutDistancia = rutDistancia;
    }

    public Character getRutTipo() {
        return rutTipo;
    }

    public void setRutTipo(Character rutTipo) {
        this.rutTipo = rutTipo;
    }

    public CdrUbicacion getRutUbiDestino() {
        return rutUbiDestino;
    }

    public void setRutUbiDestino(CdrUbicacion rutUbiDestino) {
        this.rutUbiDestino = rutUbiDestino;
    }

    public CdrUbicacion getRutUbiPartida() {
        return rutUbiPartida;
    }

    public void setRutUbiPartida(CdrUbicacion rutUbiPartida) {
        this.rutUbiPartida = rutUbiPartida;
    }

    public CdrUsuario getRutUsuId() {
        return rutUsuId;
    }

    public void setRutUsuId(CdrUsuario rutUsuId) {
        this.rutUsuId = rutUsuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutId != null ? rutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CdrRutas)) {
            return false;
        }
        CdrRutas other = (CdrRutas) object;
        if ((this.rutId == null && other.rutId != null) || (this.rutId != null && !this.rutId.equals(other.rutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exg.cdr.entities.CdrRutas[ rutId=" + rutId + " ]";
    }
    
}
