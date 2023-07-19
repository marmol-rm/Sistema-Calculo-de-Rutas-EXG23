package com.exg.cdr.repo;

import com.exg.cdr.entities.CdrRutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CdrRutasRepo extends JpaRepository<CdrRutas, Integer> {

    List<CdrRutas> findByRutFecha(Date rutFecha);
    @Query(nativeQuery = true,
            value = "select * from cdr_rutas r where r.rut_fecha = ?1 " +
                    "and r.rut_usu_id = ?2 order by rut_id desc")
    List<CdrRutas> findByRutFecha(String rutFecha, Integer id);
    List<CdrRutas> findByRutTipo(char rutTipo);

}
