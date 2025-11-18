package com.example.myapplication;

public class FuncionarioActivity {
    private String nome;
    private Float salarioBase;
    public FuncionarioActivity(String name, Float salarioBase) {
        this.nome = nome;
    }
    public String GetNome() {
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


