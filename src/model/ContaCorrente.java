package model;

import java.util.ArrayList;

public class ContaCorrente {
    private float saldo;
    private int numeroConta;
    private int numeroAgencia;
    private Cliente cliente;
    private ArrayList<Transacao> transacoes;

    public ContaCorrente(int numeroConta, int numeroAgencia, Cliente cliente) {
        this.saldo = 0.0f;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public void depositar(float valor) {
        this.saldo += valor;
        Transacao t = new Transacao(saldo, "depósito", valor);
        registrarTransacao(t);
    }

    public boolean sacar(float valor) {
        if (saldo - valor >= 0) {
            this.saldo -= valor;
            Transacao t = new Transacao(saldo, "saque", valor);
            registrarTransacao(t);
            return true;
        }
        return false;
    }

    public ArrayList<Transacao> obterExtrato() {
        return this.transacoes;
    }

    public void imprimeExtrato() {
    System.out.println("-------------Extrato------------");
    System.out.println("================================");
    for (Transacao atual : transacoes) {
        System.out.println(atual);
    }
    System.out.println("================================");
    System.out.println("Saldo atual: R$%.2f".formatted(saldo));
    }

    private void registrarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return """
                Conta: %d
                Agencia: %d
                Saldo: R$%.2f
                """
                .formatted(numeroConta, numeroAgencia, saldo);
    }
}