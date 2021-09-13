package ar.com.ada.api.noaaboyas.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.noaaboyas.entities.Muestra;

public interface MuestraRepository extends JpaRepository<Muestra, Integer> {
    
}
