package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {
    private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private int counter = 1;
    /*
     * o @GetMapping permite associoar o verbo GET com a rota /usuarios
     * */
    @GetMapping("usuarios")
    public ArrayList<UsuarioModel> getAllUsuarios(){
//        for (int i = 0; i < 10; i++) {
//            UsuarioModel u = new UsuarioModel(i + 1, "usuario", "usuario@mail.com");
//            usuarios.add(u);
//        }
//
        return usuarios;
    }
    @PostMapping("usuarios")
    public UsuarioModel create(@RequestBody UsuarioModel usuario){
        usuario.setId( counter );
        usuarios.add(usuario);
        counter++;
        return usuario;
    }
}