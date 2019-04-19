package com.example.aprendendo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.aprendendo.R;

public class TelaInicialActivity extends AppCompatActivity {

    //Criando variável para salvar find view by id
    private Button novaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //Atribui a novaLista o botão com o ID buttonCriarLista
        novaLista = findViewById(R.id.buttonCriarLista);

        //Instancia uma intent para utilizar o startActivity, primeiro parametro é o getApplicationContext,
        // e o segundo é a activity que será aberta + ".class"
        novaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaNovaLista.class);
                startActivity(intent);
            }
        });

    }

}

