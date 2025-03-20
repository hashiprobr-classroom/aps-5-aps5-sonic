package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia{

    private int ano = 1970;
    private int mes = 1;
    private int dia = 1;
    private Map<Integer, Integer> limites;

    public Data() {
        this.limites = new HashMap<>();
        this.limites.put(1, 31);
        this.limites.put(2, 28);
        this.limites.put(3, 31);
        this.limites.put(4, 30);
        this.limites.put(5, 31);
        this.limites.put(6, 30);
        this.limites.put(7, 31);
        this.limites.put(8, 31);
        this.limites.put(9, 30);
        this.limites.put(10, 31);
        this.limites.put(11, 30);
        this.limites.put(12, 31);
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

    public void atualiza(int dia, int mes, int ano) {
        if (ano < 1970) {
            ano = 1970;
        }

        if (mes < 1) {
            mes = 1;
        } else if (mes > 12) {
            mes = 12;
        }

        if (dia < 1 ) {
            dia = 1;
        } else if (dia > limites.get(mes)) {
            dia = limites.get(mes);
        }

        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public int comoInteiro() {
        int nDias = 0;

        nDias += (this.ano - 1970) *365;

        for (int mes = 1; mes <= (this.mes - 1); mes++) {
            nDias += limites.get(mes);
        }

        nDias += this.dia - 1;

        return nDias;
    }

}
