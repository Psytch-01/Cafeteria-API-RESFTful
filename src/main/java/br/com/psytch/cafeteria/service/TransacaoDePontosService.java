package br.com.psytch.cafeteria.service;

import br.com.psytch.cafeteria.dto.TransacaoRequestDTO;
import br.com.psytch.cafeteria.dto.TransacaoResponseDTO;
import br.com.psytch.cafeteria.model.TransacaoDePontos;
import br.com.psytch.cafeteria.model.CarteiraDePontos;
import br.com.psytch.cafeteria.model.TipoTransacao;
import br.com.psytch.cafeteria.repository.CarteiraRepository;
import br.com.psytch.cafeteria.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoDePontosService {

    @Autowired
    private TransacaoRepository transacaoDePontosRepository;

    @Autowired
    private CarteiraRepository carteiraDePontosRepository;

    // Registrar uma transação de ganho de pontos
    public void registrarTransacaoGanho(CarteiraDePontos carteiraDePontos, int pontos, String descricao) {
        TransacaoDePontos transacao = new TransacaoDePontos(pontos, TipoTransacao.GANHO, descricao, LocalDateTime.now(), carteiraDePontos);
        transacaoDePontosRepository.save(transacao);
    }

    // Registrar uma transação de resgate de pontos
    public void registrarTransacaoResgate(CarteiraDePontos carteiraDePontos, int pontos, String descricao) {
        TransacaoDePontos transacao = new TransacaoDePontos(pontos, TipoTransacao.RESGATE, descricao, LocalDateTime.now(), carteiraDePontos);
        transacaoDePontosRepository.save(transacao);
    }

    // Listar transações de um cliente (baseado no clienteId)
    public List<TransacaoResponseDTO> listarTransacoes(Long clienteId) {
        // Buscando a carteira do cliente pelo ID
        CarteiraDePontos carteiraDePontos = carteiraDePontosRepository.findByClienteId(clienteId);
        if (carteiraDePontos == null) {
            throw new RuntimeException("Carteira não encontrada para o cliente com ID: " + clienteId);
        }

        // Buscando as transações da carteira do cliente
        List<TransacaoDePontos> transacoes = transacaoDePontosRepository.findByCarteiraDePontos(carteiraDePontos);

        // Convertendo as transações para DTOs para a resposta
        return transacoes.stream()
                .map(transacao -> new TransacaoResponseDTO(transacao)) // Ajuste: conversão de transação para DTO
                .collect(Collectors.toList());
    }

    // Registrar uma transação (geral)
    public TransacaoResponseDTO registrarTransacao(TransacaoRequestDTO transacaoRequestDTO) {
        // Buscando a carteira do cliente pelo ID
        CarteiraDePontos carteiraDePontos = carteiraDePontosRepository.findByClienteId(transacaoRequestDTO.getClienteId());
        if (carteiraDePontos == null) {
            throw new RuntimeException("Carteira não encontrada para o cliente com ID: " + transacaoRequestDTO.getClienteId());
        }

        // Criando a transação a partir do DTO
        TransacaoDePontos transacao = new TransacaoDePontos(
                transacaoRequestDTO.getPontos(),
                transacaoRequestDTO.getTipoTransacao(),
                transacaoRequestDTO.getDescricao(),
                LocalDateTime.now(),
                carteiraDePontos
        );

        // Salvando a transação no banco de dados
        TransacaoDePontos transacaoSalva = transacaoDePontosRepository.save(transacao);

        // Convertendo a transação salva para DTO de resposta
        return new TransacaoResponseDTO(transacaoSalva);
    }
}
