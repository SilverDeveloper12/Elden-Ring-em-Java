//bonus do chefe final
import java.util.Random;

public class Godfrey extends Inimigo{
    public Godfrey() { super("Godfrey, o Primeiro Lorde Pristino", 1000, 250, new EscudoEsquiva(10, 20, 15)); }

    @Override
    public void fraseApresentacao() { System.out.println(getNome()+ ": Perante meu nome, eu vou te derrotar, eu sou Godfrey, o primeiro Lorde Pristíno!"); }

    @Override
    public void fraseMorte() { System.out.println(getNome() + ": Bravo maculado... tua força é digna de uma coroa!"); }

    /*
    * Godfrey era o marido consorte da Rainha/Deusa Marika e o
    * criador da raça dos maculado, que nosso protagonista faz parte.
    * ele era um guerreiro conhecido como Hoarah Loux antes de Marika
    * o encontrar e agraciá-lo com a benção aurea do deus "A vontade maior".
    * ele enfrenta o maculado pelo titulo de Lorde Pristino pois foi lhe dada a
    * audiência mais uma vez pelo próprio Anel Pristino, será que voce tem o que
    * é necessário para derrotar aquele que uma vez ja foi lorde, e além do mais
    * seu criador?
    * */

    //bonus criado por mim, mecanica do agarrão de godfrey;

    /* Mecanica de Godfrey, o Primeiro Lorde Pristino
    * Ao chegar a 200 de vida, Godfrey ganha um uprade, de vida, de defesa e uma mecanica similar a de Maliketh.
    * diferente de Maliketh (que simplesmente acaba com o jogo), a mecânica de godfrey é ainda mais chata de lidar,
    * porque ela impede o jogador de realizar sua ação do momento, e se o contador de agarrões de godfrey chegar a 5
    * ele irá recuperar a vida toda da batalha, mas isto acontece somente uma vez, depois os agarroes apenas impedem
    * o jogador de realizar suas ações, e por fim o jogador vira o lorde pristino com um prompt na tela mostrando que
    * isto aconteceu.
    * */

    private int agarroesAcertados = 0;
    private boolean curou = false;
    private int chanceAgarrao = 15;
    private boolean upgraded = false;
    private int vidaCritica = 200;
    @Override
    public void upgrade(){
        if(!upgraded){
            if(vidaCritica(vidaCritica)){
                System.out.println(getNome() + ": lhe dei cortesia o suficiente...");
                setNome("Hoarah Loux");
                System.out.println(getNome() + """
                        
   
                                          AGORA LUTO COMO HOARAH LOUX, GUERREIRO!!!
   
                        """);
                upgraded = true;
                restaurarVida();
                setDefesa(new Escudo(50));
                setAtaque(290);

            }
        }
    }
    @Override
    public boolean agarra(Criatura alvo) {
        if(!upgraded){
            return false;
        }
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if(sorteio < chanceAgarrao) {
            System.out.println("Hoarah Loux agarrou o player!");
            alvo.tomaDanoDireto(50);
            System.out.println("O jogador perdeu o turno e tomou 50 de dano!");
            agarroesAcertados++;
            if(agarroesAcertados == 5) {
                System.out.println("Ao te agarrar, Hoarah Loux encontrou a runa do Anel Pristino de seu filho Morgott!");
                System.out.println("Ele se cura com o poder da vontade maior!!!");
                restaurarVida();
                curou = true;
            }
            return true;
        }
        return false;
    }
}
