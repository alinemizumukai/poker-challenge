import java.util.Arrays;
import java.util.Scanner;

public class PokerApp {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Informe a quantidade de jogadores: ");
            int qtdeJogadores = scan.nextInt();
            if(qtdeJogadores <= 1)
                throw new Exception("Quantidade inválida.");

            Jogador[] jogadores = new Jogador[qtdeJogadores];

            Baralho jogo = new Baralho();

            if(!jogo.temCarta(qtdeJogadores * 2))
                throw new Exception("Não há cartas suficientes para essa quantidade de jogadores.");

            System.out.println("\n***** Início da rodada *****\n");
            Rodada rodada = new Rodada();
            jogo.embaralhar();

            for (int i = 0; i < jogadores.length; i++){
                jogadores[i] = new Jogador("Jogador " + (i+1), jogo.darCartas(2));
            }
            rodada.imprimirJogadoresAtivos(jogadores);

            String resposta;
            double aposta;
            double maiorAposta = 0;
            double totalAposta = 0;
            do {
                for (var jogador : jogadores) {
                    if(jogador.isEmJogo()){
                        do{
                            System.out.println("\nOlá, " + jogador.getNome() + "! Até o momento, você apostou R$ " + jogador.getAposta() + " -> Valor mínimo = R$ " + maiorAposta);
                            System.out.println("Deseja continuar nesta rodada? [S]: sim ou [N] não");
                            resposta = scan.next();
                        } while ( !(resposta.equals("S") || resposta.equals("s") || resposta.equals("N") || resposta.equals("n")) );

                        if (resposta.equals("S") || resposta.equals("s")) {
                            do{
                                System.out.println("Você deve apostar no mínimo R$ " + (maiorAposta - jogador.getAposta()));
                                System.out.println("Por gentileza, informe o valor da sua aposta: ");
                                aposta = scan.nextDouble();
                            } while((aposta + jogador.getAposta()) < maiorAposta);

                            jogador.setAposta(aposta);
                            totalAposta += aposta;
                            if (maiorAposta < jogador.getAposta()) {
                                maiorAposta = jogador.getAposta();
                            }
                        }
                        else {
                            System.out.println(jogador.getNome() + " desistiu.");
                            jogador.setEmJogo(false);
                            rodada.imprimirJogadoresAtivos(jogadores);
                        }
                    }
                }
            } while (rodada.apostasDesiguais(jogadores, maiorAposta));

            System.out.println("\n***** Apostas finalizadas!!! *****");
            rodada.imprimirJogadoresAtivos(jogadores);

            if(rodada.jogadoresAtivos(jogadores) > 1){
                System.out.println("\n***** Cartas na mesa *****");
                System.out.println(Arrays.toString(jogo.darCartas(5)));
            }

            System.out.println("\nQual jogador ganhou?");
            int ganhador = scan.nextInt();
            System.out.println("O Jogador " + ganhador + " ganhou R$ " + totalAposta + " nesta rodada.");

            scan.close();

            System.out.println("\n***** Fim da Rodada *****");
            System.out.println("\nConferência das cartas que restam no baralho: ");
            jogo.imprimirBaralho();

        }catch (Exception ex){
            System.out.println("Ocorreu um erro: " + ex);
        }
    }
}
