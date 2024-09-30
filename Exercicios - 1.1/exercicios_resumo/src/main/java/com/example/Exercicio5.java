package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.Exceptions.AgendaCheiaException;
import com.example.Exceptions.ContatoNaoEncontradoException;
import com.example.Models.Contato;

public class Exercicio5 {
    List<Contato> agendaTelefonica = new ArrayList<>();
    boolean menu = true;
    Scanner sc = new Scanner(System.in);

    public void run() {
        while (menu) {
            System.out.println(
                    "Bem-vindo a Agenda Telefonica, escolha a sua ação: \n1-Adicione um contato \n2- Remova um contato pelo nome \n3- Busque um contato pelo nome \n4- Liste todos os contatos");
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
                    System.out.println("Adicionar Contato");
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    if (nome.isEmpty()) {
                        System.out.println("O nome não pode ser vazio");
                        break;
                    }
                    System.out.print("Telefone: ");
                    String telefone = sc.next();
                    if (telefone.isEmpty()) {
                        System.out.println("O telefone não pode ser vazio");
                        break;
                    }
                    try {
                        adicionarContato(nome, telefone);
                        System.out.println("Contato adicionado com sucesso!");
                    } catch (AgendaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Remover Contato");
                    System.out.print("Nome: ");
                    nome = sc.next();
                    try {
                        removerContato(nome);
                        System.out.println("Contato removido com sucesso!");
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Buscar Contato");
                    System.out.print("Nome: ");
                    nome = sc.next();
                    try {
                        Contato contato = buscarContato(nome);
                        System.out.println("Contato encontrado: " + contato);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    listarContatos();
                    break;
                case 5:
                    System.out.println("Tchau...");
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void adicionarContato(String nome, String telefone) {
        if (agendaTelefonica.size() >= 100) {
            throw new AgendaCheiaException();
        }
        Contato novoContato = new Contato(nome, telefone);
        agendaTelefonica.add(novoContato);
    }

    private void removerContato(String nome) {
        Contato contatoParaRemover = buscarContato(nome);
        agendaTelefonica.remove(contatoParaRemover);
    }

    private Contato buscarContato(String nome) {
        for (Contato contato : agendaTelefonica) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado.");
    }

    private void listarContatos() {
        if (agendaTelefonica.isEmpty()) {
            System.out.println("A agenda está vazia.");
            return;
        }
        for (Contato contato : agendaTelefonica) {
            System.out.println(contato);
        }
    }
}
