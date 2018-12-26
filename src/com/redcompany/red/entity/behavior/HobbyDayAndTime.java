package com.redcompany.red.entity.behavior;

public class HobbyDayAndTime {

    private String day;
    private String time;


    public HobbyDayAndTime() {
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HobbyDayAndTime{" +
                "day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
