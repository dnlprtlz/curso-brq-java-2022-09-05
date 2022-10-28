package com.brq.ms01.repositories;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    List<UsuarioModel> findByNome(String nome);
    List<UsuarioModel> findByNomeContains(String nome);
    List<UsuarioModel> findByNomeContainsAndEmailContainsAndEnderecoRuaContains(String nome, String email, String rua);
}
