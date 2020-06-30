package com.company;

public class Animal{
    final String species;

    protected Double currentWeight;
    protected Double weightWheAdult;
    protected Double weightNeededToDie;
    public String name;
    public boolean isFed=false;



    public static final Double DEFAULT_ADULT_COW_WEIGHT = 500.0;
    public static final Double DEFAULT_ADULT_CHICKEN_WEIGHT = 5.0;
    public static final Double DEFAULT_ADULT_DUCK_WEIGHT = 6.0;
    public static final Double DEFAULT_ADULT_RABBIT_WEIGHT = 4.0;

    public static final Double DEFAULT_YOUNG_COW_WEIGHT = 50.0;
    public static final Double DEFAULT_YOUNG_CHICKEN_WEIGHT = 1.0;
    public static final Double DEFAULT_YOUNG_DUCK_WEIGHT = 1.0;
    public static final Double DEFAULT_YOUNG_RABBIT_WEIGHT = 1.0;



    public Animal(String species) {
        this.species = species;
        if (species == "cow") {
            this.currentWeight = DEFAULT_YOUNG_COW_WEIGHT;
            this.weightWheAdult = DEFAULT_ADULT_COW_WEIGHT;
            this.weightNeededToDie = 0.75*DEFAULT_YOUNG_COW_WEIGHT;
        } else if (species == "chicken") {
            this.currentWeight = DEFAULT_YOUNG_CHICKEN_WEIGHT;
            this.weightWheAdult = DEFAULT_ADULT_CHICKEN_WEIGHT;
            this.weightNeededToDie = 0.75*DEFAULT_YOUNG_CHICKEN_WEIGHT;
        } else if (species == "duck") {
            this.currentWeight = DEFAULT_YOUNG_DUCK_WEIGHT;
            this.weightWheAdult = DEFAULT_ADULT_DUCK_WEIGHT;
            this.weightNeededToDie = 0.75*DEFAULT_YOUNG_DUCK_WEIGHT;
        }else if (species == "rabbit") {
            this.currentWeight = DEFAULT_YOUNG_RABBIT_WEIGHT;
            this.weightWheAdult = DEFAULT_ADULT_RABBIT_WEIGHT;
            this.weightNeededToDie = 0.75*DEFAULT_YOUNG_RABBIT_WEIGHT;
        }

    }
    public boolean isAlive(){
        if (this.currentWeight<=weightNeededToDie){
            return false;
        }
        else return true;
    }

    public boolean isAdult(){
        if(this.currentWeight==weightWheAdult){
            return true;
        }
        else return false;
    }
    //when animal is not feeded
    public void looseWeight(){
        currentWeight-=1.0;
        if(!isAlive()){
            System.out.println("Animal: " + this + " - starved to death.");
        }
    }
    public void feed(){
        isFed = true;
    }


    public void grow(){
        if(isAlive()) {
            if(isFed == true) {
                if (currentWeight < weightWheAdult) {
                    this.currentWeight = this.currentWeight + 1.0;
                    isFed = false;
                    System.out.println("Your animal: " + this.species + " is growing.");
                }
                else {
                    System.out.println("Your animal: " + this.species + " is adult.");
                }
            }
            else{
                looseWeight();
                System.out.println("Your animal: " + this.species + " is hungry, because in these week it didn't get food.");
            }
        }
        else{
            System.out.println("Your animal: " + this.species + " is dead, becouse you don't feed it proprerly.");
        }
    }





    public String toString(){
        return this.species ;
    }
}
