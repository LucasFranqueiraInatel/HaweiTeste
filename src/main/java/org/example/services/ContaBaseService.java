package org.example.services;

import org.example.interfaces.IContaService;
import org.example.modelo.Pagamentos;

import java.util.ArrayList;

public abstract class ContaBaseService implements IContaService {
    private  String agencia;
    private String numeroConta;
    private double saldo = 0;

    ArrayList<Pagamentos> extrato = new ArrayList<Pagamentos>();

    public ContaBaseService(String agencia, String numeroConta) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean pagarConta(double valor, String nome) {
        if (this.saldo < valor)
            return false;

        this.saldo = this.saldo-valor;

        Pagamentos Pagamento = new Pagamentos(-valor, nome, "Pagamento");
        extrato.add(Pagamento);
        return true;

    }

    @Override
    public boolean depositarConta(double valor, String nome) {
        if (valor <= 0)
            return false;

        this.saldo += valor;

        extrato.add(new Pagamentos(valor, nome, "deposito"));
        return true;
    }

    @Override
    public double consultaSaldo() {
        return this.saldo;
    }

    @Override
    public void consultaEstrato() {
        for (Pagamentos pagamento: this.extrato) {
            System.out.println("Nome: " + pagamento.getNome());
            System.out.println("valor: "+ pagamento.getValor());
            System.out.println("Operacao: "+ pagamento.getOperacao());
            System.out.println("------------------------------------");
        }
        System.out.println("Saldo Total: "+ this.saldo);
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
