package com.brq.exemplo01.controllers;

import com.brq.exemplo01.dtos.ExemploDTO;
import com.brq.exemplo01.services.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ExemploController {
    @Autowired
    private ExemploService exeService;

    @GetMapping("animais")
    public List<ExemploDTO> getAllUsuarios(){
        return exeService.getAllUsuarios();
    }
    @GetMapping("animais/{id}")
    public ExemploDTO getOne(@PathVariable int id){
        return exeService.getOne(id);
    }
    @PostMapping("animais")
    public ExemploDTO create(@Valid  @RequestBody ExemploDTO animal){
        var ani = exeService.create(animal);
        return ani;
    }
    @DeleteMapping("animais/{id}")
    public void delete(@PathVariable int id){
        exeService.delete(id);
    }
    @PatchMapping("animais/{id}")
    public ExemploDTO update( @RequestBody ExemploDTO animal, @PathVariable int id){
        return exeService.update(id, animal);
    }
}
