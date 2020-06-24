package com.company;

import java.util.Random;

public class Player {
    public Double cash= 10000.0;

    public Farm farms[] = new Farm[10];

    public Integer freePlaceForFarm=null;
    public Integer numberOfFamrs=0;

    public Farm randomFarm1,randomFarm2,randomFarm3;

    public void freePlaceForFarm() {
        for (Integer i = 0; i < this.farms.length; i++) {
            if (farms[i] == null)
            {
                this.freePlaceForFarm =i;
                break;
            }
        }
    }
    public boolean isFreePlaceForFarm(){
        for(Farm farm : farms){
            if(farm == null){
                return true;
            }
        }
        return false;
    }
    public void add(Farm farm){
        freePlaceForFarm();
        if( freePlaceForFarm == null){
            System.out.println("You have reached the maximum in the number of farms.");
        }
        else{
            this.farms[freePlaceForFarm] = farm;
            freePlaceForFarm = null;
            System.out.println( "You add new farm. " );
        }
    }
    public void remove(Farm farm){
        for (Integer i = 0; i < this.farms.length; i++) {
            if (farms[i] == farm)
            {
                farms[i]=null;
                System.out.println("Farm removed.");
            }
        }
    }

    public void getRandom3Farms(Merchant merchant) {
        Integer i,j,k;
        do {
            i = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[i] != null);
        randomFarm1 = merchant.farmsToSell[i];
        do {
            j = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[j] != null);
        randomFarm2 = merchant.farmsToSell[j];
        do {
            k = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[k] != null);
        randomFarm3 = merchant.farmsToSell[k];
    }

    public void presentRandomFarms(){
        System.out.println(randomFarm1.toString());
        System.out.println(randomFarm2.toString());
        System.out.println(randomFarm3.toString());
    }

    public void buyFarm(Merchant merchant, Farm farm){
        if(this.cash >= farm.value && isFreePlaceForFarm()){
            add(farm);
            this.cash -= farm.value;
            for(Farm farms : merchant.farmsToSell){
                if(farms ==  farm){
                    farms = null;
                }
            }
            System.out.println("You have bought another farm.");
        }
        else{
            System.out.println("You don't have enough money to buy this farm, or you can't have free place for new farm.");
        }
    }

}
