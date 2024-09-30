package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import org.json.JSONArray;

public class LeituraTexto {

    String inputFile = "arquivo.txt";
    List<Aluno> alunos = new ArrayList<>();
    double somaTotal = 0;
    int totalAlunos = 0;

    public void app() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if(partes.length < 2){
                    System.out.println("Linha com formato incorreto");
                }
                String nome = partes[0];
                double somaNotas = 0;
                int numeroNotas = 0;
                try{
                    for (int i = 1; i < partes.length; i++) {
                        somaNotas += Double.parseDouble(partes[i]);
                        numeroNotas++;
                    }
                } catch (NumberFormatException e){
                    somaNotas += 0;
                }
                
                double media = somaNotas / numeroNotas;

                Aluno aluno = new Aluno(nome, media);
                alunos.add(aluno);
                somaTotal += media;
                totalAlunos++;
            }

            Aluno alunoMaiorNota = alunos.get(0);
            Aluno alunoMenorNota = alunos.get(0);
            for (Aluno aluno : alunos) {
                if(aluno.getMedia() > alunoMaiorNota.getMedia()){
                    alunoMaiorNota = aluno;
                }
                if(aluno.getMedia() < alunoMenorNota.getMedia()){
                    alunoMenorNota = aluno;
                }
            }


            double mediaGeralTurma = somaTotal/totalAlunos;

            System.out.println(alunoMaiorNota.getNome()+" teve a maior nota :"+ alunoMaiorNota.getMedia());
            System.out.println(alunoMenorNota.getNome()+" teve a menor nota :"+ alunoMenorNota.getMedia());
            System.out.println("Média geral da turma:"+ mediaGeralTurma);
        } catch (Exception e) {

        }

    }
}
