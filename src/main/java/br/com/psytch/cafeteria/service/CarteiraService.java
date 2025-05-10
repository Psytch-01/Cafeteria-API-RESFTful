package br.com.psytch.cafeteria.service;

import br.com.psytch.cafeteria.dto.CarteiraResponseDTO;
import br.com.psytch.cafeteria.model.CarteiraDePontos;
import br.com.psytch.cafeteria.model.Cliente;
import br.com.psytch.cafeteria.model.NivelFidelidade;
import br.com.psytch.cafeteria.repository.CarteiraRepository;
import br.com.psytch.cafeteria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Buscar o Cliente por ID
    public Cliente buscarCliente(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));  // Lança exceção se não encontrar o cliente
    }

    // Buscar a carteira de pontos de um cliente
    public CarteiraDePontos buscarCarteiraDeCliente(Cliente cliente) {
        return carteiraRepository.findByCliente(cliente);
    }

    // Adicionar pontos à carteira de um cliente
    public void adicionarPontos(CarteiraDePontos carteiraDePontos, int pontosAdicionais) {
        carteiraDePontos.setPontos(carteiraDePontos.getPontos() + pontosAdicionais);
        // Aqui pode ser chamado um método para atualizar o nível de fidelidade, caso necessário
        carteiraRepository.save(carteiraDePontos);
    }

    public CarteiraResponseDTO obterCarteira(Long clienteId) {
        Cliente cliente = buscarCliente(clienteId);
        CarteiraDePontos carteira = carteiraRepository.findByCliente(cliente);

        if (carteira == null) {
            // Se a carteira não existir, criamos uma nova
            carteira = criarCarteira(clienteId).toEntity(); // A lógica de criação da carteira
        }

        return new CarteiraResponseDTO(carteira.getId(), carteira.getPontos(), carteira.getNivelFidelidade().toString());
    }


    // Atualizar nível de fidelidade
    public CarteiraResponseDTO atualizarNivel(Long clienteId) {
        Cliente cliente = buscarCliente(clienteId);
        CarteiraDePontos carteira = carteiraRepository.findByCliente(cliente);
        // Calcule o novo nível de fidelidade
        // Método de cálculo de nível de fidelidade
        return new CarteiraResponseDTO(carteira.getId(), carteira.getPontos(), "Novo Nível");  // Atualize com o nível calculado
    }

    public CarteiraResponseDTO criarCarteira(Long clienteId) {
        // Buscando o cliente
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Criando a nova carteira de pontos
        CarteiraDePontos novaCarteira = new CarteiraDePontos();
        novaCarteira.setCliente(cliente);
        novaCarteira.setPontos(0); // Inicializando com 0 pontos
        novaCarteira.setNivelFidelidade(NivelFidelidade.BRONZE); // Definindo o nível de fidelidade padrão como BRONZE

        // Salvando a nova carteira no banco de dados
        carteiraRepository.save(novaCarteira);

        // Retornando a resposta com a nova carteira
        return new CarteiraResponseDTO(novaCarteira);
    }

}
