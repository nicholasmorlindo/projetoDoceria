package com.doceria.renata.model.request;

import com.doceria.renata.model.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UsuarioRequest {

    @Email @NotEmpty
    private String email;

    @NotEmpty
    private String senha;

    public UsuarioRequest(){
    }

    public UsuarioRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
