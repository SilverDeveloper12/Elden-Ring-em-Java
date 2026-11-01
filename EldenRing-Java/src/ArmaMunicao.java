//Exercicio 3

public class ArmaMunicao extends Arma{
    private int municao;
    private int municaoInicial;

    public ArmaMunicao(String nome, int ataque, int chance, int municao) {
        super(nome, ataque, chance);
        if(municao < 0) {
            municao = 0;
        }
        this.municao = municao;
        this.municaoInicial = municao;
    }
    @Override
    public boolean podeUsar() {
        return this.municao > 0;
    }
    @Override
    public void recarregar() {
        this.municao = this.municaoInicial;
    }
    @Override
    public void fazAtaque(Criatura criatura) {
        if(!podeUsar()) {
            System.out.println("Sem munição!");
            return;
        }
        this.municao--;
        super.fazAtaque(criatura);
    }
    @Override
    public void mensagem() {
        super.mensagem();
        System.out.println("Munição: " + this.municao + "/" + this.municaoInicial);
    }
}
