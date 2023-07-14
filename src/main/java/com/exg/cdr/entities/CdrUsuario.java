package com.exg.cdr.entities;

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
    @Basic(optional = false)
    @Column(name = "usu_username")
    private String usuUsername;
    @Basic(optional = false)
    @Column(name = "usu_password")
    private String usuPassword;
    @Basic(optional = false)
    @Column(name = "usu_email")
    private String usuEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsuId")
    private List<CdrRutas> cdrRutasList;

    public CdrUsuario() {
    }

    public CdrUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public CdrUsuario(Integer usuId, String usuUsername, String usuPassword, String usuEmail) {
        this.usuId = usuId;
        this.usuUsername = usuUsername;
        this.usuPassword = usuPassword;
        this.usuEmail = usuEmail;
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
    public List<CdrRutas> getCdrRutasList() {
        return cdrRutasList;
    }

    public void setCdrRutasList(List<CdrRutas> cdrRutasList) {
        this.cdrRutasList = cdrRutasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
