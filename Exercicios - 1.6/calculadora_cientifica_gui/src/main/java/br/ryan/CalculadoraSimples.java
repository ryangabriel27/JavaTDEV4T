package br.ryan;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSimples extends JPanel {
    private JTextField display;

    public CalculadoraSimples() {
        this.setLayout(new BorderLayout());
        // Criação do campo de texto para exibir os resultados
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(display, BorderLayout.NORTH);

        // Criação do painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4));

        // Adicionando botões
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();

                    // Aqui você pode implementar a lógica para a calculadora
                    if (command.equals("C")) {
                        display.setText("");
                    } else if (command.equals("=")) {
                        // Lógica para calcular o resultado (a ser implementada)
                        // Exemplo: display.setText(calcular(display.getText()));
                    } else {
                        display.setText(display.getText() + command);
                    }
                }

            });
            buttonsPanel.add(button);
        }

        this.add(buttonsPanel, BorderLayout.CENTER);
    }
}
