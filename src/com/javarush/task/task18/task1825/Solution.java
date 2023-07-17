package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> files = fillingListWithFiles();
        String fileName = getFileName(files);
        File fileForWriting = getFileForWriting(fileName);
        fileForWriting.createNewFile();
        Collections.sort(files);

        FileOutputStream fileOutput = writesToFile(fileForWriting, files);
    }

    public static List<String> fillingListWithFiles() {
        List<String> files = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = null;
            while(!(fileName = reader.readLine()).equals("end")) {
                files.add(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    public static String getFileName(List<String> files) {
        return files.get(0);
    }

    public static File getFileForWriting(String fileName) {
        File fileForWriting = new File(fileName.substring(0, fileName.lastIndexOf(".")));
        return fileForWriting;
    }

    public static FileOutputStream writesToFile(File fileForWriting, List<String> files) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(fileForWriting);
        for (String file : files) {
            try (FileInputStream fileInput = new FileInputStream(file)) {
                byte[] buffer = new byte[fileInput.available()];
                fileInput.read(buffer);
                fileOutput.write(buffer);
            }
        }
        return fileOutput;
    }
}
