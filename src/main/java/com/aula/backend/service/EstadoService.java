package com.aula.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.backend.entity.Estado;
import com.aula.backend.repository.EstadoRepository;



@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Page<Estado> buscarTodos(Pageable pageable){
        return estadoRepository.findAll(pageable);
    }

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).get();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
        
    }

    public Estado atualizar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);

    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estado não encontrado."));
        estadoRepository.delete(estado);

    }
    
}
