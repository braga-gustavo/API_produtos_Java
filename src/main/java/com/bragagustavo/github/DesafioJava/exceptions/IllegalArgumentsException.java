package com.bragagustavo.github.DesafioJava.exceptions;

public class IllegalArgumentsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IllegalArgumentsException(String message){
        super(message);

    }

    public IllegalArgumentsException(String message, Throwable cause){
        super(message, cause);

    }



}
