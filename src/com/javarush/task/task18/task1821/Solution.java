package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] repeatNumber = new int[256];

        while (fileInputStream.available() > 0) {
            repeatNumber[fileInputStream.read()]++;
        }

        for (int i = 0; i < repeatNumber.length; i++) {
            if (repeatNumber[i] > 0) {
                System.out.println((char) i + " " + repeatNumber[i]);
            }
        }
        fileInputStream.close();
    }
}
