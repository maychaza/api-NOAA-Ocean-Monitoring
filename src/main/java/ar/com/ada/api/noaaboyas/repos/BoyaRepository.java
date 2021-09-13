package ar.com.ada.api.noaaboyas.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.noaaboyas.entities.Boya;

@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer> {

    Boya findByBoyaId(Integer boyaId);
    
}
