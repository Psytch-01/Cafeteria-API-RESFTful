package br.com.psytch.cafeteria.dto;

import br.com.psytch.cafeteria.model.TipoTransacao;

public class TransacaoRequestDTO {

    private Long clienteId;  // Campo que representa o ID do cliente
    private int pontos;
    private TipoTransacao tipoTransacao;
    private String descricao;

    // Getter e Setter para clienteId
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Getters e Setters para os outros campos
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
}
