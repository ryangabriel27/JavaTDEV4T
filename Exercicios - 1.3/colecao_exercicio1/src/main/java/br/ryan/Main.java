package br.ryan;

import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Vendas vendas = new Vendas();
        String operacao;
        do {
            operacao = JOptionPane.showInputDialog("---===XXX===---\n" + "1 - Cadastra vendar \n"
                    + "2 - Listar por CPF \n" + "3 - Listar vendas por CPF\n" + "4 - Sair");
            switch (operacao) {
                case "1":
                    String cpfVenda = JOptionPane.showInputDialog("Informe o CPF do cliente (somente números):");
                    String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto:");
                    double precoProduto = Double
                            .parseDouble(JOptionPane.showInputDialog("Informe o valor do produto:"));

                    Produto produto = new Produto(nomeProduto, precoProduto);
                    vendas.cadastroVenda(cpfVenda, produto);
                    JOptionPane.showMessageDialog(null, "Venda registrada com sucesso");
                    break;
                case "2":
                    String cpfCliente = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                    List<Produto> compras = vendas.listaProdutos(cpfCliente);

                    // Concatena a lista á um JOptionPane
                    StringBuilder mediasInfo = new StringBuilder("Lista de produtos:\n");
                    for (Produto produto1 : compras) {
                        mediasInfo.append("Nome: " + produto1.getNome() + " - Preço: " + produto1.getPreco())
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, mediasInfo.toString());
                    break;

                case "3":
                    String cpfList = JOptionPane.showInputDialog("Informe o CPF do cliente (somente números):");
                    double valorMinimo = Double
                            .parseDouble(JOptionPane.showInputDialog("Informe o valor Minimo para a lista:"));
                    try {
                        List<Produto> comprasFiltro = vendas.listaProdutosFiltro(cpfList, valorMinimo);

                        // Concatena a lista á um JOptionPane
                        StringBuilder mediasInfo2 = new StringBuilder("Lista de produtos:\n");
                        for (Produto produto1 : comprasFiltro) {
                            mediasInfo2.append("Nome: " + produto1.getNome() + " - Preço: " + produto1.getPreco())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mediasInfo2.toString());
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        } while (!operacao.equals("4"));
    }
}