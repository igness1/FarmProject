package com.company.Buildings;

public abstract class Building {

    public final String name;
    public final String description;
    public final Double value;



    public Building(String name, String description, Double value) {
        this.name = name;
        this.description = description;
        this.value = value;

    }

    public void sell(){

    }

}
