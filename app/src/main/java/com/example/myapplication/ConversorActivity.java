package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConversorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);

        // Taxas de conversão (exemplo aproximado)
        final double taxaDolar = 5.00; // 1 USD = 5,00 BRL
        final double taxaEuro = 5.50;  // 1 EUR = 5,50 BRL

        // Referências para os elementos do layout
        EditText txtValor = findViewById(R.id.txtValor);
        Spinner spMoeda = findViewById(R.id.spMoeda);
        Button btnConversor = findViewById(R.id.btnConversor);
        TextView txtResultado = findViewById(R.id.txtResultado);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ConversorActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        });

        // Opções de moedas
        String[] moedas = {"Dólar", "Euro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                moedas
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMoeda.setAdapter(adapter);

        // Ação do botão Converter
        btnConversor.setOnClickListener(v -> {
            String valorStr = txtValor.getText().toString();

            if (valorStr.isEmpty()) {
                Toast.makeText(this, "Digite um valor em reais!", Toast.LENGTH_SHORT).show();
                return;
            }

            double valorReais = Double.parseDouble(valorStr);
            String moedaSelecionada = spMoeda.getSelectedItem().toString();
            double resultado = 0.0;

            // Converte de Real → Moeda selecionada
            if (moedaSelecionada.equals("Dólar")) {
                resultado = valorReais / taxaDolar;
            } else if (moedaSelecionada.equals("Euro")) {
                resultado = valorReais / taxaEuro;
            }

            txtResultado.setText(String.format("Valor em %s: %.2f", moedaSelecionada, resultado));
        });
    }
}


