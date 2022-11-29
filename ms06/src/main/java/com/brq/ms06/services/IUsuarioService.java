package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;

import java.util.List;

public interface IUsuarioService {

	    List<UsuarioDTO> getAll();
	    List<UsuarioDTO> findByNome(String nome);
	    List<UsuarioDTO> searchByNome(String nome);

	    UsuarioDTO create(UsuarioModel model);

	    UsuarioDTO update(String id, UsuarioDTO dto);

	    void delete(String id);

	    UsuarioDTO getOne(String id);

}
