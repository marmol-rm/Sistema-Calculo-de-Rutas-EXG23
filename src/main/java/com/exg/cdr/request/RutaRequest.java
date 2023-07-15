package com.exg.cdr.request;

import java.math.BigDecimal;
import java.util.Date;

public class RutaRequest {

    private String usuEmail;
    private String coordPartida;
    private String coordDestino;
    private String ubiDestino;
    private String ubiPartida;
    private Date horaInicio;
    private Date horaFin;
    private boolean rutGuardada;
    private Date fecha;
    private BigDecimal distanciaTotal;
    private Character tipo;

    public RutaRequest() {
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getCoordPartida() {
        return coordPartida;
    }

    public void setCoordPartida(String coordPartida) {
        this.coordPartida = coordPartida;
    }

    public String getCoordDestino() {
        return coordDestino;
    }

    public void setCoordDestino(String coordDestino) {
        this.coordDestino = coordDestino;
    }

    public String getUbiDestino() {
        return ubiDestino;
    }

    public void setUbiDestino(String ubiDestino) {
        this.ubiDestino = ubiDestino;
    }

    public String getUbiPartida() {
        return ubiPartida;
    }

    public void setUbiPartida(String ubiPartida) {
        this.ubiPartida = ubiPartida;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isRutGuardada() {
        return rutGuardada;
    }

    public void setRutGuardada(boolean rutGuardada) {
        this.rutGuardada = rutGuardada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(BigDecimal distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }
}
