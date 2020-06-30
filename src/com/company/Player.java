package com.company;

import java.util.Random;
import java.util.Scanner;

public class Player {
    public Double cash= 2000.0;

    public Farm farms[] = new Farm[9];

    public Integer freePlaceForFarm=null;
    public Integer numberOfFarms=0;

    public Farm randomFarm1,randomFarm2,randomFarm3;

    Scanner scan = new Scanner(System.in);

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
    public void sellFarm(){
        System.out.println("Which farm you want to sell? (Enter a number)");
        presentYourFarms();
        Integer farmNumber = scan.nextInt();
        if(farms[farmNumber] != farms[0]) {
            if (farms[farmNumber].howMuchBuildingsIsThere() == 0) {
                remove(farms[farmNumber]);
                this.cash += farms[farmNumber].value;
            } else {
                System.out.println("You can't sell farm with buildings on it.");
            }
        }
        else{
            System.out.println("You cant sell your first farm.");
        }
    }

    public void getRandom3Farms(Merchant merchant) {
        Integer i,j,k;
        do {
            i = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[i] == null);
        randomFarm1 = merchant.farmsToSell[i];
        do {
            j = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[j] == null);
        randomFarm2 = merchant.farmsToSell[j];
        do {
            k = new Random().nextInt(merchant.farmsToSell.length);
        }
        while (merchant.farmsToSell[k] == null);
        randomFarm3 = merchant.farmsToSell[k];
    }

    public void presentRandomFarms(){

        System.out.println("Farm nr 1 -> " + randomFarm1.toString());
        System.out.println("Farm nr 2 -> " + randomFarm2.toString());
        System.out.println("Farm nr 2 -> " + randomFarm3.toString());
    }

    public void buyFarm(Merchant merchant){
        getRandom3Farms(merchant);
        presentRandomFarms();
        System.out.println("Which farm do you want to buy? (Enter number)");
        Integer farmNumber = scan.nextInt();
        Farm farmToBuy=randomFarm1;
        switch (farmNumber){
            case 1:
                farmToBuy = randomFarm1;
                break;
            case 2:
                farmToBuy = randomFarm2;
                break;
            case 3:
                farmToBuy = randomFarm3;
            default:
                System.out.println("Incorrect number of farm, try again.");
                buyFarm(merchant);
                break;
        }

        if(this.cash >= farmToBuy.value && isFreePlaceForFarm()){
            add(farmToBuy);
            this.cash -= farmToBuy.value;
            for(Farm farms : merchant.farmsToSell){
                if(farms ==  farmToBuy){
                    farms = null;
                }
            }
            System.out.println("You have bought another farm.");
        }
        else{
            System.out.println("You don't have enough money to buy this farm, or you can't have free place for new farm.");
        }
    }

    public void presentYourFarms(){
        for(Integer i=0;i<farms.length;i++){
            if(farms[i] != null) {
                System.out.println("Farm nr " + i + " ->   " + farms[i].toString());
            }
        }
    }
    public void presentBarns(Integer farmNumber){
        for(Integer j=0;j<farms[farmNumber].barns.length;j++){
            if(farms[farmNumber].barns[j] != null){
                System.out.println("Barn nr: " + j + " -> " + farms[farmNumber].barns[j].toString());
            }
        }
    }
    public void presentChickenCoops(Integer farmNumber){
        for(Integer j=0;j<farms[farmNumber].chickenCoops.length;j++){
            if(farms[farmNumber].chickenCoops[j] != null){
                System.out.println("Chicken coop nr: " + j + " -> " + farms[farmNumber].chickenCoops[j].toString());
            }
        }
    }
    public void presentDuckCoops(Integer farmNumber){
        for(Integer j=0;j<farms[farmNumber].duckCoops.length;j++){
            if(farms[farmNumber].duckCoops[j] != null){
                System.out.println("Duck coop nr: " + j + " -> " + farms[farmNumber].duckCoops[j].toString());
            }
        }
    }
    public void presentRabbitCoops(Integer farmNumber){
        for(Integer j=0;j<farms[farmNumber].rabbitCoops.length;j++){
            if(farms[farmNumber].rabbitCoops[j] != null){
                System.out.println("Rabbit coop nr: " + j + " -> " + farms[farmNumber].rabbitCoops[j].toString());
            }
        }
    }

    public void presentBuildingAndAnimalsThere(){
        for(Integer i=0;i<farms.length;i++){
            if(farms[i] != null) {
                System.out.println("Farm nr " + i + " -> Buildings and animals in there:  " );
                for(Integer j=0;j<farms[i].barns.length;j++){
                    if(farms[i].barns[j] != null){
                        System.out.println("Barn nr: " + j + " -> " + farms[i].barns[j].toString());
                    }
                }
                for(Integer k=0;k<farms[i].chickenCoops.length;k++){
                    if(farms[i].chickenCoops[k] != null){
                        System.out.println("Chicken coop nr: " + k + " -> " + farms[i].chickenCoops[k].toString());
                    }
                }
                for(Integer m=0;m<farms[i].duckCoops.length;m++){
                    if(farms[i].duckCoops[m] != null){
                        System.out.println("Duck coop nr: " + m + " -> " + farms[i].duckCoops[m].toString());
                    }
                }
                for(Integer n=0;n<farms[i].rabbitCoops.length;n++){
                    if(farms[i].rabbitCoops[n] != null){
                        System.out.println("Rabbit coop nr: "+ n + " -> "+ farms[i].rabbitCoops[n].toString());
                    }
                }
            }
        }
    }

    public void presentYourFields(){
        for(Integer i=0;i<farms.length;i++){
            if(farms[i] != null) {
                System.out.println("Farm nr " + i + " ->  Fields:");
                for(Integer j=0;j<farms[i].fields.length;j++) {
                    System.out.println("Field nr: "+ j + " -> " + farms[i].fields[j].toString());
                }
            }
        }
    }

    public void buyBuilding(Merchant merchant){
        System.out.println("What type of building do you want to buy? ");
        System.out.println();
        System.out.println("1 - Normal barn , price: 300 coins.");
        System.out.println("2 - Big barn , price: 400 coins.");
        System.out.println("3 - Normal chicken coop , price: 200 coins. ");
        System.out.println("4 - Big chicken coop , price: 300 coins.");
        System.out.println("5 - Normal duck coop , price: 300 coins.");
        System.out.println("6 - Big duck coop , price: 350 coins.");
        System.out.println("7 - Normal rabbit coop , price: 200 coins.");
        System.out.println("8 - Big rabbit coop , price: 300 coins.");
        Integer answer1 = scan.nextInt();
        System.out.println("On which farm do you want to buy this building? Enter farm number,for example: 0.");
        presentYourFarms();
        Integer answer2 = scan.nextInt();
        if(farms[answer2]!=null){

            switch (answer1){
                case 1:
                    farms[answer2].buyBuilding("NormalBarn",this,merchant);
                    break;
                case 2:
                    farms[answer2].buyBuilding("BigBarn",this,merchant);
                    break;
                case 3:
                    farms[answer2].buyBuilding("NormalChickenCoop",this,merchant);
                    break;
                case 4:
                    farms[answer2].buyBuilding("BigChickenCoop",this,merchant);
                    break;
                case 5:
                    farms[answer2].buyBuilding("NormalDuckCoop",this,merchant);
                    break;
                case 6:
                    farms[answer2].buyBuilding("BigDuckCoop",this,merchant);
                    break;
                case 7:
                    farms[answer2].buyBuilding("NormalRabbitCoop",this,merchant);
                    break;
                case 8:
                    farms[answer2].buyBuilding("BigRabbitCoop",this,merchant);
                    break;
                default:
                    System.out.println("Incorrect number of building.Try again.");
                    buyBuilding(merchant);
            }
        }
        else{
            System.out.println("Incorrect number of farm, such farm doesn't exist.");
            buyBuilding(merchant);
        }
    }

    public void sellBuilding(Merchant merchant){
        System.out.println("What type of building do you want to sell? ");
        System.out.println();
        System.out.println("1 - Barn");
        System.out.println("2 - Chicken coop");
        System.out.println("3 - Duck coop");
        System.out.println("4 - Rabbit coop");
        Integer answer1 = scan.nextInt();
        System.out.println("On which farm do you want to sell this type of building? Enter farm number,for example: 0.");
        presentYourFarms();
        Integer answer2 = scan.nextInt();
        if(farms[answer2] != null){
            switch (answer1) {
                case 1:
                    System.out.println("Which barn you want sell? Enter number of barn from list below.");
                    presentBarns(answer2);
                    Integer answer3 = scan.nextInt();
                    if(farms[answer2].barns[answer3] !=null){
                        farms[answer2].sellBarn(answer3,this);
                    }
                    else{
                        System.out.println("Incorrect number of barn.");
                    }
                    break;
                case 2:
                    System.out.println("Which chicken coop you want sell? Enter number of chicken coop from list below.");
                    presentChickenCoops(answer2);
                    Integer answer4 = scan.nextInt();
                    if(farms[answer2].chickenCoops[answer4] !=null){
                        farms[answer2].sellChickenCoop(answer4,this);
                    }
                    else{
                        System.out.println("Incorrect number of chicken coop.");
                    }
                    break;
                case 3:
                    System.out.println("Which duck coop you want sell? Enter number of duck coop from list below.");
                    presentDuckCoops(answer2);
                    Integer answer5 = scan.nextInt();
                    if(farms[answer2].duckCoops[answer5] !=null){
                        farms[answer2].sellDuckCoop(answer5,this);
                    }
                    else{
                        System.out.println("Incorrect number of duck coop.");
                    }
                    break;
                case 4:
                    System.out.println("Which rabbit coop you want sell? Enter number of rabbit coop from list below.");
                    presentRabbitCoops(answer2);
                    Integer answer6 = scan.nextInt();
                    if(farms[answer2].rabbitCoops[answer6] !=null){
                        farms[answer2].sellRabbitCoop(answer6,this);
                    }
                    else{
                        System.out.println("Incorrect number of rabbit coop.");
                    }
                    break;
                default:
                    System.out.println("Incorrect number, try again.");
                    sellBuilding(merchant);
                    break;
            }
        }
        else{
            System.out.println("Incorrect number of farm, such farm doesn't exist.");
            buyBuilding(merchant);
        }
    }

    public void buyAnimal(Merchant merchant){
        System.out.println("What animals want you buy? (Enter number.)");
        System.out.println("1-cows | 50 coins per one.\n2-chickens | 15 coins per one.\n3-ducks | 20 coins per one.\n4-rabbits | 10 coins per one.");
        Integer answer = scan.nextInt();
        System.out.println("On which farm do you want these animals? Enter farm number,for example: 0.");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        System.out.println("How much animals want you buy?");
        Integer howMuch = scan.nextInt();
        if(farms[whichFarm] != null){
            switch (answer){
                case 1:
                    System.out.println("In which barn do you want to have those cows?");
                    presentBarns(whichFarm);
                    Integer whichBarn = scan.nextInt();
                    farms[whichFarm].buyAnimal("cow",howMuch,this,merchant,whichBarn);
                    break;
                case 2:
                    System.out.println("In which chicken coop do you want to have those cows?");
                    presentChickenCoops(whichFarm);
                    Integer whichChickenCoop = scan.nextInt();
                    farms[whichFarm].buyAnimal("chicken",howMuch,this,merchant,whichChickenCoop);
                    break;
                case 3:
                    System.out.println("In which duck coop do you want to have those cows?");
                    presentDuckCoops(whichFarm);
                    Integer whichDuckCoop = scan.nextInt();
                    farms[whichFarm].buyAnimal("duck",howMuch,this,merchant,whichDuckCoop);
                    break;
                case 4:
                    System.out.println("In which rabbit coop do you want to have those cows?");
                    presentRabbitCoops(whichFarm);
                    Integer whichRabbitCoop = scan.nextInt();
                    farms[whichFarm].buyAnimal("rabbit",howMuch,this,merchant,whichRabbitCoop);
                    break;
                default:
                    System.out.println("Incorrect number, try again.");
                    buyAnimal(merchant);
                    break;
            }
        }
        else{
            System.out.println("Incorrect number of farm, try again.");
            buyAnimal(merchant);
        }
    }

    public void sellAnimal(Merchant merchant){
        System.out.println("What animals want you sell? (Enter number.)");
        System.out.println("1-cows.\n2-chickens.\n3-ducks.\n4-rabbits.");
        Integer answer = scan.nextInt();
        System.out.println("From which farm do you want these animals to sell? Enter farm number,for example: 0.");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        System.out.println("How much animals want you sell?");
        Integer howMuch = scan.nextInt();
        if(farms[whichFarm] != null){
            switch (answer){
                case 1:
                    System.out.println("From which barn do you want to sell those cows?");
                    presentBarns(whichFarm);
                    Integer whichBarn = scan.nextInt();
                    farms[whichFarm].sellAnimal("cow",howMuch,this,merchant,whichBarn);
                    break;
                case 2:
                    System.out.println("From which chicken coop do you want to sell those cows?");
                    presentChickenCoops(whichFarm);
                    Integer whichChickenCoop = scan.nextInt();
                    farms[whichFarm].sellAnimal("chicken",howMuch,this,merchant,whichChickenCoop);
                    break;
                case 3:
                    System.out.println("From which duck coop do you want to sell those cows?");
                    presentDuckCoops(whichFarm);
                    Integer whichDuckCoop = scan.nextInt();
                    farms[whichFarm].sellAnimal("duck",howMuch,this,merchant,whichDuckCoop);
                    break;
                case 4:
                    System.out.println("From which rabbit coop do you want to sell those cows?");
                    presentRabbitCoops(whichFarm);
                    Integer whichRabbitCoop = scan.nextInt();
                    farms[whichFarm].sellAnimal("rabbit",howMuch,this,merchant,whichRabbitCoop);
                    break;
                default:
                    System.out.println("Incorrect number, try again.");
                    buyAnimal(merchant);
                    break;
            }
        }
        else{
            System.out.println("Incorrect number of farm, try again.");
            buyAnimal(merchant);
        }
    }

    public void feedAnimals(){
        for(Integer i=0; i<farms.length;i++){
            if(farms[i] != null){
                System.out.println("Farm nr " + i );
                farms[i].feed();
            }
        }
    }

    public void buyAnimalFood(Merchant merchant){
        System.out.println("To which farm do you want to buy this for?");
        presentYourFarms();
        Integer farmNumber = scan.nextInt();
        if(farms[farmNumber] != null){
            farms[farmNumber].buyAnimalFood(this,merchant);
        }
        else{
            System.out.println("Incorrect farm number, try again.");
            buyAnimal(merchant);
        }
    }

    public void sellRawMaterial(Merchant merchant){

        System.out.println("From which farm do you want to sell raw material?");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        if(farms[whichFarm] != null){
            farms[whichFarm].sellRawMaterial(this,merchant);
        }
        else{
            System.out.println("Incorrect number of farm,try again.");
            sellRawMaterial(merchant);
        }
    }

    public void sowField(){
        System.out.println("On which farm do you want to plant the field?");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        System.out.println("Which field do you want to plant?");
        presentYourFields();
        Integer whichField = scan.nextInt();
        System.out.println("What type of plant you want?(Enter a number) \n1 - wheat\n2 - oat\n3 - lettuce\n4 - strawberry");
        Integer plantType = scan.nextInt();
        if(farms[whichFarm] != null){
            if(0 <=  whichField  &&  whichField < farms[whichFarm].fields.length){
                switch (plantType) {
                    case 1:
                        farms[whichFarm].fields[whichField].sowTheField("wheat");
                        break;
                    case 2:
                        farms[whichFarm].fields[whichField].sowTheField("oat");
                        break;
                    case 3:
                        farms[whichFarm].fields[whichField].sowTheField("lettuce");
                        break;
                    case 4:
                        farms[whichFarm].fields[whichField].sowTheField("strawberry");
                        break;
                    default:
                        System.out.println("Incorrect number, try again.");
                        sowField();
                        break;
                }
            }
            else{
                System.out.println("Incorrect number of field, try again.");
                sowField();
            }
        }
        else{
            System.out.println("Incorrect number of farm, try again.");
            sowField();
        }
    }

    public void waterAndGreenFields(){
        System.out.println("On which farm do you want to water and whiten the fields?");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        if(farms[whichFarm] != null){
            farms[whichFarm].fieldCare();
        }
        else{
            System.out.println("Incorrect number, try again.");
            waterAndGreenFields();
        }
    }

    public void sellHarvest(Merchant merchant){
        System.out.println("From which farm do you want to sell the harvest? (Enter a number)");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        System.out.println("What type of harvest you want?(Enter a number) \n1 - wheat \n2 - oat\n3 - lettuce\n4 - strawberry");
        Integer plantType = scan.nextInt();
        if(farms[whichFarm] != null){
            switch (plantType) {
                case 1:
                        farms[whichFarm].sellHarvest("wheat",this,merchant);
                        break;
                case 2:
                        farms[whichFarm].sellHarvest("oat",this,merchant);
                        break;
                case 3:
                        farms[whichFarm].sellHarvest("lettuce",this,merchant);
                        break;
                case 4:
                        farms[whichFarm].sellHarvest("strawberry",this,merchant);
                        break;
                default:
                        System.out.println("Incorrect number, try again.");
                        sellHarvest(merchant);
                        break;
            }
        }
        else{
            System.out.println("Incorrect number of farm, try again.");
            sellHarvest(merchant);
        }
    }

    public void buySeeds(Merchant merchant){
        System.out.println("From which farm do you want to sell the harvest? (Enter a number)");
        presentYourFarms();
        Integer whichFarm = scan.nextInt();
        System.out.println("What type of seeds you want?(Enter a number) \n1 - wheat \n2 - oat\n3 - lettuce\n4 - strawberry");
        Integer plantType = scan.nextInt();
        System.out.println("How many sacks of seeds you want? ");
        Integer sacksNumber = scan.nextInt();
        if(farms[whichFarm] != null){
            switch (plantType) {
                case 1:
                    farms[whichFarm].buySeeds(sacksNumber,"wheat",this,merchant);
                    break;
                case 2:
                    farms[whichFarm].buySeeds(sacksNumber,"oat",this,merchant);
                    break;
                case 3:
                    farms[whichFarm].buySeeds(sacksNumber,"lettuce",this,merchant);
                    break;
                case 4:
                    farms[whichFarm].buySeeds(sacksNumber,"strawberry",this,merchant);
                    break;
                default:
                    System.out.println("Incorrect number, try again.");
                    buySeeds(merchant);
                    break;
            }
        }
        else{
            System.out.println("Incorrect number of farm, try again.");
            buySeeds(merchant);
        }
    }




}
