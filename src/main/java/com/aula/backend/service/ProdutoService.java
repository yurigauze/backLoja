package com.aula.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.aula.backend.entity.Produto;
import com.aula.backend.entity.ProdutoNotificacao;
import com.aula.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public Page<Produto> listarTodos(Pageable pageable){
        return produtoRepository.findAll(pageable);
    }

    public Produto salvar(Produto produto){
        notificar(produto);
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto atualizar(Produto produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }

    private void notificar(Produto produto){
        ProdutoNotificacao notificacao = new ProdutoNotificacao();
        notificacao.setDescricao("O produto "+produto.getDescricao() + " foi cadastrado");
        simpMessagingTemplate.convertAndSend("/produto/novo-produto", notificacao);
    }
}
