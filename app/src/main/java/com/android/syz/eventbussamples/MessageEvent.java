package com.android.syz.eventbussamples;

/**
 * Created by syz on 2017/9/25 .
 */

public class MessageEvent {
    private String name;
    private int age;

    public MessageEvent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MessageEvent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
