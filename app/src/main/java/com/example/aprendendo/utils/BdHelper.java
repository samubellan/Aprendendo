package com.example.aprendendo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper {

    final static String bdName = "contatos_Bd";
    final static int versaoBd = 2;

    public BdHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, bdName, factory, versaoBd);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table contatos (id integer primary key autoincrement," +
                " nome varchar(100), email varchar(50), telefone varchar(30)," +
                " endereco varchar(200));" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAtual, int novaVersao) {
        if (versaoAtual == 1){
            sqLiteDatabase.execSQL("create table usuarios (id integer primary key autoincrement," +
                    "name varchar(30), lastname varchar(50), email varchar(50), password varchar(30));");
        }
    }
}
