package br.com.psytch.cafeteria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class TransacaoDePontos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pontos;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    private String descricao;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private CarteiraDePontos carteiraDePontos;

    // Construtor padrão (necessário para JPA)
    public TransacaoDePontos() {}

    // Construtor completo
    public TransacaoDePontos(int pontos, TipoTransacao tipoTransacao, String descricao, LocalDateTime data, CarteiraDePontos carteiraDePontos) {
        this.pontos = pontos;
        this.tipoTransacao = tipoTransacao;
        this.descricao = descricao;
        this.data = data;
        this.carteiraDePontos = carteiraDePontos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public CarteiraDePontos getCarteiraDePontos() {
        return carteiraDePontos;
    }

    public void setCarteiraDePontos(CarteiraDePontos carteiraDePontos) {
        this.carteiraDePontos = carteiraDePontos;
    }

    @Override
    public String toString() {
        return "TransacaoDePontos{" +
                "id=" + id +
                ", pontos=" + pontos +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", carteiraDePontosId=" + (carteiraDePontos != null ? carteiraDePontos.getId() : null) +
                '}';
    }
}
