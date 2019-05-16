package com.example.aprendendo.model;

public class Usuario {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public Usuario(long id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.name = nome;
        this.lastName = sobrenome;
        this.email = email;
        this.password = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}