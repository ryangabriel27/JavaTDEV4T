package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio3 {
    Scanner sc = new Scanner(System.in);
    double n1 = 0;
    double n2 = 0;
    boolean menu = true;

    public void run() {
        while (menu) {
            System.out.println("------x-------");
            System.out.println(
                    "Bem-vindo a calculadora, escolha sua ação: \n1- Soma \n2- Subtração \n3- Multiplicação \n4- Divisão \n5- Raiz quadrada \n6- Sair");

            int escolha = 0;
            boolean escolhaValida = false;

            // Lê a escolha do menu com tratamento de erro
            while (!escolhaValida) {
                try {
                    escolha = sc.nextInt();
                    escolhaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    sc.next(); // Limpa o buffer do scanner
                }
            }

            sc.nextLine(); // Limpar o buffer após a escolha

            switch (escolha) {
                case 1:
                    n1 = lerNumero("Digite o primeiro número:");
                    n2 = lerNumero("Digite o segundo número:");
                    System.out.println("Resultado da soma: " + soma(n1, n2));
                    break;
                case 2:
                    n1 = lerNumero("Digite o primeiro número:");
                    n2 = lerNumero("Digite o segundo número:");
                    System.out.println("Resultado da subtração: " + subtracao(n1, n2));
                    break;
                case 3:
                    n1 = lerNumero("Digite o primeiro número:");
                    n2 = lerNumero("Digite o segundo número:");
                    System.out.println("Resultado da multiplicação: " + multiplicacao(n1, n2));
                    break;
                case 4:
                    n1 = lerNumero("Digite o primeiro número:");
                    n2 = lerNumero("Digite o segundo número:");
                    if (n2 == 0) {
                        System.out.println("Não é possível dividir por 0, por favor escolha outro número");
                    } else {
                        System.out.println("Resultado da divisão: " + divisao(n1, n2));
                    }
                    break;
                case 5:
                    n1 = lerNumero("Digite um número:");
                    if (n1 < 0) {
                        System.out.println(
                                "Não é possível realizar raiz quadrada de um número negativo, por favor escolha outro número");
                    } else {
                        System.out.println("Resultado da operação: " + raizQuadrada(n1));
                    }
                    break;
                case 6:
                    System.out.println("Tchau..");
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
                    break;
            }
        }
    }

    private double lerNumero(String mensagem) { // Verifica se o número digitado é realmente um número
        double numero = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            try {
                System.out.println(mensagem);
                numero = sc.nextDouble();
                numeroValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Limpa o buffer do scanner
            }
        }
        return numero;
    }

    public double soma(double n1, double n2) {
        return n1 + n2;
    }

    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    public double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }

    public double divisao(double n1, double n2) {
        return n1 / n2;
    }

    public double raizQuadrada(double n) {
        return Math.sqrt(n);
    }
}
