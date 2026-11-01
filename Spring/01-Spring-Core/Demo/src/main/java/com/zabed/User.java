package com.zabed;

import org.springframework.stereotype.Component;

//@Component  // here @Component fails, means spring cant make an object of this class bcz of what to pass in the constructor its not aware of this
// so how to solve this problem !? check AppConfig.java ....
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
