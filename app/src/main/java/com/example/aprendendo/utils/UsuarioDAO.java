package com.example.aprendendo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aprendendo.activity.NovoUsuario;
import com.example.aprendendo.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

    private SQLiteDatabase escreve;

    public UsuarioDAO(Context context) {
        BdHelper db = new BdHelper(context);
        escreve = db.getWritableDatabase();
    }

    @Override
    public boolean salvar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("name", usuario.getName());
        cv.put("lastname", usuario.getLastName());
        cv.put("email", usuario.getEmail());
        cv.put("password", usuario.getPassword());

        try{
            escreve.insert(BdHelper.TABELA_USUARIOS, null, cv );
            Log.i("INFO", "Sucesso ao salvar usuário");
        }
        catch (Exception e){
            Log.e("INFO", "Erro ao salvar usuário"+e.getMessage());
            return false;
        }

        return true;
    }
}
