package com.brq.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Criar um novo micro serviço que faz um CRUD em de Professores.
// Criar um ArrayList na camada de Controller para armazenar os professores.
// Cada professor deve ter id, nome, email , salário,  rua, número, cep
public class ProfessorModel {
    private int id;
    private String nome;
    private String email;
    private String salario;
    private String rua;
    private String numero;
    private String cep;
}
