package com.exg.cdr.controller;

import com.exg.cdr.RutaRequest;
import com.exg.cdr.entities.CdrPlantillaCorreo;
import com.exg.cdr.entities.CdrRutas;
import com.exg.cdr.entities.CdrUbicacion;
import com.exg.cdr.entities.CdrUsuario;
import com.exg.cdr.repo.CdrPlantillaCorreoRepo;
import com.exg.cdr.repo.CdrRutasRepo;
import com.exg.cdr.repo.CdrUbicacionRepo;
import com.exg.cdr.repo.CdrUsuarioRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cdr")
public class CdrController {
    @Autowired
    private CdrUsuarioRepo usuarioRepo;
    @Autowired
    private CdrUbicacionRepo ubicacionRepo;
    @Autowired
    private CdrRutasRepo rutasRepo;
    @Autowired
    private CdrPlantillaCorreoRepo plantillaCorreoRepo;

    @GetMapping("/get-users")
    List<CdrUsuario> getUsers() {
        try {
            return usuarioRepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping("/save-user")
    ResponseEntity<CdrUsuario> saveUser(@RequestBody CdrUsuario usr) {
        try {
            if(usuarioRepo.findByUsuEmail(usr.getUsuEmail()).orElse(null) == null ||
            usuarioRepo.findByUsuUsername(usr.getUsuUsername()).orElse(null) == null) {
                usr = usuarioRepo.save(usr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(usr);
    }

    @PostMapping("/save-ubi")
    ResponseEntity<CdrUbicacion> saveUbicacion(@RequestBody CdrUbicacion ubi) {
        try {
            if(ubicacionRepo.findByUbiNombre(ubi.getUbiNombre()).orElse(null) == null)
                ubi = ubicacionRepo.save(ubi);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(ubi);
    }

    @PostMapping("/save-ruta")
    ResponseEntity<CdrRutas> saveRuta(@RequestBody RutaRequest r) {
        // Se crea la ruta base
        CdrRutas ruta = new CdrRutas(
                null, r.getRutCoordenadasPartida(), r.getRutCoordenadasDestino(),
                r.getRutHoraInicio(), r.getRutHoraFin(), r.isRutGuardada(), r.getRutFecha(),
                r.getRutTipo()
        );
        try {
            CdrPlantillaCorreo plantilla = plantillaCorreoRepo.findById(1).orElse(new CdrPlantillaCorreo());
            CdrUbicacion ubiPartida = ubicacionRepo.findByUbiNombre(r.getRutUbiPartida()).orElse(null);
            CdrUbicacion ubiDestino = ubicacionRepo.findByUbiNombre(r.getRutUbiDestino()).orElse(null);

            if(ubiPartida == null) {
                ubiPartida = new CdrUbicacion(null, r.getRutUbiPartida(), r.isRutGuardada());
                ubiPartida = ubicacionRepo.save(ubiPartida);
            }
            if(ubiDestino == null) {
                ubiDestino = new CdrUbicacion(null, r.getRutUbiDestino(), r.isRutGuardada());
                ubiDestino = ubicacionRepo.save(ubiDestino);
            }
            // Se le agregan los valores de usuario y ubicaciones
            ruta.setRutUsuId(new CdrUsuario(r.getRutUsuId()));
            ruta.setRutUbiPartida(ubiPartida);
            ruta.setRutUbiDestino(ubiDestino);
            ruta = rutasRepo.save(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(ruta);
    }

}
