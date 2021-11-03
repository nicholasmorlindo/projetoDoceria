package com.doceria.renata.model.response;

import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.Usuario;

public class CarrinhoResponse {

    private Long id;
    private Double valor;
    private Integer quantidade;
    private Produto produto;

    public CarrinhoResponse(Long id, Double valor, Integer quantidade, Produto produto) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public static CarrinhoResponse toResponse(Carrinho carrinho){
        return new CarrinhoResponse(carrinho.getId(),
                carrinho.getValor(),
                carrinho.getQuantidade(),
                carrinho.getProduto());
    }

    public Long getId() {
        return id;
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
}
