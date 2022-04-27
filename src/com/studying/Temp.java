package com.studying;

import java.util.Calendar;

public class Temp {
    public double temp_max;
    public double temp_min;
    public double feels_like;
    public double temp;

    public void getTemp(){
        System.out.println(temp_max + " " + temp_min + " " + feels_like);
    }

    public void getTime(){
        Calendar calendar = Calendar.getInstance();
        String current;
    }
}
