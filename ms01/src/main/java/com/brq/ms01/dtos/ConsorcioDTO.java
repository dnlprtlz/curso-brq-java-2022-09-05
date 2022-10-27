package com.brq.ms01.dtos;

import com.brq.ms01.models.ConsorcioModel;
import com.brq.ms01.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsorcioDTO {

    private Integer id;
    private String nome;
    private String tipo;
    private Double valor;
}