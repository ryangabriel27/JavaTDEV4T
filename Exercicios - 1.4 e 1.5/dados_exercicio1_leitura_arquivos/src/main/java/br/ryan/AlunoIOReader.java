package br.ryan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AlunoIOReader {
    String arquivo = "C:\\Users\\DevTarde\\Documents\\RyanGabriel\\JavaTDEV4T\\dados_exercicio1_leitura_arquivos\\arquivo.txt";
    List<Aluno> alunos;
    double mediaTurma = 0;

    public AlunoIOReader() {
        super();
        alunos = new ArrayList<>();
        readerFileIO();
    }

    public void readerFileIO() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String[] conteudo = linha.split(",");
                Aluno aluno = new Aluno(conteudo[0], Double.parseDouble(conteudo[1]), Double.parseDouble(conteudo[2]),
                        Double.parseDouble(conteudo[3]));
                alunos.add(aluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double mediaAlunos() {
        for (Aluno aluno : alunos) {
            mediaTurma += aluno.mediaNotas();
        }
        mediaTurma /= alunos.size();
        return mediaTurma;
    }

    public String alunoMaiorNota() {
        double maiorNota = 0;
        String nomeAluno = "";
        for (Aluno aluno : alunos) {
            if (aluno.maiorNota() > maiorNota) {
                nomeAluno = aluno.getNome();
            }
        }
        return "Aluno com maior nota é: " + nomeAluno;
    }

    public String alunoMenorNota() {
        double menorNota = 10;
        String nomeAluno = "";
        for (Aluno aluno : alunos) {
            if (aluno.menorNota() < menorNota) {
                nomeAluno = aluno.getNome();
            }
        }
        return "Aluno com menor nota é: " + nomeAluno;
    }

    public void relatorioAlunos() {
        System.out.println("Alunos e médias:");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: "+aluno.getNome()+" - Média: "+aluno.mediaNotas());
        }
        System.out.println("\n ===================xx==============");
        System.out.println(alunoMaiorNota());
        System.out.println(alunoMenorNota());
    }
}
