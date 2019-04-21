package com.example.aprendendo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aprendendo.R;

public class NovoUsuario extends AppCompatActivity {

    private Button cadastrarNovoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        cadastrarNovoUsuario = findViewById(R.id.buttonCadastrarUsuario);

        /*Finalizando (finish();) a activity, dentro deste setOnClickListner iremos
        inserir também as ações para inserir os parâmetros no banco de dados*/
        cadastrarNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
