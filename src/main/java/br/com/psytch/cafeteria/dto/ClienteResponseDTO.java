package br.com.psytch.cafeteria.dto;

import br.com.psytch.cafeteria.model.Cliente;

public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;

    // Construtor para converter Cliente para ClienteResponseDTO
    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
