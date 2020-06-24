package com.company.Buildings;

import com.company.Animal;
import com.company.AnimalCare;
import com.company.Buildings.Building;

public class Barn extends Building implements AnimalCare {

    public Animal cows[];
    public Integer numberOfAnimals=0;

    public Integer freePlaceForCow;
    public Integer placesForCows;

    public Double milkAmount=0.0; // in liters

    public Barn(String name, String description, Double value, Integer placesForCows) {
        super(name, description, value);
        cows = new Animal[placesForCows];
        this.placesForCows = placesForCows;
    }

    // -----------------------------------------------   ANIMALS CARE -------------------------------------------
    @Override
    public void freePlaceForAnimal() {
        for (Integer i = 0; i < this.cows.length; i++) {
            if (cows[i] == null)
            {
                this.freePlaceForCow =i;
                break;
            }
        }
    }
    @Override
    public Integer howManyAnimalsIsThere(){
        Integer number=0;
        for(Animal animal : cows){
            if(animal != null){
                number += 1;
            }
        }
        numberOfAnimals=number;
        return numberOfAnimals;
    }
    @Override
    public boolean isFreePlaceForAnimals(Integer howManyNeededForAnimals){
        Integer freePlace=0;
        for (Integer i = 0; i < this.cows.length; i++) {
            if (cows[i] == null)
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
        for(Animal cow : cows){
            cow.feed();
        }
    }
    @Override
    public void animalsNotFeeding(){
        for(Animal cow: cows){
            cow.looseWeight();
        }
    }
    @Override
    public void removesDeadAnimal(){
        for(Animal cow :cows){
            if(!cow.isAlive()){
                remove(cow);
            }
        }

    }

    public void milkingCow(){
        for(Animal a : cows){
            if(a.isAdult()) {
                milkAmount += 10.0;
            }
            else{
                System.out.println("This cow: " +a.toString() + " is too young to milking.");
            }
        }

    }
    @Override
    public void add(Animal animal){
        freePlaceForAnimal();
        if( freePlaceForCow == null){
            System.out.println("You don't have space for this cow.");
        }
        else{
            this.cows[freePlaceForCow] = animal;
            freePlaceForCow = null;
            System.out.println( "You add to your barn new cow. " );
        }
    }
    @Override
    public void remove(Animal cow){
        for (Integer i = 0; i < this.cows.length; i++) {
            if (cows[i] == cow)
            {
                cows[i]=null;
                System.out.println("Cow removed from your barn");
            }
        }
    }

    @Override
    public String toString(){
        return "Barn name: "+ this.name + "  Barn description: "+ this.description + " Barn value: " +this.value +
                " \nNumber of places for cows: " + this.placesForCows + " Number of cows now:  " + this.numberOfAnimals;
    }
}
