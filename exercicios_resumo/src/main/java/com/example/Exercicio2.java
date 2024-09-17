package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Models.Funcionarios;

public class Exercicio2 {
    List<Funcionarios> listFuncionarios = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean menu = true;

    public void run() {
        try {
            while (menu) {
                System.out.println("----xx----");
                System.out.println("Bem-vindo!");
                System.out.println(
                        "Escolha sua ação: \n1- Adicionar um novo funcionário \n2- Listar todos os funcionários \n3- Verificar Média Salarial \n4- Remover um funcionario \n5- Sair");
                int escolha = sc.nextInt();
                sc.nextLine();
                if (escolha == 1) {
                    // Adicionar funcionario
                    try {
                        System.out
                                .println("Você escolheu adicionar um novo funcionario, digite o nome do funcionario:");
                        String nome = sc.nextLine();
                        if (nome.isEmpty()) {
                            System.out.println("Nome não digitado!");
                            break;
                        }
                        System.out.println("Digite o cargo do funcionario:");
                        String cargo = sc.nextLine();
                        if (cargo.isEmpty()) {
                            System.out.println("Cargo não digitado!");
                            break;
                        }
                        System.out.println("Digite o salario em R$:");
                        double salario = sc.nextDouble();
                        if (salario <= 0) {
                            System.out.println("Digite um salario válido!");
                            break;
                        }
                        Funcionarios novoFuncionario = new Funcionarios(nome, salario, cargo);
                        listFuncionarios.add(novoFuncionario);
                    } catch (Exception e) {
                        System.out.println("Falha ao adicionar!" + e);
                    }
                } else if (escolha == 2) {
                    // Listar funcionarios
                    if (listFuncionarios.size() == 0) {
                        System.out.println("Não há funcionarios cadastrados!");
                    } else {
                        System.out.println("Aqui está a lista de todos os funcionarios");
                        for (Funcionarios funcionarios : listFuncionarios) {
                            System.out.println(
                                    "Nome: " + funcionarios.getNome() + " - Cargo: " + funcionarios.getCargo()
                                            + " - Sálario: "
                                            + funcionarios.getSalario());
                        }
                    }
                } else if (escolha == 3) {
                    // Verificar Média Salarial
                    if (listFuncionarios.size() == 0) {
                        System.out.println("Não há funcionarios cadastrados!");
                    } else {
                        double salarioTotal = 0;
                        for (Funcionarios funcionarios : listFuncionarios) {
                            salarioTotal += funcionarios.getSalario();
                        }
                        double mediaSalarial = salarioTotal / listFuncionarios.size();
                        System.out.println("Atualmente a média salarial dos funcionários é de: " + mediaSalarial);
                    }

                } else if (escolha == 4) {
                    // Remover um funcionario
                    if (listFuncionarios.size() == 0) {
                        System.out.println("Não há funcionarios cadastrados!");
                    } else {
                        System.out.println("Digite o nome do funcionario que será desligado: ");
                        String nomeFuncionario = sc.next();
                        boolean funcionarioEncontrado = false;
                        for (Funcionarios funcionarios : listFuncionarios) {
                            if (funcionarios.getNome().equals(nomeFuncionario)) {
                                funcionarioEncontrado = true;
                                listFuncionarios.remove(funcionarios);
                                System.out.println("Funcionário desligado com sucesso!");
                            }
                        }
                        if (!funcionarioEncontrado) {
                            System.out.println("Funcionário não encontrado");
                        }
                    }

                } else if (escolha == 5) {
                    // Sair
                    System.out.println("Tchau....");
                    menu = false;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Falha ao escolher ação! " + e);
        }

    }
}
