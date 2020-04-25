package com.naveen.basicjava.Friend;

import com.naveen.basicjava.hobby.Hobby;

import java.io.Serializable;

public class Friend implements Serializable {
   private String name;
   private int age;
   private Hobby[] hobbies;

   public Friend(String name, int age, Hobby[] hobbies){
       this.name=name;
       this.age=age;
       this.hobbies=hobbies;
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hobby[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobby[] hobbies) {
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
