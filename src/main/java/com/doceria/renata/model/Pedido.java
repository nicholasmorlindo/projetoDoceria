package com.doceria.renata.model;

import com.doceria.renata.model.enumerator.StatusPedido;
import com.doceria.renata.model.enumerator.TipoEntrega;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.ORDINAL)
    private TipoEntrega tipoEntrega = TipoEntrega.RETIRADA;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;

    @OneToOne
    private Usuario usuario;

    @NotNull
    private Double valor_total = 0.0;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Set<Pedido_Produto> pedido_produto = new HashSet<Pedido_Produto>();

    public Pedido(){
    }

    public Pedido(TipoEntrega tipoEntrega, Endereco endereco, Pagamento pagamento, Usuario usuario) {
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pagamento = pagamento;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
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

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public Set<Pedido_Produto> getPedido_produto() {
        return pedido_produto;
    }

    public void addProduto(Pedido_Produto pedido_produto){
        this.pedido_produto.add(pedido_produto);
    }

    public void calcularValorTotal(){
        pedido_produto.forEach(x -> {
            valor_total = valor_total + x.getValor();
        });
    }
}
