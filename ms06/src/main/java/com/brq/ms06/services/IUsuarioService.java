package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    void mostrarMensagemService();
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO create(UsuarioDTO usuario);
    UsuarioDTO update(String id, UsuarioDTO usuarioBody);
    String delete(String id);
    UsuarioDTO getOne(String id);
}