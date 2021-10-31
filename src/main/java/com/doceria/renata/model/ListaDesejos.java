package com.doceria.renata.model;

import javax.persistence.*;

@Entity
public class ListaDesejos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Produto produto;

    @OneToOne
    private Usuario usuario;

    public ListaDesejos(){}

    public ListaDesejos(Produto produto, Usuario usuario) {
        this.produto = produto;
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
