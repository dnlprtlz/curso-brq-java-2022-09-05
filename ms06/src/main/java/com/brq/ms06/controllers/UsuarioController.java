package com.brq.ms06.controllers;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.mappers.UsuarioMapper;
import com.brq.ms06.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ApiOperation(
        value = "API de Usuários"
)
@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @ApiOperation(
            value = "retorna todos os usuários",
            notes = "retorna todos os usuários do Mongo"
    )
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        return  ResponseEntity.ok().body( this.service.getAll() );
    }
    
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<UsuarioDTO>> findByName(@PathVariable String nome){
        return  ResponseEntity.ok().body( this.service.findByNome(nome) );
    }

    @GetMapping(value = "/buscarnome")
    public ResponseEntity<List<UsuarioDTO>> searchByName(@RequestParam("nome") String nome){
        return  ResponseEntity.ok().body( this.service.searchByNome(nome) );
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body( service.create(dto.toModel())  );
    }

    @PatchMapping (value = "{id}")
    public ResponseEntity<UsuarioDTO> update(
            @PathVariable String id,
            @Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id){
        return ResponseEntity.ok().body( service.getOne(id) );
    }

}