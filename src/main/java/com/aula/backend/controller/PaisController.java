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
import com.aula.backend.entity.Pais;
import com.aula.backend.service.PaisService;

@RestController
@RequestMapping("/pais")
@CrossOrigin
public class PaisController {

    @Autowired
    private PaisService paisService;
    
    @GetMapping
    public Page<Pais> buscarTodos(Pageable pageable) {
        return paisService.buscarTodos(pageable);
    }

    @GetMapping("/list")
    public List<Pais> buscarListaTodos() {
        return paisService.buscarListaTodos();
    }

    @PostMapping
    public Pais inserir(@RequestBody Pais pais) {
        return paisService.inserir(pais);

    }

    @PutMapping
    public Pais atualizar(@RequestBody Pais pais) {
        return paisService.atualizar(pais);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> excluirPais(@PathVariable Long id) {
        try {
            paisService.excluir(id);
            return ResponseEntity.ok("Pais excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(paisService.buscarPorId(id));
    }

}
