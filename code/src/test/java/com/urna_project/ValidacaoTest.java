package com.urna_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidacaoTest {

    @Test
    void nome(){
        assertEquals(false, Validacao.validarNome(""));
    }

    @Test
    void cpf(){
         assertEquals(false, Validacao.validacaoCPF("1111111111"));
    }

    @Test
    void email(){
         assertEquals(false, Validacao.validacaoEmail("teste.com"));
    }

    @Test
    void matricula(){
         assertEquals(false, Validacao.validarMatricula("123456"));
    }
}
