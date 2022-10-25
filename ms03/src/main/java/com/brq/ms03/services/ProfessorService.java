package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProfessorService {
    private ProfessorRepository profRepository;

    public ProfessorDTO create(ProfessorDTO professor){
        ProfessorModel profSalvo = profRepository.save(professor.toModel());
        return profSalvo.toDTO();
    }
    public List<ProfessorDTO> getAllProfessores(){
       List<ProfessorModel> listModel = profRepository.findAll();
       List<ProfessorDTO> listDTO = new ArrayList<>();
       for (ProfessorModel profs : listModel){
            listDTO.add(profs.toDTO());
        }
       return listDTO;
    }
    public ProfessorDTO update(ProfessorDTO professor, int id){
        ProfessorModel profSalvo = profRepository
                .findById(id).orElseThrow(()-> new RuntimeException("Não encontrou"));
        profSalvo.setNome(professor.getNome());
        profSalvo.setCpf(professor.getCpf());
        profSalvo.setTelefone(professor.getTelefone());
        profSalvo.setSalario(professor.getSalario());

        return profRepository.save(profSalvo).toDTO();
    }
}
