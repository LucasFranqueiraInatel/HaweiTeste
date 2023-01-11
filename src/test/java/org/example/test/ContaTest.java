package org.example.test;

import org.example.services.ContaCorrenteService;
import org.example.services.ContaPoupancaService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContaTest {
    ContaCorrenteService cc;
    ContaPoupancaService cp;

    @Before
    public void setup(){
        //cc = new ContaCorrenteService("1234", "12345678-9");
        //cp = new ContaPoupancaService("4321", "98765432-1");
    }
    @Test
    public void ContaCorrentePagarCredito_Ok(){
        cc = new ContaCorrenteService("1234", "12345678-9");
        boolean verifica = cc.pagarCredito(10);
        assertEquals(true, verifica);

    }

    @Test
    public void ContaCorrentePagarCredito_Erro() {
        cc = new ContaCorrenteService("1234", "12345678-9");
        //cp = new ContaPoupancaService("4321", "98765432-1");
        assertEquals(false, cc.pagarCredito(-10));
    }
    }


