package com.brq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Criar um novo micro serviço que faz um CRUD em de Professores.
// Criar um ArrayList na camada de Controller para armazenar os professores.
//Cada professor deve ter id, nome, email , salário,  rua, número, cep
@SpringBootApplication
public class Ms02Application {
	public static void main(String[] args) {
		SpringApplication.run(Ms02Application.class, args);
	}

}
