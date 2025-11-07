package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ComprasActivity extends AppCompatActivity {

    EditText editItem;
    Button btnAdicionar, btnRemover;
    ListView listCompras;
    TextView txtTotal;
    ArrayList<String> listaItens;
    ArrayAdapter<String> adapter;
    int itemSelecionado = -1; // guarda o índice do item clicado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        editItem = findViewById(R.id.editItem);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnRemover = findViewById(R.id.btnRemover);
        listCompras = findViewById(R.id.listCompras);
        txtTotal = findViewById(R.id.txtTotal);

        listaItens = new ArrayList<>();

        // Usamos layout customizado (para poder mudar a cor do item selecionado)
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, listaItens);
        listCompras.setAdapter(adapter);
        listCompras.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // permite seleção de 1 item

        atualizarContador();

        // Adicionar item
        btnAdicionar.setOnClickListener(v -> {
            String item = editItem.getText().toString().trim();
            if (!item.isEmpty()) {
                listaItens.add(item);
                adapter.notifyDataSetChanged();
                editItem.setText("");
                atualizarContador();
            } else {
                Toast.makeText(this, "Digite um item!", Toast.LENGTH_SHORT).show();
            }
        });

        // Selecionar item da lista (muda visualmente)
        listCompras.setOnItemClickListener((adapterView, view, position, id) -> {
            itemSelecionado = position;
            listCompras.setItemChecked(position, true);
            Toast.makeText(this, "Selecionado: " + listaItens.get(position), Toast.LENGTH_SHORT).show();
        });

        // Remover item selecionado
        btnRemover.setOnClickListener(v -> {
            if (itemSelecionado != -1) {
                listaItens.remove(itemSelecionado);
                adapter.notifyDataSetChanged();
                listCompras.clearChoices(); // limpa seleção visual
                itemSelecionado = -1;
                atualizarContador();
            } else {
                Toast.makeText(this, "Selecione um item para remover", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Atualiza o texto com o número total de compras
    private void atualizarContador() {
        txtTotal.setText("Total de compras: " + listaItens.size());
    }
}

