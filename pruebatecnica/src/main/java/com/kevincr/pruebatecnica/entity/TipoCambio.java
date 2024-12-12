package com.kevincr.pruebatecnica.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TIPO_CAMBIO")
public class TipoCambio {
    @Id
    @Column(name = "ID_TIPO_CAMBIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "COD_MONEDA")
    private String codMoneda;
    @Column(name = "DES_MONEDA")
    private String desMoneda;
    @Column(name = "VAL_TIPO_CAMBIO",precision = 10, scale = 6)
    private BigDecimal valTipoCambio;

    public TipoCambio() {
    }

    public TipoCambio(Long id, String codMoneda, String desMoneda, BigDecimal valTipoCambio) {
        this.id = id;
        this.codMoneda = codMoneda;
        this.desMoneda = desMoneda;
        this.valTipoCambio = valTipoCambio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getDesMoneda() {
        return desMoneda;
    }

    public void setDesMoneda(String desMoneda) {
        this.desMoneda = desMoneda;
    }

    public BigDecimal getValTipoCambio() {
        return valTipoCambio;
    }

    public void setValTipoCambio(BigDecimal valTipoCambio) {
        this.valTipoCambio = valTipoCambio;
    }
}
