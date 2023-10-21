package com.aula.backend.controller;

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

import com.aula.backend.entity.Produto;
import com.aula.backend.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> listarTodos(Pageable pageable) {
        return produtoService.listarTodos(pageable);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping
    public Produto atualizar(@RequestBody Produto produto) {
        return produtoService.atualizar(produto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        produtoService.excluir(id);
    }
}
