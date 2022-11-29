package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.enums.MensagensExceptionEnum;
import com.brq.ms06.exceptions.NaoAcheiException;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    public List<UsuarioDTO> getAll(){
        final var list = (List<UsuarioModel>) repository.findAll();

        return list
        		.stream()
        		.map( UsuarioModel::toDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> findByNome(String nome){
    	
    	
        final var list = (List<UsuarioModel>) repository.findByNome(nome);

        return list
        		.stream()
        		.map( UsuarioModel::toDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> searchByNome(String nome){
    	
    	
        final var list = (List<UsuarioModel>) repository.searchByNome(nome);

        return list
        		.stream()
        		.map( UsuarioModel::toDTO)
                .collect(Collectors.toList());
    }

    
    public UsuarioDTO create(UsuarioModel model){

        final var obj = repository.save(model);

        return obj.toDTO();
    }

    public UsuarioDTO update(String id, UsuarioDTO dto){

        var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(
                        MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem())
                );

        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());

        usuario = repository.save(usuario);

        return usuario.toDTO();
    }

    public void delete(String id){

        final var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()) );

        repository.deleteById(usuario.getId());
    }

    public UsuarioDTO getOne(String id){

        final var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()) );

        return usuario.toDTO();
    }
}