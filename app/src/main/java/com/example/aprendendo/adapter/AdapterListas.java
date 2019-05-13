package com.example.aprendendo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aprendendo.R;
import com.example.aprendendo.model.Listas;

import java.util.List;

public class AdapterListas extends RecyclerView.Adapter<AdapterListas.MyViewHolder> {

    private List<Listas> listaDeListas;

    public AdapterListas(List<Listas> lista) {
        this.listaDeListas = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemListagem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);
        return new MyViewHolder(itemListagem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Listas lista = listaDeListas.get(i);
        myViewHolder.tituloLista.setText(lista.getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaDeListas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tituloLista;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloLista = itemView.findViewById(R.id.textTitle);
        }
    }

}
