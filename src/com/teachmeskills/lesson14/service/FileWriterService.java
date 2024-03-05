package com.teachmeskills.lesson14.service;

import com.teachmeskills.lesson14.consts.PathConsts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
    public static void writerValidDocumentFile(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PathConsts.VALID_PATH_DOCUMENT, true))) {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }

    public static void writerValidContractFile(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PathConsts.VALID_PATH_CONTRACT, true))) {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }

    public static void writerInvalidDocumentFile(String line, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }
}
