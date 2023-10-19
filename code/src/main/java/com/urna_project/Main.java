package com.urna_project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int nav;
        String senhaByPass;
        do {

            Menu.inicial();
            nav = input.nextInt();
            switch (nav) {
                case 1:
                    input.nextLine();

                    System.out.print("Informe a senha: ");

                    senhaByPass = input.nextLine();

                    if (senhaByPass.equals("teste2023")) {

                        int navAdm;
                        do {

                            Menu.administracao();
                            navAdm = input.nextInt();

                            switch (navAdm) {
                                case 1:
                                    Controle.handleCandidatoMenu(input);
                                    break; // Fim case 1 menu adm

                                case 2:

                                    Controle.handleEleitorMenu(input);
                                    break; // Fim case 2 menu adm

                                case 3:

                                    Controle.viewRelatorio();
                                    break;// Fim case 3 menu adm

                            }

                        } while (navAdm != 4);

                    } else {
                        System.out.println("Senha invalida");
                        break;
                    }

                    break; // Direcionamento para a área de adm

                case 2:
                    input.nextLine();

                    int navAreaEleitor;
                    do {
                        Menu.loginEleitor();
                        navAreaEleitor = input.nextInt();

                        switch (navAreaEleitor) {
                            case 1:
                                Controle.login(input);
                                break; // Breack do case 1 da área de eleitores

                            case 2:
                                Controle.cadastroLogin(input);
                                break; // Break do case 2 da área de eleitores

                            case 3:
                                break;

                            default:
                                System.out.println("Erro de digitação");
                                break;

                        }
                    } while (navAreaEleitor != 3);

                    break;

                case 3:
                    System.out.println("\n\tEncerrando...");
                    break;

                default:
                    System.out.println("\n\tErro de digitação! Tente novamente");
                    break;
            } // Fim do Switch da main

        } while (nav != 3); // Fim do Menu principal

        input.close();
    }



}