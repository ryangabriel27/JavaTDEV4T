package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Produto implements Transportavel{
    // Atributos
    private String nome;
    private double preco;
    private double volume;

    // Calcular peso
    public abstract double calcularPeso();
}
