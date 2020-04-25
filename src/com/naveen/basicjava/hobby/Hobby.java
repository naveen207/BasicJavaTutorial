package com.naveen.basicjava.hobby;

import java.io.Serializable;

public class Hobby implements Serializable {
    private String name;
    private String location;

    public Hobby(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

