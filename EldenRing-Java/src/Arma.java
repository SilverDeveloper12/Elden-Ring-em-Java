import java.util.Random;

public class Arma {

    private String nome;
    private int ataque;
    private int chance;

    public Arma(String nome, int ataque, int chance){
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
    }
    public Arma(String nome, int ataque) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = 100;
    }

    public void mensagem() {
        System.out.println( this.nome + " - dano: " +
                            this.ataque + " - chance: " +
                            this.chance + "%");
    }
    //exercicio 3 municao das armas
    public boolean podeUsar() { return true; }
    public void recarregar() { }
    public void fazAtaque( Criatura criatura ) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if(sorteio<this.chance) {
            criatura.tomaDano(this.ataque);
        }else{
            System.out.println("ERROU!");
        }
    }

    //exercicio 7 (upgrade do jogador)
    public void aumentaAtaque(int valor) { this.ataque += valor; }


}
