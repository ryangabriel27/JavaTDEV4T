package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Eletronico extends Produto implements Transportavel {
    // Atributo
    private double volume;
    private double peso;

    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        this.peso = volume * 150;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double valorFrete = peso * 1.00;
        return valorFrete;
    }

}
