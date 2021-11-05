package com.example.pigrupo5backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_postagem")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("post")
    private Usuario user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("post")
    private List<Comentario> comentarios;

    @NotNull
    @Size(min = 2, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 2, max = 1000)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP) //para informar que estamos trabalhando com tempo
    private Date data = new java.sql.Date(System.currentTimeMillis());

    private float preparo;

    private float porcao;

    private float curtidas;

    @Size(max=5000)
    private String img;

    private ArrayList<String> ingredientes;

    @Size(max = 500)
    private String referencias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getPreparo() {
        return preparo;
    }

    public void setPreparo(float preparo) {
        this.preparo = preparo;
    }

    public float getPorcao() {
        return porcao;
    }

    public void setPorcao(float porcao) {
        this.porcao = porcao;
    }

    public float getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(float curtidas) {
        this.curtidas = curtidas;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
}
