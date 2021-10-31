package com.doceria.renata.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String rua;

    @NotEmpty
    private String bairro;

    @NotNull
    private Integer numero;

    public Endereco(){
    }

    public Endereco(String rua, String bairro, Integer numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getNumero() {
        return numero;
    }
}
