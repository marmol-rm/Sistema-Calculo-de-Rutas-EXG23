package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CdrUbicacionRepo extends JpaRepository<CdrUbicacion, Integer> {

    Optional<CdrUbicacion> findByUbiNombre(String nombre);

}
