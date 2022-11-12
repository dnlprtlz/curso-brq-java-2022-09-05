package com.brq.ms06.controllers;

import com.brq.ms06.dtos.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>>
}
