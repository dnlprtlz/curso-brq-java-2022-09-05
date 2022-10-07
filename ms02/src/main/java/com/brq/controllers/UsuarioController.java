package com.brq.controllers;

import com.brq.models.UsuarioModel;
import org.springframework.web.bind.annotation.*;

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
    public ArrayList<UsuarioModel> getAllUsuarios() {

//
        return usuarios;
    }

    @PostMapping("usuarios")
    public UsuarioModel create(@RequestBody UsuarioModel usuario) {
        usuario.setId(counter);
        usuarios.add(usuario);
        counter++;
        return usuario;
    }

    @PatchMapping("usuarios/{id}")
    public UsuarioModel update(@RequestBody UsuarioModel usuario,
                               @PathVariable int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.get(i).setNome(usuario.getNome());
                usuarios.get(i).setEmail(usuario.getEmail());

                return usuarios.get(i);
            }
        }
        return null;
    }
    @GetMapping("usuarios/{id}")
    public UsuarioModel getOne(@PathVariable int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return usuarios.get(i);
            }
        }
        return null;
    }
    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                return "Feito";
            }
        }
        return null;
    }

}