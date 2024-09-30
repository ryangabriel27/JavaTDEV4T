package br.ryan;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaCalculadora extends JFrame {
    public JanelaCalculadora() {
        super("Calculadora Avançada");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Calculadora Simples", new CalculadoraSimples());
        tab.addTab("Calculadora Avançada", new CalculadoraAvancada());
        this.add(tab);
        // Torna a janela visível
        this.setVisible(true);
    }
}
