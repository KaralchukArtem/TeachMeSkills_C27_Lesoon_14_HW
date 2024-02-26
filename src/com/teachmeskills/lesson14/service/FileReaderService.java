package com.teachmeskills.lesson14.service;

import com.teachmeskills.lesson14.consts.PathConsts;
import com.teachmeskills.lesson14.custom_exceptions.WrongContractException;
import com.teachmeskills.lesson14.custom_exceptions.WrongDocumentNumberException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.teachmeskills.lesson14.validator.DocumentNumberValidator.fileTypeDocumentCheck;

public class FileReaderService {

    public static void ReadFile() throws WrongContractException, WrongDocumentNumberException {

        try(BufferedReader reader = new BufferedReader(new FileReader(PathConsts.DEFAULT_PATH_DOCUMENT_NUMBERS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileTypeDocumentCheck(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Путь указанный к файлу не найден");
        } catch (IOException e) {
            System.out.println("Случилось что-то ещё, обратитесь пожалуйста в тех.поддержку");
        }
    }
}
