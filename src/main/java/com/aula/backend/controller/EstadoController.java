package com.aula.backend.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aula.backend.entity.Estado;
import com.aula.backend.service.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;
    
    @GetMapping
    public Page<Estado> buscarTodos(Pageable pageable) {
        return estadoService.buscarTodos(pageable);
    }

    @PostMapping
    public Estado inserir(@RequestBody Estado estado) {
        return estadoService.inserir(estado);

    }

    @PutMapping
    public Estado atualizar(@RequestBody Estado estado) {
        return estadoService.atualizar(estado);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> excluirEstado(@PathVariable Long id) {
        try {
            estadoService.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

}
