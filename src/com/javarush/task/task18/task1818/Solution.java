package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        FileReader firstFileReader = new FileReader(reader.readLine());
        FileReader secondFileReader = new FileReader(reader.readLine());

        while (firstFileReader.ready()) {
            fileWriter.write(firstFileReader.read());
        }
        firstFileReader.close();

        while (secondFileReader.ready()) {
            fileWriter.write(secondFileReader.read());
        }
        secondFileReader.close();
        fileWriter.close();
    }
}
