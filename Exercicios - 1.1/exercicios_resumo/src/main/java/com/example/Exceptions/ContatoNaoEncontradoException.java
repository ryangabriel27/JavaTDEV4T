package com.example.Exceptions;

public class ContatoNaoEncontradoException extends RuntimeException {
    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}