package br.com.ryan;

import java.util.Scanner;

public class Exercicio4Fatorial {
    Scanner sc = new Scanner(System.in);
    double fatorial = 0.0;
    int numero = -1;

    public double calcularFatorial(int numero) throws Exception {
        if (numero < 0) {
            throw new Exception("O número deve ser positivo");
        }
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return calcularFatorial(numero - 1) * numero;
        }
    }

    public void calculadora() {
        System.out.println("Digite um número para calcular a fatorial:");
        numero = sc.nextInt();
        while (true) {
            try {
                System.out.println(calcularFatorial(numero));
            } catch (Exception e) {
                System.out.println("Número Inválido!!!! digite um número válido: ");
                numero = sc.nextInt();
            }
        }
        
    }
}
