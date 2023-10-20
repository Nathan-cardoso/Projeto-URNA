package com.urna_project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CandidatoTeste {
    @Test
    public void isCandidatosCadastrados(){
        Candidato ca = new Candidato("sergio", "70589239490", "sergio@gmail.com", "78945");
        ca.cadastrar();

        assertEquals(true,Candidato.verificacaoCandidato());
        
        Candidato.excluir("78945");
    }

    /**
     * 
     */
    @Test
    void buscarCandidatoTest(){
        Candidato ca = new Candidato("sergio", "70589239490", "sergio@gmail.com", "78945");
        ca.cadastrar();

        Candidato c = Candidato.buscar("78945");
        assertEquals(ca,c);
    }
}
