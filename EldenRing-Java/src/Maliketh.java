import java.util.Random;
public class Maliketh extends Inimigo{

    public Maliketh(){super("Maliketh, a Lâmina Negra", 900, 100, new Esquiva(30));}

    @Override
    public void fraseApresentacao() { System.out.println(getNome()+": Maculado tolo, não terei a runa da morte roubada de mim novamente..."); }

    @Override
    public void fraseMorte() { System.out.println(getNome() + ": Maculado tolo... o que procura com a morte destinada...? para matar o que...?"); }


    /*
    * Maliketh, a Lâmina Negra era a sombra da Rainha Marika e tinha
    * o proposito de ser o guarda da Runa da Morte, runa esta que fazia parte
    * do anel pristino e que tinha o proposito de MATAR INDISCRIMINADAMENTE SEJA MORTAL OU DEUS
    * e foi a causa da guerra A Ruptura de Elden Ring quando foi roubada dele, voces se enfrentam em uma
    * luta fervorosa e ele tem a capacidade de matar o jogador em um so golpe, mas o jogador está tao determinado quanto
    * para resolver isto de uma vez por todas.
    * */


    //EX1 - Sobrescrita do metodo fazAtaque(): morte destinada - sorteia uma chance pequena de matar o jogador independente da vida dele
    /*
    * Como funciona a mecanica de Maliketh, a Lâmina Negra:
    * Em determinada chance (5 em 100) Maliketh terá a chance de matar o jogador em um so hit independentemente da vida dele atual.
    * Isso acontece a partir da classe criatura que valida o valor da classe runaDaMorte() como zero, e isto traduz para o ataque de
    * maliketh, apos isto na classe do Maliketh() é criado um sorteio que se acontecer do valor ser menor que a chance da morte destinada,
    * o jogador irá perder a luta de qualquer maneira.
    * */
    private int chanceMorteDestinada = 5;
    @Override
    public void fazAtaque(Criatura criatura) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if(sorteio < chanceMorteDestinada) {
            System.out.println("""
                        ********************************************************************************
                        ********************************************************************************                                                                
                        ********                  Maliketh acerta a Lâmina Negra                ********
                        ********              com a runa da Morte Destinada Liberada.           ********
                        ********                                                                ********
                        ********                     A Morte Destinada ceifa                    ********
                        ********                    TANTO DEUS, QUANTO MORTAL                   ********
                        ********************************************************************************
                        ********************************************************************************
                    
                    """);
            System.out.println(" ");
            System.out.println("A vida de " + criatura.getNome() + " vai para 0");
            criatura.runaDaMorte();
        } else {
            super.fazAtaque(criatura);
        }
    }
    //sistema de upgrade
    private boolean upgraded = false;
    private int vidaCritica = 200;
    @Override
    public void upgrade(){
        if(!upgraded){
            if(vidaCritica(vidaCritica)){
                System.out.println(getNome() + ": Oh morte, torne-se minha lâmina mais uma vez...");
                System.out.println("""
                        ********************************************************************************
                        ********                                                                ********
                        ********      A runa da morte teve seu verdadeiro poder liberado...     ********
                        ********                                                                ********
                        ********************************************************************************
                        """);
                upgraded = true;
                setDefesa(new Escudo(40));
                setAtaque(200);
                chanceMorteDestinada = 20;
            }
        }
    }
}
