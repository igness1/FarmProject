package com.company.Buildings;

import com.company.Animal;
import com.company.AnimalCare;

public class RabbitCoop extends Building implements AnimalCare {

    public Animal rabbits[];

    public Integer freePlaceForRabbit;
    public Integer numberOfAnimals=0;
    public Integer placesForRabbits;

    public Double rabbitMeatAmount=0.0; // in kg.

    public RabbitCoop(String name, String description, Double value, Integer placesForRabbits) {
        super(name, description, value);
        this.rabbits = new Animal[placesForRabbits];
        this.placesForRabbits = placesForRabbits;
    }


    // -----------------------------------------------   ANIMALS CARE -------------------------------------------
    @Override
    public Integer howManyAnimalsIsThere(){
        Integer number=0;
        for(Animal animal : rabbits){
            if(animal != null){
                number += 1;
            }
        }
        numberOfAnimals=number;
        return numberOfAnimals;
    }
    @Override
    public void freePlaceForAnimal() {
        for (Integer i = 0; i < this.rabbits.length; i++) {
            if (rabbits[i] == null)
            {
                this.freePlaceForRabbit =i;
                break;
            }
        }
    }
    @Override
    public boolean isFreePlaceForAnimals(Integer howManyNeededForAnimals){
        Integer freePlace=0;
        for (Integer i = 0; i < this.rabbits.length; i++) {
            if (rabbits[i] == null)
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
        for(Animal rabbit : rabbits){
            if(rabbit != null) {
                rabbit.feed();
            }
        }
    }
    @Override
    public void animalGrowingOrNot(){
        for(Animal rabbit : rabbits){
            if(rabbit != null) {
                rabbit.grow();
            }
        }
    }
    @Override
    public void removesDeadAnimal(){
        for(Animal rabbit : rabbits){
            if(rabbit != null) {
                if (!rabbit.isAlive()) {
                    remove(rabbit);
                }
            }
        }

    }

    public void killRabbitAndMakeMeat(){
        for(Animal a : rabbits){
            if(a != null) {
                if (a.isAdult()) {
                    rabbitMeatAmount += 4.0;
                    remove(a);
                } else {
                    System.out.println("This rabbit: " + a.toString() + " is too young to kill it for meat.");
                }
            }
        }
    }
    @Override
    public void add(Animal rabbit){
        freePlaceForAnimal();
        if( freePlaceForRabbit == null){
            System.out.println("You don't have space for this rabbit.");
        }
        else{
            this.rabbits[freePlaceForRabbit] = rabbit;
            freePlaceForRabbit = null;
            System.out.println( "You add to your rabbit coop new rabbit. " );
        }
    }
    @Override
    public void remove(Animal rabbit){
        for (Integer i = 0; i < this.rabbits.length; i++) {
            if (rabbits[i] == rabbit)
            {
                rabbits[i]=null;
                System.out.println("Rabbit removed from your rabbit coop.");
            }
        }
    }
    @Override
    public String toString(){
        howManyAnimalsIsThere();
        return "Rabbit coop name: "+ this.name + "  | Rabbit coop description: "+ this.description + " | Rabbit coop value: " +this.value +
                " \nNumber of places for rabbits: " + this.placesForRabbits + " | Number of rabbits now:  " + this.numberOfAnimals;
    }
}
