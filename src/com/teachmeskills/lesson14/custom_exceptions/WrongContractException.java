package com.teachmeskills.lesson14.custom_exceptions;

public class WrongContractException extends Exception {
    public WrongContractException(){}
    public WrongContractException(String message){super(message);}
}
