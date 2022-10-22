package com.brq.exemplo01.models;

import com.brq.exemplo01.dtos.ExemploDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animais")

public class ExemploModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_animal")
    private int id;
    @Column (name = "nome_animal", length = 50)
    private String nome;
    @Column (name = "apelido_animal", length = 50)
    private String apelido;
    @Column (name = "idade_animal")
    private int idade;
    @Column (name = "raca_animal", length = 50)
    private String raca;
    @Column (name = "peso_animal", precision = 2)
    private Double peso;
    @Column (name = "origem_animal", length = 50)
    private String origem;

    public ExemploDTO toDTO() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ExemploDTO.class);
    }

}
