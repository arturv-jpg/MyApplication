package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperaturaActivity extends AppCompatActivity {

    private EditText txtValor;
    private Spinner spDe, spPara;
    private Button btnConverter, btnVoltar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperatura);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Conversor de Temperatura");
        }

        // 🔹 Inicialização dos componentes
        txtValor = findViewById(R.id.txtValor);
        spDe = findViewById(R.id.spDe);
        spPara = findViewById(R.id.spPara);
        btnConverter = findViewById(R.id.btnConverter);
        btnVoltar = findViewById(R.id.btnVoltar);
        txtResultado = findViewById(R.id.txtResultado);

        // 🔹 Opções de unidades de temperatura
        String[] unidades = {"Celsius", "Fahrenheit", "Kelvin"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, unidades
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spDe.setAdapter(adapter);
        spPara.setAdapter(adapter);

        // 🔹 Botão Converter
        btnConverter.setOnClickListener(v -> {
            String valorStr = txtValor.getText().toString().trim();

            if (valorStr.isEmpty()) {
                Toast.makeText(this, "Digite um valor de temperatura!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                String de = spDe.getSelectedItem().toString();
                String para = spPara.getSelectedItem().toString();

                double resultado = converterTemperatura(valor, de, para);

                txtResultado.setText(String.format("%.2f %s = %.2f %s", valor, de, resultado, para));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite um número válido!", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔹 Botão Voltar
        btnVoltar.setOnClickListener(v -> finish());
    }

    // 🔹 Método que faz a conversão entre as unidades
    private double converterTemperatura(double valor, String de, String para) {
        double resultado = valor;

        // Converte tudo para Celsius primeiro
        if (de.equals("Fahrenheit")) {
            resultado = (valor - 32) / 1.8;
        } else if (de.equals("Kelvin")) {
            resultado = valor - 273.15;
        }

        // Depois converte de Celsius para a unidade desejada
        if (para.equals("Fahrenheit")) {
            resultado = resultado * 1.8 + 32;
        } else if (para.equals("Kelvin")) {
            resultado = resultado + 273.15;
        }

        return resultado;
    }

    // 🔹 Faz o botão da ActionBar voltar também
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}


