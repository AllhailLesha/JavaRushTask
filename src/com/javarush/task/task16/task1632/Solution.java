package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
    }

    static {
        Thread threadOne = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread threadTwo = new ThreadTwo();
        Thread threadThree = new ThreadThree();
        Thread threadFour = new ThreadFour();
        Thread threadFive = new ThreadFive();

        threads.add(threadOne);
        threads.add(threadTwo);
        threads.add(threadThree);
        threads.add(threadFour);
        threads.add(threadFive);

    }

    public static class ThreadTwo extends Thread {

        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException interruptedException) {
                System.out.println("InterruptedException");
                interruptedException.printStackTrace();
            }
        }
    }

    public static class ThreadThree extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public static class ThreadFour extends Thread implements Message{
        private static boolean bool = true;

        @Override
        public void run() {
            while (bool) {

            }
        }

        public void showWarning() {
            bool = false;
        }
    }

    public static class ThreadFive extends Thread {

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            List<Integer> list = new ArrayList<>();
            String num = scanner.nextLine();
            int result = 0;

             if (num.matches("[-+]?\\d+")){
                while (!num.equalsIgnoreCase("N")) {
                    int tempNum = Integer.parseInt(num);
                    list.add(tempNum);
                    num = scanner.nextLine();
                }
                 for (int i = 0; i < list.size(); i++) {
                     result += list.get(i);
                 }
                 System.out.println(result);
            } else {
                 System.out.println(result);
             }
        }
    }
}