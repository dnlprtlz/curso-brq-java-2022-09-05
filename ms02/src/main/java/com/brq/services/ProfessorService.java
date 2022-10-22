package com.brq.services;
import com.brq.dtos.ProfessorDTO;
import com.brq.models.ProfessorModel;
import com.brq.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository profRepository;
    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }
    public List<ProfessorDTO> getAllProfessores(){
        List<ProfessorModel> list = profRepository.findAll();
        List<ProfessorDTO> listDTO = new ArrayList<>();
        for (ProfessorModel profs : list) {
            listDTO.add( profs.toDTO() );
        }

        return listDTO;
    }
    public ProfessorDTO getOne(int id){
        ProfessorModel prof = profRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Professor Não Encontrado"));

        return prof.toDTO();
    }

    public ProfessorDTO create(ProfessorDTO professor){
        ProfessorModel profSalvo = profRepository.save( professor.toModel() );
        return profSalvo.toDTO();
    }
    public ProfessorDTO update(int id, ProfessorDTO professorBody){
        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Professor não localizado") );
        professor.setId(professorBody.getId());
        professor.setNome(professorBody.getNome());
        professor.setSalario(professorBody.getSalario());
        professor.setEmail(professorBody.getEmail());
        professor.setRua(professorBody.getRua());
        professor.setNumero(professorBody.getNumero());
        professor.setCep(professorBody.getCep());

        return profRepository.save(professor).toDTO();

    }
    public String delete(int id){
        profRepository.deleteById(id);
        return  "Deletado com sucesso!";
    }


}
