package com.fatec.todo.controller;

import com.fatec.todo.model.Tarefa;
import com.fatec.todo.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TarefaControllerTest {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaController tarefaController;

    @BeforeEach
    public void limparBanco() {
        tarefaRepository.deleteAll();
    }

    @Test
    public void deveCriarUmaTarefa() {

        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Estudar Spring Boot");
        tarefa.setDescricao("Estudar para o projeto");
        tarefa.setStatus("PENDENTE");
        tarefa.setObservacoes("Teste de integração");

        Tarefa resultado = tarefaController.criar(tarefa);

        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("Estudar Spring Boot", resultado.getNome());
        assertEquals("PENDENTE", resultado.getStatus());
    }
}