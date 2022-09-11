package view;

import java.util.Scanner;

import controller.Actions;

public class Tela extends Actions {
    public Tela() {
        leitor = new Scanner(System.in);
        cliente = null;
        conta = null;
        terminado = false;
    }

    public void mostrarTela() {
        String opcao;
        cadastrarCliente();
        cadastrarConta();

        while (!terminado) {
            do {
                System.out.println("Bem vindo(a), %s. O que deseja fazer?".formatted(cliente.nome));
                System.out.println(conta);
                System.out.printf(menu);
                opcao = leitor.nextLine();
            } while (!opcao.matches("[1-4]"));

            switch (opcao) {
                case "1": // depositar
                    depositar();
                    break;
                case "2": // sacar
                    sacar();
                    break;
                case "3": // extrato
                    imprimeExtrato();
                    break;
                case "4":
                    leitor.close();
                    terminado = true;
                    break;
            }
        }
    }
}