package br.com.ryan;

import java.util.Scanner;

public class Exercicio1 {
    // Atributos
    double[] notas = new double[4];
    double mediaNotas = 0.0;
    boolean bonus = true;
    Scanner sc = new Scanner(System.in);

    public void calculoNotas() {
        // Pegando as notas
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a nota " + (i + 1) + " do aluno:");
            notas[i] = sc.nextDouble();
            mediaNotas += notas[i];
            if (notas[i] < 9) {
                bonus = false;
            }
        }

        mediaNotas /= notas.length; // Calculando a média

        if (bonus) {
            mediaNotas = (mediaNotas * 1.1 > 10 ? mediaNotas = 10 : mediaNotas * 1.1); // Atribui 10% a mais de média e
                                                                                       // define o máximo como 10
        }

        if (mediaNotas >= 7) {
            System.out.println("Aprovado!");
        } else if (mediaNotas >= 5 && mediaNotas < 7) {
            System.out.println("Recuperação!");
        } else {
            System.out.println("Reprovado!");
        }

        System.out.println("Média: " + mediaNotas);
    }
}
