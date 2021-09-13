package ar.com.ada.api.noaaboyas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.noaaboyas.entities.Boya;
import ar.com.ada.api.noaaboyas.entities.Boya.EstadoColorEnum;
import ar.com.ada.api.noaaboyas.repos.BoyaRepository;

public class BoyaService {

    @Autowired
    BoyaRepository repo;

    public Boya crear(Double longitudInstalacion, Double latitudInstalacion) {

        Boya boya = new Boya();
        boya.setColorLuz(null);
        boya.setLongitudInstalacion(longitudInstalacion);
        boya.setLatitudInstalacion(latitudInstalacion);

        return repo.save(boya);
    }

    public List<Boya> traerBoyas() {
        return repo.findAll();
    }

    public Boya buscarPorId(Integer id) {
        return repo.findByBoyaId(id);
    }

    public void actualizar(Boya boya) {
        repo.save(boya);
    }

    // nivel del mar
    // -50 o +50 AMARILLO
    // -100 o +100 ROJO
    // sino VERDE
    public Boya calcularColor(Boya boya, Double alturaNivelMar) {
        if (alturaNivelMar <= -50 || alturaNivelMar >= +50) {
            boya.setColorLuz(EstadoColorEnum.AMARILLO);

        } else if (alturaNivelMar == -100 || alturaNivelMar == +100) {
            boya.setColorLuz(EstadoColorEnum.ROJO);
        } else
            boya.setColorLuz(EstadoColorEnum.VERDE);

        return boya;
    }

}
