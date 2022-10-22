package com.brq.exemplo01.dtos;
import com.brq.exemplo01.models.ExemploModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExemploDTO {

    private int id;
    @NotNull(message = "Campo Obrigatorio")
    private String nome;
    private String apelido;
    private int idade;
    @NotNull(message = "Campo Obrigatorio")
    private String raca;
    private Double peso;
    private String origem;

    public ExemploModel toModel() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ExemploModel.class);
    }
}
