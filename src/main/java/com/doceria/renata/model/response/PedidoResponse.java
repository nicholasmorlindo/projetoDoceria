package com.doceria.renata.model.response;

import com.doceria.renata.model.*;
import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;
import java.util.ArrayList;
import java.util.List;

public class PedidoResponse {

    private Long id;

    private TipoEntrega tipoEntrega;

    private Endereco endereco;

    private Pagamento pagamento;

    private StatusPedido statusPedido;

    private Usuario usuario;

    private Double valor_total;

    private List<Pedido_Produto> pedido_produto = new ArrayList<>();

    public PedidoResponse(
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
        this.statusPedido = statusPedido;
        this.usuario = usuario;
        this.valor_total = valor_total;
        this.pedido_produto = pedido_produto;
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
    public List<Pedido_Produto> getPedido_produto() { return pedido_produto; }
}
