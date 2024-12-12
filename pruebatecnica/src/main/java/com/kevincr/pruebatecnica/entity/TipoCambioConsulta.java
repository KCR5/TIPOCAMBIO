package com.kevincr.pruebatecnica.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TipoCambioConsulta implements Serializable {
    private BigDecimal monto;
    private String codMonedaOrigen;
    private String codMonedaDestino;

    public TipoCambioConsulta() {
    }

    public TipoCambioConsulta(BigDecimal monto, String codMonedaOrigen, String codMonedaDestino) {
        this.monto = monto;
        this.codMonedaOrigen = codMonedaOrigen;
        this.codMonedaDestino = codMonedaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCodMonedaOrigen() {
        return codMonedaOrigen;
    }

    public void setCodMonedaOrigen(String codMonedaOrigen) {
        this.codMonedaOrigen = codMonedaOrigen;
    }

    public String getCodMonedaDestino() {
        return codMonedaDestino;
    }

    public void setCodMonedaDestino(String codMonedaDestino) {
        this.codMonedaDestino = codMonedaDestino;
    }
}
