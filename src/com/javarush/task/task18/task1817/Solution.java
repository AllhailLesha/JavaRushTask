package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[256];

        while (fileInputStream.available() > 0) {
            bytes[fileInputStream.read()]++;
        }

        int qualitySpace = 0;
        int qualityAllChar = 0;

        for (int i = 0; i < bytes.length; i++) {
            if (i == 32) {
                qualitySpace += bytes[i];
            }
            qualityAllChar += bytes[i];
        }

        double result = (double) qualitySpace / qualityAllChar * 100;
        System.out.printf("%.2f", result);

        fileInputStream.close();
    }
}
