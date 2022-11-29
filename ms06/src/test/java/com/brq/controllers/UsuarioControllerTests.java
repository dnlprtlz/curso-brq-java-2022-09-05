package com.brq.controllers;

import com.brq.ms06.controllers.UsuarioController;
import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsuarioControllerTests {

    @Autowired
    private UsuarioController controller;

    @MockBean
    private UsuarioService service;

    @Test
    void getAllTest(){
        // dado que

        //quando
        final var usuarioDTO = createUsuarioDTO();
        final var listDTO = Arrays.asList(usuarioDTO);
        when(service.getAll()).thenReturn(listDTO);

        //então
        final var response = controller.getAll();

        //validação
        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(listDTO);
        verify(service, times(1)).getAll();
    }

    @Test
    void createTest(){
        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";

        // quando
        final var usuarioDTOInput = createUsuarioDTO(null, nome, email);
        final var usuarioDTOOutput = createUsuarioDTO(id, nome, email);
        when(service.create(usuarioDTOInput.toModel())).thenReturn(usuarioDTOOutput);

        // então
        final var response = controller.create(usuarioDTOInput);

        //validação
        assertThat(response.getBody().getNome()).isEqualTo(nome);
        assertThat(response.getBody().getEmail()).isEqualTo(email);
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(service, times(1)).create(usuarioDTOInput.toModel());
    }

    @Test
    void updateTest(){
        // dado que
        String id = "1";
        String nomeExpected = "nome-alterado";
        String emailExpected = "email-alterado";

        // quando
        final var usuarioDTO = createUsuarioDTO(id, nomeExpected,emailExpected);
        when(service.update(id, usuarioDTO )).thenReturn(usuarioDTO);

        //então
        final var response = controller.update(id, usuarioDTO);

        //validação
        assertThat(response.getBody().getNome()).isEqualTo(nomeExpected);
        assertThat(response.getBody().getEmail()).isEqualTo(emailExpected);
        assertThat(response.getBody().getId()).isEqualTo(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(service, times(1)).update(id, usuarioDTO);
    }

    @Test
    void deleteTest(){
        // dado que
        String id = "1";

        // quando
        // não vamos mockar o usuario.delete, pois o mesmo não possui retorno

        //então
        final var response = controller.delete(id);

        // validação
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(service, times(1)).delete(id);
    }

    @Test
    void getOneTest(){
        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";

        // quando
        final var usuarioDTO =createUsuarioDTO(id, nome, email);
        when(service.getOne(id)).thenReturn(usuarioDTO);

        // então
        final var response = controller.getOne(id);

        // validação
        assertThat(response.getBody().getNome()).isEqualTo(nome);
        assertThat(response.getBody().getEmail()).isEqualTo(email);
        assertThat(response.getBody().getId()).isEqualTo(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(service, times(1)).getOne(id);
    }

    private UsuarioDTO createUsuarioDTO(){

        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome("nome");
        dto.setEmail("email");

        return dto;
    }

    private UsuarioDTO createUsuarioDTO(String id, String nome, String email){

        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(nome);
        dto.setEmail(email);

        return dto;
    }

}
