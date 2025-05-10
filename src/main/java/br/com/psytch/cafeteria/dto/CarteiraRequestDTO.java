package br.com.psytch.cafeteria.dto;

public class CarteiraRequestDTO {

    private Long clienteId;
    private int pontos;

    // Getters and Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
