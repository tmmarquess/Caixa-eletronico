import model.Cliente;
import model.ContaCorrente;

public class CaixaEletronico {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente("Fernando", "123.345.567-00", "2826504-6", "Rua das flores, 1021. Cachoeirinha. Manaus/AM");

        ContaCorrente conta1 = new ContaCorrente(459863, 2105, cli1);

        conta1.depositar(500);

        conta1.sacar(200);

        System.out.println(conta1);

        conta1.imprimeExtrato();
    }
}
