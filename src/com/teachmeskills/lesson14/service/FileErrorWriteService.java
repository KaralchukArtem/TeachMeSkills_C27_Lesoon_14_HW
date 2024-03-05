package com.teachmeskills.lesson14.service;

import com.teachmeskills.lesson14.consts.PathConsts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileErrorWriteService {
    public static void writerErrorLogFile(Date date, String messageError, Exception exception) {
        try (BufferedWriter writerError = new BufferedWriter(new FileWriter(PathConsts.PATH_ERROR_LOG, true))) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateFormat = simpleDateFormat.format(date);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n[ERROR] -> " + dateFormat + " -> " + messageError + "\n");

            StackTraceElement[] stackTraceElements = exception.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                stringBuilder.append("\t\t\t" + element.toString());
                stringBuilder.append("\n");
            }

            writerError.write(stringBuilder.toString());
            writerExecutionLogFile(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }

    private static void writerExecutionLogFile(String messageError) {
        try (BufferedWriter writerExecution = new BufferedWriter(new FileWriter(PathConsts.PATH_EXECUTION_LOG, true))) {
            writerExecution.write(messageError);
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }
}
