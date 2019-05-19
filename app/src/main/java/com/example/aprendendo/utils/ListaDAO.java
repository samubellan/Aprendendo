package com.example.aprendendo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aprendendo.model.Listas;

import java.util.ArrayList;
import java.util.List;

public class ListaDAO implements IListaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ListaDAO(Context context) {
        BdHelper bd = new BdHelper(context);
        escreve = bd.getWritableDatabase();
        le = bd.getReadableDatabase();
    }

    @Override
    public boolean salvar(Listas listas) {
        ContentValues cv = new ContentValues();
        cv.put("title", listas.getTitulo());

        try {
            escreve.insert(BdHelper.TABELA_LISTAS, null, cv);
            Log.i("INFO", "Lista salva com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar lista" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Listas listas) {

        ContentValues cv = new ContentValues();
        cv.put("title", listas.getTitulo());

        try {
            String[] args = {listas.getId().toString()};
            escreve.update(BdHelper.TABELA_LISTAS, cv,"id=?", args );
            Log.i("INFO", "Lista salva com sucesso!");
        } catch (Exception e){
            Log.e("INFO", "Erro ao atualizar lista" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Listas listas) {
        try{
            String[] args = {listas.getId().toString()};
            escreve.delete(BdHelper.TABELA_LISTAS, "id=?", args);
            Log.i("INFO", "Lista removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover lista" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Listas> listar() {
        List<Listas> listas = new ArrayList<>();

        String sql = "SELECT * FROM " + BdHelper.TABELA_LISTAS+ " ;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){

            Listas lista = new Listas();

            Long id = c.getLong( c.getColumnIndex("id") );
            String nomeLista = c.getString( c.getColumnIndex("title") );

            lista.setId(id);
            lista.setTitulo(nomeLista);

            listas.add(lista);
        }

        return listas;

    }
}
