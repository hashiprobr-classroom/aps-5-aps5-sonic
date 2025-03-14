package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class AgendaTest {

    Agenda agenda = new Agenda();

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
    }

    @Test
    void constroi() {
        assertEquals(0, agenda.getEventos().size());
    }

    @Test
    void adicionaValido() {
        Data dataInicio = new Data();
        dataInicio.atualiza(2003, 11, 23);
        Data dataFim = new Data();
        dataFim.atualiza(2025, 3, 14);

        Tempo tempoInicio = new Tempo();
        Tempo tempoFim = new Tempo();
        tempoFim.atualiza(8, 41);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(inicio, fim);

        agenda.adiciona(evento);
        assertEquals(1, agenda.getEventos().size());
    }

    @Test
    void adicionaInvalido() {
        Data dataInicio = new Data();
        dataInicio.atualiza(2003, 11, 23);
        Data dataFim = new Data();
        dataFim.atualiza(2025, 3, 14);

        Tempo tempoInicio = new Tempo();
        Tempo tempoFim = new Tempo();
        tempoFim.atualiza(8, 41);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(fim, inicio);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(evento);
        });

        assertEquals("Evento inválido!", e.getMessage());
    }

}
