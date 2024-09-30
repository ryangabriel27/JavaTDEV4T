package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.Exceptions.EstoqueCheioException;
import com.example.Exceptions.FalhaDeArquivoException;
import com.example.Exceptions.ItemNaoEncontradoException;
import com.example.Models.Produto;

public class Exercicio6 {
    private static final String ARQUIVO_ESTOQUE = "estoque.txt";
    private List<Produto> estoque = new ArrayList<>();
    private boolean menu = true;
    private Scanner sc = new Scanner(System.in);

    public void run() {
        carregarEstoque();

        while (menu) {
            System.out.println(
                    "Bem-vindo ao Gerenciamento de Estoque, escolha a sua ação: \n1-Adicione um produto \n2- Remova um produto \n3- Liste todos os produtos \n4- Salvar e Sair");
            int escolha = 0;
            boolean escolhaValida = false;

            // Lê a escolha do menu com tratamento de erro
            while (!escolhaValida) {
                try {
                    escolha = sc.nextInt();
                    escolhaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    sc.next(); // Limpa o buffer do scanner
                }
            }

            switch (escolha) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    salvarEstoque();
                    System.out.println("Estoque salvo!!");
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void adicionarProduto() {
        System.out.println("Adicionar Produto");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Quantidade: ");
        int quantidade = 0;
        try {
            quantidade = sc.nextInt();
            if (quantidade < 0) {
                System.out.println("Quantidade não pode ser negativa.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Quantidade inválida. Deve ser um número inteiro.");
            sc.next(); // Limpa o buffer do scanner
            return;
        }

        if (estoque.size() >= 100) {
            throw new EstoqueCheioException();
        }

        Produto novoProduto = new Produto(nome, quantidade);
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void removerProduto() {
        System.out.println("Remover Produto");
        System.out.print("Nome: ");
        String nome = sc.next();
        Produto produtoParaRemover = null;
        for (Produto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtoParaRemover = produto;
                break;
            }
        }

        if (produtoParaRemover == null) {
            throw new ItemNaoEncontradoException("Produto com o nome " + nome + " não encontrado.");
        }

        estoque.remove(produtoParaRemover);
        System.out.println("Produto removido com sucesso!");
    }

    private void listarProdutos() {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        for (Produto produto : estoque) {
            System.out.println("Nome: " + produto.getNome() + " - Quantidade: " + produto.getQuantidade());
        }
    }

    private void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Produto produto : estoque) {
                writer.write(produto.getNome() + "," + produto.getQuantidade());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FalhaDeArquivoException("Erro ao salvar o estoque no arquivo: " + e.getMessage());
        }
    }

    private void carregarEstoque() {
        File arquivo = new File(ARQUIVO_ESTOQUE);
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new FalhaDeArquivoException("Erro ao criar o arquivo de estoque: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nome = partes[0];
                    int quantidade = Integer.parseInt(partes[1]);
                    estoque.add(new Produto(nome, quantidade));
                }
            }
        } catch (IOException e) {
            throw new FalhaDeArquivoException("Erro ao carregar o estoque do arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro no formato dos dados no arquivo. Dados inválidos podem estar presentes.");
        }
    }
}
