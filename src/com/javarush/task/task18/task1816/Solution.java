package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[256];
        while (fileInputStream.available() > 0) {
            bytes[fileInputStream.read()]++;
        }

        int count = 0;

        for (int i = 65; i <= 90; i++) {
            count += bytes[i];
        }

        for (int i = 97; i <= 122; i++) {
            count += bytes[i];
        }

        System.out.println(count);

        fileInputStream.close();
    }
}
