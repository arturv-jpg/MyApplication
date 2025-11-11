package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AplicativoActivity extends AppCompatActivity {

    EditText editNome, editPreco, editQuantidade, editEntrada, editSaida;
    TextView textResultado;
    Button btnCadastrar, btnAdicionar, btnRemover;

    ProdutoActivity produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estoque);

        editNome = findViewById(R.id.editNome);
        editPreco = findViewById(R.id.editPreco);
        editQuantidade = findViewById(R.id.editQuantidade);
        editEntrada = findViewById(R.id.editEntrada);
        editSaida = findViewById(R.id.editSaida);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnRemover = findViewById(R.id.btnRemover);
        textResultado = findViewById(R.id.textResultado);

        // 🔹 Cadastrar o produto
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                float preco = Float.parseFloat(editPreco.getText().toString());
                int quantidade = Integer.parseInt(editQuantidade.getText().toString());

                produto = new ProdutoActivity(nome, preco, quantidade);
                textResultado.setText(produto.toString());
            }
        });

        // 🔹 Adicionar ao estoque
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (produto == null) {
                    Toast.makeText(AplicativoActivity.this, "Cadastre um produto primeiro!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int entrada = Integer.parseInt(editEntrada.getText().toString());
                produto.quantidaProduto(entrada);
                textResultado.setText(produto.toString());
            }
        });

        // 🔹 Remover do estoque
        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (produto == null) {
                    Toast.makeText(AplicativoActivity.this, "Cadastre um produto primeiro!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int saida = Integer.parseInt(editSaida.getText().toString());
                produto.removerProduto(saida);
                textResultado.setText(produto.toString());
            }
        });
    }
}

