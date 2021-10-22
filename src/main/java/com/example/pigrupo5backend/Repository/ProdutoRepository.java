package com.example.pigrupo5backend.Repository;

import com.example.pigrupo5backend.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

    public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
}
