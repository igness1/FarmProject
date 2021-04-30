# Project Name
> FarmProject

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)


## General info
FarmProject is a console game, where you play the role of a farmer.

You start the game with one of three farms to choose (selected randomly) and with 2000 coins.
This farm has empty fields (for cultivation), and zero animals (you have to buy animals)
and zero buildings (you have to buy them too).
You have 150 weeks to achieve the goal. If you fail, you lose.
At the start you have 10 bags of seeds from each plant species.
The goal of the game is to achieve richness(10 000.0 coins) as quickly as possible in the shortest possible time.
Time is defined by weeks. Maximum you can have 10 farms.
Sell harvest and items from animals, buy animals and buildings and develop your farm.
Earn and invest money into next farms to become a super farmer. Remember to take care of animals and crops.
Few tips: 
- You have to feed animals once a week, otherwise they will starve.
 Remember to make sure you have anything to feed the animals. They must be fed to grow.
- You can't buy animals when you don't have place for them. Each type of animal has a building. For example: cows need barn.
- Gathering harvest and raw material from animals is done automatically once a week too.
- Animals give items,for example eggs, when they are adult. You can buy only young animals. They need time and food to grow, remember.


## Screenshots
Example screenshot of console game, we can see on the second screenshot main menu for player to administrate farm.

<img src=./img/screenshot.PNG>
<img src=./img/screenshot1.PNG>


## Technologies
* IntelliJ IDEA - version 2019.3.3
* Java - version 11.0.5
* Project SDK - version 11

## Setup
To run application and check it out you will need IntelliJ IDEA environment. If you have already installed IntelliJ IDEA environment,
the next step is to dowload the FarmProject and open it in IntelliJ IDEA. To run console game press 'Run' button. 

## Code Examples
Content of Animal Class:
```Java
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
        if(this.currentWeight==this.weightWheAdult){
            return true;
        }
        else{
            return false;
        }
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

                    isFed = false;
                    System.out.println("Your animal: " + this.species + " is growing.");
                    if(this.species=="cow"){
                        this.currentWeight = this.currentWeight + 20.0;
                    }
                    else{
                        this.currentWeight = this.currentWeight + 1.0;
                    }
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

```

## Features
List of features ready and TODOs for future development
* Player can purchase/sell farm.
* Player can purchase/sell farm fields, animals, buildings, food for animals, seeds.
* Player can crop harvest and sell it or use to feed animals.
* Animals grow when they are not hungry, and they may die if not cared properly.
* Plants grow when they are cared properly.
* Player can checked information and status of his animals, fields, plants and buildings.



To-do list:
* An attempt to make GUI.
* Add more farm features and rules that exist in real farm.

## Status
Project is: _in progress_

## Inspiration
My inspiration to create such an app was a willings to learn SOLID principles and Java fundamentals. 
