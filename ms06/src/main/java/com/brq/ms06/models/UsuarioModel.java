
//Lição de CASA: spring mongo
//
//1-) fazer crud completo de usuários
//2-) usar response entity
//3-) criar DTOs
//4-) criar validação de campos nos DTOs
//5-) criar interface de services
//6-) criar testes unitários
package com.brq.ms06.models;

import com.brq.ms06.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class UsuarioModel {
    @Id
    private String id;

    private String nome;
    private String email;
    private String dataCadastro;
    private String tipo;

    public UsuarioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        UsuarioDTO DTO = mapper.map(this, UsuarioDTO.class);
        return DTO;
    }

}
