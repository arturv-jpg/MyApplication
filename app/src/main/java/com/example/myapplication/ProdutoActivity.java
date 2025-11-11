package com.example.myapplication;
public class ProdutoActivity {

    private String nome;
    private float preco;
    private int quantidade;

    public ProdutoActivity(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public float valorTotalStock() {
        return preco * quantidade;
    }

    public void quantidaProduto(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerProduto(int quantidade) {
        this.quantidade -= quantidade;
        if (this.quantidade < 0) this.quantidade = 0; // Evita negativo
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                "\nPreço: R$ " + String.format("%.2f", preco) +
                "\nQuantidade em estoque: " + quantidade +
                "\nValor total em estoque: R$ " + String.format("%.2f", valorTotalStock());
    }
}

