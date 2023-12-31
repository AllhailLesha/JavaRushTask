package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean counter = true;

        while (counter) {
            String fileName = reader.readLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
        reader.close();
    }
}
