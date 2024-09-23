package br.ryan;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerencia = new FuncionarioController();

        int operacao = 0;

        do {
            try {
                operacao = Integer.parseInt(JOptionPane
                        .showInputDialog("---=== Gerenciamento de funcionario ===---"
                                + "\nEscolha sua ação: \n 1 - Cadastrar Funcionario \n 2 - Listar Funcionarios \n 3 - Remover Funcionarios \n 4 - Calcular Média Salarial \n 5 - Sair "));

            } catch (Exception e) {
                System.err.println(e.getMessage());
                operacao = 0;
            }

            switch (operacao) {
                case 1:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario:");
                        String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionario:");
                        double salario = Double
                                .parseDouble(JOptionPane.showInputDialog("Digite o salario do funcionario:"));
                        Funcionarios novoFuncionario = new Funcionarios(nome, salario, cargo);
                        gerencia.addFuncionario(novoFuncionario);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.err.println(e.getMessage());
                    }

                    break;
                case 2:
                    gerencia.listFuncionarios();
                    break;
                case 3:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario a remover:");
                        gerencia.removerFuncionarios(nome);
                        JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        if (gerencia.calcularMediaSalarial() == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Não há funcionarios cadastrados! \n Média salaria igual a: "
                                            + gerencia.calcularMediaSalarial(),
                                    null, 0);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Média salarial dos funcionarios: " + gerencia.calcularMediaSalarial(), null, 1);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Digite novamente...");
                    break;
            }
        } while (operacao != 5);
    }
}