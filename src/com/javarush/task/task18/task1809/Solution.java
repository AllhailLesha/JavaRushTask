package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());
        FileOutputStream fileOutput = new FileOutputStream(reader.readLine());

        byte[] byteFirstFile = new byte[fileInput.available()];
        int count = fileInput.read(byteFirstFile);

        for (int i = count - 1; i >= 0 ; i--) {
            fileOutput.write(byteFirstFile[i]);
        }


        fileOutput.close();
        fileInput.close();
    }
}
