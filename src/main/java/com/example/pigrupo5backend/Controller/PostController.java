package com.example.pigrupo5backend.Controller;

import com.example.pigrupo5backend.Model.Post;
import com.example.pigrupo5backend.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private final PostRepository repository;

    public PostController(PostRepository repository) throws Exception{
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Post>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity<List<Post>> getByTexto(@PathVariable String texto) {
        return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }

    @PostMapping
    public ResponseEntity<Post> post(@RequestBody Post postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Post> put(@RequestBody Post postagem) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
