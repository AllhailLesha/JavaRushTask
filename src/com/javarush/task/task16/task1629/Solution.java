package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();


        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{
        public String str = "";


        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    str += reader.readLine() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void printResult() {
            System.out.println(str);
        }
    }
}
