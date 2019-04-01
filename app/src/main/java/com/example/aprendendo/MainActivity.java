package com.example.aprendendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //cria a classe Button com o nome Entrar
    private Button Entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribui a Entrar o botão com o ID buttonEntrar
        Entrar = findViewById(R.id.buttonEntrar);

        //Adiciona um evento de clique ao botão Entrar
        Entrar.setOnClickListener(new OnClickListener() {

            public void onClick(View view){

                //Instancia uma intent para utilizar o startActivity, primeiro parametro é o getApplicationContext,
                // e o segundo é a activity que será aberta + ".class"
                Intent intent = new Intent(getApplicationContext(), TelaInicialActivity.class);
                startActivity(intent);
            }
    });


    }
}
