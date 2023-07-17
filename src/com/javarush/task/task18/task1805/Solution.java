package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Set<Integer> list = new TreeSet<>();

        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        for (int element : list ) {
            System.out.print(element + " ");
        }
        reader.close();
        fileInputStream.close();
    }
}
