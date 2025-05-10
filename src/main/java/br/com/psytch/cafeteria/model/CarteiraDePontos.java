package br.com.psytch.cafeteria.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carteiras")
public class CarteiraDePontos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pontos;

    @Enumerated(EnumType.STRING)
    private NivelFidelidade nivelFidelidade;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "carteiraDePontos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransacaoDePontos> transacoes = new ArrayList<>();

    // Construtor padrão (obrigatório para o JPA)
    public CarteiraDePontos() {}

    // Construtor com lógica de nível
    public CarteiraDePontos(Cliente cliente, int pontos) {
        this.cliente = cliente;
        this.pontos = pontos;
        this.nivelFidelidade = NivelFidelidade.calcularNivel(pontos);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public int getPontos() {
        return pontos;
    }

    public NivelFidelidade getNivelFidelidade() {
        return nivelFidelidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<TransacaoDePontos> getTransacoes() {
        return transacoes;
    }

    // Setters
    public void setPontos(int pontos) {
        this.pontos = pontos;
        atualizarNivel();
    }

    public void setNivelFidelidade(NivelFidelidade nivelFidelidade) {
        this.nivelFidelidade = nivelFidelidade;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Métodos de negócio
    public void adicionarPontos(int quantidade) {
        this.pontos += quantidade;
        atualizarNivel();
    }

    public void atualizarNivel() {
        this.nivelFidelidade = NivelFidelidade.calcularNivel(this.pontos);
    }

    // toString
    @Override
    public String toString() {
        return "CarteiraDePontos{" +
                "id=" + id +
                ", pontos=" + pontos +
                ", nivelFidelidade=" + nivelFidelidade +
                ", cliente=" + (cliente != null ? cliente.getId() : null) +
                '}';
    }
}
