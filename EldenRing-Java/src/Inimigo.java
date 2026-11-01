public abstract class Inimigo extends Criatura {
    private int ataque;
    private Defesa defesa;

    public Inimigo(String nome, int vida, int ataque) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = new Defesa();
    }
    public Inimigo(String nome, int vida, int ataque, Defesa defesa) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public void fazAtaque(Criatura criatura) {criatura.tomaDano(this.ataque);}

    @Override
    public void tomaDano(int dano){
        int danoReduzido = this.defesa.danoReduzido(dano);
        super.tomaDano(danoReduzido);
    }
    public void setAtaque(int ataque){this.ataque = ataque;}
    public void setDefesa(Defesa defesa) {this.defesa = defesa;}
}
