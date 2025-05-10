package br.com.psytch.cafeteria.dto;

import br.com.psytch.cafeteria.model.CarteiraDePontos;
import br.com.psytch.cafeteria.model.NivelFidelidade;

public class CarteiraResponseDTO {

    private Long id;
    private int pontos;
    private String nivelFidelidade;

    // Construtor
    public CarteiraResponseDTO(Long id, int pontos, String nivelFidelidade) {
        this.id = id;
        this.pontos = pontos;
        this.nivelFidelidade = nivelFidelidade;
    }

    public CarteiraResponseDTO(CarteiraDePontos novaCarteira) {
        this.id = novaCarteira.getId();
        this.pontos = novaCarteira.getPontos();
        this.nivelFidelidade = novaCarteira.getNivelFidelidade().toString();  // Convertendo o Enum para String
    }


    public CarteiraDePontos toEntity() {
        CarteiraDePontos carteiraDePontos = new CarteiraDePontos();
        carteiraDePontos.setPontos(this.pontos);
        carteiraDePontos.setNivelFidelidade(NivelFidelidade.valueOf(this.nivelFidelidade));
        return carteiraDePontos;
    }


    // Getters and Setters
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

    public String getNivelFidelidade() {
        return nivelFidelidade;
    }

    public void setNivelFidelidade(String nivelFidelidade) {
        this.nivelFidelidade = nivelFidelidade;
    }
}
