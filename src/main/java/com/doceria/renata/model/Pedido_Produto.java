package com.doceria.renata.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido_Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @OneToOne
    private Produto produto;

    @NotNull
    private Integer quantidade;

    @NotNull
    private Double valor;

    public Pedido_Produto(){}

    public Pedido_Produto(Produto produto, Integer quantidade, Double valor_unitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor_unitario;
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

    public Double getValor() {
        return valor;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
