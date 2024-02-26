package com.teachmeskills.lesson14.service;

import com.teachmeskills.lesson14.consts.PathConsts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileErrorWriteService {

    public static void writerErrorLogFile(String a, String path) {
        try (BufferedWriter writerError = new BufferedWriter(new FileWriter(path, true))) {
            char[] strCharArray = a.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c: strCharArray){
                if (c == '[') {
                    builder.append("\n");
                }
                if (c != ','){
                    builder.append(c);
                }else {
                    builder.append("\n");
                }
            }
            writerError.write(builder + "\n");
            writerExecutionLogFile(builder.toString(), PathConsts.PATH_EXECUTION_LOG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writerErrorLogFile(String line, String a, String path) {
        try (BufferedWriter writerError = new BufferedWriter(new FileWriter(path, true))) {
            writerError.write( a + " - " + line + "\n");
            writerExecutionLogFile(line, a, PathConsts.PATH_EXECUTION_LOG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writerExecutionLogFile(String a, String path) {
        try (BufferedWriter writerExecution = new BufferedWriter(new FileWriter(path, true))) {
            writerExecution.write(a + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writerExecutionLogFile(String line, String a, String path) {
        try (BufferedWriter writerExecution = new BufferedWriter(new FileWriter(path, true))) {
            writerExecution.write(a + " - " + line + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
