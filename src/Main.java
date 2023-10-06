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
                    case 2:
                    case 3:
                    break;
                    case 4:
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
