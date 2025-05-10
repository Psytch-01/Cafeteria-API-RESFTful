package br.com.psytch.cafeteria.service;

import br.com.psytch.cafeteria.model.NivelFidelidade;
import org.springframework.stereotype.Service;

@Service
public class NivelFidelidadeService {

    // Calcular o nível de fidelidade de um cliente baseado nos pontos
    public NivelFidelidade calcularNivelFidelidade(int pontos) {
        return NivelFidelidade.calcularNivel(pontos);
    }
}
