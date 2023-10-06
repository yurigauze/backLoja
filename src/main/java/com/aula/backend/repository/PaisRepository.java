package com.aula.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.backend.entity.Pais;


public interface PaisRepository extends JpaRepository<Pais, Long>{
    
}
