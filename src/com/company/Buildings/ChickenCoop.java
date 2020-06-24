package com.company.Buildings;

import com.company.Animal;
import com.company.AnimalCare;

public class ChickenCoop extends Building implements AnimalCare {

    public Animal chickens[];
    public Integer numberOfAnimals=0;
    public Integer placesForChickens;


    public Integer freePlaceForChicken;

    public Integer chickenEggAmount=0; // in number of single eggs.

    public ChickenCoop(String name, String description, Double value, Integer placesForChickens) {
        super(name, description, value);
        chickens = new Animal[placesForChickens];
        this.placesForChickens = placesForChickens;
    }


    // -----------------------------------------------   ANIMALS CARE -------------------------------------------
    @Override
    public Integer howManyAnimalsIsThere(){
        Integer number=0;
        for(Animal animal : chickens){
            if(animal != null){
                number += 1;
            }
        }
        numberOfAnimals=number;
        return numberOfAnimals;
    }
    @Override
    public void freePlaceForAnimal() {
        for (Integer i = 0; i < this.chickens.length; i++) {
            if (chickens[i] == null)
            {
                this.freePlaceForChicken =i;
                break;
            }
        }
    }
    @Override
    public boolean isFreePlaceForAnimals(Integer howManyNeededForAnimals){
        Integer freePlace=0;
        for (Integer i = 0; i < this.chickens.length; i++) {
            if (chickens[i] == null)
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
        for(Animal chicken : chickens){
            chicken.feed();
        }
    }
    @Override
    public void animalsNotFeeding(){
        for(Animal chicken : chickens){
            chicken.looseWeight();
        }
    }
    @Override
    public void removesDeadAnimal(){
        for(Animal chicken : chickens){
            if(!chicken.isAlive()){
                remove(chicken);
            }
        }

    }

    public void Egging(){
        for(Animal a : chickens){
            if(a.isAdult()) {
                chickenEggAmount += 30;
            }
            else{
                System.out.println("This chicken: " +a.toString() + " is too young to give eggs.");
            }
        }

    }
    @Override
    public void add(Animal chicken){
        freePlaceForAnimal();
        if( freePlaceForChicken == null){
            System.out.println("You don't have space for this chicken.");
        }
        else{
            this.chickens[freePlaceForChicken] = chicken;
            freePlaceForChicken = null;
            System.out.println( "You add to your chicken coop new chicken. " );
        }
    }
    @Override
    public void remove(Animal chicken){
        for (Integer i = 0; i < this.chickens.length; i++) {
            if (chickens[i] == chicken)
            {
                chickens[i]=null;
                System.out.println("Chicken removed from your chicken coop.");
            }
        }
    }
    @Override
    public String toString(){
        return "Chicken coop name: "+ this.name + "  Chicken coop description: "+ this.description + " Chicken coop value: " +this.value +
                " \nNumber of places for chicken: " + this.placesForChickens + " Number of chickens now:  " + this.numberOfAnimals;
    }
}
