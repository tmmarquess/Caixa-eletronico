package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    public String operacao;
    public float valor;
    public float saldo;
    public String dataHora;

    public Transacao(float saldo, String operacao, float valor) {
        this.operacao = operacao;
        this.valor = valor;
        this.dataHora = getFormatedDateTime();
    }

    @Override
    public String toString() {
        if (operacao.equals("depósito")) {
            return "+ R$%.2f -> %s".formatted(valor, dataHora);
        } else {
            return "- R$%.2f -> %s".formatted(valor, dataHora);
        }
    }

    private String getFormatedDateTime() {
        LocalDateTime tempo = LocalDateTime.now();
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return tempo.format(formatter);
    }

}