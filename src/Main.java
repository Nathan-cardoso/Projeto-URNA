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
                    case 3:
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
            }else{
                System.out.println("Senha invalida");
                break;
            }
            break;

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
