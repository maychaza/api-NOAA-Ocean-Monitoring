package ar.com.ada.api.noaaboyas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.noaaboyas.entities.Boya;
import ar.com.ada.api.noaaboyas.entities.Muestra;
import ar.com.ada.api.noaaboyas.models.request.InfoMuestraNueva;
import ar.com.ada.api.noaaboyas.models.response.GenericResponse;
import ar.com.ada.api.noaaboyas.models.response.MuestraResponse;
import ar.com.ada.api.noaaboyas.services.BoyaService;
import ar.com.ada.api.noaaboyas.services.MuestraService;

@RestController
public class MuestraController {

    @Autowired
    MuestraService muestraService;

    @Autowired 
    BoyaService boyaService;
    
    @PostMapping("api/muestras")
    public ResponseEntity<?> registrar(@RequestBody InfoMuestraNueva muestraNueva){

        GenericResponse rta= new GenericResponse();
        MuestraResponse otrarespuesta = new MuestraResponse();

        Muestra muestra = muestraService.registrar(muestraNueva.boyaId, muestraNueva.horario, muestraNueva.matricula, muestraNueva.latitud, muestraNueva.longitud, muestraNueva.alturaNivelMar);

        otrarespuesta.id = muestra.getMuestraId();
        otrarespuesta.color = muestra.getBoya().getColorLuz();

        return ResponseEntity.ok(otrarespuesta);
    }
}
