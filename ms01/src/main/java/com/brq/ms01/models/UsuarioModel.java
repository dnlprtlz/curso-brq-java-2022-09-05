package com.brq.ms01.models;
import java.util.ArrayList;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModel {
    private int id;
    private String nome;
    private String email;

//    public UsuarioModel (){}
//    public UsuarioModel (int id, String nome, String email){
//        this.id = id;
//        this.nome = nome;
//        this.email = email;
}
