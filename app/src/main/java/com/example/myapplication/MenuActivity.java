package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnHome = findViewById(R.id.btnMotivacional);
        Button btnConversor = findViewById(R.id.btnConversor);
        Button btnTemperatura = findViewById(R.id.btnTemperatura);
        Button btnCep = findViewById(R.id.btnCep);
        Button btnDog = findViewById(R.id.btnDog);
        Button btncompras = findViewById(R.id.btncompras);
        Button btncamera = findViewById(R.id.btncamera);
        Button btnSalario = findViewById(R.id.btnSalario);
        Button btnAplicativo = findViewById(R.id.btnAplicativo);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ConversorActivity.class);
                startActivity(intent);
            }
        });
        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TemperaturaActivity.class);
                startActivity(intent);
            }
        });
        btnCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CepActivity.class);
                startActivity(intent);
            }
        });
        btnDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, DogActivity.class);
                startActivity(intent);
            }
        });
        btncompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ComprasActivity.class);
                startActivity(intent);
            }
        });
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
        btnSalario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SalarioActivity.class);
                startActivity(intent);
            }
        });
        btnAplicativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AplicativoActivity.class);
                startActivity(intent);
            }
        });
    }
}



