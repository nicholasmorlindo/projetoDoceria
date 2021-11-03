package com.doceria.renata.model.request;


import com.doceria.renata.model.*;
import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;
import java.util.ArrayList;
import java.util.List;

public class PedidoRequest {

    private TipoEntrega tipoEntrega;
    private Endereco endereco;
    private Pagamento pagamento;
    private Long usuario;

    public PedidoRequest(
        TipoEntrega tipoEntrega,
        Endereco endereco,
        Pagamento pagamento,
        Long usuario
    ) {
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pagamento = pagamento;
        this.usuario = usuario;
    }

    public Pedido toModel(Usuario usuario){
        return new Pedido(
            this.tipoEntrega,
            this.endereco,
            this.pagamento,
            usuario
        );
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Long getUsuario() {
        return usuario;
    }
}
