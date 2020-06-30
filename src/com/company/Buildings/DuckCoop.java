package com.company.Buildings;

import com.company.Animal;
import com.company.AnimalCare;

public class DuckCoop extends Building implements AnimalCare {

    public Animal ducks[];
    public Integer numberOfAnimals=0;

    public Integer freePlaceForDuck;
    public Integer placesForDucks;

    public Integer duckEggAmount=0; // in number of single eggs.

    public DuckCoop(String name, String description, Double value, Integer howMuchPlaceForDucks) {
        super(name, description, value);
        this.ducks = new Animal[howMuchPlaceForDucks];
        this.placesForDucks = howMuchPlaceForDucks;
    }

    // -----------------------------------------------   ANIMALS CARE -------------------------------------------
    @Override
    public Integer howManyAnimalsIsThere(){
        Integer number=0;
        for(Animal animal : ducks){
            if(animal != null){
                number += 1;
            }
        }
        numberOfAnimals=number;
        return numberOfAnimals;
    }
    @Override
    public void freePlaceForAnimal() {
        for (Integer i = 0; i < this.ducks.length; i++) {
            if (ducks[i] == null)
            {
                this.freePlaceForDuck =i;
                break;
            }
        }
    }
    @Override
    public boolean isFreePlaceForAnimals(Integer howManyNeededForAnimals){
        Integer freePlace=0;
        for (Integer i = 0; i < this.ducks.length; i++) {
            if (ducks[i] == null)
            {
                freePlace += 1;
            }
        }
        if(freePlace>=howManyNeededForAnimals){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void animalsFeeding(){
        for(Animal duck : ducks){
            if(duck != null) {
                duck.feed();
            }
        }
    }
    @Override
    public void animalGrowingOrNot(){
        for(Animal duck : ducks){
            if(duck != null) {
                duck.grow();
            }
        }
    }
    @Override
    public void removesDeadAnimal(){
        for(Animal duck : ducks){
            if(duck != null) {
                if (!duck.isAlive()) {
                    remove(duck);
                }
            }
        }

    }

    public void Egging(){
        for(Animal a : ducks){
            if(a != null) {
                if (a.isAdult()) {
                    duckEggAmount += 30;
                } else {
                    System.out.println("This duck: " + a.toString() + " is too young to give eggs.");
                }
            }
        }

    }
    @Override
    public void add(Animal animal){
        freePlaceForAnimal();
        if( freePlaceForDuck == null){
            System.out.println("You don't have space for this duck.");
        }
        else{
            this.ducks[freePlaceForDuck] = animal;
            freePlaceForDuck = null;
            System.out.println( "You add to your duck coop new duck. " );
        }
    }
    @Override
    public void remove(Animal animal){
        for (Integer i = 0; i < this.ducks.length; i++) {
            if (ducks[i] == animal)
            {
                ducks[i]=null;
                System.out.println("Duck removed from your duck coop.");
            }
        }
    }

    @Override
    public String toString(){
        howManyAnimalsIsThere();
        return "Duck coop name: "+ this.name + "  | Duck coop description: "+ this.description + " | Duck coop value: " +this.value +
                " \nNumber of places for ducks: " + this.placesForDucks + " | Number of ducks now:  " + this.numberOfAnimals;
    }
}
