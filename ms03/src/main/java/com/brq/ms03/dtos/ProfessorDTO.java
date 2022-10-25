package com.brq.ms03.dtos;

import com.brq.ms03.models.ProfessorModel;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorDTO {
    private int id;
    private String nome;
    private String cpf;
    private Double salario;
    private String telefone;

    public ProfessorModel toModel(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProfessorModel.class);
    }
}
