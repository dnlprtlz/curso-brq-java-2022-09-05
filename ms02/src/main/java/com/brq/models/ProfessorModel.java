package com.brq.models;

import com.brq.dtos.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professores")

//Criar um novo micro serviço que faz um CRUD em de Professores.
// Criar um ArrayList na camada de Controller para armazenar os professores.
// Cada professor deve ter id, nome, email , salário,  rua, número, cep
public class ProfessorModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private int id;

    @Column(name = "nome_professor")
    private String nome;

    @Column(name = "email_professor")
    private String email;

    @Column(name = "salario_professor")
    private Double salario;

    @Column(name = "rua_professor")
    private String rua;

    @Column(name = "numero_professor")
    private String numero;

    @Column(name = "cep_professor")
    private String cep;

    public ProfessorDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ProfessorDTO.class);
    }

}

