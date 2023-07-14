package com.exg.cdr.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author molin
 */
@Entity
@Table(name = "cdr_plantilla_correo", catalog = "db_rutas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdrPlantillaCorreo.findAll", query = "SELECT c FROM CdrPlantillaCorreo c"),
    @NamedQuery(name = "CdrPlantillaCorreo.findByPtcId", query = "SELECT c FROM CdrPlantillaCorreo c WHERE c.ptcId = :ptcId"),
    @NamedQuery(name = "CdrPlantillaCorreo.findByPctAsunto", query = "SELECT c FROM CdrPlantillaCorreo c WHERE c.pctAsunto = :pctAsunto"),
    @NamedQuery(name = "CdrPlantillaCorreo.findByPtcSaludo", query = "SELECT c FROM CdrPlantillaCorreo c WHERE c.ptcSaludo = :ptcSaludo"),
    @NamedQuery(name = "CdrPlantillaCorreo.findByPtcDespedida", query = "SELECT c FROM CdrPlantillaCorreo c WHERE c.ptcDespedida = :ptcDespedida"),
    @NamedQuery(name = "CdrPlantillaCorreo.findByPtcMensaje", query = "SELECT c FROM CdrPlantillaCorreo c WHERE c.ptcMensaje = :ptcMensaje")})
public class CdrPlantillaCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ptc_id")
    private Integer ptcId;
    @Column(name = "pct_asunto")
    private String pctAsunto;
    @Column(name = "ptc_saludo")
    private String ptcSaludo;
    @Column(name = "ptc_despedida")
    private String ptcDespedida;
    @Column(name = "ptc_mensaje")
    private String ptcMensaje;

    public CdrPlantillaCorreo() {
    }

    public CdrPlantillaCorreo(Integer ptcId) {
        this.ptcId = ptcId;
    }

    public Integer getPtcId() {
        return ptcId;
    }

    public void setPtcId(Integer ptcId) {
        this.ptcId = ptcId;
    }

    public String getPctAsunto() {
        return pctAsunto;
    }

    public void setPctAsunto(String pctAsunto) {
        this.pctAsunto = pctAsunto;
    }

    public String getPtcSaludo() {
        return ptcSaludo;
    }

    public void setPtcSaludo(String ptcSaludo) {
        this.ptcSaludo = ptcSaludo;
    }

    public String getPtcDespedida() {
        return ptcDespedida;
    }

    public void setPtcDespedida(String ptcDespedida) {
        this.ptcDespedida = ptcDespedida;
    }

    public String getPtcMensaje() {
        return ptcMensaje;
    }

    public void setPtcMensaje(String ptcMensaje) {
        this.ptcMensaje = ptcMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptcId != null ? ptcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CdrPlantillaCorreo)) {
            return false;
        }
        CdrPlantillaCorreo other = (CdrPlantillaCorreo) object;
        if ((this.ptcId == null && other.ptcId != null) || (this.ptcId != null && !this.ptcId.equals(other.ptcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exg.cdr.entities.CdrPlantillaCorreo[ ptcId=" + ptcId + " ]";
    }
    
}
