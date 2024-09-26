package com.example;

public class Main {
    public static void main(String[] args) {
        // List :
        ListExemplo list = new ListExemplo();
        list.addList("Maria");
        list.addList("João");
        list.addList("Ronaldinho");
        list.addList("Pedro");

        list.listarNomes();

        list.atualizarNome("Pedro", "PedrinhoMinecraft2017");

        list.listarNomes();

        list.removerNomes("PedrinhoMinecraft2017");

        list.listarNomes();

        // ===============XX==================
        // Set :
        SetExemplo set = new SetExemplo();
        set.addList("Maria");
        set.addList("João");
        set.addList("Ronaldinho");
        set.addList("Pedro");

        set.listarNomes();

        set.removerNomes("Pedro");

        set.listarNomes();
        // ===============XX==================
        // Map :
        MapExemplo map = new MapExemplo();

        map.addNomeIdade("João", 15);
        map.addNomeIdade("Pedro", 19);
        map.addNomeIdade("Paulo", 19);

        map.listarNomesIdade();

        map.modificarValor("Pedro", 30);

        map.listarNomesIdade();

        map.removerNomeIdade("Paulo");

        map.listarNomesIdade();
    }
}