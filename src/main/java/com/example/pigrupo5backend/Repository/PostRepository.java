package com.example.pigrupo5backend.Repository;

import com.example.pigrupo5backend.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    //consultar pelo titulo
    public List<Post> findAllByTituloContainingIgnoreCase(String titulo);

    //consultar por texto
    public List<Post> findAllByTextoContainingIgnoreCase(String texto);
}
