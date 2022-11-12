
//Lição de CASA: spring mongo
//
//1-) fazer crud completo de usuários
//2-) usar response entity
//3-) criar DTOs
//4-) criar validação de campos nos DTOs
//5-) criar interface de services
//6-) criar testes unitários
package com.brq.ms06.dtos;

import com.brq.ms06.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.ui.ModelMap;
import org.modelmapper.ModelMapper;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioDTO {
    private String id;

    @NotEmpty(message = "Valor em branco")
    @NotNull(message = "Preenchimento Obrigatório")
    @Length(min=3, max= 50, message = "O número de caracteres deve ser entre 3 e 50")
    private String nome;

    @NotNull(message = "Preenchimento Obrigatório")
    private String email;private String dataCadastro;
    private String tipo;

    public UsuarioModel toModel(){
        ModelMapper mapper = new ModelMapper();
        UsuarioModel model = mapper.map(this, UsuarioModel.class);
        return model;
    }
}
