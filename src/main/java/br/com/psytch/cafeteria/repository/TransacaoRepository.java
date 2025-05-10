package br.com.psytch.cafeteria.repository;

import br.com.psytch.cafeteria.model.TransacaoDePontos;
import br.com.psytch.cafeteria.model.CarteiraDePontos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoDePontos, Long> {
    // Buscar transações de uma carteira de pontos
    List<TransacaoDePontos> findByCarteiraDePontos(CarteiraDePontos carteiraDePontos);
}
