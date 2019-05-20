package com.example.aprendendo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.utils.BdHelper;

public class MainActivity extends AppCompatActivity {

    //cria a classe Button com o nome Entrar e NovoUsuario
    Button buttonEntrar, buttonUsuario;
    EditText et_usuario, et_senha;

    BdHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = new BdHelper(this);

        et_usuario = findViewById(R.id.et_usuario);
        et_senha = findViewById(R.id.et_senha);

        buttonEntrar = findViewById(R.id.buttonEntrar);
        buttonUsuario = findViewById(R.id.buttonUsuario);


        //Adiciona um evento de clique ao botão Entrar
        buttonEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_usuario.getText().toString();
                String password = et_senha.getText().toString();

                if(username.equals("")){
                    Toast.makeText(MainActivity.this, "Usuário não inserido, tente novamente!", Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(MainActivity.this, "Senha não inserida, tente novamente!", Toast.LENGTH_SHORT).show();
                }else {
                    String res = bd.ValidarLogin(username, password);

                    if(res.equals("OK")){
                        Toast.makeText(MainActivity.this, "Login realizado!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Login errado, tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Adiciona um evento de clique ao botão NovoUsuario
        buttonUsuario.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //Instancia uma intent para utilizar o startActivity, primeiro parametro é o getApplicationContext,
                // e o segundo é a activity que será aberta + ".class"
                Intent intent = new Intent(MainActivity.this, NovoUsuario.class);
                startActivity(intent);
            }
        });





    }
}
