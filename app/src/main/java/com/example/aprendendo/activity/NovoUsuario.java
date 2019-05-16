package com.example.aprendendo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.model.Usuario;
import com.example.aprendendo.repositorios.RepositorioUsuarios;

public class NovoUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
    }

    public void cadastrarNovoUsuario(View view){
        EditText name = findViewById(R.id.etxtName);
        EditText lastName = findViewById(R.id.etxtLastName);
        EditText email = findViewById(R.id.etxtEmail);
        EditText password = findViewById(R.id.etxtPassWord);
        EditText passwordConfirmation = findViewById(R.id.etxtPassWordConfirmation);

        String nome = name.getText().toString();
        String sobrenome = lastName.getText().toString();
        String endEletronico = email.getText().toString();
        String senha = password.getText().toString();
        String confirmaSenha = passwordConfirmation.getText().toString();

        Usuario usuario = new Usuario( 1, nome , sobrenome, endEletronico, senha);
        Toast.makeText(getApplicationContext(), "Usuário cadastrado :)", Toast.LENGTH_SHORT).show();
        RepositorioUsuarios reposit = RepositorioUsuarios.getDbUsuarios(this);
        reposit.addUsuario(usuario);
        }
}
