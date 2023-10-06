package com.aula.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.backend.entity.Pais;
import com.aula.backend.repository.PaisRepository;



@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public Page<Pais> buscarTodos(Pageable pageable){
        return paisRepository.findAll(pageable);
    }

    public List<Pais> buscarListaTodos( ){
        return paisRepository.findAll();
    }

    public Pais buscarPorId(Long id) {
        return paisRepository.findById(id).get();
    }

    public Pais inserir(Pais Pais){
        Pais.setDataCriacao(new Date());
        Pais pais = paisRepository.saveAndFlush(Pais);
        return pais;
        
    }

    public Pais atualizar(Pais Pais){
        Pais.setDataAtualizacao(new Date());
        return paisRepository.saveAndFlush(Pais);

    }

    public void excluir(Long id) {
        Pais Pais = paisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pais não encontrado."));
        paisRepository.delete(Pais);

    }
    
}
