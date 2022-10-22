package com.brq.exemplo01.services;

import com.brq.exemplo01.dtos.ExemploDTO;
import com.brq.exemplo01.models.ExemploModel;
import com.brq.exemplo01.repositories.ExemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExemploService {

    @Autowired
    private ExemploRepository exeRepository;

    public List<ExemploDTO> getAllUsuarios(){
        List<ExemploModel> list = exeRepository.findAll();
        List<ExemploDTO> listDTO = new ArrayList<>();
        for (ExemploModel animal: list) {
            listDTO.add( animal.toDTO() );
        }
        return listDTO;
    }
    public ExemploDTO getOne(int id){
        ExemploModel animais = exeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Não encontrou"));
        return animais.toDTO();
    }
    public ExemploDTO create(ExemploDTO animal){
        ExemploModel animalSalvo = exeRepository.save(animal.toModel());
        return animalSalvo.toDTO();
    }

    public void delete(int id){
        exeRepository.deleteById(id);
    }

    public ExemploDTO update(int id, ExemploDTO animal){
        ExemploModel animais = exeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Não encontrou"));

        animais.setPeso   (animal.getPeso());
        animais.setNome   (animal.getNome());
        animais.setOrigem (animal.getOrigem());
        animais.setApelido(animal.getApelido());
        animais.setIdade  (animal.getIdade());
        animais.setRaca   (animal.getRaca());

        exeRepository.save(animais);
        return animais.toDTO();
    }

}
