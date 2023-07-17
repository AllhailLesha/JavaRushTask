package com.javarush.task.task17.task1714;

/* 
Comparable
*/



public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int quality = Integer.compare(this.quality, o.quality); // есл первыйй больше втрого -> 1 если меньше -> -1 если равны -> 0
        float distance = Float.compare(this.distance, o.distance);
        return (int) (quality - distance);
    }
}
