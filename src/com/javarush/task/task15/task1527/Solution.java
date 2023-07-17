package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        URL uri = new URL(url);

        String[] pairs = uri.getQuery().split("&");

        for (String pair : pairs) {
            String[] elements = pair.split("=.+");
            for (String result : elements) {
                System.out.println(result + " ");
            }
        }

        for (String pair : pairs) {
            if (pair.contains("obj")) {
                System.out.println();
                try {
                    alert(Double.parseDouble(pair.substring(pair.indexOf("=") + 1)));
                } catch (Exception e) {
                    alert(pair.substring(pair.indexOf("=") + 1));
                }
            }
        }


    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.print("String: " + value);
    }
}
