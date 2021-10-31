package com.doceria.renata.model.response;

import com.doceria.renata.model.Produto;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private Double valor;
    private String imagem;

    public ProdutoResponse(Long id, String nome, Double valor, String imagem) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public static ProdutoResponse toResponse(Produto produto){
        return new ProdutoResponse(produto.getId(),
                produto.getNome(),
                produto.getValor(),
                produto.getImagem());
    }
}
