package com.example.slot713senddatabybundle;

import java.io.Serializable;

public class Student implements Serializable {
    private String hovaten;
    private String age;

    public Student(String hovaten, String age) {
        this.hovaten = hovaten;
        this.age = age;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
