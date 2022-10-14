package com.brq.ms01.models;
import java.util.ArrayList;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    @Column(name = "nome_user")
    private String nome;
    @Column(name = "email_user")
    private String email;
    @Column(name = "telefone_user")
    private String telefone;

    public UsuarioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, UsuarioDTO.class);
    }

//    public UsuarioModel (){}
//    public UsuarioModel (int id, String nome, String email){
//        this.id = id;
//        this.nome = nome;
//        this.email = email;
}
