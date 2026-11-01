//Exercicio 5

public class Batalha {
    private Criatura player;
    private Criatura inimigo;
    private boolean playerVenceu;

    public Batalha(Criatura player, Criatura inimigo) {
        this.player = player;
        this.inimigo = inimigo;
        this.playerVenceu = false;
    }

    public boolean executar() {
        System.out.println("=========================================================");
        System.out.println("Você entra na parede de névoa, seu oponente te espera...");
        System.out.println("=========================================================\n");

        player.fraseApresentacao();
        inimigo.fraseApresentacao();

        while(true){
            player.mostraVida();
            inimigo.mostraVida();

            //bonus: mecanica GodFrey
            boolean agarrou = inimigo.agarra(player);
            if(!agarrou){
            player.fazAtaque(inimigo);
                if( inimigo.estaVivo()){
                    inimigo.fazAtaque(player);
                }
            }
            if( !player.estaVivo()) {
                player.fraseMorte();
                System.out.println(inimigo.getNome() + " venceu.");
                this.playerVenceu = false;
                break;
            }
            if( !inimigo.estaVivo()) {
                inimigo.fraseMorte();
                System.out.println(player.getNome() + " venceu.");
                this.playerVenceu = true;
                break;
            }
            player.upgrade();
            inimigo.upgrade();
        }
        return this.playerVenceu;
    }
    public String getResultado() {
        if (playerVenceu) {
            return "Na batalha contra " + inimigo.getNome() + ": " +player.getNome()+ " foi o vitorioso!";
        } else {
            return "Na batalha contra " + inimigo.getNome() + ": "+player.getNome()+ " foi derrotado...";
        }
    }

}
