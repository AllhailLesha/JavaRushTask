package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!line.equals("exit")) {
             new ReadThread(line).start();
            line = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                int[] bytes = new int[256];

                while (fileInputStream.available() > 0) {
                    bytes[fileInputStream.read()]++;
                }

                int count = 0;
                int maxRepeat = 0;

                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > maxRepeat) {
                        maxRepeat = bytes[i];
                        count = i;
                    }
                }
                resultMap.put(fileName, count);

            } catch (Exception  e) {
                e.printStackTrace();
            }
        }
    }
}
