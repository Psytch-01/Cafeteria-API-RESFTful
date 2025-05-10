package br.com.psytch.cafeteria.controller;

import br.com.psytch.cafeteria.dto.TransacaoRequestDTO;
import br.com.psytch.cafeteria.dto.TransacaoResponseDTO;
import br.com.psytch.cafeteria.service.TransacaoDePontosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoDePontosService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> registrarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        TransacaoResponseDTO transacaoResponseDTO = transacaoService.registrarTransacao(transacaoRequestDTO);
        return new ResponseEntity<>(transacaoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<TransacaoResponseDTO>> listarTransacoes(@PathVariable Long clienteId) {
        List<TransacaoResponseDTO> transacoes = transacaoService.listarTransacoes(clienteId);
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }
}
