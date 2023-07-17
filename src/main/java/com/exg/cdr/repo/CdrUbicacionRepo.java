package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdrUbicacionRepo extends JpaRepository<CdrUbicacion, Integer> {

    Optional<CdrUbicacion> findByUbiNombre(String ubiNombre);
    @Query("Select distinct ubi from CdrUbicacion ubi " +
            "INNER JOIN CdrRutas rut ON rut.rutUbiDestino.ubiId = ubi.ubiId " +
            "INNER JOIN CdrUsuario usu ON usu.usuId = rut.rutUsuId.usuId " +
            "where usu.usuEmail = ?1 ORDER BY ubi.ubiId DESC")
    List<CdrUbicacion> findUbiVisitadas(String email);

}
