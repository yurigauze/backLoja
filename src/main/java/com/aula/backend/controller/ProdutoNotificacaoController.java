package com.aula.backend.controller;

import org.springframework.messaging.handler.annotation.SendTo;

import com.aula.backend.entity.ProdutoNotificacao;

public class ProdutoNotificacaoController {
    
    @SendTo("/produto/novo-produto")
    private ProdutoNotificacao notificarProduto(ProdutoNotificacao notificacao){
        return notificacao;
    }
}   
