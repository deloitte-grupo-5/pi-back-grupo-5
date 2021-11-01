package com.example.pigrupo5backend.Controller;

import com.example.pigrupo5backend.Model.Comentario;

import com.example.pigrupo5backend.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/comentarios")
@CrossOrigin("*")
public class ComentarioController {
    @Autowired
    private ComentarioRepository repository;

    public ComentarioController(ComentarioRepository repository) throws Exception {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity<List<Comentario>> getByTexto(@PathVariable String texto) {
        return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }

    @PostMapping  //vamos usar esta annotation para identificar que usaremos o verbo post
    public ResponseEntity<Comentario> post (@RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
    }

    @PutMapping
    public ResponseEntity<Comentario> put(@RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(comentario));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
