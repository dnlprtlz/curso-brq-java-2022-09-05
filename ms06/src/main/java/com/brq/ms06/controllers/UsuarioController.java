package com.brq.ms06.controllers;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuService;

    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

        // usuService.mostrarMensagemService();

        var usuarios = usuService.getAllUsuarios();

        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario){

        var usuarioResponse = usuService.create(usuario);

        return ResponseEntity.ok().body(usuarioResponse);

    }
    
    @PatchMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioBody,
                                @PathVariable String id ){

        var tiberio = usuService.update(id, usuarioBody);
        return ResponseEntity.ok().body(tiberio);
    } 
    
    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        var resp = usuService.delete(id);
        return ResponseEntity.ok().body(resp);
    } 

    @GetMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id){

        var u = usuService.getOne(id);
        return ResponseEntity.ok().body(u);

    } 

} // UsuarioController