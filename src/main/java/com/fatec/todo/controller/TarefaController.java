package com.fatec.todo.controller;

import com.fatec.todo.model.Tarefa;
import com.fatec.todo.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // Criar uma tarefa
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    // Listar todas as tarefas
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }

    // Buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Alterar uma tarefa
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> alterar(
            @PathVariable Long id,
            @RequestBody Tarefa tarefa) {

        return tarefaService.alterar(id, tarefa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (tarefaService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}