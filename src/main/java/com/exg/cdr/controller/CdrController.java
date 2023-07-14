package com.exg.cdr.controller;

import com.exg.cdr.entities.CdrUsuario;
import com.exg.cdr.repo.CdrUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cdr")
public class CdrController {

    @Autowired
    private CdrUsuarioRepo usuarioRepo;

    @GetMapping("/get-users")
    List<CdrUsuario> getUsers() {
        try {
            return usuarioRepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
