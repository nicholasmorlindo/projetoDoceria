package com.doceria.renata.model.response;

import com.doceria.renata.model.*;
import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PedidoResponse {

    private Long id;
    private TipoEntrega tipoEntrega;
    private Endereco endereco;
    private Pagamento pagamento;
    private StatusPedido statusPedido;
    private Usuario usuario;
    private Double valor_total;
    private Set<Pedido_Produto> pedido_produto = new HashSet<Pedido_Produto>();

    public PedidoResponse(Long id, TipoEntrega tipoEntrega, Endereco endereco, Pagamento pagamento, StatusPedido statusPedido, Usuario usuario, Double valor_total, Set<Pedido_Produto> pedido_produto) {
        this.id = id;
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pagamento = pagamento;
        this.statusPedido = statusPedido;
        this.usuario = usuario;
        this.valor_total = valor_total;
        this.pedido_produto = pedido_produto;
    }

    public static PedidoResponse toResponse(Pedido pedido){
        return new PedidoResponse(pedido.getId(),
                pedido.getTipoEntrega(),
                pedido.getEndereco(),
                pedido.getPagamento(),
                pedido.getStatusPedido(),
                pedido.getUsuario(),
                pedido.getValor_total(),
                pedido.getPedido_produto());
    }

    public Long getId() { return id; }
    public TipoEntrega getTipoEntrega() { return tipoEntrega; }
    public Endereco getEndereco() {
        return endereco;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public StatusPedido getStatusPedido() { return statusPedido; }
    public Usuario getUsuario() { return usuario; }
    public Double getValor() { return valor_total; }
    public Set<Pedido_Produto> getPedido_produto() { return pedido_produto; }
}
