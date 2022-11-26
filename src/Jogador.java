public class Jogador {

    private String nome;
    private String[] cartas;
    private double aposta;
    private boolean emJogo = true;

    public Jogador() {
    }

    public Jogador(String nome, String[] cartas) {
        this.nome = nome;
        this.cartas = cartas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getCartas() {
        return cartas;
    }

    public void setCartas(String[] cartas) {
        this.cartas = cartas;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta += aposta;
    }

    public boolean isEmJogo() {
        return emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }
}
