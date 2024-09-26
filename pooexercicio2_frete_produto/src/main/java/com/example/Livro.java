package com.example;

public class Livro extends Produto implements Transportavel {

    @Override
    public double calcularFrete() {
        return 2.0;
    }

    @Override
    public double calcularPeso() {
        return 0.;
    }

}
