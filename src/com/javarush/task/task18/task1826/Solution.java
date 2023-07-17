package com.javarush.task.task18.task1826;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws Throwable {
        FileInputStream fileInput = new FileInputStream(args[1]);
        FileOutputStream fileOutput = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
                encryptFile(fileInput, fileOutput);
                break;
            case "-d":
                decryptFile(fileInput, fileOutput);
                break;
        }

        fileInput.close();
        fileOutput.close();
    }

    private static void encryptFile(FileInputStream fileInput, FileOutputStream fileOutput) throws Throwable {
        while (fileInput.available() > 0) {
            fileOutput.write(fileInput.read() + 1);
        }
    }

    private static void decryptFile(FileInputStream fileInput, FileOutputStream fileOutput) throws Throwable {
        while (fileInput.available() > 0) {
            fileOutput.write(fileInput.read() - 1);
        }
    }
}
