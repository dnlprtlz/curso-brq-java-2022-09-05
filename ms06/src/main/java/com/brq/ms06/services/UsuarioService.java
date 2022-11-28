package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.exceptions.DataCreateException;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService {
    
	@Autowired
    private UsuarioRepository usuRepository;

    public void mostrarMensagemService(){
        log.info("Mensagem do serviço");
    }

    public List<UsuarioDTO> getAllUsuarios(){

        List<UsuarioModel> list = (List<UsuarioModel>) usuRepository.findAll();

        List<UsuarioDTO> listDTO = new ArrayList<>();

        for (UsuarioModel balde : list) {
            listDTO.add( balde.toDTO() );
        }

        return listDTO;
    }

    public UsuarioDTO create(UsuarioDTO usuario){
        UsuarioModel usuarioSalvo = null;

        try{
            usuarioSalvo = usuRepository.save( usuario.toModel() );
            log.info(usuarioSalvo.toString());
            return usuarioSalvo.toDTO();
        }
        catch (Exception exception){
            log.error("Erro ao salvar o usuário: " + exception.getMessage());
            throw new DataCreateException("Erro ao salvar usuário");
        }
    }

    public UsuarioDTO update(String id, UsuarioDTO usuarioBody)  {

        UsuarioModel usuario = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );


        usuario.setEmail( usuarioBody.getEmail() );
        usuario.setNome( usuarioBody.getNome() );

        return usuRepository.save(usuario).toDTO();

    }

    public String delete(String id){

        final var usuario = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        usuRepository.deleteById(usuario.getId());
        return "Usuário delatado com sucesso!";
    }

    public UsuarioDTO getOne(String id){

        UsuarioModel usuario = usuRepository.findById(id)
                    .orElseThrow( () -> new RuntimeException("Usuário não localizado"));

        return usuario.toDTO();
    }


}