package com.example.aprendendo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BdHelper extends SQLiteOpenHelper {

    //criando variáveis para futuramente, caso precise, fique mais fácil alterar nomenclatura de BD, VERSION e nome das tabelas.
    public static String BDNAME = "listaDeTarefas_Bd";
    public static int VERSION = 1;
    public static String TABELA_USUARIOS = "usuarios";
    public static String TABELA_LISTAS = "listas";

    public BdHelper(Context context) {
        super(context, BDNAME, null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //string que armazenará os códigos SQL para criação do bd
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS "+ TABELA_USUARIOS
                       + "(id integer primary key autoincrement," +
                        " name varchar(30), " +
                        " lastname varchar(50)," +
                        " email varchar(50)," +
                        " password varchar(30))";

        //string que armazenará os códigos SQL para criação do bd
        String sqlListas = "CREATE TABLE IF NOT EXISTS "+ TABELA_LISTAS
                       + "(id integer primary key autoincrement," +
                        " title varchar(30), " +
                        " color varchar(50)," +
                        " note varchar(100)," +
                        " stateNote int(1))";

        try{
            //executando os códigos SQL armazenados na String acima
            sqLiteDatabase.execSQL(sqlUsuarios);
            Log.i("INFO DB", "Sucesso ao criar a tabela USUARIOS. ");
            sqLiteDatabase.execSQL(sqlListas);
            Log.i("INFO DB", "Sucesso ao criar a tabela LISTAS. ");

        }
        catch (Exception e){
            Log.i("INFO DB", "Erro ao criar tabela. " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAtual, int novaVersao) {
        //após atualização, sistema realiza estes códigos
        String sqlUsuarios = "DROP TABLE IF EXISTS "+TABELA_USUARIOS+" ;";
        String sqlListas = "DROP TABLE IF EXISTS "+TABELA_LISTAS+" ;";

            try{
                sqLiteDatabase.execSQL(sqlUsuarios);
                sqLiteDatabase.execSQL(sqlListas);
                onCreate(sqLiteDatabase);
                Log.i("INFO DB", "Sucesso ao atualizar APP :)");
            }
            catch (Exception e){
                Log.i("INFO DB", "Erro ao atualizar APP :(" + e.getMessage());
            }
        }
}

