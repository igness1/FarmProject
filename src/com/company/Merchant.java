package com.company;

import com.company.Buildings.Barn;
import com.company.Buildings.ChickenCoop;
import com.company.Buildings.DuckCoop;
import com.company.Buildings.RabbitCoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Merchant {

    public Merchant(){
        addAnimalsToSell();
        addBuildingsToSell();
        addFarms();

    }

    //prices for items, maybe give it to merchant
    public Double priceForOneDuckEgg = 0.5;
    public Double priceForOneChickenEgg = 0.4;
    public Double priceForOneLiterOfMilk = 1.5;
    public Double priceForOneToneOfOat = 350.0;
    public Double priceForOneToneOfWheat = 300.0;
    public Double priceForOneToneOfLettuce = 200.0;
    public Double priceForOneToneOfStrawberries = 200.0;
    public Double priceForOneKgRabbitMeat = 15.0;

    public Double priceFor100kgOfAnimalFood = 35.0;

    public Double priceForYoungChicken = 15.0;
    public Double priceForYoungDuck = 20.0;
    public Double priceForYoungCow = 50.0;
    public Double priceForYoungRabbit = 10.0;

    public Double priceForAdultCow = 100.0;
    public Double priceForAdultChicken = 30.0;
    public Double priceForAdultDuck = 40.0;
    public Double priceForAdultRabbit = 20.0;

    public Double priceForsackOfOatSeeds = 15.0;
    public Double priceForsackOfWheatSeeds = 15.0;
    public Double priceForsackOfLettuceSeeds = 15.0;
    public Double priceForsackOfStrawberrySeeds = 15.0;

    public Barn normalBarnsToSell[] = new Barn[50];
    public Barn bigBarnsToSell[] = new Barn[50];
    public ChickenCoop normalChickenCoopToSell[] = new ChickenCoop[50];
    public ChickenCoop bigChickenCoopToSell[] = new ChickenCoop[50];
    public DuckCoop normalDuckCoopToSell[] = new DuckCoop[50];
    public DuckCoop bigDuckCoopToSell[] = new DuckCoop[50];
    public RabbitCoop normalRabbitCoopToSell[] = new RabbitCoop[50];
    public RabbitCoop bigRabbitCoopToSell[] = new RabbitCoop[50];

    public Integer normalBarnNumber=0;
    public Integer bigBarnNumber=0;
    public Integer normalChickenCoopNumber=0;
    public Integer bigChickenCoopNumber=0;
    public Integer normalDuckCoopNumber=0;
    public Integer bigDuckCoopNumber=0;
    public Integer normalRabbitCoopNumber=0;
    public Integer bigRabbitCoopNumber=0;

    public Animal cows[] = new Animal[300];
    public Animal chickens[] = new Animal[300];
    public Animal ducks[] = new Animal[300];
    public Animal rabbits[] = new Animal[300];

    public Integer cowNumber = 0 ;
    public Integer duckNumber = 0;
    public Integer chickenNumber = 0;
    public Integer rabbitNumber = 0;

    public Farm farmsToSell[] = new Farm[20];
    public Farm randomFarms[];


    public void addBuildingsToSell(){
        for(Integer i=0;i<normalBarnsToSell.length;i++){
            normalBarnsToSell[i]= new Barn("Normal Barn","The place for cows.",300.0,10);
        }
        for(Integer i=0;i<bigBarnsToSell.length;i++){
            bigBarnsToSell[i]= new Barn("Big Barn","The place for cows.",400.0,20);
        }
        for(Integer i=0;i<normalChickenCoopToSell.length;i++){
            normalChickenCoopToSell[i]= new ChickenCoop("Normal chicken coop","The place to hold chickens.",200.0,10);
        }
        for(Integer i=0;i<bigChickenCoopToSell.length;i++){
            bigChickenCoopToSell[i]= new ChickenCoop("Big chicken coop","The place to hold chickens.",300.0,20);
        }
        for(Integer i=0;i<normalDuckCoopToSell.length;i++){
            normalDuckCoopToSell[i]= new DuckCoop("Normal duck coop","The place to hold ducks.",300.0,15);
        }
        for(Integer i=0;i<bigDuckCoopToSell.length;i++){
            bigDuckCoopToSell[i]= new DuckCoop("Big duck coop","The place to hold ducks.",350.0,25);
        }
        for(Integer i=0;i<normalRabbitCoopToSell.length;i++){
            normalRabbitCoopToSell[i]= new RabbitCoop("Normal rabbit coop","The place for cows.",500.0,20);
        }
        for(Integer i=0;i<bigRabbitCoopToSell.length;i++){
            bigRabbitCoopToSell[i]= new RabbitCoop("Big rabbit coop","Place for cows.",500.0,20);
        }
    }

    public void addAnimalsToSell(){
        for(Integer i=0;i<cows.length;i++){
            cows[i] = new Animal("cow");
        }
        for(Integer i=0;i<chickens.length;i++){
            chickens[i] = new Animal("chicken");
        }
        for(Integer i=0;i<ducks.length;i++){
            ducks[i] = new Animal("duck");
        }
        for(Integer i=0;i<rabbits.length;i++){
            rabbits[i] = new Animal("rabbit");
        }
    }

    public void addFarms(){
        for(Integer i=0;i<=5;i++){
            farmsToSell[i] = new Farm("Small farm : type 1",5000.0,3,4,2,2,1);
        }
        for(Integer i=6;i<=10;i++){
            farmsToSell[i] = new Farm("Small farm : type 2",5000.0,4,3,3,1,3);
        }
        for(Integer i=11;i<=15;i++){
            farmsToSell[i] = new Farm("Big farm : type 1",7000.0,6,5,4,5,5);
        }
        for(Integer i=16;i<=20;i++){
            farmsToSell[i] = new Farm("Big farm : type 2",7000.0,5,6,5,4,5);
        }

    }








}
