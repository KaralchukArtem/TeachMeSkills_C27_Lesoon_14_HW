package com.teachmeskills.lesson14.service;

import com.teachmeskills.lesson14.consts.PathConsts;
import com.teachmeskills.lesson14.custom_exceptions.WrongContractException;
import com.teachmeskills.lesson14.custom_exceptions.WrongDocumentNumberException;

import java.io.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.teachmeskills.lesson14.service.FileErrorWriteService.writerErrorLogFile;
import static com.teachmeskills.lesson14.validator.DocumentNumberValidator.fileTypeDocumentCheck;

public class FileReaderService {

    public static void ReadFile() throws WrongContractException, WrongDocumentNumberException {

        try (BufferedReader reader = new BufferedReader(new FileReader(PathConsts.DEFAULT_PATH_DOCUMENT_NUMBERS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileTypeDocumentCheck(line);
            }
        } catch (FileNotFoundException e) {
            Calendar calendar = new GregorianCalendar();
            Date date = calendar.getTime();
            writerErrorLogFile(date + Arrays.toString(e.getStackTrace()) + "\n", PathConsts.PATH_ERROR_LOG);
            System.out.println("Путь указанный к файлу не найден");
        } catch (IOException e) {

            System.out.println("Случилось что-то ещё, обратитесь пожалуйста в тех.поддержку");
        }
    }
}
