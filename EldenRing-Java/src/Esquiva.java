import java.util.Random;

public class Esquiva extends Defesa{
    private int chance;

    Esquiva(int chance){
        if(chance<0){this.chance = 0;}
        else if(chance>100){this.chance=100;}
        else this.chance = chance;
    }

    @Override
    public int danoReduzido(int dano){
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if(sorteio < this.chance){
            System.out.println("Esquivou!!!");
            return 0;
        }
        return dano;
    }
}
