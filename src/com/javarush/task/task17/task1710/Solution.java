package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                createPerson(args[1], args[2], args[3]);
                break;
            case "-r":
                printPerson(args[1]);
                break;
            case "-u":
                updatePerson(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                removePerson(args[1]);
                break;
        }
    }

    public static void createPerson(String name, String sex, String date) throws ParseException {
        Date bd = dateFormat.parse(date);
        if (sex.equalsIgnoreCase("м")) {
            allPeople.add(Person.createMale(name, bd));
        } else if (sex.equalsIgnoreCase("ж")) {
            allPeople.add(Person.createFemale(name, bd));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void printPerson(String id) {
        Date bd = allPeople.get(Integer.parseInt(id)).getBirthDate();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.print(allPeople.get(Integer.parseInt(id)).getName() + " ");
        System.out.print(allPeople.get(Integer.parseInt(id)).getSex() == Sex.MALE ? "м " : "ж");
        System.out.println(dateFormat1.format(bd));
    }

    public static void updatePerson(String id, String name, String sex, String date) throws ParseException {
        Date bd = dateFormat.parse(date);
        if (sex.equalsIgnoreCase("м")) {
            allPeople.set(Integer.parseInt(id), Person.createMale(name, bd));
        } else if (sex.equalsIgnoreCase("ж")) {
            allPeople.set(Integer.parseInt(id), Person.createFemale(name, bd));
        }
    }

    public static void removePerson(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setSex(null);
        person.setBirthDate(null);
        person.setName(null);
        allPeople.set(Integer.parseInt(id), person);
    }
}
