package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrUsuarioRepo extends JpaRepository<CdrUsuario, Integer> {
}
