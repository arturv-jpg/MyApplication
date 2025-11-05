package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cep);

        EditText txtCEP = findViewById(R.id.txtCEP);
        Button btnConsultaCEP = findViewById(R.id.btnConsultaCEP);
        TextView txtResultadoCEP = findViewById(R.id.txtResultadoCEP);

        btnConsultaCEP.setOnClickListener(v -> {

            String cep = txtCEP.getText().toString();

            if (!cep.isEmpty()) {
                buscarEndereco(cep, txtResultadoCEP);
            } else {
                txtResultadoCEP.setText("Digite um CEP válido.");

            }

        });
    }

    private void buscarEndereco(String cep, TextView txtResultadoCEP) {
        new Thread(() -> {
            try {
                String cepClean = cep.replace("-", "").trim(); // remove traço
                String url = "https://viacep.com.br/ws/" + cepClean + "/json/";

                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder resultado = new StringBuilder();
                String linha;

                while ((linha = reader.readLine()) != null) {
                    resultado.append(linha);
                }

                reader.close();

                JSONObject jsonObject = new JSONObject(resultado.toString());

                if (jsonObject.has("erro")) {
                    runOnUiThread(() -> txtResultadoCEP.setText("CEP não encontrado."));
                    return;
                }

                String logradouro = jsonObject.optString("logradouro", "");
                String bairro = jsonObject.optString("bairro", "");
                String localidade = jsonObject.optString("localidade", "");
                String uf = jsonObject.optString("uf", "");

                String endereco = logradouro + ", " + bairro + "\n" + localidade + " - " + uf;

                runOnUiThread(() -> txtResultadoCEP.setText(endereco));

            } catch (Exception e) {
                runOnUiThread(() -> txtResultadoCEP.setText("Erro ao buscar endereço."));
                e.printStackTrace();
            }
        }).start();
    }
}


