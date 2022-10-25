package com.brq.ms03.models;

import com.brq.ms03.dtos.ProfessorDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="professores_01")
public class ProfessorModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private int id;

    @Column(name = "nome_professor")
    private String nome;

    @Column(name = "email_professor")
    private String cpf;

    @Column(name = "salario_professor")
    private Double salario;

    @Column(name = "cep_professor")
    private String telefone;

    public ProfessorDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProfessorDTO.class);
    }

}
