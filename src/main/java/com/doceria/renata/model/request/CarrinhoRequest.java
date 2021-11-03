package com.doceria.renata.model.request;

import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Pedido_Produto;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.Usuario;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoRequest {

    @NotNull
    private Long usuario;

    @NotNull
    private Integer quantidade;

    @NotNull
    private Long produto;

    public CarrinhoRequest(Long usuario, Integer quantidade, Long produto) {
        this.usuario = usuario;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Carrinho toModel(Produto produto, Usuario usuario){
        return new Carrinho(usuario,this.quantidade,produto);
    }

    public Long getUsuario() {
        return usuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Long getProduto() {
        return produto;
    }
}
