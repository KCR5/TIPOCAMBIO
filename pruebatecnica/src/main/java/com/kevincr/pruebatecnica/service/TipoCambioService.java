package com.kevincr.pruebatecnica.service;

import com.kevincr.pruebatecnica.entity.Respuesta;
import com.kevincr.pruebatecnica.entity.TipoCambio;
import com.kevincr.pruebatecnica.entity.TipoCambioConsulta;
import com.kevincr.pruebatecnica.entity.TipoCambioRespuesta;
import com.kevincr.pruebatecnica.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioService {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;
    private Respuesta respuesta = new Respuesta();

    public Respuesta listaTipoCambio(){
        List<TipoCambio> lista = tipoCambioRepository.findAll();
        respuesta.setMensaje("OK");

        if(lista.isEmpty()){
            respuesta.setMensaje("No existen tipos de cambio configurados.");
            return respuesta;
        }

        respuesta.setObject(lista);
        return respuesta;
    }

    public Respuesta calcularTipoCambio(TipoCambioConsulta consulta){
        //Inicializamos variables
        respuesta.setMensaje("OK");

        TipoCambioRespuesta cambioRespuesta = new TipoCambioRespuesta();
        cambioRespuesta.setMonto(consulta.getMonto());
        cambioRespuesta.setCodMonedaOrigen(consulta.getCodMonedaOrigen());
        cambioRespuesta.setCodMonedaDestino(consulta.getCodMonedaDestino());

        //Buscamos tipo de cambio de origen
        TipoCambio tipoCambioORIGEN = tipoCambioRepository.findByCodMoneda(consulta.getCodMonedaOrigen());
        if(tipoCambioORIGEN == null){
            respuesta.setMensaje("No se configuró el tipo de cambio de origen: "+consulta.getCodMonedaOrigen());
            return respuesta;
        }
        //Buscamos tipo de cambio de destino
        TipoCambio tipoCambioDESTINO = tipoCambioRepository.findByCodMoneda(consulta.getCodMonedaDestino());
        if(tipoCambioDESTINO == null){
            respuesta.setMensaje("No se configuró el tipo de cambio de destino: "+consulta.getCodMonedaDestino());
            return respuesta;
        }
        //Calculamos el tipo de cambio
        switch (consulta.getCodMonedaOrigen()){
            case "PEN":
                cambioRespuesta.setValorTipoCambio(tipoCambioDESTINO.getValTipoCambio());

                cambioRespuesta.setMontoCalculado(consulta.getMonto().divide(tipoCambioDESTINO.getValTipoCambio(),2));

                respuesta.setObject(cambioRespuesta);
                break;
            default:
                cambioRespuesta.setValorTipoCambio(tipoCambioORIGEN.getValTipoCambio());

                cambioRespuesta.setMontoCalculado(consulta.getMonto().multiply(tipoCambioORIGEN.getValTipoCambio()).setScale(2,RoundingMode.HALF_UP));

                respuesta.setObject(cambioRespuesta);
                break;
        }

        return respuesta;
    }

    public Respuesta actualizarTipoCambio(TipoCambio tipoCambio){
        //Inicializamos variables
        respuesta.setMensaje("OK");
        //Buscamos tipo de cambio
        TipoCambio tc = tipoCambioRepository.findByIdtc(tipoCambio.getId());
        if(tc.getId() == null){
            respuesta.setMensaje("No se encuentra la configuración de la moneda: "+tipoCambio.getCodMoneda());
            return respuesta;
        }
        //Actualizamos el tipo de cambio
        tc.setDesMoneda(tipoCambio.getDesMoneda());
        tc.setValTipoCambio(tipoCambio.getValTipoCambio());
        try{
            tipoCambioRepository.save(tc);
            respuesta.setMensaje("OK");
            respuesta.setObject(tc);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            respuesta.setMensaje("Error al actualizar el tipo de cambio.");
        }

        return respuesta;
    }

    public Respuesta registrarTipoCambio(TipoCambio tipoCambio){
        //Inicializamos variables
        respuesta.setMensaje("OK");
        //Buscamos tipo de cambio
        TipoCambio tc = tipoCambioRepository.findByCodMoneda(tipoCambio.getCodMoneda());
        if(tc != null){
            respuesta.setMensaje("Ya se encuentra registrada una moneda con el código: "+tipoCambio.getCodMoneda());
            return respuesta;
        }
        //Registramos el tipo de cambio
        try{
            tipoCambioRepository.save(tipoCambio);
            respuesta.setMensaje("OK");
            respuesta.setObject(tipoCambio);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            respuesta.setMensaje("Error al registrar el tipo de cambio.");
        }

        return respuesta;
    }
}
