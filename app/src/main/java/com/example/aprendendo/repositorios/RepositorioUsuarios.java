package com.example.aprendendo.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprendendo.model.Usuario;
import com.example.aprendendo.utils.BdHelper;

import java.util.ArrayList;

public class RepositorioUsuarios {
    SQLiteDatabase dbUsuarios;
    static RepositorioUsuarios singleton;

    public static RepositorioUsuarios getDbUsuarios(Context context) {

        if (singleton == null) {
            singleton = new RepositorioUsuarios();
            singleton.dbUsuarios = new BdHelper(context).getWritableDatabase();
        }
        return singleton;
    }
    public void addUsuario(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("name", usuario.getName());
        values.put("lastName", usuario.getLastName());
        values.put("email", usuario.getEmail());
        values.put("password", usuario.getPassword());

        dbUsuarios.insertOrThrow("usuarios", null, values);

    }
    public ArrayList<Usuario> getUsuarios(){
        String[] projection = {
                "id",
                "name",
                "lastName",
                "email",
                "password"
        };
        Cursor cursor = dbUsuarios.query("usuarios", projection,null,
                null,null,null,null);
        ArrayList itens = new ArrayList<Usuario>();
        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(
                    cursor.getColumnIndexOrThrow("name"));
            String sobrenome = cursor.getString(
                    cursor.getColumnIndexOrThrow("lastName"));
            String email = cursor.getString(
                    cursor.getColumnIndexOrThrow("email"));
            String senha = cursor.getString(
                    cursor.getColumnIndexOrThrow("password"));

            Usuario usuario = new Usuario();
            itens.add(usuario);
        }
        cursor.close();
        return itens;
    }
}
