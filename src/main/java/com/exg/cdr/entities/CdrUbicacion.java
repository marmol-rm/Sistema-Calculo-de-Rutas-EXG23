package com.exg.cdr.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Size(max = 100)
    @Column(name = "ubi_nombre")
    private String ubiNombre;
    @Column(name = "ubi_guardada")
    private Boolean ubiGuardada;
    @OneToMany(mappedBy = "rutUbiDestino")
    private Collection<CdrRutas> cdrRutasCollection;
    @OneToMany(mappedBy = "rutUbiPartida")
    private Collection<CdrRutas> cdrRutasCollection1;

    public CdrUbicacion() {
    }

    public CdrUbicacion(Integer ubiId) {
        this.ubiId = ubiId;
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

    public Boolean getUbiGuardada() {
        return ubiGuardada;
    }

    public void setUbiGuardada(Boolean ubiGuardada) {
        this.ubiGuardada = ubiGuardada;
    }

    @XmlTransient
    public Collection<CdrRutas> getCdrRutasCollection() {
        return cdrRutasCollection;
    }

    public void setCdrRutasCollection(Collection<CdrRutas> cdrRutasCollection) {
        this.cdrRutasCollection = cdrRutasCollection;
    }

    @XmlTransient
    public Collection<CdrRutas> getCdrRutasCollection1() {
        return cdrRutasCollection1;
    }

    public void setCdrRutasCollection1(Collection<CdrRutas> cdrRutasCollection1) {
        this.cdrRutasCollection1 = cdrRutasCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubiId != null ? ubiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
