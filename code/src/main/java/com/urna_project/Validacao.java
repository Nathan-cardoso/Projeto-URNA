package com.urna_project;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.caelum.stella.validation.CPFValidator;

public class Validacao {
        public static boolean validacaoCPF(String cpf){
        CPFValidator cpfValidator = new CPFValidator(); 
        try {
            
            cpfValidator.assertValid(cpf); 
            return true;

        } catch (Exception e) {
            System.out.println("\nCPF inválido!");
            return false;
        }
    }

    public static boolean validacaoEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            System.out.println("E-mail inválido!");
            result = false;
        }
        return result;
    }

    public static boolean validarNumeroEleicao(String numeroEleicao) {
        if (!numeroEleicao.matches("\\d{5}")) {
            System.out.println("Erro ao cadastrar o número do candidato. Era esperado 5 dígitos numéricos.");
            return false;
        }
        if (numeroEleicao.equals("00000")) {
            System.out.println("Não pode ser cadastrado esse número para eleição.");
            return false;
        }
        return true;
    }

    public static boolean validarMatricula(String matricula) {
        if (!matricula.matches("\\d{10}")) {
            System.out.println("     Erro no número de matrícula do eleitor.\n\tEra esperado 10 digitos numericos");
            return false;
        }
        return true;
    }

    public static boolean validarNome(String nome) {
        // Verifique se o nome contém apenas letras e espaços em branco
        if (nome.matches("^[a-zA-Z\\s]*$") || nome.trim().isEmpty() || nome == null || nome.equals("") ) {
            return false;
        }
        return true;
    }
}
