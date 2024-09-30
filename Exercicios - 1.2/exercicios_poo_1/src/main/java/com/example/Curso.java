package com.example;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String exibirInformacoes() {
        return "Nome do curso: " + nome + " -  Quantidade de alunos: " + alunos.size() + " - Professor: "
                + professor.getNome();
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(
                    "Aluno: " + aluno.getNome() + "- CPF: " + aluno.getCpf() + " - Matricula: " + aluno.getMatricula());
        }
    }
}
