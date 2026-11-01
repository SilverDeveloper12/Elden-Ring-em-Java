public class Godrick extends Inimigo{
    public Godrick() { super("Godrick, o Enxertado", 750, 200, new Escudo(30));}

    @Override
    public void fraseApresentacao() { System.out.println(getNome() + ": Eu sou o lorde de tudo que é áureo!"); }

    @Override
    public void fraseMorte() { System.out.println(getNome() + ": Um dia... vamos retornar para nossa casa... banhada em raios áureos..."); }

    /*
    * Godrick é um homem velho e debil que sonha em se tornar lorde de alguma coisa
    * ele pratica o enxerto para se tornar mais forte na luta contra o maculado, mas ele
    * perde ainda sim pois é muito fraco.
    * ele apenas ganha um boost de ataque depois de perder 350 de vida
    * */

    //Mecanica basica de Godrick, o Enxertado: um mero upgrade de segunda fase

    private boolean upgraded = false;
    private int vidaCritica = 200;
    @Override
    public void upgrade(){
        if(!upgraded){
            if(vidaCritica(vidaCritica)){
                System.out.println(getNome() + ": A todos os meus antecessores... PRESENCIEM!!!");
                System.out.println(" ");
                System.out.println("Godrick se aprimorou usando a cabeça de um dragão!");
                System.out.println(" ");
                upgraded = true;
                setDefesa(new Escudo(40));
                setAtaque(250);
            }
        }
    }
}
