package com.doceria.renata.model.request;


import com.doceria.renata.model.*;
import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;
import java.util.ArrayList;
import java.util.List;

public class PedidoRequest {


    TipoEntrega tipoEntrega;

    Endereco endereco;

    Pagamento pagamento;

    StatusPedido statusPedido;

    Usuario usuario;

    Double valor_total;

    List<Pedido_Produto> pedido_produto = new ArrayList<>();

    public PedidoRequest(
        TipoEntrega tipoEntrega,
        Endereco endereco,
        Pagamento pagamento,
        StatusPedido statusPedido,
        Usuario usuario,
        Double valor_total,
        List<Pedido_Produto> pedido_produto

    ) {
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pagamento = pagamento;
        this.statusPedido =statusPedido;
        this.usuario = usuario;
        this.valor_total = valor_total;
        this.pedido_produto = pedido_produto;
    }

    public Pedido toModel(){
        return new Pedido(
            this.tipoEntrega,
            this.endereco,
            this.pagamento,
            this.statusPedido,
            this.usuario
        );
    }
}
