package com.example.aprendendo.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.model.Listas;
import com.example.aprendendo.utils.ListaDAO;

public class AdicionarListaActivity extends AppCompatActivity {

    private TextInputEditText editLista;
    private Listas listaAtual;

    @SuppressLint("WrongViewCast")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nova_lista);

        editLista = findViewById(R.id.textLista);

        //Recuperar tarefa, caso seja edição
        listaAtual = (Listas) getIntent().getSerializableExtra("listaSelecionada");

        //Configurar tarefa na caixa de texto
        if (listaAtual != null){
            editLista.setText(listaAtual.getTitulo());
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSalvar :
                //Salvar dados
                ListaDAO listaDAO = new ListaDAO(getApplicationContext());

                if (listaAtual != null) {//edição

                    String nomeLista = editLista.getText().toString();
                    if (!nomeLista.isEmpty()){

                        Listas listas = new Listas();
                        listas.setTitulo(nomeLista);
                        listas.setId(listaAtual.getId());

                        //Atualizar no banco de dados
                        if (listaDAO.atualizar(listas)){
                            Toast.makeText(getApplicationContext(),"Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{//salvar

                    String nomeLista = editLista.getText().toString();
                    if (!nomeLista.isEmpty()){
                        Listas listas = new Listas();
                        listas.setTitulo(nomeLista);
                        if (listaDAO.salvar(listas)){
                            finish();
                            Toast.makeText(getApplicationContext(),"Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"Erro ao salvar tarefa!", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}