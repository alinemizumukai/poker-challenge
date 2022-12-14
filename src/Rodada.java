import java.util.Arrays;

public class Rodada {

    public Rodada() {
    }

    public void imprimirJogadoresAtivos(Jogador[] jogadores){
        System.out.println("\nParticipantes da rodada: ");
        for (var jogador : jogadores){
            if(jogador.isEmJogo())
                System.out.printf("\n%s -> %s -> Aposta: R$ %.2f", jogador.getNome(), Arrays.toString(jogador.getCartas()), jogador.getAposta());
        }
        System.out.println();
    }

    public int jogadoresAtivos(Jogador[] jogadores){
        int ativos = 0;
        for (var jogador : jogadores){
            if(jogador.isEmJogo())
                ativos++;
        }
        return ativos;
    }

    public boolean apostasDesiguais (Jogador[] jogadores, double maiorAposta){
        double somaApostasAtivas = 0.0;
        int quantidade = jogadoresAtivos(jogadores);
        for (var jogador : jogadores){
            if(jogador.isEmJogo())
                somaApostasAtivas += jogador.getAposta();
        }
        return somaApostasAtivas / quantidade < maiorAposta;
    }
}
