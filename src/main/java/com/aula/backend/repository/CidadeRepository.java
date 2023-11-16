package com.aula.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.backend.entity.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
