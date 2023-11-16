package com.aula.backend.controller;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aula.backend.entity.Cidade;
import com.aula.backend.service.CidadeService;

@RestController
@RequestMapping("/cidades")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping
    public Page<Cidade> buscarTodos(Pageable pageable) {
        return cidadeService.buscarTodos(pageable);
    }

    @PostMapping
    public Cidade inserir(@RequestBody Cidade cidade) {
        System.out.println("Dados recebidos no backend: " + cidade);
        return cidadeService.inserir(cidade);

    }

    @PutMapping
    public Cidade atualizar(@RequestBody Cidade cidade) {
        return cidadeService.atualizar(cidade);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> excluirCidade(@PathVariable Long id) {
        try {
            cidadeService.excluir(id);
            return ResponseEntity.ok("Cidade excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

}
