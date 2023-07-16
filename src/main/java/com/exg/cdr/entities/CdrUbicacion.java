package com.exg.cdr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author molin
 */
@Entity
@Table(name = "cdr_ubicacion", catalog = "db_rutas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdrUbicacion.findAll", query = "SELECT c FROM CdrUbicacion c"),
    @NamedQuery(name = "CdrUbicacion.findByUbiId", query = "SELECT c FROM CdrUbicacion c WHERE c.ubiId = :ubiId"),
    @NamedQuery(name = "CdrUbicacion.findByUbiNombre", query = "SELECT c FROM CdrUbicacion c WHERE c.ubiNombre = :ubiNombre"),
    @NamedQuery(name = "CdrUbicacion.findByUbiGuardada", query = "SELECT c FROM CdrUbicacion c WHERE c.ubiGuardada = :ubiGuardada")})
public class CdrUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubi_id")
    private Integer ubiId;
    @Basic(optional = false)
    @Column(name = "ubi_nombre")
    private String ubiNombre;
    @Basic(optional = false)
    @Column(name = "ubi_guardada")
    private boolean ubiGuardada;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUbiDestino")
    private List<CdrRutas> cdrRutasList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUbiPartida")
    private List<CdrRutas> cdrRutasList1;

    public CdrUbicacion() {
    }

    public CdrUbicacion(Integer ubiId) {
        this.ubiId = ubiId;
    }

    public CdrUbicacion(Integer ubiId, String ubiNombre, boolean ubiGuardada) {
        this.ubiId = ubiId;
        this.ubiNombre = ubiNombre;
        this.ubiGuardada = ubiGuardada;
    }

    public Integer getUbiId() {
        return ubiId;
    }

    public void setUbiId(Integer ubiId) {
        this.ubiId = ubiId;
    }

    public String getUbiNombre() {
        return ubiNombre;
    }

    public void setUbiNombre(String ubiNombre) {
        this.ubiNombre = ubiNombre;
    }

    public boolean getUbiGuardada() {
        return ubiGuardada;
    }

    public void setUbiGuardada(boolean ubiGuardada) {
        this.ubiGuardada = ubiGuardada;
    }

    @XmlTransient
    public List<CdrRutas> getCdrRutasList() {
        return cdrRutasList;
    }

    public void setCdrRutasList(List<CdrRutas> cdrRutasList) {
        this.cdrRutasList = cdrRutasList;
    }

    @XmlTransient
    public List<CdrRutas> getCdrRutasList1() {
        return cdrRutasList1;
    }

    public void setCdrRutasList1(List<CdrRutas> cdrRutasList1) {
        this.cdrRutasList1 = cdrRutasList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubiId != null ? ubiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CdrUbicacion)) {
            return false;
        }
        CdrUbicacion other = (CdrUbicacion) object;
        if ((this.ubiId == null && other.ubiId != null) || (this.ubiId != null && !this.ubiId.equals(other.ubiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exg.cdr.entities.CdrUbicacion[ ubiId=" + ubiId + " ]";
    }
    
}
