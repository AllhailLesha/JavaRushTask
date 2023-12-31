package com.javarush.task.task15.task1522;

public class Moon implements Planet{

    private static Moon instance;

    private Moon(){}


    public static Moon getInstance() {
        if(instance == null) { // если объект еще не создан
            instance = new Moon(); // создаем новый объект
        }
        return instance; // возвращаем объект или ново-созданный или ранее созданный
    }
}
