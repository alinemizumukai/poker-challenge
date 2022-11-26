import java.util.Random;

public class Baralho {
    final int QTDE_NAIPES = 4;
    final int QTDE_POR_NAIPE = 13;
    Carta[] cartas = new Carta[52];

    public Baralho(){
        String[] nomes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"♦", "♠", "♥", "♣"};
        int index = 0;
        int contadorNaipe = 0;
        while(contadorNaipe < QTDE_NAIPES){
            int contadorNome = 0;
            while (contadorNome < QTDE_POR_NAIPE){
                cartas[index] = new Carta(nomes[contadorNome], naipes[contadorNaipe]);
                contadorNome++;
                index++;
            }
            contadorNaipe++;
        }
    }

    public void embaralhar(){
        Random rdm = new Random();
        for (int i = 0; i < cartas.length; i++){
            int index = rdm.nextInt(cartas.length - 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[index];
            cartas[index] = temp;
        }
        System.out.println("Cartas embaralhadas!");
    }

    public String[] darCartas(int quantidade){
        String[] temp = new String[quantidade];

        for (int i = 0; i < quantidade; i++){
            for(var carta : cartas){
                if(!carta.isEmJogo()){
                    temp[i] = carta.getNome() + carta.getNaipe();
                    carta.setEmJogo(true);
                    break;
                }
            }
        }
        return temp;
    }

    public boolean temCarta(int quantidade){
        int mesa = 5;
        int contador = 0;
        for(var carta : cartas){
            if (!carta.isEmJogo())
                contador++;
        }
        return contador >= (quantidade + mesa);
    }

    public void imprimirBaralho(){
        for(var carta : cartas){
            if (!carta.isEmJogo())
                System.out.print(carta.getNome() + carta.getNaipe() + "  ");
        }
        System.out.println();
    }
}
