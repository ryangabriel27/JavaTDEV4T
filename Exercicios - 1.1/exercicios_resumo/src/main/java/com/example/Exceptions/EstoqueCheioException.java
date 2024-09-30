package com.example.Exceptions;

public class EstoqueCheioException extends RuntimeException {
    public EstoqueCheioException() {
        super("O estoque está cheio. Não é possível adicionar mais itens.");
    }
}