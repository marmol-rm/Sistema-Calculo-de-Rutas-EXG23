package com.exg.cdr.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cdr_usuario", catalog = "db_rutas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdrUsuario.findAll", query = "SELECT c FROM CdrUsuario c"),
    @NamedQuery(name = "CdrUsuario.findByUsuId", query = "SELECT c FROM CdrUsuario c WHERE c.usuId = :usuId"),
    @NamedQuery(name = "CdrUsuario.findByUsuUsername", query = "SELECT c FROM CdrUsuario c WHERE c.usuUsername = :usuUsername"),
    @NamedQuery(name = "CdrUsuario.findByUsuPassword", query = "SELECT c FROM CdrUsuario c WHERE c.usuPassword = :usuPassword"),
    @NamedQuery(name = "CdrUsuario.findByUsuEmail", query = "SELECT c FROM CdrUsuario c WHERE c.usuEmail = :usuEmail")})
public class CdrUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Size(max = 50)
    @Column(name = "usu_username")
    private String usuUsername;
    @Size(max = 100)
    @Column(name = "usu_password")
    private String usuPassword;
    @Size(max = 100)
    @Column(name = "usu_email")
    private String usuEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsuId")
    private Collection<CdrRutas> cdrRutasCollection;

    public CdrUsuario() {
    }

    public CdrUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsername() {
        return usuUsername;
    }

    public void setUsuUsername(String usuUsername) {
        this.usuUsername = usuUsername;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    @XmlTransient
    public Collection<CdrRutas> getCdrRutasCollection() {
        return cdrRutasCollection;
    }

    public void setCdrRutasCollection(Collection<CdrRutas> cdrRutasCollection) {
        this.cdrRutasCollection = cdrRutasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrUsuario)) {
            return false;
        }
        CdrUsuario other = (CdrUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exg.cdr.entities.CdrUsuario[ usuId=" + usuId + " ]";
    }
    
}
