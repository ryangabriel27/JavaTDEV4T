package com.example;

import java.util.ArrayList;
import java.util.List;

import lombok.val;

public class CarrinhoDeCompras {
    private List<Produto> carrinho;

    public CarrinhoDeCompras() {
        carrinho = new ArrayList<>();
    }

    // Métodos
    // adicionar ao carrinho
    public void adicionarProduto(Produto produto) {
        carrinho.add(produto);
    }

    // remover do carrinho
    public void removeCarrinho(Produto produto) {
        carrinho.remove(produto);
    }

    // calcular frete do carrinho
    public double calcularFrete() {
        double freteTotal = 0.0;
        for (Produto produto : carrinho) {
            // Verifica se o produto é transportável (implementa a interface Transportavel)
            produto.calcularFrete();
        }
        return freteTotal;
    }

    // calcular valor total do carrinho
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Produto produto : carrinho) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }
}
