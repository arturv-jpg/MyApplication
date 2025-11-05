package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DogActivity extends AppCompatActivity {

    private ImageView imageDog;
    private Button btnLoadDog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog);

        imageDog = findViewById(R.id.imageDog);
        btnLoadDog = findViewById(R.id.btnLoadDog);

        // Define ação do botão
        btnLoadDog.setOnClickListener(v -> loadRandomDog());
    }

    private void loadRandomDog() {
        // Executa em thread separada (não pode usar rede na UI Thread)
        new Thread(() -> {
            try {
                // Requisição HTTP para a API
                URL url = new URL("https://dog.ceo/api/breeds/image/random");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                // Lê resposta JSON
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();
                conn.disconnect();

                // Extrai a URL da imagem do JSON
                JSONObject json = new JSONObject(jsonBuilder.toString());
                String imageUrl = json.getString("message");

                // Baixa a imagem
                URL imageRequest = new URL(imageUrl);
                HttpURLConnection imageConn = (HttpURLConnection) imageRequest.openConnection();
                imageConn.connect();
                InputStream inputStream = imageConn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                // Atualiza a imagem na UI
                runOnUiThread(() -> imageDog.setImageBitmap(bitmap));

                inputStream.close();
                imageConn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() ->
                        Toast.makeText(DogActivity.this, "Erro ao carregar imagem", Toast.LENGTH_SHORT).show()
                );
            }
        }).start();
    }
}



