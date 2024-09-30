package com.example;

import java.util.Scanner;

public class LeituraTeclado {
    public void teste() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vou adivinhar seu nome e quantos anos tem");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Seu Nome é " + nome + "e você tem " + idade + " anos");
        scanner.close();
    }
}
