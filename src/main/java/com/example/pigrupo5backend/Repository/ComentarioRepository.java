package com.example.pigrupo5backend.Repository;

import com.example.pigrupo5backend.Model.Comentario;
import com.example.pigrupo5backend.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    public List<Comentario> findAllByTextoContainingIgnoreCase(String texto);
}
