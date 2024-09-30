package com.example;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

    public static void main(String[] args) {
        String[] opcoes = { "Adicionar Produto", "Calcular Total", "Calcular Frete", "Sair" };
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione uma opção",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            switch (escolha) {
                case 0: // Adicionar Produto
                    adicionarProduto();
                    break;
                case 1: // Calcular Total
                    calcularTotal();
                    break;
                case 2: // Calcular Frete
                    calcularFrete();
                    break;
                case 3: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    break;
            }

        } while (escolha != 3);
    }

    private static void adicionarProduto() {
        String[] tiposProduto = { "Eletronico", "Roupa", "Livro" };
        int tipoProduto = JOptionPane.showOptionDialog(
                null,
                "Selecione o tipo de produto",
                "Adicionar Produto",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tiposProduto,
                tiposProduto[0]);

        String nome = JOptionPane.showInputDialog("Informe o nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto:"));
        double volume = Double.parseDouble(JOptionPane.showInputDialog("Digite o volume do produto:"));

        Produto produto = null;
        switch (tipoProduto) {
            case 0:
                produto = new Eletronico(nome, preco, volume);
                break;
            case 1:
                produto = new Roupa(nome, preco, volume);
                break;
            case 2:
                produto = new Livro(nome, preco, volume);
                break;
        }

        if (produto != null) {
            carrinho.adicionarProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho!");
        }
    }

    private static void calcularTotal() {
        double total = carrinho.calcularValorTotal();
        JOptionPane.showMessageDialog(null, "O total do carrinho é: R$ " + total);
    }

    private static void calcularFrete() {
        double frete = carrinho.calcularFrete();
        JOptionPane.showMessageDialog(null, "O frete total é: R$ " + frete);
    }
}
