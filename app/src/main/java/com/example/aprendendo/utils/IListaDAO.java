package com.example.aprendendo.utils;

import com.example.aprendendo.model.Listas;

import java.util.List;

public interface IListaDAO {

    public boolean salvar(Listas listas);
    public boolean atualizar (Listas listas);
    public boolean deletar (Listas listas);
    public List<Listas> listar();
}
