package com.example.aprendendo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.model.Usuario;
import com.example.aprendendo.repositorios.RepositorioUsuarios;

import org.w3c.dom.Text;

public class NovoUsuario extends AppCompatActivity {

    private EditText nome;
    private EditText sobrenome;
    private EditText endEletronico;
    private EditText senha;
    private EditText confirmacaoSenha;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
    }

    public void salvarUsuario(View view) {
        nome = (EditText) findViewById(R.id.etxtName);
        sobrenome = (EditText) findViewById(R.id.etxtLastName);
        endEletronico = (EditText) findViewById(R.id.etxtEmail);
        senha = (EditText) findViewById(R.id.etxtPassWord);
        confirmacaoSenha = (EditText) findViewById(R.id.etxtPassWordConfirmation);

        name = nome.getText().toString();
        lastName = sobrenome.getText().toString();
        email = endEletronico.getText().toString();
        password = senha.getText().toString();
        passwordConfirmation = confirmacaoSenha.getText().toString();

        if(name.isEmpty() && email.isEmpty() && password.isEmpty() && passwordConfirmation.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha todos os dados obrigatórios!", Toast.LENGTH_LONG).show();
        }
        else if(name!=null && email != null && password != null && passwordConfirmation != null && password.equals(passwordConfirmation)) {
            //Usuario usuario = new Usuario(1, nome.getText().toString(), sobrenome.getText().toString(), endEletronico.getText().toString(), senha.getText().toString());
            Toast.makeText(getApplicationContext(), "Usuário " + name + " cadastrado :)", Toast.LENGTH_LONG).show();
            //RepositorioUsuarios repositorio = RepositorioUsuarios.getDbUsuarios(this);
            //repositorio.addUsuario(usuario);
            finish();
        }
    }


    public void setUsuario(Usuario usuario) {
        nome.setText(usuario.getName());
        sobrenome.setText(usuario.getLastName());
        endEletronico.setText(usuario.getEmail());
        senha.setText(usuario.getPassword());
    }
}
