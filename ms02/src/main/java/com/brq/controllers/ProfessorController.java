package com.brq.controllers;

import com.brq.models.ProfessorModel;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ProfessorController {
    private ArrayList<ProfessorModel> professores = new ArrayList<>();
    private int counter = 1;

    @GetMapping("professores")
    public ArrayList<ProfessorModel> getAllProfessores() {
        return professores;
    }

    @PostMapping("professores")
    public ProfessorModel create(@RequestBody ProfessorModel professor) {
        professor.setId(counter);
        professores.add(professor);
        counter++;
        return professor;
    }

    @PatchMapping("professores/{id}")
    public ProfessorModel update(@RequestBody ProfessorModel professor,
                               @PathVariable int id) {
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId() == id) {
                professores.get(i).setNome(professor.getNome());
                professores.get(i).setEmail(professor.getEmail());
                professores.get(i).setSalario(professor.getSalario());
                professores.get(i).setRua(professor.getRua());
                professores.get(i).setNumero(professor.getNumero());
                professores.get(i).setCep(professor.getCep());
                return professores.get(i);
            }
        }
        return null;
    }
    @GetMapping("professores/{id}")
    public ProfessorModel getOne(@PathVariable int id) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId() == id) {
                return professores.get(i);
            }
        }
        return null;
    }
    @DeleteMapping("professores/{id}")
    public String delete(@PathVariable int id) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId() == id) {
                professores.remove(i);
                return "Feito";
            }
        }
        return null;
    }

}
