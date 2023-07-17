package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] product = line.split(" ");
                if (args[0].equals(product[0])) {
                    System.out.println(String.format("%d %s %.1f %d", Integer.parseInt(product[0]), product[1], Double.parseDouble(product[2]), Integer.parseInt(product[3])));
                }
            }
        }
    }
}
