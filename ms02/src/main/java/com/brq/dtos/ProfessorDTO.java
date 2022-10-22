package com.brq.dtos;

import com.brq.models.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private int id;

    @NotNull(message = "Preenchimento Obrigatorio")
    private String nome;

    @NotNull(message = "Preenchimento Obrigatorio")
    private String email;

    private Double salario;
    private String rua;
    private String numero;
    private String cep;

    public ProfessorModel toModel(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProfessorModel.class);
    }
}