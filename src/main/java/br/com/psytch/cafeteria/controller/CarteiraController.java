package br.com.psytch.cafeteria.controller;

import br.com.psytch.cafeteria.dto.CarteiraRequestDTO;
import br.com.psytch.cafeteria.dto.CarteiraResponseDTO;
import br.com.psytch.cafeteria.model.CarteiraDePontos;
import br.com.psytch.cafeteria.model.Cliente;
import br.com.psytch.cafeteria.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    // Método para obter a carteira de um cliente
    @GetMapping("/{clienteId}")
    public ResponseEntity<CarteiraResponseDTO> obterCarteira(@PathVariable Long clienteId) {
        CarteiraResponseDTO carteiraResponseDTO = carteiraService.obterCarteira(clienteId);
        return new ResponseEntity<>(carteiraResponseDTO, HttpStatus.OK);
    }

    // Método para adicionar pontos a um cliente (utilizando o DTO)
    @PostMapping("/adicionar-pontos")
    public ResponseEntity<Void> adicionarPontos(@RequestBody CarteiraRequestDTO carteiraRequestDTO) {
        try {
            // Buscar a carteira do cliente usando o clienteId
            Cliente cliente = carteiraService.buscarCliente(carteiraRequestDTO.getClienteId());  // Agora buscando o cliente

            // Buscar a carteira do cliente
            CarteiraDePontos carteiraDePontos = carteiraService.buscarCarteiraDeCliente(cliente);

            // Adicionar pontos à carteira do cliente
            carteiraService.adicionarPontos(carteiraDePontos, carteiraRequestDTO.getPontos());
            return ResponseEntity.ok().build();  // Retorna status 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Caso haja erro
        }
    }

    @PostMapping("/{clienteId}")
    public ResponseEntity<CarteiraResponseDTO> criarCarteira(@PathVariable Long clienteId) {
        CarteiraResponseDTO carteiraResponseDTO = carteiraService.criarCarteira(clienteId);
        return new ResponseEntity<>(carteiraResponseDTO, HttpStatus.CREATED);
    }


    // Método para atualizar o nível de fidelidade de um cliente
    @PutMapping("/{clienteId}/atualizarNivel")
    public ResponseEntity<CarteiraResponseDTO> atualizarNivel(@PathVariable Long clienteId) {
        CarteiraResponseDTO carteiraResponseDTO = carteiraService.atualizarNivel(clienteId);
        return new ResponseEntity<>(carteiraResponseDTO, HttpStatus.OK);
    }
}
