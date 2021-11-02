package com.example.pigrupo5backend.Controller;


import com.example.pigrupo5backend.Model.Comentario;
import com.example.pigrupo5backend.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin("*")
public class ComentarioController {

    @Autowired
    private final ComentarioRepository repository;

    public ComentarioController(ComentarioRepository repository) throws Exception{
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {return ResponseEntity.ok(repository.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/comentario/{title}")
    public ResponseEntity<List<Comentario>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
    }

    @GetMapping("/comentario/{body}")
    public ResponseEntity<List<Comentario>> getByBody(@PathVariable String body) {
        return ResponseEntity.ok(repository.findAllByBodyContainingIgnoreCase(body));
    }

    @PostMapping
    public ResponseEntity<Comentario> post (@RequestBody Comentario comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comment));
    }

    @PutMapping
    public ResponseEntity<Comentario> put(@RequestBody Comentario comment) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(comment));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }

}



