package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdrUsuarioRepo extends JpaRepository<CdrUsuario, Integer> {

    Optional<CdrUsuario> findByUsuEmail(String usuEmail);
    Optional<CdrUsuario> findByUsuUsername(String usuUsername);

    @Query("SELECT u FROM CdrUsuario u WHERE u.usuEmail = ?1 AND u.usuPassword = ?2")
    List<CdrUsuario> validate(String email, String pwd);
}
