package com.example.Exceptions;

public class FalhaDeArquivoException extends RuntimeException {
    public FalhaDeArquivoException(String mensagem) {
        super(mensagem);
    }
}