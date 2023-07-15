package com.exg.cdr;

import java.math.BigDecimal;
import java.util.Date;

public class RutaRequest {

    private Integer rutUsuId;
    private String rutCoordenadasPartida;
    private String rutCoordenadasDestino;
    private String rutUbiDestino;
    private String rutUbiPartida;
    private Date rutHoraInicio;
    private Date rutHoraFin;
    private boolean rutGuardada;
    private Date rutFecha;
    private BigDecimal rutDistancia;
    private Character rutTipo;

    public RutaRequest() {
    }

    public Integer getRutUsuId() {
        return rutUsuId;
    }

    public void setRutUsuId(Integer rutUsuId) {
        this.rutUsuId = rutUsuId;
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

    public String getRutUbiDestino() {
        return rutUbiDestino;
    }

    public void setRutUbiDestino(String rutUbiDestino) {
        this.rutUbiDestino = rutUbiDestino;
    }

    public String getRutUbiPartida() {
        return rutUbiPartida;
    }

    public void setRutUbiPartida(String rutUbiPartida) {
        this.rutUbiPartida = rutUbiPartida;
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

    public boolean isRutGuardada() {
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
}
