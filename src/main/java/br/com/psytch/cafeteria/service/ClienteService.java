package br.com.psytch.cafeteria.service;

import br.com.psytch.cafeteria.dto.ClienteRequestDTO;
import br.com.psytch.cafeteria.dto.ClienteResponseDTO;
import br.com.psytch.cafeteria.model.Cliente;
import br.com.psytch.cafeteria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar um novo cliente
    public ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequestDTO) {
        // Convertendo o DTO em um modelo Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setCpf(clienteRequestDTO.getCpf());

        // Salvando o cliente no banco
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Retornando o cliente salvo no formato de ClienteResponseDTO
        return new ClienteResponseDTO(clienteSalvo);
    }

    // Buscar um cliente por CPF
    public ClienteResponseDTO buscarClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);

        if (cliente == null) {
            // Retornando null ou pode lançar uma exceção personalizada
            throw new RuntimeException("Cliente não encontrado com CPF: " + cpf);
        }

        // Convertendo o cliente encontrado para ClienteResponseDTO
        return new ClienteResponseDTO(cliente);
    }

    // Atualizar informações do cliente
    public ClienteResponseDTO atualizarCliente(Long clienteId, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Atualizando os dados do cliente
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setCpf(clienteRequestDTO.getCpf());

        // Salvando as mudanças
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        // Retornando o cliente atualizado no formato de ClienteResponseDTO
        return new ClienteResponseDTO(clienteAtualizado);
    }

    // Deletar um cliente
    public void deletarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    // Listar todos os clientes
    public List<ClienteResponseDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteResponseDTO::new)
                .collect(Collectors.toList());
    }

    // Detalhar um cliente pelo ID
    public ClienteResponseDTO detalharCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return new ClienteResponseDTO(cliente);
    }
}
