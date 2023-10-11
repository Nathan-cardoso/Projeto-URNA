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
                                System.out.println("Ok");
                                break; // Fim  case 1 menu do eleitor na navegação do adm

                                case 2:
                                System.out.println("OK");
                                break; // Fim case 2 menu do eleitor na navegação do adm.

                                case 3:
                                System.out.println("OK");
                                break; //// Fim case 3 menu do eleitor na navegação do adm.

                                case 4:
                                System.out.println("Ok");
                                break; // Fim case 4 menu do eleitor na navegação do adm.7

                                case 5:
                                break;

                                default:
                                System.out.println("Erro de digitação");
                                break;
                                }

                            }while(navEleitor != 5);

                        break; // Fim case 2 menu adm


                    }

                }while(navAdm != 4);

            }else{
                System.out.println("Senha invalida");
                break;
            }

            break; //Direcionamento para a área de adm

            case 2:
            System.out.println("Ok");
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
