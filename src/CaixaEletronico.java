import java.util.Scanner;

import model.Cliente;
import model.ContaCorrente;
import model.Transacao;
import resources.Tela;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("1 - Dados prontos | 2 - UI com interação");
            opcao = leitor.nextLine();
        } while (!opcao.matches("[1-2]"));

        if (opcao.equals("1")) {
            dadosProntos();
        } else {
            Tela t = new Tela();
            t.mostrarTela();
        }

        leitor.close();
    }

    private static void dadosProntos() {
        Cliente cli1 = new Cliente("Fernando", "123.345.567-00", "2826504-6",
                "Rua das flores, 1021. Cachoeirinha. Manaus/AM");

        ContaCorrente conta1 = new ContaCorrente(459863, 2105, cli1);

        conta1.depositar(500);

        conta1.sacar(200);

        System.out.println(conta1);

        System.out.println("-------------Extrato------------");
        System.out.println("================================");
        for (Transacao extrato : conta1.obterExtrato()) {
            System.out.println(extrato);
        }
        System.out.println("================================");
        System.out.println("Saldo atual: R$%.2f".formatted(conta1.getSaldo()));
    }
}
