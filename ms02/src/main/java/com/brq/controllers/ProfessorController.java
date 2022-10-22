package com.brq.controllers;

import com.brq.dtos.ProfessorDTO;
import com.brq.models.ProfessorModel;
import com.brq.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfessorController {
    private ArrayList<ProfessorModel> professores = new ArrayList<>();
    private int counter = 1;
    @Autowired
    private ProfessorService profService;


    @GetMapping("professores")
    public List<ProfessorDTO> getAllProfessores() {
        profService.mostrarMensagemService();
        return profService.getAllProfessores();
    }
    @GetMapping("professores/{id}")
    public ProfessorDTO getOne(@PathVariable int id) {
        return profService.getOne(id);
    }

    @PostMapping("professores")
    public ProfessorDTO create(@Valid @RequestBody ProfessorDTO professor) {
        var prof = profService.create(professor);
        return prof;
    }
    @PatchMapping("professores/{id}")
    public ProfessorDTO update(@RequestBody ProfessorDTO professorBody,
                             @PathVariable int id ){
        return profService.update(id, professorBody);
    }
    @DeleteMapping("professores/{id}")
    public String delete(@PathVariable int id) {
        return profService.delete(id);
    }

}
