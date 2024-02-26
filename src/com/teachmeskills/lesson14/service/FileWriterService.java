package com.teachmeskills.lesson14.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
    public static void writerValidDocumentFile(String line, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            writer.write(line+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writerValidContractFile(String line, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            writer.write(line+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writerInvalidDocumentFile(String line, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            writer.write(line+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
