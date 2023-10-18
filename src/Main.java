import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int nav;
        String senhaByPass;
        do{
        
        Menu.inicial();
        nav = input.nextInt();

        switch(nav){
            case 1:
            input.nextLine();

            System.out.print("Informe a senha: ");

            senhaByPass = input.nextLine();

            if(senhaByPass.equals("teste2023")){

                int navAdm;
                do{
            
                    Menu.administracao();
                    navAdm = input.nextInt();

                    switch(navAdm){
                    case 1:
                        int navCandidato;

                        do{

                        Menu.candidato();
                        navCandidato = input.nextInt();

                        switch(navCandidato){
                            case 1:
                            //Dados que o usuário passa para o banco.
                            String numeroEleicao;
                            String nome;
                            String cpf;
                            String email;

                            input.nextLine();
                            System.out.println("Digite o número do candidato: ");
                            numeroEleicao = input.nextLine();

                            if(!numeroEleicao.matches("\\d{5}")){
                                System.out.println("------------------------------------------------");
                                System.out.println("    Erro ao cadastrar o número do candidato.\n\tEra esperado 5 digitos numericos");
                                System.out.println("------------------------------------------------");
                                break;
                            }else if(numeroEleicao.equals("00000")){
                                System.out.println("Não pode ser cadastrado esse número para eleição");
                                break;
                            }

                            System.out.println("Informe o nome do candidato: ");
                            nome = input.nextLine();

                            System.out.println("Informe o cpf do candidato: ");
                            cpf = input.nextLine();

                            if(!cpf.matches("\\d{11}")){
                                System.out.println("---------------------------------------------------------------------");
                                System.out.println("\tCPF invalido! Foi passado " + cpf.length() + " digitos, era esperado 11");
                                System.out.println("---------------------------------------------------------------------");
                                break;
                            }



                            System.out.println("Para finalizar, digite o emeil do candidato: ");
                            email = input.nextLine();

                            Candidato candidato = new Candidato(nome, cpf, email, numeroEleicao);

                            candidato.cadastrar();

                            break;
                            case 2:
                                input.nextLine();

                                int codigoEdicao;
                                String numeroDeBusca;
                                String alteracao;

                                System.out.print("\nDigite o número do candidato que deseja editar -> ");
                                numeroDeBusca = input.nextLine();

                                Candidato cand = Candidato.buscar(numeroDeBusca);

                                if(cand != null){
                                    System.out.println("------------------------------------------------");
                                    System.out.println(cand);
                                    System.out.println("------------------------------------------------");
                                }else{
                                    System.out.println("Candidato não encotrado");
                                    break;
                                }
                                
                                Menu.edicaoCandidato();
                                codigoEdicao = input.nextInt();

                                switch(codigoEdicao){
                                    case 1:
                                    input.nextLine();
                                    System.out.println("Informe o nome: ");
                                    alteracao = input.nextLine();

                                    cand.editar(codigoEdicao, alteracao);

                                    break;

                                    case 2:
                                    input.nextLine();
                                    System.out.println("Informe o CPF: ");
                                    alteracao = input.nextLine();

                                    if(!alteracao.matches("\\d{11}")){

                                    System.out.println("---------------------------------------------------------------------");
                                    System.out.println("\tCPF invalido! Foi passado " + alteracao.length() + " digitos, era esperado 11");
                                    System.out.println("---------------------------------------------------------------------");

                                        break;
                                    }

                                    cand.editar(codigoEdicao, alteracao);
                                            
                                    break;

                                    case 3:
                                    input.nextLine();
                                    System.out.println("Informe o novo E-mail: ");
                                    alteracao = input.nextLine();

                                    cand.editar(codigoEdicao, alteracao);

                                    break;

                                    case 4:
                                    input.nextLine();
                                    System.out.println("Informe o novo número para eleição");
                                    alteracao = input.nextLine();

                                    if(!alteracao.matches("\\d{5}")){
                                    System.out.println("------------------------------------------------");
                                    System.out.println("    Erro ao alterar o número do candidato.\n\tEra esperado 5 digitos numericos");
                                    System.out.println("------------------------------------------------");
                                    }else if(alteracao.equals("00000")){
                                    System.out.println("Não pode ser cadastrado esse número para eleição");
                                            break;
                                    }

                                    cand.editar(codigoEdicao, alteracao);

                                    break;

                                    default:
                                    System.out.println("Erro de digitação");
                                    break;
                                }

                                

                                break;

                            case 3:

                            input.nextLine();
                            
                            String exclusaoNumero;
                            System.out.print("\nDigite o número do candidato que deseja excluir -> ");
                            exclusaoNumero = input.nextLine();

                                if(!exclusaoNumero.matches("\\d{5}")){
                                System.out.println("------------------------------------------------");
                                System.out.println("    Erro ao buscar o número do candidato.\n\tEra esperado 5 digitos numericos");
                                System.out.println("------------------------------------------------");
                                break;
                            }

                            Candidato.excluir(exclusaoNumero);
                            break;
                            case 4:
                            System.out.println("\tLista de Candidatos");
                            Candidato.listar();
                            break;
                            case 5:
                            break;
                            default:
                            System.out.println("Erro de digitação");
                            break;
                        }

                        }while(navCandidato != 5);

                        break; //Fim case 1 menu adm

                    case 2:

                            int navEleitor;


                            do{

                                Menu.eleitor();
                                navEleitor = input.nextInt();

                                switch(navEleitor){
                                case 1:
                            String matricula;
                            String nome;
                            String cpf;
                            String email;
                            String senha;

                            input.nextLine();
                            System.out.println("Digite a matrícula do eleitor: ");
                            matricula = input.nextLine();

                            if(!matricula.matches("\\d{10}")){
                                System.out.println("------------------------------------------------");
                                System.out.println("    Erro ao cadastrar o número do eleitor.\n\tEra esperado 10 digitos numericos");
                                System.out.println("------------------------------------------------");
                                break;
                            }

                            System.out.println("Informe o nome do eleitor: ");
                            nome = input.nextLine();

                            System.out.println("Informe o cpf do eleitor: ");
                            cpf = input.nextLine();

                            if(!cpf.matches("\\d{11}")){
                                System.out.println("---------------------------------------------------------------------");
                                System.out.println("\tCPF invalido! Foi passado " + cpf.length() + " digitos, era esperado 11");
                                System.out.println("---------------------------------------------------------------------");
                                break;
                            }

                            System.out.println("Digite o emeil do eleitor: ");
                            email = input.nextLine();

                            System.out.println("Digite sua senha: ");
                            senha = input.nextLine();

                            Eleitor eleitor = new Eleitor(nome, cpf, email, matricula,senha);

                            eleitor.cadastrar();

                                break; // Fim  case 1 menu do eleitor na navegação do adm

                                case 2:
                                 input.nextLine();

                                int codigoEdicaoEleitor;
                                String matriculaBusca;
                                String alteracao;

                                System.out.print("\nDigite a matrícula do eleitor que deseja editar -> ");
                                matriculaBusca = input.nextLine();

                                if(!matriculaBusca.matches("\\d{10}")){
                                    System.out.println("------------------------------------------------");
                                    System.out.println("    Erro ao pesquisar a matrícula do eleitor.\n\tEra esperado 10 digitos numericos");
                                    System.out.println("------------------------------------------------");
                                    break;
                                }

                                Eleitor eli = Eleitor.buscar(matriculaBusca);

                                if(eli != null){
                                    System.out.println("------------------------------------------------");
                                    System.out.println(eli);
                                    System.out.println("------------------------------------------------");
                                }else{
                                    System.out.println("Eleitor não encotrado");
                                    break;
                                }
                                
                                Menu.edicaoEleitor();
                                codigoEdicaoEleitor = input.nextInt();

                                switch(codigoEdicaoEleitor){
                                    case 1: 

                                    input.nextLine();

                                    System.out.println("Informe o nome: ");
                                    alteracao = input.nextLine();

                                    eli.editar(codigoEdicaoEleitor, alteracao);

                                    break; // Fim case 1 de edição eleitor

                                    case 2: 

                                    input.nextLine();
                                    System.out.println("Informe o CPF: ");
                                    alteracao = input.nextLine();

                                    if(!alteracao.matches("\\d{11}")){

                                    System.out.println("---------------------------------------------------------------------");
                                    System.out.println("\tCPF invalido! Foi passado " + alteracao.length() + " digitos, era esperado 11");
                                    System.out.println("---------------------------------------------------------------------");

                                        break;
                                    }

                                    eli.editar(codigoEdicaoEleitor, alteracao);

                                    break; // Fim case 2 de edição eleitor

                                    case 3: 

                                    input.nextLine();
                                    System.out.println("Informe o novo E-mail: ");
                                    alteracao = input.nextLine();

                                    eli.editar(codigoEdicaoEleitor, alteracao);

                                    break; // Fim case 3 de edição eleitor

                                    case 4: 

                                    input.nextLine();
                                    System.out.println("Informe a nova senha: ");
                                    alteracao = input.nextLine();

                                    eli.editar(codigoEdicaoEleitor, alteracao);

                                    break; // Fim case 4 de edição eleitor

                                    case 5: 

                                    break; // Fim case 5 de edição eleitor

                                    default:
                                        System.out.println("Erro de digitação");

                                    break;


                                }

                                break; // Fim case 2 menu do eleitor na navegação do adm.

                                case 3:
                                
                                    input.nextLine();
                                    
                                    String excluirMatricula;
                                    System.out.print("\nDigite a matricula do eleitor que deseja excluir -> ");
                                    excluirMatricula = input.nextLine();

                                        if(!excluirMatricula.matches("\\d{10}")){
                                        System.out.println("------------------------------------------------");
                                        System.out.println("    Erro ao buscar a matricula do eleitor.\n\tEra esperado 10 digitos numericos");
                                        System.out.println("------------------------------------------------");
                                        break;
                                    }

                                    Eleitor.excluir(excluirMatricula);

                                break; //// Fim case 3 menu do eleitor na navegação do adm.

                                case 4:

                                System.out.println("\tLista dos eleitores cadastrados");
                                Eleitor.listar();
                                
                                break; // Fim case 4 menu do eleitor na navegação do adm.7

                                case 5:
                                break;

                                default:
                                System.out.println("Erro de digitação");
                                break;
                                }

                            }while(navEleitor != 5);

                        break; // Fim case 2 menu adm
                    
                    case 3:

                        List<String> resultados = Candidato.gerarRelatorio();
                        
                        Menu.relatório();

                        for (String resultado : resultados) {
                            System.out.println(resultado);
                        }

                    break;// Fim case 3 menu adm

                    }

                }while(navAdm != 4);

            }else{
                System.out.println("Senha invalida");
                break;
            }

            break; //Direcionamento para a área de adm

            case 2:
            input.nextLine();

            int navAreaEleitor;
            do{
            Menu.loginEleitor();
            navAreaEleitor = input.nextInt();

            switch(navAreaEleitor){
                case 1:

                input.nextLine();

                String emailLogin;
                String senhaLogin;

                System.out.printf("Digite seu email: ");
                emailLogin = input.nextLine();

                System.out.printf("Digite sua senha: ");
                senhaLogin = input.nextLine();

                Eleitor user = Eleitor.login(emailLogin, senhaLogin);

                if(user == null){

                    System.out.println("email ou senha invalido!");

                }else{

                    int navLogado;

                    System.out.println("\nOlá, " + user.getNome());
                    do{

                        Menu.areaEleitor();
                        navLogado = input.nextInt();

                        switch(navLogado){
                            case 1:
                            input.nextLine();

                            
                            String voto;

                                if(user.isStatusDeVoto() == true){
                                System.out.println("Não é permitodo votar novamente");
                                break;

                            }

                            System.out.println("Digite o número do candidato que deseja votar");
                            voto = input.nextLine();

                            user.votar(voto);
                            
                            
                            break; // Fim do case 1 da área após o login

                            case 2:
                            
                            System.out.println("Seus dados...");
                            System.out.println("----------------------------------");
                            System.out.println(user);
                            System.out.println("----------------------------------");

                            break;// Fim do case 2 da área após o login

                            case 3:
                            int codParaEdit;
                            String alteracaoEleitor;

                            Menu.edicaoEleitor();
                                codParaEdit = input.nextInt();

                                switch(codParaEdit){
                                    case 1: 

                                    input.nextLine();

                                    System.out.println("Informe o nome: ");
                                    alteracaoEleitor = input.nextLine();

                                    user.editar(codParaEdit, alteracaoEleitor);

                                    break; // Fim case 1 de edição eleitor

                                    case 2: 

                                    input.nextLine();
                                    System.out.println("Informe o CPF: ");
                                    alteracaoEleitor = input.nextLine();

                                    if(!alteracaoEleitor.matches("\\d{11}")){

                                    System.out.println("---------------------------------------------------------------------");
                                    System.out.println("\tCPF invalido! Foi passado " + alteracaoEleitor.length() + " digitos, era esperado 11");
                                    System.out.println("---------------------------------------------------------------------");

                                        break;
                                    }

                                    user.editar(codParaEdit, alteracaoEleitor);

                                    break;

                                    case 3: 

                                    input.nextLine();
                                    System.out.println("Informe o novo E-mail: ");
                                    alteracaoEleitor = input.nextLine();

                                    user.editar(codParaEdit, alteracaoEleitor);

                                    break; // Fim case 3 de edição eleitor

                                    case 4: 

                                    input.nextLine();
                                    System.out.println("Informe a nova senha: ");
                                    alteracaoEleitor = input.nextLine();

                                    user.editar(codParaEdit, alteracaoEleitor);

                                    break; // Fim case 4 de edição eleitor

                                    case 5: 
                                    break; // Fim case 5 de edição eleitor

                                    default:
                                        System.out.println("Erro de digitação");

                                    break;

                                }

                            break;// Fim do case 3 da área após o login

                            case 4:
                            break;// Fim do case 4 da área após o login

                            default:
                            System.out.println("Erro de digitação");
                            break;
                        }

                    }while(navLogado != 4);
                    

                }


                break; //Breack do case 1 da área de eleitores

                case 2:
                        String matricula;
                        String nome;
                        String cpf;
                        String email;
                        String senha;

                        input.nextLine();
                        System.out.println("Digite seu número de matrícula: ");
                        matricula = input.nextLine();

                        if(!matricula.matches("\\d{10}")){
                            System.out.println("------------------------------------------------");
                            System.out.println("    Erro ao cadastrar a matrícula do eleitor.\n\tEra esperado 10 digitos numericos");
                            System.out.println("------------------------------------------------");
                            break;
                        }

                        System.out.println("Informe seu nome: ");
                        nome = input.nextLine();

                        System.out.println("Informe seu CPF: ");
                        cpf = input.nextLine();

                        if(!cpf.matches("\\d{11}")){
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("\tCPF invalido! Foi passado " + cpf.length() + " digitos, era esperado 11");
                            System.out.println("---------------------------------------------------------------------");
                            break;
                        }

                        System.out.println("Digite seu  E-meil: ");
                        email = input.nextLine();

                        System.out.println("cadastre uma senha: ");
                        senha = input.nextLine();

                        Eleitor eleitor = new Eleitor(nome, cpf, email, matricula,senha);

                        eleitor.cadastrar();

                break; //Break do case 2 da área de eleitores

                case 3:
                break;

                default:
                System.out.println("Erro de digitação");
                break;

            }
            }while(navAreaEleitor != 3);

            break;

            case 3:
            System.out.println("\n\tEncerrando...");
            break;

            default:
            System.out.println("\n\tErro de digitação! Tente novamente");
            break;
        }

        }while(nav != 3);

        input.close();
    }
}
