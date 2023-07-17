package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int[] byteArray = new int[256];

        while (fileInputStream.available() > 0) {
            byteArray[fileInputStream.read()]++;
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] > maxValue) {
                maxValue = byteArray[i];
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] == maxValue) {
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
