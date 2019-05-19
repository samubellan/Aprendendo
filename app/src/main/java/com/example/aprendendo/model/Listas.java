package com.example.aprendendo.model;

import java.io.Serializable;

public class Listas implements Serializable {

    private String titulo;
    private Long id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
