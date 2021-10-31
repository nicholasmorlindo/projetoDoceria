package com.doceria.renata.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido_Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pedido pedido;

    @OneToOne
    private Produto produto;

    @NotNull
    private Integer quantidade;

    @NotNull
    private Double valor_unitario;

    public Pedido_Produto(){}

    public Pedido_Produto(Pedido pedido, Produto produto, Integer quantidade, Double valor_unitario) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }
}
