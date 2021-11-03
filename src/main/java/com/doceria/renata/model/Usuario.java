package com.doceria.renata.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @Email @NotEmpty
    private String email;

    @NotEmpty
    private String senha;

    private String token = "";

    public Usuario(){
    }

    public Usuario(String nome, String sobrenome, String email, String senha, String token) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString()
    {
        return "Usuario: " + this.nome + " " + this.sobrenome + " - " + this.email + " Senha: " + this.senha + " Token: " + this.token;
    }
}
