package com.example.pigrupo5backend.Controller;

import com.example.pigrupo5backend.Model.Produto;
import com.example.pigrupo5backend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) throws Exception{
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByTitutlo(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Produto>> getByTexto(@PathVariable String descricao) {
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Produto> post (@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
    }
