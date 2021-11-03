package com.doceria.renata.model.request;

import com.doceria.renata.model.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UsuarioRequest {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @Email @NotEmpty
    private String email;

    @NotEmpty
    private String senha;

    public UsuarioRequest(){
    }

    public UsuarioRequest(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario toModel()
    {
        return new Usuario(
            this.nome,
            this.sobrenome,
            this.email,
            this.senha,
            ""
        );
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
}
