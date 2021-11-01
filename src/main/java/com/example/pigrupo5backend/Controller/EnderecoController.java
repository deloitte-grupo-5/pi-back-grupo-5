package com.example.pigrupo5backend.Controller;

import com.example.pigrupo5backend.Model.Endereco;
import com.example.pigrupo5backend.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin("*")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoController(EnderecoRepository repository) throws Exception{
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/endereco/{cep}")
    public ResponseEntity<List<Endereco>> getByCep(@PathVariable String cep) {
        return ResponseEntity.ok(repository.findAllByCepContainingIgnoreCase(cep));
    }

    @PostMapping  //vamos usar esta annotation para identificar que usaremos o verbo post
    public ResponseEntity<Endereco> post (@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
    }

    @PutMapping
    public ResponseEntity<Endereco> put(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(endereco));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
