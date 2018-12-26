package com.redcompany.red.entity.behavior;

public class Hobby {

    private String hobby_name;
    private String times_per_week;
    private Schema schema;


    public Hobby() {
        schema = new Schema();
    }

    public void setHobby_name(String hobby_name) {
        this.hobby_name = hobby_name;
    }

    public void setTimes_per_week(String times_per_week) {
        this.times_per_week = times_per_week;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby_name='" + hobby_name + '\'' +
                ", times_per_week=" + times_per_week +
                ", schema=" + schema +
                '}';
    }
}
