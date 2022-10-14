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
    @Column(name = "idProfessor")
    private int id;
    @Column(name = "nomeProfessor")
    private String nome;
    @Column(name = "emailProfessor")
    private String email;
    @Column(name = "salarioProfessor")
    private String salario;
    @Column(name = "ruaProfessor")
    private String rua;
    @Column(name = "numeroProfessor")
    private String numero;
    @Column(name = "cepProfessor")
    private String cep;

    public ProfessorDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        ProfessorDTO model = mapper.map(this, ProfessorDTO.class);
        return model;
    }

}

