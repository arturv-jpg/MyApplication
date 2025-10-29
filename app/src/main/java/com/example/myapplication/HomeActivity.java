package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView txtFrase;
    Button btnFrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        TextView txtFrase = findViewById(R.id.txtFrase);
        Button btnFrase = findViewById(R.id.btnFrase);
        ImageView img = findViewById(R.id.img);
         int [] imagens = {
                 R.drawable.img1,
                 R.drawable.img2,
                 R.drawable.img3,
                 R.drawable.img4,
                 R.drawable.img5,
                 R.drawable.img6,
         };

        String [] frases = {
                "Acredite em Você",
                "Nunca desista!",
                "Você é capaz",
                "Continue tentando!",
                "Você fera!",
                "Com grandes poderes ,vem grandes responsabilidades"
        };

        btnFrase.setOnClickListener( view -> {
            int numero = (int) (Math.random() * frases.length);
            txtFrase.setText(frases[numero]);
            img.setImageResource(imagens[numero]);
        });
    }
}