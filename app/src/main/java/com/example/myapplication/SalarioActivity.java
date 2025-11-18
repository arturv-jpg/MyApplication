package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SalarioActivity extends AppCompatActivity {

    EditText editNome, editSalarioBase, editBonus, editHoras;
    TextView textResultado, textBonus, textHoras;
    Spinner spinnerTipo;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salario);

        // Referências XML
        editNome = findViewById(R.id.editNome);
        editSalarioBase = findViewById(R.id.editSalarioBase);

        editBonus = findViewById(R.id.editBonus);
        editHoras = findViewById(R.id.editHoras);

        textBonus = findViewById(R.id.textBonus);
        textHoras = findViewById(R.id.textHoras);

        spinnerTipo = findViewById(R.id.spinnerTipo);
        textResultado = findViewById(R.id.textResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Configuração do Spinner
        String[] tipos = {"Gerente", "Desenvolvedor", "Estagiário"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipos);
        spinnerTipo.setAdapter(adapter);

        // Mostrar campos dependendo do tipo
        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Esconde tudo
                textBonus.setVisibility(View.GONE);
                editBonus.setVisibility(View.GONE);
                textHoras.setVisibility(View.GONE);
                editHoras.setVisibility(View.GONE);

                if (position == 0) { // Gerente
                    textBonus.setVisibility(View.VISIBLE);
                    editBonus.setVisibility(View.VISIBLE);
                }
                if (position == 1) { // Desenvolvedor
                    textHoras.setVisibility(View.VISIBLE);
                    editHoras.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Botão calcular
        btnCalcular.setOnClickListener(v -> calcularFuncionario());
    }

    private void calcularFuncionario() {

        try {
            String nome = editNome.getText().toString();
            float salarioBase = Float.parseFloat(editSalarioBase.getText().toString());

            FuncionarioActivity funcionario;
            int tipo = spinnerTipo.getSelectedItemPosition();

            if (tipo == 0) { // Gerente
                float bonus = Float.parseFloat(editBonus.getText().toString());
                funcionario = new Gerente(nome, salarioBase, bonus);

            } else if (tipo == 1) { // Desenvolvedor
                int horas = Integer.parseInt(editHoras.getText().toString());
                funcionario = new Desenvolvedor(nome, salarioBase, horas);

            } else { // Estagiário
                funcionario = new Estagiario(nome, salarioBase);
            }

            textResultado.setText(funcionario.toString());

        } catch (Exception e) {
            Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
