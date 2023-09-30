package com.aula.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.backend.entity.Marca;
import com.aula.backend.entity.Produto;
import com.aula.backend.service.MarcaService;



@RestController
@CrossOrigin
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public Page<Marca> listarTodos(Pageable pageable) {
        
        return marcaService.listarTodos(pageable);
    }

    @PostMapping
    public Marca inserir(@RequestBody Marca marca) {
        return marcaService.inserir(marca);

    }

    @PutMapping
    public Marca alterar(@RequestBody Marca marca) {
        return marcaService.alterar(marca);

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        marcaService.excluir(id);
    }
}
