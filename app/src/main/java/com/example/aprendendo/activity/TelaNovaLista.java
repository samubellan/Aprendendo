/*package com.example.aprendendo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aprendendo.R;

public class TelaNovaLista extends AppCompatActivity {

    private Button cadastrarNovaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nova_lista);

        cadastrarNovaLista = findViewById(R.id.buttonCriarLista);

        /*Finalizando (finish();) a activity, dentro deste setOnClickListner iremos
        inserir também as ações para inserir os parâmetros no banco de dados
        cadastrarNovaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
*/