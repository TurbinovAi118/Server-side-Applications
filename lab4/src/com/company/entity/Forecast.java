package com.company.entity;

public class Forecast {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minTemp;
    private int maxTemp;

    public Forecast(int day, int month, int year, int hour, int minTemp, int maxTemp) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "Forecast {" +
                day +
                "/" + month +
                "/" + year +
                ", " + hour +
                ":00 -> min = " + minTemp +
                ", max = " + maxTemp +
                '}';
    }
}
