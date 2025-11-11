package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SalarioActivity extends AppCompatActivity {
    EditText editNome, editBruto, editImposto, editPorcentagem;
    TextView textResultado;
    Button btnIniciar, btnAumentar;
    String nome;
    double salarioBruto, imposto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salario);

        editNome = findViewById(R.id.editNome);
        editBruto = findViewById(R.id.editBruto);
        editImposto = findViewById(R.id.editImposto);
        editPorcentagem = findViewById(R.id.editPorcentagem);
        textResultado = findViewById(R.id.textResultado);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnAumentar = findViewById(R.id.btnAumentar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = editNome.getText().toString();
                salarioBruto = Double.parseDouble(editBruto.getText().toString());
                imposto = Double.parseDouble(editImposto.getText().toString());

                double salarioLiquido = salarioBruto - imposto;

                textResultado.setText("Funcionário: " + nome + ", R$ " + String.format("%.2f", salarioLiquido));
            }
        });
        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome == null) {
                    Toast.makeText(SalarioActivity.this, "Insira os dados primeiro!", Toast.LENGTH_SHORT).show();
                    return;
                }
                double porcentagem = Double.parseDouble(editPorcentagem.getText().toString());
                salarioBruto += salarioBruto * (porcentagem / 100);

                double salarioLiquido = salarioBruto - imposto;

                textResultado.setText("Funcionário: " + nome +
                        "\nDados atualizados: " + nome + String.format(",R$ %.2f", salarioLiquido));
            }
        });
    }
}
