package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // запускаем поток ввода
            String string;
            while(!(string = reader.readLine()).equalsIgnoreCase("exit")) {
                if(string.matches("-?\\d+[.]\\d+")) { // "если есть минус, есть точка и любое количество символов
                    print(Double.parseDouble(string));
                } else if(string.matches("-?\\d+")) { // есть минус и любое количество символов
                    int numInt = Integer.parseInt(string);

                    if(numInt > 0 && numInt < 128) {
                        print((short) numInt);
                    } else {
                        print(numInt);
                    }
                } else {
                    print(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
