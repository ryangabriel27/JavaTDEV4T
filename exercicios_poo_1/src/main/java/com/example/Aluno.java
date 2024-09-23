package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa implements Avaliavel{
    private String matricula;
    private double[] notas = new double[3];

    @Override
    public String exibirInformacoes() {
        return "Nome: " + getNome() + " - CPF: " + getCpf() + "- Matricula: " + getMatricula();
    }

    public String exibirInformacoesMedia() {
        return "Nome: " + getNome() + " - CPF: " + getCpf() + "- Matricula: " + getMatricula() + "- Média: "
                + String.valueOf(calcularMedia());
    }

    public double calcularMedia() {
        double somaDasNotas = 0;
        for (int i = 0; i < notas.length; i++) {
            somaDasNotas += notas[i];
        }
        return somaDasNotas / notas.length;
    }

    @Override
    public void avaliaDesempenho() {
        double media = calcularMedia();
        if (media >= 7) {
            System.out.println("Aprovado!");
        } else if (media >=5 && media < 7){
            System.out.println("Recuperação!");
        } else {
            System.out.println("Reprovado!");
        }
    }
}
