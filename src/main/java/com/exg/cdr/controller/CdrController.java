package com.exg.cdr.controller;

import com.exg.cdr.request.RutaRequest;
import com.exg.cdr.entities.CdrPlantillaCorreo;
import com.exg.cdr.entities.CdrRutas;
import com.exg.cdr.entities.CdrUbicacion;
import com.exg.cdr.entities.CdrUsuario;
import com.exg.cdr.repo.CdrPlantillaCorreoRepo;
import com.exg.cdr.repo.CdrRutasRepo;
import com.exg.cdr.repo.CdrUbicacionRepo;
import com.exg.cdr.repo.CdrUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    private JavaMailSender emailSender;

    @GetMapping("/get-users")
    List<CdrUsuario> getUsers() {
        try {
            return usuarioRepo.findAll();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/get-rutas")
    List<CdrRutas> getRutas() {
        try {
            return rutasRepo.findAll();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping("/save-user")
    ResponseEntity<CdrUsuario> saveUser(@RequestBody CdrUsuario usr) {
        try {
            if(usuarioRepo.findByUsuEmail(usr.getUsuEmail()).orElse(null) == null &&
            usuarioRepo.findByUsuUsername(usr.getUsuUsername()).orElse(null) == null) {
                usr = usuarioRepo.save(usr);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return ResponseEntity.ok(usr);
    }

    @PostMapping("/save-ubi")
    ResponseEntity<CdrUbicacion> saveUbicacion(@RequestBody CdrUbicacion ubi) {
        try {
            if(ubicacionRepo.findByUbiNombre(ubi.getUbiNombre()).orElse(null) == null)
                ubi = ubicacionRepo.save(ubi);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return ResponseEntity.ok(ubi);
    }

    @PostMapping("/save-ruta")
    ResponseEntity<CdrRutas> saveRuta(@RequestBody RutaRequest r) {
        // Se crea la ruta base
        CdrRutas ruta = new CdrRutas(
                null, r.getCoordPartida(), r.getCoordDestino(),
                r.getHoraInicio(), r.getHoraFin(), false,
                new Date(), r.getDistanciaTotal(), 'V'
        );
        try {
            CdrPlantillaCorreo plantilla = plantillaCorreoRepo.findById(1).orElse(new CdrPlantillaCorreo());
            CdrUbicacion ubiPartida = ubicacionRepo.findByUbiNombre(r.getUbiPartida()).orElse(null);
            CdrUbicacion ubiDestino = ubicacionRepo.findByUbiNombre(r.getUbiDestino()).orElse(null);

            if(ubiPartida == null && r.getUbiPartida() != null) {
                ubiPartida = new CdrUbicacion(null, r.getUbiPartida(), false);
                ubiPartida = ubicacionRepo.save(ubiPartida);
            }
            if(ubiDestino == null && r.getUbiDestino() != null) {
                ubiDestino = new CdrUbicacion(null, r.getUbiDestino(), false);
                ubiDestino = ubicacionRepo.save(ubiDestino);
            }
            // Se le agregan los valores de usuario y ubicaciones
            ruta.setRutUsuId(usuarioRepo.findByUsuEmail(r.getUsuEmail()).orElse(null));
            ruta.setRutUbiPartida(ubiPartida);
            ruta.setRutUbiDestino(ubiDestino);
            if(ruta.getRutUbiDestino() != null)
                ruta = rutasRepo.save(ruta);

            // Se envía el correo de finaluzacion
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("");
            message.setTo(r.getUsuEmail());
            message.setSubject(plantilla.getPctAsunto());
            message.setText(plantilla.getPtcMensaje());
            //emailSender.send(message);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return ResponseEntity.ok(ruta);
    }

}
