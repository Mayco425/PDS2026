package com.bibliotecar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String endereco;

    private String tipoUsuario; // Aluno, Bibliotecario, Administrador

    private String status; // ATIVO ou INATIVO
}