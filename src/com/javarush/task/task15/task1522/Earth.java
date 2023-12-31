package com.javarush.task.task15.task1522;


public class Earth implements Planet {
    private static Earth instance;

    private Earth(){}


    public static Earth getInstance() {
        if(instance == null) { // если объект еще не создан
            instance = new Earth(); // создаем новый объект
        }
        return instance; // возвращаем объект или ново-созданный или ранее созданный
    }
}

