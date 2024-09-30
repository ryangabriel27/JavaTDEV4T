package com.example;

public class Livro extends Produto implements Transportavel {

    private double volume;

    public Livro(String nome, double preco, double volume) {
        super(nome, preco, volume);
    }

    @Override
    public double calcularFrete() {
        return 2.0;
    }

    @Override
    public double calcularPeso() {
        return 0.5;
    }

}
