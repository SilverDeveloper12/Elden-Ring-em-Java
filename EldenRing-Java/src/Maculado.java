import java.util.Scanner;
import java.util.Random;

public class Maculado extends Criatura {

    /*
    * O maculado é uma criatura descendente de Godfrey e é simplesmente a espécie humana no mundo de elden ring.
    * ele tem a capacidade de transformar runas em força (inclusive as runas do anel pristino) mas isto só pode
    * ser feito se uma donzela dos dedos realizar isto para ele, ele é o protagonista que voce controla e
    * ajudará a se tornar o Lorde Pristino!
    * */

    private Arma[] armas;
    private Defesa defesa;

    public Maculado(String nome, Arma[] armas){
        super(nome, 1000);
        this.armas = armas;
        this.defesa = new Defesa();
    }
    public Maculado(String nome, Arma[] armas, Defesa defesa){
        super(nome, 1000);
        this.armas = armas;
        this.defesa = defesa;
    }

    @Override
    public void fraseApresentacao() { System.out.println(getNome() + ": Eu vou me tornar lorde pristino!"); }
    @Override
    public void fraseMorte() { System.out.println(getNome() + ": não... posso... perder..."); }

    @Override
    public void fazAtaque(Criatura criatura) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha sua arma:");
        int n = 1;
        for(Arma arma : armas) {
            System.out.println(n + ") ");
            arma.mensagem();
            n++;
        }
        int escolha = sc.nextInt();
        //Exercicio3 (validacao de arma com municao)
        while(true) {
            if(escolha < 1 || escolha > n - 1 ){
            System.out.println("Número inválido. Digite novamente:");
            } else if(!armas[escolha-1].podeUsar()) {
                System.out.println(getNome()+ " esta sem munição. Escolha outra arma: ");
            } else {break;}
            escolha = sc.nextInt();
        }
        armas[escolha-1].fazAtaque(criatura);
    }
    @Override
    public void tomaDano(int dano){
        int danoReduzido = this.defesa.danoReduzido(dano);
        super.tomaDano(danoReduzido);
    }
    //ao final de cada round, o metodo chamado para recuperar a vida do player e sua municao
    @Override
    public void restaurarVida(){
        super.restaurarVida();
        for(Arma arma : armas) {
            arma.recarregar();
        }
    }
    //exercicio 7
    public void bencaoPristina() {
        System.out.println("Ao atravessar os grandes portoes em direçao a tervore, " + getNome() + " recebe a benção da tervore!");
        System.out.println("Vida: +200!");
        System.out.println("Dano: +100 em todas as armas!");
        aumentaVidaMaxima(200);
        for(Arma arma : armas) {
            arma.aumentaAtaque(100);
        }

    }
}


