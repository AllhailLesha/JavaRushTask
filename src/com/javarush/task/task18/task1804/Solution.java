package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        
        int[] fileElements = new int[256];
        
        while (fileInputStream.available() > 0) {
            fileElements[fileInputStream.read()]++;
        }
        
        int min = Integer.MAX_VALUE;
        for (int byteElement : fileElements) {
            if (byteElement > 0 && byteElement < min) {
                min = byteElement;
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < fileElements.length; i++) {
            if (fileElements[i] == min) {
                resultList.add(i);
            }
        }
        for (Integer resultElement : resultList) {
            System.out.print(resultElement + " ");
        }

        reader.close();
        fileInputStream.close();
    }
}
