package com.example.myapplication;

public class FuncionarioActivity {

    protected String nome;
    protected float salarioBase;

    public FuncionarioActivity(String nome, float salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float calcularSalario() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Funcionário: " + nome + " | Salário final: R$ " + calcularSalario();
    }
}
