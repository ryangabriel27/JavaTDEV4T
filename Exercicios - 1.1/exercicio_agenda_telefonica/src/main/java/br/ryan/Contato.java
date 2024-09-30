package br.ryan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    // Atributos
    private String nome;
    private String telefone;

    public String toString() {
        return "Nome: " + nome + " - Telefone: " + telefone;
    }

}
