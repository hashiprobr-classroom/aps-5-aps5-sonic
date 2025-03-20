package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgendaTest {

    Agenda agenda;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
    }

    @Test
    void constroi() {
        List<Evento> lista = agenda.getEventos();
        assertTrue(lista.isEmpty());
    }

    @Test
    void adicionaValido() {
        Evento evento = mock(Evento.class);
        when(evento.valido()).thenReturn(true);

        agenda.adiciona(evento);

        assertEquals(1, agenda.getEventos().size());
    }

    @Test
    void adicionaInvalido() {
        Evento evento = mock(Evento.class);
        when(evento.valido()).thenReturn(false);

         IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(evento);
        });

         assertEquals("Evento inválido", e.getMessage());
    }
}
