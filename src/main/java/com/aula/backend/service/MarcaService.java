package com.aula.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.backend.entity.Marca;
import com.aula.backend.repository.MarcaRepository;



@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Page<Marca> listarTodos(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcaRepository.saveAndFlush(marca);
        return marcaNovo;

    }

    public Marca alterar(Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        Marca objeto = marcaRepository.findById(id).get();
        marcaRepository.delete(objeto);

    }

}
