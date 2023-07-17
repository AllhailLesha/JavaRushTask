package com.javarush.task.task18.task1808;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream firstFileInput = new FileInputStream(reader.readLine());
        FileOutputStream secondFile = new FileOutputStream(reader.readLine());
        FileOutputStream thirdFile = new FileOutputStream(reader.readLine());

        byte[] byteFileInput = new byte[firstFileInput.available()];
        int countByte = firstFileInput.read(byteFileInput);

        if (countByte % 2 == 0) {
            secondFile.write(byteFileInput, 0, countByte / 2);
            thirdFile.write(byteFileInput, countByte / 2, countByte / 2);
        } else {
            secondFile.write(byteFileInput, 0, countByte / 2 + 1);
            thirdFile.write(byteFileInput, countByte / 2 + 1, countByte / 2);
        }


        reader.close();
        firstFileInput.close();
        secondFile.close();
        thirdFile.close();
    }
}
