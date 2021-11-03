package com.doceria.renata.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    @NotNull
    private Double valor;

    @NotNull
    private Integer quantidade;

    @OneToOne
    private Produto produto;

    public Carrinho(){
    }

    public Carrinho(Usuario usuario, Integer quantidade, Produto produto) {
        this.usuario = usuario;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setValor(Double valor) {
        this.valor = quantidade * valor;
    }
}
