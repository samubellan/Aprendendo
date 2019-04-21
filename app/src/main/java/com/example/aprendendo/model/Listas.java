package com.example.aprendendo.model;

public class Listas {

    private String titulo;
    private String primeiroItem;

    public Listas(String titulo, String primeiroItem) {
        this.titulo = titulo;
        this.primeiroItem = primeiroItem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrimeiroItem() {
        return primeiroItem;
    }

    public void setPrimeiroItem(String primeiroItem) {
        this.primeiroItem = primeiroItem;
    }
}
