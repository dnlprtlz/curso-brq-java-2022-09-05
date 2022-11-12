package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuRepository;

    public List<UsuarioDTO> getAllUsuarios(){

        List<UsuarioModel> list = usuRepository.findAll();
        List<UsuarioDTO> listDTO = new ArrayList<>();

        for (UsuarioModel user : list) {
            listDTO.add( user.toDTO() );
        }
        return listDTO;
    }
}
