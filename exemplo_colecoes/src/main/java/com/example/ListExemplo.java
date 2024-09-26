package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }

    public void addList(String nome) {
        nomes.add(nome);
        System.out.println(nomes.lastIndexOf(nome));
    }

    public void listarNomes() {
        System.out.println(nomes);
    }

    public void removerNomes(String nome) {
        try {
            nomes.remove(nome);
            System.out.println("Nome removido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }

    public void atualizarNome(String oldNome, String newNome) {
        try {
            int newIndex = nomes.indexOf(oldNome);
            nomes.set(newIndex, newNome);
            System.out.println("Nome alterado com sucesso!!");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
}
