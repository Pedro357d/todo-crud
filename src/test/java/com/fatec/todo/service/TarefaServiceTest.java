package com.fatec.todo.service;

import com.fatec.todo.model.Tarefa;
import com.fatec.todo.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    public void deveCriarUmaTarefa() {

        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Fazer projeto");
        tarefa.setDescricao("Desenvolver o projeto de To-Do");
        tarefa.setStatus("PENDENTE");
        tarefa.setObservacoes("Projeto avaliativo");

        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        Tarefa resultado = tarefaService.criar(tarefa);

        assertEquals("Fazer projeto", resultado.getNome());
        assertEquals("PENDENTE", resultado.getStatus());
    }

    @Test
    public void deveListarTodasAsTarefas() {

        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Fazer projeto");
        tarefa.setStatus("PENDENTE");

        List<Tarefa> tarefas = List.of(tarefa);

        when(tarefaRepository.findAll()).thenReturn(tarefas);

        List<Tarefa> resultado = tarefaService.listarTodas();

        assertEquals(1, resultado.size());
        assertEquals("Fazer projeto", resultado.get(0).getNome());
    }
}