package com.company;

public interface AnimalCare {
    public Integer howManyAnimalsIsThere();
    public void freePlaceForAnimal();
    public boolean isFreePlaceForAnimals(Integer howManyNeddedForAnimals);
    public void animalsFeeding();
    public void animalsNotFeeding();
    public void removesDeadAnimal();
    public void add(Animal animal);
    public void remove(Animal animal);
}
