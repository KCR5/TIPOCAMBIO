package com.kevincr.pruebatecnica.entity;

import java.math.BigDecimal;

public class TipoCambioRespuesta {
    private BigDecimal monto;
    private BigDecimal montoCalculado;
    private String codMonedaOrigen;
    private String codMonedaDestino;
    private BigDecimal valorTipoCambio;

    public TipoCambioRespuesta() {
    }

    public TipoCambioRespuesta(BigDecimal monto, BigDecimal montoCalculado, String codMonedaOrigen, String codMonedaDestino, BigDecimal valorTipoCambio) {
        this.monto = monto;
        this.montoCalculado = montoCalculado;
        this.codMonedaOrigen = codMonedaOrigen;
        this.codMonedaDestino = codMonedaDestino;
        this.valorTipoCambio = valorTipoCambio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoCalculado() {
        return montoCalculado;
    }

    public void setMontoCalculado(BigDecimal montoCalculado) {
        this.montoCalculado = montoCalculado;
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

    public BigDecimal getValorTipoCambio() {
        return valorTipoCambio;
    }

    public void setValorTipoCambio(BigDecimal valorTipoCambio) {
        this.valorTipoCambio = valorTipoCambio;
    }
}
