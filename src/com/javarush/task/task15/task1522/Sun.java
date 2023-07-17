package com.javarush.task.task15.task1522;

public class Sun implements Planet{

    private static Sun instance;

    private Sun(){}


    public static Sun getInstance() {
        if(instance == null) { // если объект еще не создан
            instance = new Sun(); // создаем новый объект
        }
        return instance; // возвращаем объект или ново-созданный или ранее созданный
    }
}
