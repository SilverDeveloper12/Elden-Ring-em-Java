import java.util.Scanner;

public class EldenRing {
   //exercicio 4
    private static int lerOpcao(Scanner sc, int maximo) {
        while(true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= 1 && n <= maximo) {
                    return n;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Opção invalida. digite um numero de 1 a " + maximo + ": ");
        }
    }
   private static Arma escolhaArmaCurtoAlcance(Scanner sc) {
       System.out.println("Escolha sua arma de curta distância:");
       System.out.println("1) Uchigatana");
       System.out.println("2) Faca");
       System.out.println("3) Clube reforçado");
       switch(lerOpcao(sc,3)){
           case 1: return new Espada();
           case 2: return new Faca();
           default: return new Porrete();
       }
   }
   private static Arma escolhaArmaLongoAlcance(Scanner sc) {
       System.out.println("Agora escolha sua arma de longo alcance:");
       System.out.println("(uma fratura no espaço tempo fez com que a tecnologia de armas a pólvora existissem nas terras intemédias)");
       System.out.println("1) Arco e Flecha");
       System.out.println("2) Pistola");
       if(lerOpcao(sc, 2) == 1) {
           return new Arco();
       }
       return new Pistola();
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
         
         
         *********************************************************************
           **********************************************************************
               **********************************************************************
                **********************************************************************
                
               ==========    ===          =======       =========    ===        ==
               ===           ===          ==      ==    =            === =      ==
               =========     ===          ==       ==   =========    ===  ==    ==
               ===           ===          ==      ==    ===          ===    ==  ==
               ==========    =========    =========     ==========   ===     =====
                
                         =========       ===    ===        ==     ==========    
                         ==       =      ===    === =      ==    =            
                         ========        ===    ===  ==    ==    ==    =====    
                         ==      ==      ===    ===    ==  ==    ==       ====    
                         ===     ====    ===    ===     =====     ==========         
                
                ********************************************************************
              *********************************************************************
           **********************************************************************
         **********************************************************************
         
                                                                  versao terminal do windows
                """);
        System.out.println("-----------------------------------------------");
        System.out.println("Trabalho criado com intuito acadêmico, os direitos de imagem pertencem as empresas: ");
        System.out.println("Bandai Namco");
        System.out.println("FromSoftware");
        System.out.println("-----------------------------------------------");
        System.out.print("Escolha seu nome: ");
        String nome = sc.nextLine().trim(); //pra validar se tem espaco em branco
        while(nome.isEmpty()) {
            System.out.print("O nome não pode ser vazio, digite novamente: ");
            nome = sc.nextLine().trim();
        }

        Arma curto = escolhaArmaCurtoAlcance(sc);
        Arma longo = escolhaArmaLongoAlcance(sc);
        Arma[] armas = { curto, longo};
        //fim exercicio 4
        //exercicio 6 (batalha de tres rounds)
        Maculado maculado = new Maculado(nome, armas, new Esquiva(75));
        Criatura[] inimigos = { new Godrick(), new Maliketh(), new Godfrey()};

        Batalha[] batalhas = new Batalha[3];
        int batalhasRealizadas = 0;
        boolean playerVenceu = true;

        for (int i = 0; i < 3 && playerVenceu; i++){
            if(i == 2){
                maculado.bencaoPristina();
            }
            batalhas[i] = new Batalha(maculado, inimigos[i]); // contabilizar a quantidade de batalhas aqui
            playerVenceu = batalhas[i].executar();
            batalhasRealizadas++;
            if(playerVenceu) {
                maculado.restaurarVida();
            }
        }

        System.out.println("\n===== Resultado =========");
        for(int i = 0; i < batalhasRealizadas; i++ ){
            System.out.println(batalhas[i].getResultado());
        }
        //mensagem final do codigo do jogo
        if(playerVenceu) {
            System.out.println(" ");
            System.out.println(maculado.getNome() + " entra na grande Térvore com um unico proposito, restaurar o Anel Pristino...");
            System.out.println(" ");
            System.out.println("Ele encontra o corpo da rainha Marika totalmente rachado, e une seu poder ao dela, restaurando o Anel Pristino...");
            System.out.println(" ");
            System.out.println("======================================================");
            System.out.println("As folhas caídas, contam uma história");
            System.out.println(" ");
            System.out.println("De como um Maculado se tornou o Lorde Pristino.");
            System.out.println(" ");
            System.out.println("Nossas sementes irão se relembrar e contar...");
            System.out.println("======================================================");
            System.out.println("======================================================");
            System.out.println("================== A ERA DA FRATURA  =================");
            System.out.println("======================================================");
            System.out.println("======================================================");
            System.out.println(" ");
            System.out.println("""
                                                    Obrigado por jogar!
                                   Trabalho feito por Enzo de Oliveira Conceição da Silva
                                                        Senac SP
                                   
                                   Este trabalho teve intuito acadêmico, o IP de Elden Ring
                                   permanece nos direitos das empresas Bandai Namco Japão e
                                                       FromSoftware
                                                       
                    """);
        } else {
            System.out.println(" ");
            System.out.println("Você perdeu, mas o Maculado volta a vida e tenta denovo!");
            System.out.println(" ");
            System.out.println("""
                                                    Obrigado por jogar!
                                   Trabalho feito por Enzo de Oliveira Conceição da Silva
                                                        Senac SP
                                   
                                   Este trabalho teve intuito acadêmico, o IP de Elden Ring
                                   permanece nos direitos das empresas Bandai Namco Japão e
                                                       FromSoftware
                                                       
                    """);

        }
    }
}
