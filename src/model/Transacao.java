package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao{
    public String operacao;
    public float valor;
    public float saldo;
    public LocalDateTime dataHora;


    public Transacao(float saldo, String operacao, float valor) {
        this.operacao = operacao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }


    @Override
    public String toString() {
        if(operacao.equals("depósito")){
            return "+ R$%.2f -> %s".formatted(valor, getFormatedDateTime());
        }else{
            return "- R$%.2f -> %s".formatted(valor, getFormatedDateTime());
        }
    }

    private String getFormatedDateTime(){
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return dataHora.format(formatter);
    }


}