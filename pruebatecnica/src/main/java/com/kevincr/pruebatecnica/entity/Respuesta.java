package com.kevincr.pruebatecnica.entity;

import org.springframework.context.annotation.Bean;

public class Respuesta {
    private String mensaje;
    private Object object;

    public Respuesta() {
    }

    public Respuesta(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
