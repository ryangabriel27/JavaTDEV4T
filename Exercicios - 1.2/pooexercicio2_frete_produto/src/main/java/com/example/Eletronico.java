package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Eletronico extends Produto implements Transportavel {
    // Atributo
    private double peso;

    // Construtor
    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco,volume);
    }

    // Métodos
    @Override
    public double calcularPeso() {
        this.peso = getVolume() * 150;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double valorFrete = peso * 1.00;
        return valorFrete;
    }

}
