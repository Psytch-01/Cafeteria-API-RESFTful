package br.com.psytch.cafeteria.dto;

import br.com.psytch.cafeteria.model.TipoTransacao;
import br.com.psytch.cafeteria.model.TransacaoDePontos;

import java.time.LocalDateTime;

public class TransacaoResponseDTO {

    private Long id;
    private int pontos;
    private TipoTransacao tipoTransacao;
    private String descricao;
    private LocalDateTime data;

    // Construtor que recebe um objeto TransacaoDePontos
    public TransacaoResponseDTO(TransacaoDePontos transacao) {
        this.id = transacao.getId();
        this.pontos = transacao.getPontos();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.descricao = transacao.getDescricao();
        this.data = transacao.getData();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
