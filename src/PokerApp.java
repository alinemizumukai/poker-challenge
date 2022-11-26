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

            jogo.embaralhar();

            for (int i = 0; i < jogadores.length; i++){
                jogadores[i] = new Jogador("Jogador " + (i+1), jogo.darCartas(2));
            }
            imprimirJogadoresAtivos(jogadores);

            String resposta;
            double aposta;
            double maiorAposta = 0;
            double totalAposta = 0;
            do {
                for (int i = 0; i < jogadores.length; i++) {
                    if(jogadores[i].isEmJogo()){
                        do{
                            System.out.println("Olá, " + jogadores[i].getNome() + "! Até o momento, você apostou R$ " + jogadores[i].getAposta() + " -> Valor mínimo = R$ " + maiorAposta);
                            System.out.println("Deseja continuar nesta rodada? [S]: sim ou [N] não");
                            resposta = scan.next();
                        } while ( !(resposta.equals("S") || resposta.equals("s") || resposta.equals("N") || resposta.equals("n")) );

                        if (resposta.equals("S") || resposta.equals("s")) {
                            do{
                                System.out.println("Você deve apostar no mínimo R$ " + (maiorAposta - jogadores[i].getAposta()));
                                System.out.println("Por gentileza, informe o valor da sua aposta: ");
                                aposta = scan.nextDouble();
                            } while((aposta + jogadores[i].getAposta()) < maiorAposta);

                            jogadores[i].setAposta(aposta);
                            totalAposta += aposta;
                            if (maiorAposta < jogadores[i].getAposta()) {
                                maiorAposta = jogadores[i].getAposta();
                            }
                        }
                        else {
                            System.out.println(jogadores[i].getNome() + " desistiu.");
                            jogadores[i].setEmJogo(false);
                            imprimirJogadoresAtivos(jogadores);
                        }
                    }
                }
            } while (apostasDesiguais(jogadores, maiorAposta));

            System.out.println("Apostas finalizadas!!");
            imprimirJogadoresAtivos(jogadores);

            if(jogadoresAtivos(jogadores) > 1){
                System.out.println("Cartas na mesa: ");
                System.out.println(Arrays.toString(jogo.darCartas(5)));
            }

            System.out.println("Qual jogador ganhou?");
            int ganhador = scan.nextInt();
            System.out.println("O Jogador " + ganhador + " ganhou R$ " + totalAposta + " nesta rodada.");

            scan.close();

            System.out.println("Conferência do restante do baralho: ");
            jogo.imprimirBaralho();

        }catch (Exception ex){
            System.out.println("Ocorreu um erro: " + ex);
        }
    }

    public static void imprimirJogadoresAtivos(Jogador[] jogadores){
        System.out.println("Participando do jogo: ");
        for (int i = 0; i < jogadores.length; i++){
            if(jogadores[i].isEmJogo())
                System.out.println(jogadores[i].getNome() + " -> " + Arrays.toString(jogadores[i].getCartas()) + " -> Aposta: R$ " + jogadores[i].getAposta());
        }
    }

    public static int jogadoresAtivos(Jogador[] jogadores){
        int ativos = 0;
        for (int i = 0; i < jogadores.length; i++){
            if(jogadores[i].isEmJogo())
                ativos++;
        }
        return ativos;
    }

    public static boolean apostasDesiguais (Jogador[] jogadores, double maiorAposta){
        double somaApostasAtivas = 0.0;
        int quantidade = jogadoresAtivos(jogadores);
        for (int i = 0; i < jogadores.length; i++){
            if(jogadores[i].isEmJogo())
                somaApostasAtivas += jogadores[i].getAposta();
        }
        return somaApostasAtivas / quantidade < maiorAposta;
    }
}
