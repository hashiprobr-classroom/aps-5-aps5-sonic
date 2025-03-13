package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia {

    private Data data;
    private Tempo tempo;

    public DataTempo(Data data, Tempo tempo) {
        this.data = data;
        this.tempo = tempo;
    }

    public Data getData() {
        return data;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public int comoInteiro() {
        int tempoTotal = 0;

        tempoTotal += (tempo.comoInteiro()
                + data.comoInteiro()*1440);

        return tempoTotal;
    }
}
