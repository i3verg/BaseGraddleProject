package com.base.ch4.profiling;

public class Food {

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\'' + '}';
    }
}
