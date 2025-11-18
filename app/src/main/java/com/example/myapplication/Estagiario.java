package com.example.myapplication;

public class Estagiario extends FuncionarioActivity {

    public Estagiario(String nome, float salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public float calcularSalario() {
        return salarioBase * 0.8f;
    }
}

