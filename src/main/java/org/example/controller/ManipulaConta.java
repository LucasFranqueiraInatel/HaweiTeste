package org.example.controller;

import org.example.services.ContaBaseService;
import org.example.services.ContaCorrenteService;
import org.example.services.ContaPoupancaService;

import java.util.Scanner;

public class ManipulaConta {
    ContaBaseService ContaCorrente;
    ContaBaseService ContaPoupanca;

    public void menuInicial(){
        System.out.println("Selecione o seu tipo de conta: \n");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupanca");
        System.out.print("\nEscolha uma opcao: ");

        Scanner teclado = new Scanner(System.in);

        short op = teclado.nextShort();

        teclado.nextLine();

        System.out.print("Entre com uma agencia: ");
        String agencia = teclado.nextLine();

        System.out.print("Entre com o numero da conta: ");
        String numero = teclado.nextLine();

        System.out.println("------------------------------------");

        switch (op){
            case 1:
                ContaCorrente = new ContaCorrenteService(agencia, numero);
                this.menuConta(ContaCorrente);
                break;

            case 2:
                ContaPoupanca = new ContaPoupancaService(agencia, numero);
                this.menuConta(ContaPoupanca);
                break;
        }
    }

    public  void menuConta(ContaBaseService Conta){
        short op = 0;
        while (op != 3){
            System.out.println("Conta:");
            System.out.println("1 - Depositar dinheiro em conta");
            System.out.println("2 - Pagar conta");
            System.out.println("3 - Sair");

            Scanner teclado = new Scanner(System.in);

            op = teclado.nextShort();

            teclado.nextLine();

            switch (op){
                case 1:
                    System.out.println("Entre com o nome do deposito: ");
                    String nomeDeposito = teclado.nextLine();

                    System.out.println("Entre com o valor do deposito: ");
                    double valorDeposito = teclado.nextDouble();

                    teclado.nextLine();

                    System.out.println("\n" + this.depositarValor(Conta, valorDeposito, nomeDeposito) + "\n");
                    break;
                case 2:
                    System.out.println("Entre com o nome do pagamento: ");
                    String nomePagamento = teclado.nextLine();

                    System.out.println("Entre com o valor do pagamento");
                    double valorPagamento = teclado.nextDouble();

                    teclado.nextLine();

                    System.out.println("\n" + this.pagamentoConta(Conta, valorPagamento, nomePagamento) + "\n");
                    break;

                case 3:
                    System.out.println("Fim da operacao");
                    break;
            }
        }
    }

    public String depositarValor(ContaBaseService Conta, double valor, String nome){
        boolean response = Conta.depositarConta(valor, nome);

        if(!response){
            return "Falha ao realizar deposito";
        }

        return "Deposito realizado com sucesso";
    }

    public String pagamentoConta(ContaBaseService Conta, double valor, String nome){
        boolean response = Conta.pagarConta(valor, nome);

        if(!response){
            return "Falha ao realizar pagamento";
        }
        return "Pagamento realizado com sucesso";
    }

}
