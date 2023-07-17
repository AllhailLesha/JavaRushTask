package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        FileInputStream firstFileInputStream = new FileInputStream(firstFileName);
        byte[] firstBytes = new byte[firstFileInputStream.available()];
        firstFileInputStream.read(firstBytes);
        firstFileInputStream.close();

        FileInputStream secondFileInputStream = new FileInputStream(secondFileName);
        byte[] secondBytes = new byte[secondFileInputStream.available()];
        secondFileInputStream.read(secondBytes);
        secondFileInputStream.close();

        FileOutputStream firstWrite = new FileOutputStream(firstFileName);
        firstWrite.write(secondBytes);
        firstWrite.write(firstBytes);
        firstWrite.close();
    }
}
