package com.kevincr.pruebatecnica.controller;

import com.kevincr.pruebatecnica.entity.Respuesta;
import com.kevincr.pruebatecnica.entity.TipoCambio;
import com.kevincr.pruebatecnica.entity.TipoCambioConsulta;
import com.kevincr.pruebatecnica.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {
    @Autowired
    private TipoCambioService tipoCambioService;

    @GetMapping
    public ResponseEntity<?> getTipoCambio(){
        Respuesta respuesta = new Respuesta();
        respuesta = tipoCambioService.listaTipoCambio();

        if(respuesta.getMensaje().equals("OK")) {
            return ResponseEntity.ok(respuesta.getObject());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta.getMensaje());
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> postCalculoTipoCambio(@RequestBody TipoCambioConsulta consulta){
        Respuesta respuesta = new Respuesta();
        respuesta = tipoCambioService.calcularTipoCambio(consulta);

        if(respuesta.getMensaje().equals("OK")) {
            return ResponseEntity.ok(respuesta.getObject());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta.getMensaje());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> postActualizaTipoCambio(@RequestBody TipoCambio tipoCambio){
        Respuesta respuesta = new Respuesta();
        respuesta = tipoCambioService.actualizarTipoCambio(tipoCambio);

        if(respuesta.getMensaje().equals("OK")) {
            return ResponseEntity.ok(respuesta.getObject());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta.getMensaje());
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> postRegistraTipoCambio(@RequestBody TipoCambio tipoCambio){
        Respuesta respuesta = new Respuesta();
        respuesta = tipoCambioService.registrarTipoCambio(tipoCambio);

        if(respuesta.getMensaje().equals("OK")) {
            return ResponseEntity.ok(respuesta.getObject());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta.getMensaje());
    }


}
