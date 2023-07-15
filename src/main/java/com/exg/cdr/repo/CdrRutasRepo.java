package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrRutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrRutasRepo extends JpaRepository<CdrRutas, Integer> {
}
