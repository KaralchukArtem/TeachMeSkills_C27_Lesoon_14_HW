package com.teachmeskills.lesson14.custom_exceptions;

public class WrongDocumentNumberException extends Exception{
    public WrongDocumentNumberException(){}
    public WrongDocumentNumberException(String message){super(message);}
}
