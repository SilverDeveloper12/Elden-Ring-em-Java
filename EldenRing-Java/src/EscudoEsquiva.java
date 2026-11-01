import java.util.Random;

public class EscudoEsquiva extends Defesa {
    private int reducao;
    private int chanceBloqueio;
    private int chanceEsquiva;

    EscudoEsquiva(int reducao, int chanceBloqueio, int chanceEsquiva) {
        if (reducao < 0) {
            reducao = 0;
        } if (chanceBloqueio < 0) {
            chanceBloqueio = 0;
        } if (chanceEsquiva < 0) {
            chanceEsquiva = 0;
        } if (chanceBloqueio > 100) {
            chanceBloqueio = 100;
        } if (chanceBloqueio + chanceEsquiva > 100) {
            chanceEsquiva = 100 - chanceBloqueio;
        }
        this.reducao = reducao;
        this.chanceBloqueio = chanceBloqueio;
        this.chanceEsquiva = chanceEsquiva;
    }

    @Override
    public int danoReduzido(int dano) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);

        if (sorteio < this.chanceBloqueio) {
            System.out.println("Bloqueou!");
            if (dano < this.reducao) {
                return 0;
            }
            return dano - this.reducao;
        } else if (sorteio < this.chanceBloqueio + this.chanceEsquiva) {
            System.out.println("Esquivou!!");
            return 0;
        }
        return dano;
    }
}