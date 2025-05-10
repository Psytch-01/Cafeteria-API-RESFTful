package br.com.psytch.cafeteria.model;

public enum NivelFidelidade {
    INICIANTE(0),
    BRONZE(500),
    PRATA(1500),
    OURO(3500),
    PLATINA(7000),
    DIAMANTE(10000);

    private final int pontosNecessarios;

    NivelFidelidade(int pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }

    public int getPontosNecessarios() {
        return pontosNecessarios;
    }

    public static NivelFidelidade calcularNivel(int pontos) {
        NivelFidelidade nivel = INICIANTE;
        for(NivelFidelidade n : values()) {
            if (pontos >= n.getPontosNecessarios()) {
                nivel = n;
            }
        }
        return nivel;
    }


}
