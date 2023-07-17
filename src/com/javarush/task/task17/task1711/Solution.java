package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch  (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) {
                        createPerson(args[i], args[i+1], args[i+2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        updatePerson(args[i], args[i+1], args[i+2], args[i+3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        removePerson(args[i]);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        printPerson(args[i]);
                    }
                    break;
                }
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

    public static void updatePerson(String id, String name, String sex, String date) throws ParseException {
        Date bd = dateFormat.parse(date);
        allPeople.get(Integer.parseInt(id)).setName(name);
        allPeople.get(Integer.parseInt(id)).setBirthDate(bd);
        if (sex.equalsIgnoreCase("м")) {
            allPeople.get(Integer.parseInt(id)).setSex(Sex.MALE);
        } else if (sex.equalsIgnoreCase("ж")) {
            allPeople.get(Integer.parseInt(id)).setSex(Sex.FEMALE);
        }
    }

    public static void removePerson(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        allPeople.set(Integer.parseInt(id), person);
    }

    public static void printPerson(String id) {
        SimpleDateFormat dateFormatMMM = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.print(person.getName() + " ");
        if (person.getSex().equals(Sex.MALE)) {
            System.out.print("м ");
        } else if (person.getSex().equals(Sex.FEMALE)) {
            System.out.print("ж ");
        }
        System.out.println(dateFormatMMM.format(person.getBirthDate()));
    }
}
