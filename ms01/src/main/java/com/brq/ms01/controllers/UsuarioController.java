package com.brq.ms01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {

    /*
     * o @GetMapping permite associoar o verbo GET com a rota /usuarios
     * */
    @GetMapping("usuarios")
    public String getAllUsuarios(){
        return "GET Usuários aqui batatattatat";
    }
    @PostMapping("usuarios")
    public String create(){
        return "POST Usuários";
    }
}