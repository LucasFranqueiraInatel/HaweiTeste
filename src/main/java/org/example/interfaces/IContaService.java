package org.example.interfaces;

public interface IContaService {
    public boolean pagarConta(double valor, String nome);
    public boolean depositarConta(double valor, String nome);
    public double consultaSaldo();
    public void consultaEstrato();

}
