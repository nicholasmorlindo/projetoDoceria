package com.doceria.renata.model.request;

import com.doceria.renata.model.Produto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private Double valor;

    @NotEmpty
    private String imagem;

    public ProdutoRequest(String nome, Double valor, String imagem) {
        this.nome = nome;
        this.valor = valor;
        this.imagem = imagem;
    }

    public Produto toModel(){
        return new Produto(this.nome,this.valor,this.imagem);
    }

    public Produto toModelUpdate(Long id){
        return new Produto(this.nome,this.valor,this.imagem);
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public String getImagem() {
        return imagem;
    }
}
