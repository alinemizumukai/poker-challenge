import java.util.Random;

public class Baralho {
    final int QTDE_NAIPE = 13;
    Carta[] cartas = new Carta[52];

    public Baralho(){
        for(int i = 0; i < cartas.length; i++){
            if(i < QTDE_NAIPE * 1){
                cartas[i]= new Carta(((i+1) - QTDE_NAIPE * 0) + "", "♦");
            }else if(i < QTDE_NAIPE * 2){
                cartas[i] = new Carta(((i+1) - QTDE_NAIPE * 1) + "", "♠");
            }else if(i < QTDE_NAIPE * 3){
                cartas[i] = new Carta(((i+1) - QTDE_NAIPE * 2) + "", "♥");
            }else if(i < QTDE_NAIPE * 4){
                cartas[i] = new Carta(((i+1) - QTDE_NAIPE * 3) + "", "♣");
            }

            switch (cartas[i].getNome()){
                case "1":   cartas[i].setNome("A");
                            break;
                case "11":  cartas[i].setNome("J");
                            break;
                case "12":  cartas[i].setNome("Q");
                            break;
                case "13":  cartas[i].setNome("K");
                            break;
            }
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
            for(int j=0; j < cartas.length; j++){
                if(!cartas[j].isEmJogo()){
                    temp[i] = cartas[j].getNome() + cartas[j].getNaipe();
                    cartas[j].setEmJogo(true);
                    break;
                }
            }
        }
        return temp;
    }

    public boolean temCarta(int quantidade){
        int mesa = 5;
        int contador = 0;
        for(int i = 0; i < cartas.length; i++ ){
            if (!cartas[i].isEmJogo())
                contador++;
        }
        return contador >= (quantidade + mesa);
    }

    public void imprimirBaralho(){
        for(int i = 0; i < cartas.length; i++ ){
            if (!cartas[i].isEmJogo())
                System.out.print(cartas[i].getNome() + cartas[i].getNaipe() + "  ");
        }
        System.out.println();
    }
}
