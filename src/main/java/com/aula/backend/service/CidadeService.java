package com.aula.backend.service;
import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aula.backend.entity.Cidade;
import com.aula.backend.repository.CidadeRepository;



@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Cidade> buscarTodos(Pageable pageable){
        return cidadeRepository.findAll(pageable);
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).get();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;
        
    }

    public Cidade atualizar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);

    }

    public void excluir(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cidade não encontrada."));
        cidadeRepository.delete(cidade);

    }
    
}
