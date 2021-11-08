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
    private String codigo;

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
    private float valorFrete;

    private String podeSerCozido;

    private String DeveSerCozido;

    private boolean folhasComestiveis;

    private boolean raizesComestiveis;

    private boolean frutosComestiveis;

    private boolean floresComestiveis;

    private boolean sementesComestiveis;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String isPodeSerCozido() {
        return podeSerCozido;
    }

    public void setPodeSerCozido(String podeSerCozido) {
        this.podeSerCozido = podeSerCozido;
    }

    public String isDeveSerCozido() {
        return DeveSerCozido;
    }

    public void setDeveSerCozido(String deveSerCozido) {
        DeveSerCozido = deveSerCozido;
    }

    public boolean isFolhasComestiveis() {
        return folhasComestiveis;
    }

    public void setFolhasComestiveis(boolean folhasComestiveis) {
        this.folhasComestiveis = folhasComestiveis;
    }

    public boolean isRaizesComestiveis() {
        return raizesComestiveis;
    }

    public void setRaizesComestiveis(boolean raizesComestiveis) {
        this.raizesComestiveis = raizesComestiveis;
    }

    public boolean isFrutosComestiveis() {
        return frutosComestiveis;
    }

    public void setFrutosComestiveis(boolean frutosComestiveis) {
        this.frutosComestiveis = frutosComestiveis;
    }

    public boolean isFloresComestiveis() {
        return floresComestiveis;
    }

    public void setFloresComestiveis(boolean floresComestiveis) {
        this.floresComestiveis = floresComestiveis;
    }

    public boolean isSementesComestiveis() {
        return sementesComestiveis;
    }

    public void setSementesComestiveis(boolean sementesComestiveis) {
        this.sementesComestiveis = sementesComestiveis;
    }
}



