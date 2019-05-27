package com.example.aprendendo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.utils.BdHelper;

public class NovoUsuario extends AppCompatActivity {

    EditText et_RegUsuario, et_Senha1, et_Senha2;
    Button buttonCadastrarUsuario;

    BdHelper bd;

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_novo_usuario);

    bd = new BdHelper(this);

    et_RegUsuario = findViewById(R.id.et_RegUsuario);
    et_Senha1 = findViewById(R.id.et_Senha1);
    et_Senha2 = findViewById(R.id.et_Senha2);

    buttonCadastrarUsuario = findViewById(R.id.buttonCadastrarUsuario);

    buttonCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String usuario = et_RegUsuario.getText().toString();
            String password1 = et_Senha1.getText().toString();
            String password2 = et_Senha2.getText().toString();

            if (usuario.equals("")) {
                Toast.makeText(NovoUsuario.this, "Usuario não iserido, tente novamente", Toast.LENGTH_SHORT).show();
            } else if (password1.equals("") || password2.equals("")) {
                Toast.makeText(NovoUsuario.this, "Deve preencher a senha, tente novamente", Toast.LENGTH_SHORT).show();
            } else if (!password1.equals(password2)){
                Toast.makeText(NovoUsuario.this, "As duas senhas não correspondem, tente novamente", Toast.LENGTH_SHORT).show();
            } else {
                //Tudo deu certo
                long res = (long) bd.CriarUsuario(usuario, password1);
                if(res>0){
                    Toast.makeText(NovoUsuario.this, "Registro feito com SUCESSO!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NovoUsuario.this, MainActivity.class);
                    finish();
                }else{
                    Toast.makeText(NovoUsuario.this, "Registro inválido, tente novamente", Toast.LENGTH_SHORT).show();

                }

            }
        }
    });
    }
}