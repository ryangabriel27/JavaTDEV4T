package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Produto {
    // Atributos
    private String nome;
    private double preco;

    // Calcular peso
    public abstract double calcularPeso();
}
