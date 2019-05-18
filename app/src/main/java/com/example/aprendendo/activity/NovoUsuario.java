package com.example.aprendendo.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.model.Usuario;
import com.example.aprendendo.utils.UsuarioDAO;

import org.w3c.dom.Text;

public class NovoUsuario extends AppCompatActivity {

    //criando variáveis para coletar os dados digitados na activity
    private EditText nome;
    private EditText sobrenome;
    private EditText endEletronico;
    private EditText senha;
    private EditText confirmacaoSenha;

    //criando variáveis para salvar os dados digitados na activity após conversão (.toString)
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;

    //criando variáveis para alteração de cor do texto, para itens obrigatórios
    private TextView colorName;
    private TextView colorEmail;
    private TextView colorPassword;
    private TextView colorPasswordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
    }

    //classe utilizada no onClick, configurado no botão "CADASTRAR"
    public void salvarUsuario(View view) {
        //buscando os EditText pelo findViewById
        nome = (EditText) findViewById(R.id.etxtName);
        sobrenome = (EditText) findViewById(R.id.etxtLastName);
        endEletronico = (EditText) findViewById(R.id.etxtEmail);
        senha = (EditText) findViewById(R.id.etxtPassWord);
        confirmacaoSenha = (EditText) findViewById(R.id.etxtPassWordConfirmation);

        //buscando os TextView pelo findViewById
        colorName = (TextView) findViewById(R.id.textViewName);
        colorEmail = (TextView) findViewById(R.id.textViewEmail);
        colorPassword = (TextView) findViewById(R.id.textViewPassword);
        colorPasswordConfirmation = (TextView) findViewById(R.id.textViewPasswordConfirmation);

        //converter os dados digitados na Activity em String
        name = nome.getText().toString();
        lastName = sobrenome.getText().toString();
        email = endEletronico.getText().toString();
        password = senha.getText().toString();
        passwordConfirmation = confirmacaoSenha.getText().toString();

        //inicio do IF e ELSE de verificação dos dados
        //verificando se os dados obrigatórios foram preenchidos
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha todos os dados obrigatórios!", Toast.LENGTH_SHORT).show();
            if(name.isEmpty()) {
                colorName.setTextColor(Color.RED);
                if (email.isEmpty()) {
                    colorEmail.setTextColor(Color.RED);
                    if (password.isEmpty()) {
                        colorPassword.setTextColor(Color.RED);
                        if (passwordConfirmation.isEmpty()) {
                            colorPasswordConfirmation.setTextColor(Color.RED);
                        }
                    }
                    else if (passwordConfirmation.isEmpty()) {
                        colorPasswordConfirmation.setTextColor(Color.RED);
                    }
                }
                else if(password.isEmpty()){
                    colorPassword.setTextColor(Color.RED);
                    if (passwordConfirmation.isEmpty()) {
                        colorPasswordConfirmation.setTextColor(Color.RED);
                    }
                }
                else if(passwordConfirmation.isEmpty()){
                    colorPasswordConfirmation.setTextColor(Color.RED);
                }
            }
            else if(email.isEmpty()) {
                colorEmail.setTextColor(Color.RED);
                if (password.isEmpty()) {
                    colorPassword.setTextColor(Color.RED);
                    if (passwordConfirmation.isEmpty()) {
                        colorPasswordConfirmation.setTextColor(Color.RED);
                    }
                }
                else if(passwordConfirmation.isEmpty()){
                    colorPasswordConfirmation.setTextColor(Color.RED);
                }
            }
            else if(password.isEmpty()) {
                colorPassword.setTextColor(Color.RED);
                if (passwordConfirmation.isEmpty()) {
                    colorPasswordConfirmation.setTextColor(Color.RED);
                }
            }
            else if(passwordConfirmation.isEmpty()) {
                colorPasswordConfirmation.setTextColor(Color.RED);
            }
        }

        //verificando se as senhas conhecidem e inserindo os dados no banco
        else if(password.equals(passwordConfirmation)){
            UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
            Usuario usuario = new Usuario();
            usuario.setName(name);
            usuario.setLastName(lastName);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuarioDAO.salvar(usuario);
            Toast.makeText(getApplicationContext(),"Usuário "+name+" cadastrado :)", Toast.LENGTH_SHORT).show();
            finish();
        }
        //mensagem informando que senhas não conhecidem
        else{
            Toast.makeText(getApplicationContext(), "As senhas não conhecidem :(", Toast.LENGTH_SHORT).show();
            colorPassword.setTextColor(Color.RED);
            colorPasswordConfirmation.setTextColor(Color.RED);
        }
    }

}