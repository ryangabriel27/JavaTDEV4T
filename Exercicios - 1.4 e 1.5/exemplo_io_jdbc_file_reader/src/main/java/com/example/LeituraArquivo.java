package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {
    public void teste() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\DevTarde\\Documents\\RyanGabriel\\JavaTDEV4T\\dados.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
