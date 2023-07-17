package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFilePath = reader.readLine();
        String secondFilePath = reader.readLine();
        reader.close();

        List<Integer> integerList = getIntegerList(firstFilePath);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secondFilePath, true))) {
            for (Integer num : integerList) {
                bufferedWriter.write(num + " ");
            }
        }
    }

    public static List<Integer> getIntegerList(String firstFilePath) throws IOException {
        List<Integer> integerList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFilePath))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    if (number.contains(".") || number.contains(",")) {
                        double roundNum = Double.parseDouble(number);
                        integerList.add((int) Math.round(roundNum));
                    } else {
                        integerList.add(Integer.parseInt(number));
                    }
                }
            }
        }
        return integerList;
    }
}
