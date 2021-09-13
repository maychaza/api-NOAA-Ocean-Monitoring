package ar.com.ada.api.noaaboyas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaaboyas.entities.Boya;
import ar.com.ada.api.noaaboyas.models.request.InfoBoyaNueva;
import ar.com.ada.api.noaaboyas.models.request.InfoEstadoColorBoya;
import ar.com.ada.api.noaaboyas.models.response.GenericResponse;
import ar.com.ada.api.noaaboyas.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;
    
    @PostMapping("api/boyas")
    public ResponseEntity<GenericResponse> crear(@RequestBody InfoBoyaNueva boyaNueva){

        GenericResponse rta = new GenericResponse();

        Boya boya = service.crear(boyaNueva.longitudInstalacion, boyaNueva.latitudInstalacion);

        rta.isOk = true;
        rta.id = boya.getBoyaId();
        rta.message = "Se crea la boya con éxito";

        return ResponseEntity.ok(rta);
    }


    @GetMapping("api/boyas")
    public ResponseEntity<List<Boya>> traerBoyas(@RequestBody Boya boya){

        return ResponseEntity.ok(service.traerBoyas());
    }

    @GetMapping("api/boyas/{id}")
    public ResponseEntity<Boya> getBoyas(@PathVariable Integer id){
        Boya boya = service.buscarPorId(id);
        return ResponseEntity.ok(boya);
    }

    @PutMapping("api/boyas/{id}")
    public ResponseEntity<GenericResponse> actualizarBoya(@PathVariable Integer id, @RequestBody InfoEstadoColorBoya color){
        
        GenericResponse rta= new GenericResponse();
        rta.isOk = true;
        rta.message = "El color ha sido actualizado";

        Boya boya = service.buscarPorId(id);
        service.actualizar(boya);
        
        return ResponseEntity.ok(rta);
    }
}
    
