package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if ((args.length == 4) && args[0].equalsIgnoreCase("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            int maxId = 0;
            while (bufferedReader.ready()) {
                int tempId = getLastId(bufferedReader.readLine());
                if (tempId > maxId) {
                    maxId = tempId;
                }
            }

            String id = String.format("%-8d", ++maxId);
            String name = String.format("%-30s", args[1]);
            String price = String.format("%-8s", args[2]);
            String quantity = String.format("%-4s", args[3]);

            FileWriter writer = new FileWriter(fileName, true);

            writer.write("\n" + id + name + price + quantity);
            reader.close();
            bufferedReader.close();
            writer.close();
        }
    }

    public static int getLastId(String line) {
        String id = line.substring(0, 8).trim();
        return Integer.parseInt(id);
    }
}
