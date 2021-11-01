package com.example.pigrupo5backend.Repository;

import com.example.pigrupo5backend.Model.Endereco;
import com.example.pigrupo5backend.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    //consultar pelo cep
    public List<Endereco> findAllByCepContainingIgnoreCase(String cep);
        }
