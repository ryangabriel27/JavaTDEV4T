package com.example;

import java.util.Scanner;

public class Exercicio1 {
    String nome;
    double[] notas = new double[4];
    double media = 0.0;
    Scanner sc = new Scanner(System.in);
    int bonus = 0;

    public void run() {
        // Pegar o nome do aluno
        System.out.println("Digite o nome do aluno");
        nome = sc.nextLine();

        // Pegar as notas do aluno
        for (int i = 0; i < notas.length; i++) {
            try {
                System.out.println("Digite a nota do aluno na disciplina " + (i + 1) + " :");
                notas[i] = sc.nextDouble();
                if (notas[i] > 9) {
                    bonus++;
                }
            } catch (Exception e) {
                System.out.println("Erro ao digitar nota. Por favor, digite de forma correta!" + e);
                break;
            }
        }

        double media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
        if (bonus == 4) {
            media += media * 0.1;
            System.out.println(
                    "Parabéns!! Por ter tirado acima de 9 em 4 disciplinas você ganhou um bonûs na média final");
        }

        if (media >= 7) {
            System.out.println("O aluno foi aprovado com média igual a: " + media);
        } else if (media > 5 && media <= 6.9) {
            System.out.println("O aluno está de recuperação com a média: " + media);
        } else {
            System.out.println("O aluno está reprovado com média igual a: " + media);
        }

        System.out.println("A média do aluno foi de: " + media);

    }
}
