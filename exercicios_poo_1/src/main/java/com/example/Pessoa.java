package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    private String nome;
    private String cpf;

    public String exibirInformacoes() {
        return "Nome: " + nome + "Cpf: " + cpf;
    }
}
