import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int nav;

        do{
        
        Menu.inicial();
        nav = input.nextInt();

        switch(nav){
            case 1:
            System.out.println("Ok");
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
