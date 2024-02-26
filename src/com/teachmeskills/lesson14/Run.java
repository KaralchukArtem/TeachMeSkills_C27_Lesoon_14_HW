package com.teachmeskills.lesson14;

import com.teachmeskills.lesson14.custom_exceptions.WrongContractException;
import com.teachmeskills.lesson14.custom_exceptions.WrongDocumentNumberException;
import com.teachmeskills.lesson14.service.FileReaderService;

public class Run {
    public static void main(String[] args) throws WrongContractException, WrongDocumentNumberException {
        FileReaderService.ReadFile();
    }
}