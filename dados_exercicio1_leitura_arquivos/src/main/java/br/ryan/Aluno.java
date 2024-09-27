package br.ryan;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Aluno {
    private String nome;
    private List<Double> notas;
    private double media = 0;

    public Aluno(String nome, double nota1, double nota2, double nota3) {
        notas = new ArrayList<>();
        this.nome = nome;

        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);
    }

    // Métodos
    public double mediaNotas() {
        for (Double nota : notas) {
            media += nota;
        }
        media /= notas.size();
        return media;
    }

    public double maiorNota() {
        double maiorNota = Double.MIN_VALUE;
        for (Double nota : notas) {
            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }
        return maiorNota;
    }

    public double menorNota() {
        double menorNota = Double.MAX_VALUE;
        for (Double nota : notas) {
            if (nota < menorNota) {
                menorNota = nota;
            }
        }
        return menorNota;
    }
}
