package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CdrUsuarioRepo extends JpaRepository<CdrUsuario, Integer> {

    Optional<CdrUsuario> findByUsuEmail(String email);
    Optional<CdrUsuario> findByUsuUsername(String username);
}
