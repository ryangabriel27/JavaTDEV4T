package br.com.ryan;

import java.util.Scanner;

public class Exercicio3Calculadora {
    Scanner sc = new Scanner(System.in); // Scanner
    // ---====XX====---
    // Atributos :
    double a = 0.0;
    double b = 0.0;
    double resultado = 0.0;
    int escolha = 0;

    // ---====XX====---
    // Calculadora:

    public void menu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Raiz Quadrada");
        System.out.println("6 - Sair");
    }

    public void entradaDados() {
        if (escolha >= 1 && escolha < 5) {
            System.out.println("Digite um número:");
            a = sc.nextDouble();
            System.out.println("Digite outro número:");
            b = sc.nextDouble();
        } else if (escolha == 5) {
            System.out.println("Digite um número:");
            a = sc.nextDouble();
        } else if (escolha == 6) {
            System.out.println("Saindo...");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public void calculadora() {
        do {
            menu();
            try {
                escolha = sc.nextInt();
                System.out.println("");
                switch (escolha) {
                    case 1:
                        entradaDados();
                        soma(a, b);
                        System.out.println("Resultado da soma: " + resultado);
                        break;
                    case 2:
                        entradaDados();
                        subtracao(a, b);
                        System.out.println("Resultado da subtração: " + resultado);
                        break;
                    case 3:
                        entradaDados();
                        multiplicacao(a, b);
                        System.out.println("Resultado da multiplicação: " + resultado);
                        break;
                    case 4:
                        entradaDados();
                        divisao(a, b);
                        System.out.println("Resultado da divisão: " + resultado);
                        break;
                    case 5:
                        entradaDados();
                        raizQuadrada(a);
                        System.out.println("Resultado da raiz quadrada: " + resultado);
                        break;
                    case 6:
                        entradaDados();
                        break;
                    default:
                        entradaDados();
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.err.println(e);
            }

        } while (escolha != 6);
    }

    // ---====XX====---
    // Operações :
    public double soma(double a, double b) {
        resultado = a + b;
        return resultado;
    }

    public double subtracao(double a, double b) {
        resultado = a - b;
        return resultado;
    }

    public double multiplicacao(double a, double b) {
        resultado = a * b;
        return resultado;
    }

    public double divisao(double a, double b) {
        try {
            resultado = a / b;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        return resultado;
    }

    public double raizQuadrada(double n) throws Exception {
        if (n < 0) {
            throw new Exception("Não existe Raiz de número negativo");
        }
        try {
            resultado = Math.sqrt(n);
        } catch (Exception e) {

        }
        return resultado;
    }
}
