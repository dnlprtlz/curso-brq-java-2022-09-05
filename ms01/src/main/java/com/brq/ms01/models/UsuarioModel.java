package com.brq.ms01.models;
import java.util.ArrayList;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Column(name = "id_user")
    private int id;
    @Column(name = "name_user")
    private String nome;
    @Column(name = "email_user")
    private String email;

//    public UsuarioModel (){}
//    public UsuarioModel (int id, String nome, String email){
//        this.id = id;
//        this.nome = nome;
//        this.email = email;
}
