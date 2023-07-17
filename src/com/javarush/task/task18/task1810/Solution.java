package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream firstFile = new FileInputStream(reader.readLine());
            byte[] byteFirst = new byte[firstFile.available()];
            int count = firstFile.read(byteFirst);
            while (count >= 1000) {
                firstFile = new FileInputStream(reader.readLine());
                byteFirst = new byte[firstFile.available()];
                count = firstFile.read(byteFirst);
            }
            firstFile.close();
            throw new DownloadException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
