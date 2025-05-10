package br.com.psytch.cafeteria.controller;

import br.com.psytch.cafeteria.dto.ClienteRequestDTO;
import br.com.psytch.cafeteria.dto.ClienteResponseDTO;
import br.com.psytch.cafeteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteService.criarCliente(clienteRequestDTO);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> detalharCliente(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.detalharCliente(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteService.atualizarCliente(id, clienteRequestDTO);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
    }
}
