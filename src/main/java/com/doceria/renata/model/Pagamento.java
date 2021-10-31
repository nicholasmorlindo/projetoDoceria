package com.doceria.renata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String numero_cartao;

    @NotEmpty
    private String nome_cartao;

    @FutureOrPresent
    private Date validade_cartao;

    @NotNull
    private Integer cod_cartao;

    public Pagamento(){
    }

    public Pagamento(String numero_cartao, String nome_cartao, Date validade_cartao, Integer cod_cartao) {
        this.numero_cartao = numero_cartao;
        this.nome_cartao = nome_cartao;
        this.validade_cartao = validade_cartao;
        this.cod_cartao = cod_cartao;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public String getNome_cartao() {
        return nome_cartao;
    }

    public Date getValidade_cartao() {
        return validade_cartao;
    }

    public Integer getCod_cartao() {
        return cod_cartao;
    }
}
