package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int minValue = Integer.MAX_VALUE;

        while ((fileInputStream.available()) > 0) {
            int tempByte = fileInputStream.read();
            if (tempByte < minValue) {
                minValue = tempByte;
            }
        }
        System.out.println(minValue);

        reader.close();
        fileInputStream.close();
    }
}
