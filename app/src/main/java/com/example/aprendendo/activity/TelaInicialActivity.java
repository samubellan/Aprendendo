package com.example.aprendendo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aprendendo.R;
import com.example.aprendendo.adapter.AdapterListas;
import com.example.aprendendo.model.Listas;
import com.example.aprendendo.utils.ListaDAO;
import com.example.aprendendo.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class TelaInicialActivity extends AppCompatActivity {

    //Criando variável para salvar find view by id do Button
    private Button novaLista;

    //Criando variável para salvar find view by id do RecyclerView
    private RecyclerView recyclerListas;

    //Criando variável para salvar find view by id do List
    private List<Listas> listagemDasListas = new ArrayList<>();
    private AdapterListas adapterListas;
    private Listas listaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Atribui a listagemTarefas o botão com o ID recyclerListas
        recyclerListas = findViewById(R.id.recyclerListaTarefas);

        recyclerListas.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerListas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Listas listaSelecionada = listagemDasListas.get(position);

                                Intent intent = new Intent(TelaInicialActivity.this, AdicionarListaActivity.class);
                                intent.putExtra("listaSelecionada", listaSelecionada);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                listaSelecionada = listagemDasListas.get(position);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(TelaInicialActivity.this);
                                dialog.setTitle("Confirmar exclusão?");
                                dialog.setMessage("Deseja excluir a tarefa: " + listaSelecionada.getTitulo() + " ?");
                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ListaDAO tarefaDAO = new ListaDAO(getApplicationContext());
                                        carregarLista();
                                        if ( tarefaDAO.deletar(listaSelecionada)){
                                            Toast.makeText(getApplicationContext(),"Sucesso ao excluir terefa!", Toast.LENGTH_SHORT).show();
                                            carregarLista();
                                        }else{
                                            Toast.makeText(getApplicationContext(),"Erro ao excluir terefa!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.setNegativeButton("Não", null);
                                //Exibir a dialog
                                dialog.create();
                                dialog.show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        })
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarListaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarLista(){
        ListaDAO listaDAO = new ListaDAO(getApplicationContext());
        listagemDasListas = listaDAO.listar();

        adapterListas = new AdapterListas(listagemDasListas);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerListas.setLayoutManager(layoutManager);
        recyclerListas.setHasFixedSize(true);
        recyclerListas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerListas.setAdapter(adapterListas);
    }

    @Override
    protected void onStart() {
        carregarLista();
        super.onStart();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

    /*public void criarListas(){
        Listas lista = new Listas("MERCADO");
        this.listagemDasListas.add(lista);

        lista = new Listas("TRABALHO");
        this.listagemDasListas.add(lista);

    lista = new Listas("COMPROMISSOS");
        this.listagemDasListas.add(lista);
    }

}*/

