package br.ryan;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws AgendaCheiaException {
        System.out.println("Hello world!");
        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador = 0;
        do {
            try {
                operador = Integer
                        .parseInt(JOptionPane.showInputDialog(
                                "Bem-vindo a Agenda Telefônica! \nEscolha sua ação :\n 1 - Adicionar um contato \n"
                                        + //
                                        " 2 - Listar contatos \n" + //
                                        " 3 - Buscar um contato \n" + //
                                        " 4 - Remover um contato \n" + //
                                        " 5 - Sair"));

            } catch (NumberFormatException e) {
                // TODO: handle exception
                operador = 0;
            }

            switch (operador) {
                case 1:
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu adicionar um contato");
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato");
                        String telefone = JOptionPane.showInputDialog("Digite o telefone do contato");
                        Contato contato = new Contato(nome, telefone);
                        agenda.addContato(contato);
                    } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o contato: " + e.getMessage()
                                + ". Tente outra operação!");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Aqui está a lista de contatos:");
                    agenda.listarContatos();
                    break;
                case 3:
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu buscar um contato");
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato");
                        Contato contato = agenda.buscaContato(nome.trim());
                        if (contato != null) {
                            JOptionPane.showMessageDialog(null, "Contato Encontrado! \n" + contato.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Contato não preenchido ou encontrado!", nome,
                                    operador);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o contato: " + e.getMessage()
                                + ". Tente outra operação!");
                    }
                    break;

                case 4:
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu remover um contato");
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato");
                        agenda.removerContato(nome);
                        JOptionPane.showMessageDialog(null, "Contato removido com sucesso!", null,
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o contato: " + e.getMessage());
                    }

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Tchau!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (operador != 5);

    }
}