package com.teachmeskills.lesson14.validator;

import com.teachmeskills.lesson14.consts.FormatConsts;
import com.teachmeskills.lesson14.consts.PathConsts;
import com.teachmeskills.lesson14.custom_exceptions.WrongContractException;
import com.teachmeskills.lesson14.custom_exceptions.WrongDocumentNumberException;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.teachmeskills.lesson14.service.FileErrorWriteService.writerErrorLogFile;
import static com.teachmeskills.lesson14.service.FileWriterService.*;

public class DocumentNumberValidator {
    public static boolean fileTypeDocumentCheck(String line) throws WrongDocumentNumberException, WrongContractException {

        if (line.startsWith(FormatConsts.DOCUMENT_SUBSEQUENCE)){
            formatDocumentCheck(line);
            System.out.println("Document true " + line);
        }else if (line.startsWith(FormatConsts.CONTRACT_SUBSEQUENCE)){
            formatContractCheck(line);
            System.out.println("CONTRACT true " + line);
        }else {
            writerInvalidDocumentFile(line,PathConsts.INVALID_PATH_DOCUMENT_NUMBER);
            System.out.println("Invalid - " + line);
        }
        return false;
    }

    private static boolean formatDocumentCheck(String line) throws WrongDocumentNumberException {
        if(line.contains(FormatConsts.DOCUMENT_SUBSEQUENCE) & line.length() <= FormatConsts.DOCUMENT_LENGTH){
            writerValidDocumentFile(line,PathConsts.VALID_PATH_DOCUMENT);
            return true;
        }else {
            Calendar calendar = new GregorianCalendar();
            Date date = calendar.getTime();
            writerErrorLogFile(line,"Document не валид, длинная больше 15 символов - "+ date,PathConsts.PATH_ERROR_LOG);
            throw new WrongDocumentNumberException("Document не валид");
        }
    }

    private static boolean formatContractCheck(String line) throws WrongContractException {
        if (line.contains(FormatConsts.CONTRACT_SUBSEQUENCE) & line.length() <= FormatConsts.DOCUMENT_LENGTH) {
            writerValidContractFile(line,PathConsts.VALID_PATH_CONTRACT);
            return true;
        }else {
            Calendar calendar = new GregorianCalendar();
            Date date = calendar.getTime();
            writerErrorLogFile(line,"CONTRACT не валид, длинная больше 15 символов - "+ date,PathConsts.PATH_ERROR_LOG);
            throw new WrongContractException("CONTRACT не валид");
        }
    }
}
