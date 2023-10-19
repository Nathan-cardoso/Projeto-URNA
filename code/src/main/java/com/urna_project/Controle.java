package com.urna_project;

import java.util.List;
import java.util.Scanner;

public class Controle {
    // Método para ação e exibição do menu dos candidatos
    public static void handleCandidatoMenu(Scanner input) {
        int navCandidato;

        do {
            Menu.candidato();
            navCandidato = input.nextInt();

            switch (navCandidato) {
                case 1:
                    cadastrarCandidato(input);
                    break;
                case 2:
                    editarCandidato(input);
                    break;
                case 3:
                    excluirCandidato(input);
                    break;
                case 4:
                    listarCandidatos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro de digitação");
                    break;
            }
        } while (navCandidato != 5);
    }

    // Método para ação e exibição do menu dos eleitores
    public static void handleEleitorMenu(Scanner input) {
        int navCandidato;

        do {
            Menu.eleitor();
            navCandidato = input.nextInt();

            switch (navCandidato) {
                case 1:
                    cadastrarEleitor(input);
                    break;
                case 2:
                    editarEleitor(input);
                    break;
                case 3:
                    excluirEleitor(input);
                    break;
                case 4:
                    listarEleitors();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro de digitação");
                    break;
            }
        } while (navCandidato != 5);
    }

    // Mostra o relatório
    public static void viewRelatorio() {
        List<String> resultados = Candidato.gerarRelatorio();

        Menu.relatório();

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    // realizar o cadastro dos candidatos
    public static void cadastrarCandidato(Scanner input) {
        String numeroEleicao;
        String nome;
        String cpf;
        String email;

        input.nextLine();
        System.out.println("Digite o número do candidato: ");
        numeroEleicao = input.nextLine();

        if (!Validacao.validarNumeroEleicao(numeroEleicao)) {
            System.out.println("Reinicie o cadastro...");
            return;
        }

        System.out.println("Informe o nome do candidato: ");
        nome = input.nextLine();

        System.out.println("Informe o cpf do candidato: ");
        cpf = input.nextLine();

        if (Validacao.validacaoCPF(cpf) != true) {
            System.out.println("Reinicie o cadastro");
            return;
        }

        System.out.println("Para finalizar, digite o email do candidato: ");
        email = input.nextLine();

        if (Validacao.validacaoEmail(email) != true) {
            System.out.println("Reinicie o cadastro");
            return;
        }

        Candidato candidato = new Candidato(nome, cpf, email, numeroEleicao);
        candidato.cadastrar();
    }

    // realizar o cadastro dos eleitores
    public static void cadastrarEleitor(Scanner input) {
        String matricula;
        String nome;
        String cpf;
        String email;
        String senha;

        input.nextLine();
        System.out.println("Digite a matrícula do eleitor: ");
        matricula = input.nextLine();

        if (!Validacao.validarMatricula(matricula)) {
            return;
        }

        System.out.println("Informe o nome do eleitor: ");
        nome = input.nextLine();

        System.out.println("Informe o cpf do eleitor: ");
        cpf = input.nextLine();

        if (!Validacao.validacaoCPF(cpf)) {
            System.out.println("CPF inválido. Reinicie o cadastro.");
            return;
        }

        System.out.println("Digite o emeil do eleitor: ");
        email = input.nextLine();

        if (!Validacao.validacaoEmail(email)) {
            System.out.println("Reinicie o cadastro");
            return;
        }

        System.out.println("Digite sua senha: ");
        senha = input.nextLine();

        Eleitor eleitor = new Eleitor(nome, cpf, email, matricula, senha);

        eleitor.cadastrar();
    }

    public static void editarCandidato(Scanner input) {
        input.nextLine();

        int codigoEdicao;
        String numeroDeBusca;
        String alteracao;

        System.out
                .print("\nDigite o número do candidato que deseja editar -> ");
        numeroDeBusca = input.nextLine();

        Candidato cand = Candidato.buscar(numeroDeBusca);

        if (cand != null) {
            System.out.println(
                    "------------------------------------------------");
            System.out.println(cand);
            System.out.println(
                    "------------------------------------------------");
        } else {
            System.out.println("Candidato não encotrado");
            return;
        }

        Menu.edicaoCandidato();
        codigoEdicao = input.nextInt();

        switch (codigoEdicao) {
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

                if (!Validacao.validacaoCPF(alteracao)) {
                    System.out.println("Reinicie o cadastro.");
                    return;
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

                if (!Validacao.validarNumeroEleicao(alteracao)) {
                    System.out.println("Reinicie o cadastro...");
                    return;
                }

                cand.editar(codigoEdicao, alteracao);

                break;

        }
    }

    // Ação de editar eleitor.
    public static void editarEleitor(Scanner input) {
        input.nextLine();

        int codigoEdicaoEleitor;
        String matriculaBusca;
        String alteracao;

        System.out
                .print("\nDigite a matrícula do eleitor que deseja editar -> ");
        matriculaBusca = input.nextLine();

        if (!Validacao.validarMatricula(matriculaBusca)) {
            System.out.println("matricula inválido!");
            return;
        }

        Eleitor eli = Eleitor.buscar(matriculaBusca);

        if (eli != null) {
            System.out.println(
                    "------------------------------------------------");
            System.out.println(eli);
            System.out.println(
                    "------------------------------------------------");
        } else {
            System.out.println("Eleitor não encotrado");
            return;
        }

        Menu.edicaoEleitor();
        codigoEdicaoEleitor = input.nextInt();

        switch (codigoEdicaoEleitor) {
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

                if (Validacao.validacaoCPF(alteracao) != true) {
                    System.out.println("Reinicie o cadastro");
                    return;
                }

                eli.editar(codigoEdicaoEleitor, alteracao);
            case 3:

                input.nextLine();
                System.out.println("Informe o novo E-mail: ");
                alteracao = input.nextLine();

                if (!Validacao.validacaoEmail(alteracao)) {
                    System.out.println("Reinicie o cadastro");
                    return;
                }

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
    }

    // Método para excluir candadato.
    public static void excluirCandidato(Scanner input) {
        input.nextLine();

        String exclusaoNumero;
        System.out
                .print("\nDigite o número do candidato que deseja excluir -> ");
        exclusaoNumero = input.nextLine();

        if (!Validacao.validarNumeroEleicao(exclusaoNumero)) {
            System.out.println("Reinicie o cadastro...");
            return;
        }

        Candidato.excluir(exclusaoNumero);
    }

    // Método para excluir eleitor.
    public static void excluirEleitor(Scanner input) {
        input.nextLine();

        String excluirMatricula;
        System.out.print(
                "\nDigite a matricula do eleitor que deseja excluir -> ");
        excluirMatricula = input.nextLine();

        if (!Validacao.validarMatricula(excluirMatricula)) {
            return;
        }

        Eleitor.excluir(excluirMatricula);
    }

    // Mostra todos os candidatos
    public static void listarCandidatos() {
        System.out.println("\tLista de Candidatos");
        Candidato.listar();
    }

    // Mostra todos os eleitores
    public static void listarEleitors() {
        System.out.println("\tLista dos eleitores cadastrados");
        Eleitor.listar();
    }

    // Realiza o login do eleitor
    public static void login(Scanner input) {
        input.nextLine();

        String emailLogin;
        String senhaLogin;

        System.out.printf("Digite seu email: ");
        emailLogin = input.nextLine();

        System.out.printf("Digite sua senha: ");
        senhaLogin = input.nextLine();

        Eleitor user = Eleitor.login(emailLogin, senhaLogin);

        if (user == null) {

            System.out.println("email ou senha invalido!");

        } else {

            int navLogado;

            System.out.println("\nOlá, " + user.getNome());
            do {

                Menu.areaEleitor();
                navLogado = input.nextInt();

                switch (navLogado) {
                    case 1:
                        input.nextLine();

                        String voto;

                        if (user.isStatusDeVoto() == true) {
                            System.out.println("Não é permitodo votar novamente");
                            break;

                        }

                        Menu.informes();

                        System.out.println("\t Digite seu voto abaixo ");
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

                        switch (codParaEdit) {
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

                                if (!Validacao.validacaoCPF(alteracaoEleitor)) {
                                    System.out.println("CPF inválido. Reinicie o cadastro.");
                                    return;
                                }

                                user.editar(codParaEdit, alteracaoEleitor);

                                break;

                            case 3:

                                input.nextLine();
                                System.out.println("Informe o novo E-mail: ");
                                alteracaoEleitor = input.nextLine();

                                if (!Validacao.validacaoEmail(alteracaoEleitor)) {
                                    System.out.println("Reinicie o cadastro");
                                    return;
                                }

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

            } while (navLogado != 4);

        }
    }

    // Faz o cadastro do candidado.
    public static void cadastroLogin(Scanner input) {
        String matricula;
        String nome;
        String cpf;
        String email;
        String senha;

        input.nextLine();
        System.out.println("Digite seu número de matrícula: ");
        matricula = input.nextLine();

        if (!Validacao.validarMatricula(matricula)) {
            return;
        }

        System.out.println("Informe seu nome: ");
        nome = input.nextLine();

        System.out.println("Informe seu CPF: ");
        cpf = input.nextLine();

        if (Validacao.validacaoCPF(cpf) != true) {
            System.out.println("Reinicie o cadastro");
            return;
        }

        System.out.println("Digite seu  E-mail: ");
        email = input.nextLine();

        System.out.println("cadastre uma senha: ");
        senha = input.nextLine();

        Eleitor eleitor = new Eleitor(nome, cpf, email, matricula, senha);

        eleitor.cadastrar();

    }
}