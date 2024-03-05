package com.teachmeskills.lesson14.validator;

import com.teachmeskills.lesson14.consts.FormatConsts;
import com.teachmeskills.lesson14.consts.PathConsts;
import com.teachmeskills.lesson14.custom_exceptions.WrongContractException;
import com.teachmeskills.lesson14.custom_exceptions.WrongDocumentNumberException;

import java.util.Date;

import static com.teachmeskills.lesson14.service.FileErrorWriteService.writerErrorLogFile;
import static com.teachmeskills.lesson14.service.FileWriterService.*;

public class DocumentNumberValidator {
    public static boolean fileTypeDocumentCheck(String line) {
        if (line.startsWith(FormatConsts.DOCUMENT_SUBSEQUENCE)) {
            formatDocumentCheck(line);
        } else if (line.startsWith(FormatConsts.CONTRACT_SUBSEQUENCE)) {
            formatContractCheck(line);
        } else {
            writerInvalidDocumentFile(line, PathConsts.INVALID_PATH_DOCUMENT_NUMBER);
        }
        return false;
    }

    private static boolean formatDocumentCheck(String line) {
        if (line.matches(FormatConsts.DOCUMENT_REGEX)) {
            writerValidDocumentFile(line);
            return true;
        } else {
            System.out.println("Document не валид, длинная больше 15 символов");
            writerErrorLogFile(new Date(), " Document не валид, длинная больше 15 символов ", new WrongDocumentNumberException());
            return false;
        }
    }

    private static boolean formatContractCheck(String line) {
        if (line.matches(FormatConsts.CONTRACT_REGEX)) {
            writerValidContractFile(line);
            return true;
        } else {
            System.out.println("CONTRACT не валид, длинная больше 15 символов");
            writerErrorLogFile(new Date(), " CONTRACT не валид, длинная больше 15 символов ", new WrongContractException());
            return false;
        }
    }
}
