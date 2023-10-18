public class Menu {

    //menu principal
    public static void inicial(){
        
        System.out.println("\n\t      Urna Universitária      ");
        System.out.println("\t ___________________________");
        System.out.println("\t|                           |");
        System.out.println("\t| 1 -> Admistração          |");
        System.out.println("\t|                           |");
        System.out.println("\t| 2 -> Área do eleitor      |");
        System.out.println("\t|                           |");
        System.out.println("\t| 3 -> Sair                 |");
        System.out.println("\t|___________________________|");
        System.out.print("Digite o número referente ao campo que deseja navegar -> ");

    }

    public static void administracao(){

        System.out.println("\n     Área de administração    ");
        System.out.println(" ____________________________");
        System.out.println("|                            |");
        System.out.println("| 1 - Controle de candidatos |");
        System.out.println("| 2 - Controle de eleitores  |");
        System.out.println("| 3 - Gerar relatório        |");
        System.out.println("| 4 - Sair                   |");
        System.out.println("|____________________________|");
        System.out.print("Digite o número referente ao campo que deseja navegar -> ");

    }

    public static void candidato(){

        System.out.println("\n      Área de candidatos    ");
        System.out.println(" ___________________________");
        System.out.println("| 1 -> cadastrar            |");
        System.out.println("| 2 -> editar               |");
        System.out.println("| 3 -> excluir              |");
        System.out.println("| 4 -> listar               |");
        System.out.println("| 5 -> sair                 |");
        System.out.println("|___________________________|");
        System.out.print("Digite o número referente ao área que deseja navegar -> ");
    }

        public static void eleitor(){

        System.out.println("\n      Área de eleitores    ");
        System.out.println(" ___________________________");
        System.out.println("| 1 -> cadastrar            |");
        System.out.println("| 2 -> editar               |");
        System.out.println("| 3 -> excluir              |");
        System.out.println("| 4 -> listar               |");
        System.out.println("| 5 -> sair                 |");
        System.out.println("|___________________________|");
        System.out.print("Digite o número referente ao área que deseja navegar -> ");
    }

    public static void edicaoCandidato(){
        System.out.println(" _______________________________");
        System.out.println("|   O que deseja alterar?       |");
        System.out.println("|                               |");
        System.out.println("| 1 - Nome                      |");
        System.out.println("| 2 - CPF                       |");
        System.out.println("| 3 - Email                     |");
        System.out.println("| 4 - Novo Numero  de eleicao   |");
        System.out.println("| 5 - Sair                      |");
        System.out.println("|_______________________________|");
        System.out.print("Digite o número referente ao campo que deseja alterar -> ");
    }

        public static void edicaoEleitor(){
        System.out.println(" _______________________________");
        System.out.println("|   O que deseja alterar?       |");
        System.out.println("|                               |");
        System.out.println("| 1 - Nome                      |");
        System.out.println("| 2 - CPF                       |");
        System.out.println("| 3 - Email                     |");
        System.out.println("| 4 - Senha                     |");
        System.out.println("| 5 - Sair                      |");
        System.out.println("|_______________________________|");
        System.out.print("Digite o número referente ao campo que deseja alterar -> ");
    }

    public static void loginEleitor(){
        System.out.println(" _______________________________");
        System.out.println("|                               |");
        System.out.println("| 1 - Entrar                    |");
        System.out.println("| 2 - Cadastra-se               |");
        System.out.println("| 3 - voltar                    |");
        System.out.println("|_______________________________|");
        System.out.print("Digite o número referente a ação desejada -> ");       
    }

    public static void areaEleitor(){
        System.out.println(" _______________________________");
        System.out.println("|                               |");
        System.out.println("| 1 - Ir para votação           |");
        System.out.println("| 2 - Consultar meus dados      |");
        System.out.println("| 3 - editar meus dados         |");
        System.out.println("| 4 - voltar                    |");
        System.out.println("|_______________________________|");
    System.out.print("Digite o número referente a ação desejada -> "); 

    }

    public static void relatório(){
        System.out.println(" _________________________________");
        System.out.println("|        Relatório dos votos      |" );
        System.out.println("|_________________________________|");
        System.out.println("\n---------------------------------------");
    }
    
    
 }
