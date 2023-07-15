package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrPlantillaCorreo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrPlantillaCorreoRepo extends JpaRepository<CdrPlantillaCorreo, Integer> {
}
