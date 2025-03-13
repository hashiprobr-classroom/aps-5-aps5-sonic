package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia {
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer, Integer> limites;

    public Data() {
        super();
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        this.limites = new HashMap<>();

        limites.put(1, 31);
        limites.put(2, 28);
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void atualiza(int ano, int mes, int dia) {

        if (ano < 1970) {
            setAno(1970);
        } else {
            setAno(ano);
        }

        if (mes < 1) {
            setMes(1);
        } else if (mes > 12) {
            setMes(12);
        } else {
            setMes(mes);
        }

        if (dia < 1) {
            setDia(1);
        } else if (dia > limites.get(mes)){
            setDia(limites.get(mes));
        } else {
            setDia(dia);
        }
    }

    @Override
    public int comoInteiro() {
        int diasPassados = 0;

        int anos = ano - 1970; // Números de anos que passaram

        for (int i = 1; i < mes; i++) {
            diasPassados += limites.get(i);
        }

        diasPassados += dia - 1;

        return diasPassados;
    }
}
