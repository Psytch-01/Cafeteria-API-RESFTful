package br.com.psytch.cafeteria.repository;

import br.com.psytch.cafeteria.model.CarteiraDePontos;
import br.com.psytch.cafeteria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<CarteiraDePontos, Long> {

    // Busca a carteira de pontos associada ao cliente
    CarteiraDePontos findByCliente(Cliente cliente);

    // Busca a carteira de pontos de um cliente com base no ID do cliente
    CarteiraDePontos findByClienteId(Long clienteId);
}
