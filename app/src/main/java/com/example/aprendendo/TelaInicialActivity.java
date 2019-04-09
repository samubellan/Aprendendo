package com.example.aprendendo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TelaInicialActivity extends AppCompatActivity {

    private EditText campoTarefa;
    //private ListView listaTarefas;
    private ListView tarefas;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        campoTarefa = findViewById(R.id.etTarefaDigitada);
        //listaTarefas = findViewById(R.id.tvTarefa);
        tarefas = findViewById(R.id.listTarefas);

        //Criando um adapter para a lista
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
            );

        //Adicionando o adapter na lista
        tarefas.setAdapter(adaptador);
    }
    private String[] itens[10];
    //criando ação de botão para inserir uma nova tarefa
    public void adicionarItens(ListView listView){
        //String tarefa = campoTarefa.getText().toString();
        //listaTarefas.setText(tarefa);
        for (int cont=0; cont<=9 ; cont++){
            String tarefaDigitada = campoTarefa.getText().toString();
            itens[cont]=tarefaDigitada;
        }
    }
}
