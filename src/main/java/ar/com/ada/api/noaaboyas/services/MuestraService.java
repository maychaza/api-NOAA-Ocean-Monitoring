package ar.com.ada.api.noaaboyas.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaaboyas.entities.Boya;
import ar.com.ada.api.noaaboyas.entities.Muestra;
import ar.com.ada.api.noaaboyas.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired 
    MuestraRepository repo;

    @Autowired
    BoyaService boyaService;

    public Muestra registrar(Integer boyaId, Date horario, String matricula, Double latitud, Double longitud,
            Double alturaNivelMar) {

        //Boya boya = new Boya();
       // boya.setBoyaId(boyaId);

        Muestra muestra = new Muestra();
        muestra.setHorarioMuestra(horario);
        muestra.setMatriculaEmbarcacion(matricula);
        muestra.setLatitud(latitud);
        muestra.setLongitud(longitud);
        muestra.setAlturaNivelMar(alturaNivelMar);


        return repo.save(muestra);
    }


    
}
