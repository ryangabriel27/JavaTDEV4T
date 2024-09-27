package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Menu {
    int escolha = 0;
    List<Aluno> listAlunos = new ArrayList<>();
    List<Curso> listCursos = new ArrayList<>();
    List<Professor> listProfessors = new ArrayList<>();

    public void menu() throws Exception {
        do {
            String[] options = { "Cursos", "Aluno", "Professores", "Sair" };
            escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao portal cursos SENAI", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    menuCursos();
                    break;
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuProfessor();
                    break;
                default:
                    break;
            }
        } while (escolha != 3);
    }

    public void menuAluno() {
        int escolha2 = 0;
        do {
            String[] options = { "Cadastrar", "Listar", "Sair" };
            escolha2 = JOptionPane.showOptionDialog(null, "Menu do aluno", "Ações do Aluno",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha2) {
                case 0:
                    try {
                        String matricula = JOptionPane.showInputDialog("Digite a matricula do aluno");
                        String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
                        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");

                        Aluno novoAluno = new Aluno();
                        novoAluno.setNome(nome);
                        novoAluno.setMatricula(matricula);
                        novoAluno.setCpf(cpf);

                        listAlunos.add(novoAluno);
                        JOptionPane.showMessageDialog(null, "Novo aluno adicionado com sucesso!!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    if (listAlunos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
                    } else {
                        StringBuilder alunosInfo = new StringBuilder("Listar alunos:\n");
                        for (Aluno aluno : listAlunos) {
                            alunosInfo.append(aluno.exibirInformacoes()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, alunosInfo.toString());
                    }
                    break;
                default:
                    break;
            }
        } while (escolha2 != 2);
    }

    public void menuProfessor() {
        int escolha3 = 0;
        do {
            String[] options = { "Cadastrar", "Listar", "Sair" };
            escolha3 = JOptionPane.showOptionDialog(null, "Menu do Professor", "Ações do Professor",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha3) {
                case 0:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do Professor");
                        String cpf = JOptionPane.showInputDialog("Digite o CPF do Professor");
                        double salario = Double
                                .parseDouble(JOptionPane.showInputDialog("Digite o salario do Professor"));

                        Professor novoProfessor = new Professor();
                        novoProfessor.setNome(nome);
                        novoProfessor.setSalario(salario);
                        novoProfessor.setCpf(cpf);

                        listProfessors.add(novoProfessor);
                        JOptionPane.showMessageDialog(null, "Novo Professor adicionado com sucesso!!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    if (listProfessors.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há professores cadastrados.");
                    } else {
                        StringBuilder professorsInfo = new StringBuilder("Listar professores:\n");
                        for (Professor prof : listProfessors) {
                            professorsInfo.append(prof.exibirInformacoes()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, professorsInfo.toString());
                    }
                    break;
                default:
                    break;
            }
        } while (escolha3 != 2);
    }

    public void menuCursos() throws Exception {
        int escolha4 = 0;
        do {
            String[] options = { "Cadastrar um curso", "Listar cursos", "Ver um curso específico", "Sair" };
            escolha4 = JOptionPane.showOptionDialog(null, "Menu de Cursos", "Ações de Cursos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha4) {
                case 0:
                    boolean existProfessor = false;
                    Professor professorResp = new Professor();
                    try {
                        if (listProfessors.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Não há professores cadastrados no momento");
                            break;
                        }

                        String nome = JOptionPane.showInputDialog("Digite o nome do Curso");
                        String nomeProf = JOptionPane.showInputDialog("Digite o professor responsável pelo Curso");

                        for (Professor prof : listProfessors) {
                            if (prof.getNome().equals(nomeProf)) {
                                existProfessor = true;
                                professorResp = prof;
                            }
                        }
                        if (!existProfessor) {
                            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                            break;
                        }

                        Curso novoCurso = new Curso();
                        novoCurso.setNome(nome);
                        novoCurso.setProfessor(professorResp);
                        listCursos.add(novoCurso);

                        JOptionPane.showMessageDialog(null, "Novo Curso adicionado com sucesso!!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar curso: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    if (listCursos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há cursos cadastrados.");
                    } else {
                        StringBuilder cursosInfo = new StringBuilder("Listar cursos:\n");
                        for (Curso curso : listCursos) {
                            cursosInfo.append("● ").append(curso.getNome()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, cursosInfo.toString());
                    }
                    break;
                case 2:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do curso:");
                        cursoEspecifico(nome);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    break;
            }
        } while (escolha4 != 3);
    }

    public void cursoEspecifico(String nome) throws Exception {
        boolean encontrado = false;
        Curso cursoEncontrado = new Curso();
        try {
            if (listCursos.isEmpty()) {
                throw new Exception("Lista está vazia!");
            }
            for (Curso curso : listCursos) {
                if (curso.getNome().equals(nome)) {
                    encontrado = true;
                    cursoEncontrado = curso;
                }
            }
            if (!encontrado) {
                throw new Exception("Curso não encontrado");
            }
            JOptionPane.showMessageDialog(null, "Curso Encontrado! \n" + cursoEncontrado.exibirInformacoes(), nome,
                    JOptionPane.INFORMATION_MESSAGE);
            menuCursoEspecifico(cursoEncontrado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void menuCursoEspecifico(Curso curso) {
        String operacao = "";
        do {
            operacao = JOptionPane.showInputDialog(
                    "Escolha sua ação: \n 1 - Adicionar um aluno \n 2 - Enviar notas de um aluno \n 3 - Listar média dos alunos \n 4- Sair");

            switch (operacao) {
                case "1":
                    try {
                        if (listAlunos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Não há alunos cadastrados, tente novamente depois!");
                            break;
                        } else {
                            boolean alunoEncontrado = false;
                            String matricula = JOptionPane.showInputDialog("Digite a matricula do aluno:");
                            for (Aluno aluno : listAlunos) {
                                if (aluno.getMatricula().equals(matricula)) {
                                    alunoEncontrado = true;
                                    curso.addAluno(aluno);
                                    JOptionPane.showMessageDialog(null, "Aluno adicionado ao curso com sucesso!");
                                }
                            }
                            if (!alunoEncontrado) {
                                throw new Exception("Aluno não encontrado");
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "2":
                    try {
                        if (listAlunos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Não há alunos cadastrados, tente novamente depois!");
                            break;
                        } else {
                            boolean alunoEncontrado = false;
                            Aluno alunoEdit = new Aluno();
                            String status;
                            String matricula = JOptionPane.showInputDialog("Digite a matricula do aluno:");
                            for (Aluno aluno : listAlunos) {
                                if (aluno.getMatricula().equals(matricula)) {
                                    alunoEncontrado = true;
                                    alunoEdit = aluno;
                                }
                            }
                            if (!alunoEncontrado) {
                                throw new Exception("Aluno não encontrado");
                            }

                            double[] notas = new double[3];
                            for (int i = 0; i < notas.length; i++) {
                                notas[i] = Double.parseDouble(
                                        JOptionPane.showInputDialog("Digite a nota " + (i + 1) + " do aluno:"));
                            }
                            alunoEdit.setNotas(notas);
                            double mediaAluno = alunoEdit.calcularMedia();
                            String situacaoAluno = alunoEdit.avaliaDesempenho();
                            JOptionPane.showMessageDialog(null, "Notas enviadas com sucesso!");
                            JOptionPane.showMessageDialog(null,
                                    "Média do aluno: " + mediaAluno + "\nSituação: " + situacaoAluno);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "3":
                    if (listAlunos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
                    } else {
                        StringBuilder mediasInfo = new StringBuilder("Média dos alunos:\n");
                        for (Aluno aluno : listAlunos) {
                            mediasInfo.append(aluno.exibirInformacoesMedia()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mediasInfo.toString());
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (!operacao.equals("4"));
    }
}
