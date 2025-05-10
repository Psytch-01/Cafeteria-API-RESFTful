package br.com.psytch.cafeteria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    // Anotações e Relacionamentos
   @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
   private CarteiraDePontos carteiraDePontos;

   // Construtor padrão Obrigatório para o JPA
    public Cliente() {}

    // Construtor sem o ID, pois este é criado automaticamente.
    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Construtor que aceita a Carteira
    public Cliente(String nome, String cpf, String email, CarteiraDePontos carteiraDePontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.carteiraDePontos = carteiraDePontos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarteiraDePontos getCarteiraDePontos() {
        return carteiraDePontos;
    }


    public void setCarteira(CarteiraDePontos carteiraDePontos) {
        this.carteiraDePontos = carteiraDePontos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", carteira=" + carteiraDePontos +
                '}';
    }
}

