package br.ryan;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.FocusListener;

public class Todolist extends JFrame {
    // atributos
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public Todolist() {

        super("TO-DO List App");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField("Digite sua tarefa...");
        addButton = new JButton("Adicionar Tarefa");
        deleteButton = new JButton("Excluir Tarefa");
        markDoneButton = new JButton("Concluir a Tarefa");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        // inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.add(filterComboBox, BorderLayout.EAST);
        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel();
        GridLayout gr = new GridLayout(4, 1, 0, 8);
        buttonPanel.setLayout(gr);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        // buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        // Adiciona o painel principal à janela
        this.add(mainPanel);
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // Estilização :
        taskInputField.setBackground(new Color(63, 62, 64));
        taskInputField.setBorder(BorderFactory.createLineBorder(new Color(93, 92, 94, 10), 5));
        // taskInputField.setForeground(Color.WHITE);

        taskList.setBackground(new Color(93, 92, 94));
        taskInputField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));
        taskList.setForeground(Color.WHITE);

        buttonPanel.setBackground(new Color(27, 27, 28));
        buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));

        addButton.setBackground(new Color(121, 42, 42));
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));

        deleteButton.setBackground(new Color(121, 42, 42));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));

        markDoneButton.setBackground(new Color(121, 42, 42));
        markDoneButton.setForeground(Color.WHITE);
        markDoneButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));

        clearCompletedButton.setBackground(new Color(121, 42, 42));
        clearCompletedButton.setForeground(Color.WHITE);
        clearCompletedButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 5));
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // Configuração de Listener para os Eventos

        // ActionListeners :
        addButton.addActionListener(e -> { // Adicionando o ouvinte ao addButton
            addTask(); // Ao clicar no botão 'Adicionar' executa o método addTask().
        });

        deleteButton.addActionListener(e -> { // Adicionando o ouvinte ao deleteButton
            deleteTask(); // Ao clicar no botão 'Excluir' executa o método deleteTask().
        });

        markDoneButton.addActionListener(e -> { // Adicionando o ouvinte ao markDoneButton
            markTaskDone();// Ao clicar no botão 'Concluir a tarefa' executa o método markTaskDone().
        });

        filterComboBox.addActionListener(e -> { // Adicionando o ouvinte ao filterComboBox
            filterTasks();// Ao clicar no comboBox executa o método filterTask(), que filtra as tarefas
                          // que devem aparecer
        });

        clearCompletedButton.addActionListener(e -> { // Adicionando o ouvinte ao clearCompletedButton
            clearCompletedTasks(); // Ao clicar no botão 'Limpar tarefas concluídas', executar o método
                                   // clearCompletedTasks().
        });
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // KeyListeners :
        HandlerEnterText enterText = new HandlerEnterText(); // Handler para adicionar uma task
        taskInputField.addKeyListener(enterText); // Adicionando o ouvinte a taskInputField

        HandlerDeleteText deleteText = new HandlerDeleteText(); // Handler para remover uma task
        taskList.addKeyListener(deleteText); // Adicionando o ouvinte a taskList
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // MouseListeners :
        HandlerDblClick doneDblClick = new HandlerDblClick(); // Handler para marcar task como concluída com 2 clicks
        taskList.addMouseListener(doneDblClick); // Adiciona o ouvinte a taskList
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // FocusListeners :
        taskInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) { // Quando o campo é clicado , "ganha o foco"
                if (taskInputField.getText().equals("Digite sua tarefa...")) {
                    taskInputField.setText(""); // O texto é limpado
                    taskInputField.setForeground(Color.WHITE); // Cor do texto Branco
                }
            }

            @Override
            public void focusLost(FocusEvent e) { // Quando outro componente é clicado , "perde o foco"
                if (taskInputField.getText().isEmpty()) {
                    taskInputField.setForeground(Color.GRAY); // Cor do texto cinza
                    taskInputField.setText("Digite sua tarefa..."); // Um texto padrão é colocado
                }
            }
        });
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // WindowListener :
        this.addWindowListener(new WindowAdapter() { // Adiciona o ouvinte ao JFrame

            @Override
            public void windowClosing(WindowEvent e) {
                close(); // Ao clicar no "X" do JFrame, é perguntado ao usuário se ele realmente deseja
                         // fechar o programa
            }

        });
    }
    // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    // Handlers para os eventos:

    public class HandlerEnterText implements KeyListener { // Handler para o KeyListener do taskInputField : Ao apertar
                                                           // a tecla 'enter' você adiciona uma tarefa

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                addTask();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public class HandlerDeleteText implements KeyListener { // Handler para o KeyListener do taskList : Ao clicar em uma
                                                            // tarefa da lista e pressionar a tecla 'DELETE' você exclui
                                                            // a tarefa selecionada

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) { // Verifica se a tecla pressionada é a 'DELETE'
                deleteTask(); // Se for , executa o método deleteTask(), apaga a tarefa.
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public class HandlerDblClick implements MouseListener { // Handler para MouseListener da taskList : Ao dar 2 clicks
                                                            // em uma tarefa da lista , você marca essa tarefa como
                                                            // concluída

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) { // Conta quantos clicks foram dados e
                                                                                 // se foram com o botão esquerdo do
                                                                                 // mouse.
                markTaskDone(); // Caso tenha dado 2 click seguidos com o botão esquerdo do mouse , executa o
                                // método markTaskDone(), marca a tarefa como concluída
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }
    // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    // Métodos :
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        if (!taskDescription.isEmpty() && !taskDescription.equals("Digite sua tarefa...")) { // Verifica se o campo não
                                                                                             // está vazio , caso não
                                                                                             // esteja adiciona uma task
                                                                                             // a
            // lista
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada", getTitle(), JOptionPane.INFORMATION_MESSAGE); // Notifica
                                                                                                                   // o
                                                                                                                   // usuário
                                                                                                                   // que
                                                                                                                   // uma
                                                                                                                   // task
                                                                                                                   // foi
                                                                                                                   // adicionada
            updateTaskList();
            taskInputField.setText(""); // Após adicionar uma task limpa o campo digitado
        }
    }

    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

            int resposta = JOptionPane.showConfirmDialog(null, "Você deseja excluir essa tarefa?", getTitle(),
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE); // Pergunta ao usuário se ele realmente
                                                                           // deseja excluir a task

            if (resposta == JOptionPane.YES_OPTION) {// Caso escolha a opção 'YES', a tarefa é excluída
                tasks.remove(selectedIndex);
                JOptionPane.showMessageDialog(null, "Tarefa excluída", getTitle(), JOptionPane.INFORMATION_MESSAGE); // Notifica
                                                                                                                     // o
                                                                                                                     // usuário
                                                                                                                     // de
                                                                                                                     // que
                                                                                                                     // a
                                                                                                                     // tarefa
                                                                                                                     // foi
                                                                                                                     // excluída
                updateTaskList();
            }

        }
    }

    private void markTaskDone() {
        // Marca a task selecionada como concluída

        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

            int resposta = JOptionPane.showConfirmDialog(null, "Você concluiu essa tarefa?", getTitle(),
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Pergunta ao usuário se ele concluiu a
                                                                              // tarefa

            if (resposta == JOptionPane.YES_OPTION) { // Caso escolha 'YES' , a tarefa é marcada como concluída
                Task task = tasks.get(selectedIndex);

                JOptionPane.showMessageDialog(null, "Tarefa concluída", getTitle(), JOptionPane.INFORMATION_MESSAGE); // Notifica
                                                                                                                      // o
                                                                                                                      // usuário
                                                                                                                      // de
                                                                                                                      // que
                                                                                                                      // a
                                                                                                                      // tarefa
                                                                                                                      // foi
                                                                                                                      // concluída
                task.setDone(true);
                updateTaskList();
            }
        }
    }

    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja excluir todas as tarefas concluídas?",
                getTitle(),
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); // Pergunta ao usuário se ele quer excluir
                                                                         // todas
                                                                         // as tarefas concluídas

        if (resposta == JOptionPane.YES_OPTION) { // Caso escolha 'YES', todas as tarefas concluídas são apagadas
            List<Task> completedTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.isDone()) {
                    completedTasks.add(task);
                }
            }
            tasks.removeAll(completedTasks);
            updateTaskList();
        }
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ?

                    " (Concluída)" : ""));

        }
    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    public void close() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja sair do app?", getTitle(),
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); // Pergunta ao usuário se deseja fechar o app
        if (resposta == JOptionPane.YES_OPTION) { // Caso escolha 'YES' , o app é fechado.
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Caso escolha 'NO' , o app continuar aberto
        }
    }
}