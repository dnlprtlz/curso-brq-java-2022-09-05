package com.brq.ms03.controllers;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    private ProfessorService profService;

    @PostMapping
    public ProfessorDTO create(@RequestBody ProfessorDTO professor){
        var prof = profService.create(professor);
        return prof;
    }
    @GetMapping
    public List<ProfessorDTO> getAllProfessores(){
            return profService.getAllProfessores();
    }

    @PatchMapping
    public ProfessorDTO update(@RequestBody ProfessorDTO professor,
                               @PathVariable int id){
        return profService.update(professor, id);

    }

}
