package com.example;

import java.util.Scanner;

import com.example.Exceptions.ValorInvalidoException;

import java.util.InputMismatchException;

public class Exercicio4 {
    Scanner sc = new Scanner(System.in);
    double fatorial = 0;

    public void run() {
        System.out.println("------x-------");
        System.out.println("Bem-vindo a calculadora de fatorial!!");
        System.out.println("Digite um número:");

        int numero = 0;
        boolean numeroValido = false;

        while (!numeroValido) {
            try {
                System.out.println("Digite um número:");
                numero = sc.nextInt();
                if (numero < 0) {
                    throw new ValorInvalidoException("Número negativo não é permitido para o cálculo de fatorial.");
                }
                numeroValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                sc.next(); // Limpa o buffer do scanner
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Resultado do fatorial de " + numero + " é: " + calcularFatorial(numero));
    }

    public double calcularFatorial(int numero) {
        if (fatorial == 0) {
            fatorial += numero; 
            return calcularFatorial(numero - 1);
        } else if (numero == 0) {
            return fatorial;
        } else {
            return calcularFatorial(numero - 1) * numero;
        }
    }
}
