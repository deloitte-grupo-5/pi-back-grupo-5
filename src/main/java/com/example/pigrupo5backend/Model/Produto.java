package com.example.pigrupo5backend.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=5, max=20)
    private Integer codigo;

    @NotNull
    @Size(max=100)
    private String nome;

    @NotNull
    @Size(max=1000)
    private String descricao;

    private String img;

    @NotNull
    private String nomeCientifico;

    @Size(max=200)
    private String outrosNomes;

    @NotNull
    private float valor;

    @NotNull
    private int quantidade_estoque;

    @NotNull
    private float peso;

    @NotNull
    private float altura;

    @NotNull
    private float comprimento;

    @NotNull
    private float largura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getOutrosNomes() {
        return outrosNomes;
    }

    public void setOutrosNomes(String outrosNomes) {
        this.outrosNomes = outrosNomes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
