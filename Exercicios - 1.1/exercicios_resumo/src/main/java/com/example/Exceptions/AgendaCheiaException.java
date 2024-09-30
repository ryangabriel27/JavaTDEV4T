package com.example.Exceptions;

public class AgendaCheiaException extends RuntimeException {
    public AgendaCheiaException() {
        super("A agenda está cheia. Não é possível adicionar mais contatos.");
    }
}
