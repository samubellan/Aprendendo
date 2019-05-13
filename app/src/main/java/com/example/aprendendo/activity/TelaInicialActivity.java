package com.example.aprendendo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.aprendendo.R;
import com.example.aprendendo.adapter.AdapterListas;
import com.example.aprendendo.model.Listas;

import java.util.ArrayList;
import java.util.List;

public class TelaInicialActivity extends AppCompatActivity {

    //Criando variável para salvar find view by id do Button
    private Button novaLista;
    //Criando variável para salvar find view by id do RecyclerView
    private RecyclerView recyclerListas;
    //Criando variável para salvar find view by id do List
    private List<Listas> listagemDasListas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //Atribui a novaLista o botão com o ID buttonCriarLista
        novaLista = findViewById(R.id.buttonCriarLista);
        //Atribui a listagemTarefas o botão com o ID recyclerListas
        recyclerListas = findViewById(R.id.recyclerListas);

        //Instancia uma intent para utilizar o startActivity, primeiro parametro é o getApplicationContext,
        // e o segundo é a activity que será aberta + ".class"
        novaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaNovaLista.class);
                startActivity(intent);
            }
        });

        //**INICIO DE CONFIGURAÇÃO DO RECYCLER VIEW**

        //Listagem de Listas
        this.criarListas();

        //Configurar Adapter
        AdapterListas adapter = new AdapterListas(listagemDasListas);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerListas.setLayoutManager(layoutManager);
        recyclerListas.setHasFixedSize(true);
        recyclerListas.setAdapter(adapter);

    }

    public void criarListas(){
        Listas lista = new Listas("MERCADO");
        this.listagemDasListas.add(lista);

        lista = new Listas("TRABALHO");
        this.listagemDasListas.add(lista);

    lista = new Listas("COMPROMISSOS");
        this.listagemDasListas.add(lista);
    }

}

