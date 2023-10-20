package com.urna_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EleitorTest {

    @Test
    void buscarEleitorTest() {
        Eleitor l = new Eleitor("teste", "14785233910", "teste@gmail.com", "1478523691", "pass");
        l.cadastrar();
        Eleitor lTeste = Eleitor.buscar("2021010903");

        assertEquals(l, lTeste);
        Eleitor.excluir("1478523691");

    }

    /**
     * 
     */
    @Test
    public void loginTest(){
        Eleitor eli = new Eleitor("Nathan", "70589239490", "nathanteste@gmail.com", "2021010903", "teste", false);
        eli.cadastrar();

        Eleitor login = Eleitor.login("nathanteste@gmail.com", "teste");

        assertEquals(eli, login);

        Eleitor.excluir("2021010903");
    }

}
