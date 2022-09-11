package controller;

import java.util.Scanner;

import model.Cliente;
import model.ContaCorrente;
import model.Transacao;

public class Actions {
    public Cliente cliente;
    public ContaCorrente conta;
    public Scanner leitor;
    public boolean terminado;
    public String menu = "1 - Depositar\t\tSacar - 2\n3 - Extrato\t\t Sair - 4\n";

    public void cadastrarConta() {
        System.out.println("---------Cadastrando Conta--------");
        int numeroConta, numeroAgencia;

        System.out.println("Digite o numero da conta:");
        numeroConta = leitor.nextInt();

        System.out.println("Digite o numero da Agencia:");
        numeroAgencia = leitor.nextInt();

        conta = new ContaCorrente(numeroConta, numeroAgencia, cliente);
        leitor.nextLine(); // limpando o buffer
    }

    public void cadastrarCliente() {
        System.out.println("---------Cadastrando Cliente--------");
        String nome, cpf, rg, endereco;

        System.out.println("Digite seu nome:");
        nome = leitor.nextLine();

        System.out.println("Digite seu CPF:");
        cpf = leitor.nextLine();

        System.out.println("Digite seu RG:");
        rg = leitor.nextLine();

        System.out.println("Digite seu endereço:");
        endereco = leitor.nextLine();

        cliente = new Cliente(nome, cpf, rg, endereco);
    }

    public void depositar() {
        float valor;
        System.out.println("Digite o valor a se depositar:");
        valor = leitor.nextFloat();
        leitor.nextLine(); // limpando o buffer

        conta.depositar(valor);
        System.out.println("\nValor depositado com sucesso!\n");
    }

    public void sacar() {
        float valor;
        System.out.println("Digite o valor a se sacar:");
        valor = leitor.nextFloat();
        leitor.nextLine(); // limpando o buffer

        boolean saqueRealizado = conta.sacar(valor);

        if (saqueRealizado) {
            System.out.println("\nSaque realizado com sucesso!\n");
        } else {
            System.out.println("\nSaldo Insuficiente!\n");
        }
    }

    public void imprimeExtrato() {
        System.out.println("-------------Extrato------------");
        System.out.println("================================");
        for (Transacao extrato : conta.obterExtrato()) {
            System.out.println(extrato);
        }
        System.out.println("================================");
        System.out.println("Saldo atual: R$%.2f".formatted(conta.getSaldo()));
    }
}
