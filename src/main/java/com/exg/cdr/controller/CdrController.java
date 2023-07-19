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
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

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
    @Autowired
    private JavaMailSender emailSender;
    private static final Logger LOG = Logger.getLogger(CdrController.class.getName());

    @GetMapping("/get-users")
    List<CdrUsuario> getUsers() {
        try {
            return usuarioRepo.findAll();
        } catch (Exception e) {
            LOG.severe(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    @PostMapping ("/val-user")
    Boolean validateUser(@RequestBody CdrUsuario u) {
        try {
            return !usuarioRepo.validate(u.getUsuEmail(), u.getUsuPassword()).isEmpty();
        } catch (Exception e) {
            LOG.severe(e.getLocalizedMessage());
            return false;
        }
    }

    @GetMapping("/get-rutas")
    List<CdrRutas> getRutas(@RequestParam String email, @RequestParam(required = false) String fecha) {
        if(fecha != null) {
            try {
                CdrUsuario usuario = usuarioRepo.findByUsuEmail(email).orElse(null);
                if(usuario != null) {
                    return rutasRepo.findByRutFecha(fecha, usuario.getUsuId());
                } else {
                    return new ArrayList<>();
                }
            } catch (Exception e) {
                LOG.severe(e.getLocalizedMessage());
                return new ArrayList<>();
            }
        } else {
            try {
                return rutasRepo.findAll();
            } catch (Exception e) {
                LOG.severe(e.getLocalizedMessage());
                return new ArrayList<>();
            }
        }
    }

    @GetMapping("/get-ubi")
    List<CdrUbicacion> getUbicacion(@RequestParam(required = true) String email) {
        if(email != null) {
            try {
                return ubicacionRepo.findUbiVisitadas(email);
            } catch (Exception e) {
                LOG.severe(e.getLocalizedMessage());
                return new ArrayList<>();
            }
        } else {
            try {
                return ubicacionRepo.findAll();
            } catch (Exception e) {
                LOG.severe(e.getLocalizedMessage());
                return new ArrayList<>();
            }
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
            LOG.severe(e.getLocalizedMessage());
        }

        return ResponseEntity.ok(usr);
    }

    //@PutMapping("/update-ubi")
    ResponseEntity<CdrUbicacion> updateUbicacion(@RequestBody CdrUbicacion ubi) {
        try {
            if(ubicacionRepo.existsById(ubi.getUbiId()))
                ubi = ubicacionRepo.save(ubi);
        } catch (Exception e) {
            LOG.severe(e.getLocalizedMessage());
        }

        return ResponseEntity.ok(ubi);
    }

    @PostMapping("/save-ruta")
    ResponseEntity<CdrRutas> saveRuta(@RequestBody RutaRequest r) {
        // Se crea la ruta base
        CdrRutas ruta = new CdrRutas(
                null, r.getCoordPartida(), r.getCoordDestino(),
                r.getHoraInicio(), r.getHoraFin(), false,
                new Date(), r.getDistanciaTotal(), 'V', r.getTiempoTotal()
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
            // Se envía el correo de finalizacion
            SimpleMailMessage message = new SimpleMailMessage();
            String destino = "Usted ha llegado a: " +
                    ruta.getRutUbiDestino().getUbiNombre() + ". ";
            message.setFrom("CDR");
            message.setTo(r.getUsuEmail());
            message.setSubject(plantilla.getPctAsunto());
            message.setText(plantilla.getPtcSaludo() + destino +
                            plantilla.getPtcMensaje() +
                            plantilla.getPtcDespedida()
            );
            emailSender.send(message);
            LOG.info("Se ha enviado el correo.");
        } catch (Exception e) {
            LOG.severe(e.getLocalizedMessage());
        }

        return ResponseEntity.ok(ruta);
    }

}
