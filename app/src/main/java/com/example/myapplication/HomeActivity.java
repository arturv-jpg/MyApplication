package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView txtFrase;
    Button btnFrase, btnVoltarMenu;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        txtFrase = findViewById(R.id.txtFrase);
        btnFrase = findViewById(R.id.btnFrase);
        btnVoltarMenu = findViewById(R.id.btnVoltarMenu);
        img = findViewById(R.id.img);

        int[] imagens = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
        };

        String[] frases = {
                "Acredite em você!",
                "Nunca desista!",
                "Você é capaz!",
                "Continue tentando!",
                "Você é fera!",
                "Com grandes poderes vêm grandes responsabilidades!"
        };

        btnFrase.setOnClickListener(view -> {
            int numero = (int) (Math.random() * frases.length);
            txtFrase.setText(frases[numero]);
            img.setImageResource(imagens[numero]);
        });

        btnVoltarMenu.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
            startActivity(intent);
            finish(); // opcional, remove a Home da pilha
        });
    }
}
