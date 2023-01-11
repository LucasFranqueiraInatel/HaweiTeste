package org.example.test;

import org.example.controller.ManipulaConta;
import org.example.services.ContaBaseService;
import org.example.services.ContaCorrenteService;
import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteIntegracaoTest {

    ManipulaConta ManipulaContaFake;

    @Test
    public void depositarValorContaCorrenteTest_Ok(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111","123456789-0");

        String resultado = ManipulaContaFake.depositarValor(cc, 1500,"pix");
        Assert.assertEquals("Deposito realizado com sucesso", resultado);
    }

    @Test
    public void depositarValorContaCorrenteTest_Erro(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111","123456789-0");

        String resultado = ManipulaContaFake.depositarValor(cc, -1500,"pix");
        Assert.assertEquals("Falha ao realizar deposito", resultado);
    }


}
