package com.doceria.renata.model;

import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.ORDINAL)
    private TipoEntrega tipoEntrega = TipoEntrega.RETIRADA;

    @OneToOne
    private Endereco endereco;

    @OneToOne
    private Pagamento pagamento;

    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusPedido;

    @OneToOne
    private Usuario usuario;

    @NotNull
    private Double valor_total;

    @OneToMany
    private List<Pedido_Produto> pedido_produto = new ArrayList<>();

    public Pedido(){
    }

    public Pedido(TipoEntrega tipoEntrega, Endereco endereco, Pagamento pagamento, StatusPedido statusPedido, Usuario usuario) {
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pagamento = pagamento;
        this.statusPedido = statusPedido;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public Double getValor_total() {
        return valor_total;
    }
}
