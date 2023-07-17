package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());

        byte[] byteFile = new byte[256];

        while (fileInput.available() > 0) {
            byteFile[fileInput.read()]++;
        }

        System.out.println(byteFile[44]);

        reader.close();
        fileInput.close();
    }
}
