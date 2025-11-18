package com.example.myapplication;

public class Desenvolvedor extends FuncionarioActivity {

    private int horasExtras;

    public Desenvolvedor(String nome, float salarioBase, int horasExtras) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
    }

    @Override
    public float calcularSalario() {
        return salarioBase + (horasExtras * 50);
    }
}

