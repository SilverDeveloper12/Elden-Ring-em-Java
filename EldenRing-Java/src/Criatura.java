/*Classe criatura:
* Na classe abstrata criatura, está toda a lógica por trás
* dos "seres" do jogo (isto inclui jogador e inimigo)
* e esta classe é abstrata pois será usada como modelo
* por outras classes e não ser instanciada posteriormente.*/

public abstract class Criatura {
    private String nome;
    private int vida;
    private int vidaInicial;

    public Criatura(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.vidaInicial = vida;
    }
    public void restaurarVida() {
        this.vida = this.vidaInicial;
    }
        public abstract void fraseApresentacao ();
        public abstract void fraseMorte ();
        public abstract void fazAtaque (Criatura criatura);


    public void mostraVida() { System.out.println(this.nome + ": " + this.vida + " pontos de vida.");}
    public String getNome() { return this.nome; }
    public void setNome(String nome){this.nome = nome;}
    public boolean estaVivo() { return this.vida > 0;}
    public void tomaDano(int dano) {
        this.vida -= dano;
        if( this.vida < 0 ){
            this.vida = 0;
        }
        System.out.println(this.nome + " recebe " + dano + " de dano");
    }
    public boolean vidaCritica(int valorCritico ){ return this.vida < valorCritico; }
    public void upgrade(){}
    //Exercicio 1
    public void runaDaMorte() {
        this.vida = 0;
    }
    //Exercicio 7 (buff do jogador para a luta final)
    public void aumentaVidaMaxima(int valor) {
        this.vidaInicial += valor;
        this.vida += valor;
    }

    //bonus criado por mim, para o ultimo chefe;
    public boolean agarra(Criatura alvo) {return false;}
    //metodo de dano direto de godfrey, para o player nao ignorar nem defender o agarrao
    public void tomaDanoDireto(int dano){
        this.vida -= dano;
        if(this.vida < 0){
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano");
    }

}