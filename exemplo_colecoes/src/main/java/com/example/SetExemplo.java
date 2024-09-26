package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo() {
        nomes = new HashSet<>();
    }

    public void addList(String nome) {
        nomes.add(nome);
        System.out.println(nomes.hashCode());
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

}
