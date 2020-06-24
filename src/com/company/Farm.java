package com.company;

import com.company.Buildings.Barn;
import com.company.Buildings.ChickenCoop;
import com.company.Buildings.DuckCoop;
import com.company.Buildings.RabbitCoop;

public class Farm {
    public Double value;
    public String name;

    public Double sumOfMilk=0.0; // in liters of milk
    public Integer sumOfchickenEggAmount=0; // in number of egg
    public Integer sumOfduckEggAmount=0; //in number of egg
    public Double sumOfRabbitMeatAmount = 0.0; // in kg.

    public Double sumOfwheatHarvest=0.0; // in tones
    public Double sumOfoatHarvest=0.0; // in tones
    public Double sumOfLettuceHarvest=0.0; // in tones
    public Double sumOfStrawberryHarvest=0.0; // in tones

    public Integer sackOfOatSeeds =10; //in numbers of sacks.
    public Integer sackOfWheatSeeds =10; //in numbers of sacks.
    public Integer sackOfStrawberrySeeds =10; //in numbers of sacks.
    public Integer sackOfLettuceSeeds =10; //in numbers of sacks.

    public Double animalFood = 0.0; // in kg, can buy it at merchant.

    public String isSomethingToFeedAnimals = null;

    public Field fields[];

    public Barn barns[];
    public Integer freePlaceForBarn = null;
    public ChickenCoop chickenCoops[];
    public Integer freePlaceForChickenCoop = null;
    public DuckCoop duckCoops[];
    public Integer freePlaceForDuckCoop = null;
    public RabbitCoop rabbitCoops[];
    public Integer freePlaceForRabbitCoop = null;


   //setting farm, with diffrent number of buildings and empty fields.
   public Farm(String name,Double value,Integer howManyPlacesForBarns, Integer howManyPlacesForFields, Integer hawManyPlacesForChickenCoops,
               Integer howManyPlacesForDuckCoops, Integer howManyPlacesForRabbitCoops){
       this.barns = new Barn[howManyPlacesForBarns];
       this.fields = new Field[howManyPlacesForFields];
       this.chickenCoops = new ChickenCoop[hawManyPlacesForChickenCoops];
       this.duckCoops = new DuckCoop[howManyPlacesForDuckCoops];
       this.rabbitCoops = new RabbitCoop[howManyPlacesForRabbitCoops];
       this.name = name;
       this.value = value;

       // preparing default empty fields.
       for(Field a : fields){
           a = new Field();
       }
   }

    @Override
    public String toString(){
        return "Farm name: "+ this.name + " | Farm value: "+ this.value + " | Places for barns: " +this.barns.length +
                " \nPlaces for chicken coops: " + this.chickenCoops.length + " | Places for duck coops:  " + this.duckCoops.length
                + " \nPlaces for rabit coops: "+ this.rabbitCoops.length;
    }

   // ----------------------------------------------  BUILDING AREA ----------------------------------------------------------
    // set free place in collection for building
    public void setFreePlaceForBarn(){
        for (Integer i = 0; i < this.barns.length; i++) {
            if (barns[i] == null)
            {
                this.freePlaceForBarn =i;
                break;
            }
        }
    }
    public void setFreePlaceForChickenCoop(){
        for (Integer i = 0; i < this.chickenCoops.length; i++) {
            if (chickenCoops[i] == null)
            {
                this.freePlaceForChickenCoop =i;
                break;
            }
        }
    }
    public void setFreePlaceForDuckCoop(){
        for (Integer i = 0; i < this.duckCoops.length; i++) {
            if (duckCoops[i] == null)
            {
                this.freePlaceForDuckCoop =i;
                break;
            }
        }
    }
    public void setFreePlaceForRabbitCoop(){
        for (Integer i = 0; i < this.rabbitCoops.length; i++) {
            if (rabbitCoops[i] == null)
            {
                this.freePlaceForRabbitCoop =i;
                break;
            }
        }
    }
    // add building
    public void addBarn(Barn barn){
            setFreePlaceForBarn();
            if( freePlaceForBarn == null){
                System.out.println("You don't have space for this barn at your farm.");
            }
            else {
                this.barns[freePlaceForBarn] = barn;
                System.out.println("Barn added to farm at place: " + freePlaceForBarn);
            }
   }
    public void addChickenCoop(ChickenCoop chickenCoop){
        setFreePlaceForChickenCoop();
        if( freePlaceForChickenCoop == null){
            System.out.println("You don't have space for this chicken coop at your farm.");
        }
        else {
            this.chickenCoops[freePlaceForChickenCoop] = chickenCoop;
            System.out.println("Chicken coop added to farm at place: " + freePlaceForChickenCoop);
        }
    }
    public void addDuckCoop(DuckCoop duckCoop){
        setFreePlaceForDuckCoop();
        if( freePlaceForDuckCoop == null){
            System.out.println("You don't have space for this duck coop at your farm.");
        }
        else {
            this.duckCoops[freePlaceForDuckCoop] = duckCoop;
            System.out.println("Duck coop added to farm at place: " + freePlaceForDuckCoop);
        }
    }
    public void addRabbitCoop(RabbitCoop rabbitCoop){
        setFreePlaceForRabbitCoop();
        if( freePlaceForRabbitCoop == null){
            System.out.println("You don't have space for this rabbit coop at your farm.");
        }
        else {
            this.rabbitCoops[freePlaceForRabbitCoop] = rabbitCoop;
            System.out.println("Rabbit coop added to farm at place: " + freePlaceForRabbitCoop);
        }
    }
    // remove building
    public void removeBarn(Integer barnNumber){
       barns[barnNumber] = null;
        System.out.println("Barn number: " +barnNumber+ " was removed.");
    }
    public void removeChickenCoop(Integer number){
       chickenCoops[number] = null;
        System.out.println("Chicken coop number: " + number + " was removed.");
    }
    public void removeDuckCoop(Integer number){
       duckCoops[number] = null;
        System.out.println("Duck coop number: " + number + " was removed.");
    }
    public void removeRabbitCoop(Integer number){
       rabbitCoops[number] = null;
        System.out.println("Rabbit coop number: " + number + " was removed.");
    }

    public void showAllBuildings() {
        for (Integer i = 0; i < barns.length; i++) {
            System.out.println("Barn number: " + i + " . | " + barns.toString());
        }
        System.out.println("");
        for (Integer i = 0; i < chickenCoops.length; i++) {
            System.out.println("Chicken coop number: " + i + " . | " + chickenCoops.toString());
        }
        System.out.println("");
        for (Integer i = 0; i < duckCoops.length; i++) {
            System.out.println("Duck coop number: " + i + " . | " + duckCoops.toString());
        }
        System.out.println("");
        for (Integer i = 0; i < rabbitCoops.length; i++) {
            System.out.println("Rabbit coop number: " + i + " . | " + rabbitCoops.toString());
        }
    }
   // --------------------------------------------------- END OF BUILDING AREA -------------------------------------------------------







   //--------------------------------------------------------- FIELD AREA -----------------------------------------------------------------------

    // sowing Field some type of plant. When some field is sown then you cannot sow again before you gather harvest.
    public void sowingField(String typeOfPlantToSow, Integer fieldNumber){
       Integer sackOfSeeds=0;

       if(typeOfPlantToSow == "oat"){
           sackOfSeeds = this.sackOfOatSeeds;
       }else if(typeOfPlantToSow == "wheat"){
           sackOfSeeds = this.sackOfWheatSeeds;
       }else if(typeOfPlantToSow == "lettuce"){
           sackOfSeeds = this.sackOfLettuceSeeds;
       }else if(typeOfPlantToSow == "strawberry"){
           sackOfSeeds = this.sackOfStrawberrySeeds;
       }

       if(sackOfSeeds >= 3){
            if(!fields[fieldNumber].isSown) {
                fields[fieldNumber].sowTheField(typeOfPlantToSow);

                System.out.println("You sowed the field number: " + fieldNumber + ". Type of plant: " + typeOfPlantToSow);

                if(typeOfPlantToSow == "oat"){
                    this.sackOfOatSeeds -= 3;
                }else if(typeOfPlantToSow == "wheat"){
                    this.sackOfWheatSeeds -= 3;
                }else if(typeOfPlantToSow == "lettuce"){
                    this.sackOfLettuceSeeds -=3;
                }else if(typeOfPlantToSow == "strawberry"){
                    this.sackOfStrawberrySeeds -=3;
                }
            }
            else{
                System.out.println("Your field is already sown, you can't sow now.");
            }
       }
       else{
           System.out.println("You don't have enough sacks of seeds of this plant to sow field. " +
                   "You have "+ sackOfSeeds + " sack of seeds of " + typeOfPlantToSow + ". You need 3 sacks to sow field.");
       }
    }
    public void gatheringHarvestFromAllField(){
       for(Field field :fields){
           field.gatherHarvest();
       }
    }
    // field care   | plants to grow need care.
    public void fieldCare(){
       for(Field field : fields){
           field.wateringAndWeeding();
       }
    }
   // field plant growing
    public void plantGrowing(){
        for(Field field : fields){
            field.plantsGrowing();
        }
    }
    //suming harvest from fields
    public void AddHarvestsFromFieldsToSum(){
        for(Field field :fields){

                sumOfoatHarvest += field.oatHarvest;
                sumOfwheatHarvest += field.wheatHarvest;
                sumOfLettuceHarvest += field.lettuceHarvest;
                sumOfStrawberryHarvest += field.strawberryHarvest;
        }
    }
    //selling harvest
    public void sellHarvest(String typeOfHarvest,Player player, Merchant merchant,Double howMuchToneToSell){
        if(typeOfHarvest == "oat" && sumOfoatHarvest > 0.0){
            sumOfoatHarvest -= howMuchToneToSell;
            player.cash += (howMuchToneToSell * merchant.priceForOneToneOfOat);
            System.out.println("You have earned " + (howMuchToneToSell * merchant.priceForOneToneOfOat) + " coins, and sold " + howMuchToneToSell +  " tone of oat.");
        }
        if(typeOfHarvest == "wheat" && sumOfwheatHarvest > 0.0){
            sumOfwheatHarvest -= howMuchToneToSell;
            player.cash += (howMuchToneToSell * merchant.priceForOneToneOfWheat);
            System.out.println("You have earned " + (howMuchToneToSell * merchant.priceForOneToneOfWheat) + " coins, and sold "  + howMuchToneToSell +  " tone of wheat.");
        }
        if(typeOfHarvest == "lettuce" && sumOfLettuceHarvest > 0.0){
            sumOfLettuceHarvest -= howMuchToneToSell;
            player.cash += (howMuchToneToSell * merchant.priceForOneToneOfLettuce);
            System.out.println("You have earned " + (howMuchToneToSell * merchant.priceForOneToneOfLettuce) + " coins, and sold "  + howMuchToneToSell +  " tone of lettuce.");
        }
        if(typeOfHarvest == "wheat" && sumOfStrawberryHarvest > 0.0){
            sumOfStrawberryHarvest -= howMuchToneToSell;
            player.cash += (howMuchToneToSell * merchant.priceForOneToneOfStrawberries);
            System.out.println("You have earned " + (howMuchToneToSell * merchant.priceForOneToneOfStrawberries) + " coins, and sold "  + howMuchToneToSell +  " tone of strawberries.");
        }
    }
    public void buySeeds(Integer howManySacks, String typeOfPlant, Player player, Merchant merchant){
        if(typeOfPlant == "oat" && player.cash >= (merchant.priceForsackOfOatSeeds * howManySacks)){
            this.sackOfOatSeeds += howManySacks;
            player.cash -= (merchant.priceForsackOfOatSeeds * howManySacks);
        }else if(typeOfPlant == "wheat" && player.cash >= (merchant.priceForsackOfWheatSeeds * howManySacks)){
            this.sackOfWheatSeeds += howManySacks;
            player.cash -= (merchant.priceForsackOfWheatSeeds * howManySacks);
        }else if(typeOfPlant == "lettuce" && player.cash >= (merchant.priceForsackOfLettuceSeeds * howManySacks)){
            this.sackOfLettuceSeeds += howManySacks;
            player.cash -= (merchant.priceForsackOfLettuceSeeds * howManySacks);
        }else if(typeOfPlant == "strawberry" && player.cash >= (merchant.priceForsackOfStrawberrySeeds * howManySacks)){
            this.sackOfStrawberrySeeds += howManySacks;
            player.cash -= (merchant.priceForsackOfStrawberrySeeds * howManySacks);
        }
    }

    //   --------------------------------------------   END OF FIELD AREA   -----------------------------------------------



    //   ------------------------------------------------   ANIMALS AREA   --------------------------------------------------

    //process of setting what type of plant player has to feed animals.
    public void isSomethingToFeedAnimals(){
       if(sumOfwheatHarvest >= 0.5){
           isSomethingToFeedAnimals = "wheat";
       }else if(sumOfoatHarvest >= 0.5){
           isSomethingToFeedAnimals = "oat";
       }else if(animalFood >= 50.0){
           isSomethingToFeedAnimals = "animalsFood";
       }else{
           System.out.println("You have nothing to feed your animals. Maybe go buy some animals food at merchant.");
           isSomethingToFeedAnimals = null;
       }
    }
    // buying animal food.
    public void buyAnimalFood(Player player, Merchant merchant){
       if(player.cash >= merchant.priceFor100kgOfAnimalFood){
           animalFood +=100;
           player.cash -= merchant.priceFor100kgOfAnimalFood;
           System.out.println("You have bought 100 kg animal food.");
       }
       else{
           System.out.println("You don't have enough money to buy animal food.");
       }
    }
    //feeding animals for week.
    public void feed(){
       for(Barn barn : barns){
           if(isSomethingToFeedAnimals == "oat"){
                 barn.animalsFeeding();
                 sumOfoatHarvest -=0.05;
           }else if(isSomethingToFeedAnimals == "wheat"){
               barn.animalsFeeding();
               sumOfwheatHarvest -=0.05;
           }else if(isSomethingToFeedAnimals == "animalsFood"){
               barn.animalsFeeding();
               animalFood -=10;
           }else if(isSomethingToFeedAnimals == null){
               barn.animalsNotFeeding();
           }
       }
       for(ChickenCoop chickenCoop : chickenCoops){
            if(isSomethingToFeedAnimals == "oat"){
                chickenCoop.animalsFeeding();
                sumOfoatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "wheat"){
                chickenCoop.animalsFeeding();
                sumOfwheatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "animalsFood"){
                chickenCoop.animalsFeeding();
                animalFood -=10;
            }
            else if(isSomethingToFeedAnimals == null){
                chickenCoop.animalsNotFeeding();
            }
       }
       for(DuckCoop duckCoop : duckCoops){
            if(isSomethingToFeedAnimals == "oat"){
                duckCoop.animalsFeeding();
                sumOfoatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "wheat"){
                duckCoop.animalsFeeding();
                sumOfwheatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "animalsFood"){
                duckCoop.animalsFeeding();
                animalFood -=10;
            }else if(isSomethingToFeedAnimals == null){
                duckCoop.animalsNotFeeding();
            }
       }
       for(RabbitCoop rabbitCoop : rabbitCoops){
            if(isSomethingToFeedAnimals == "oat"){
                rabbitCoop.animalsFeeding();
                sumOfoatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "wheat"){
                rabbitCoop.animalsFeeding();
                sumOfwheatHarvest -=0.05;
            }else if(isSomethingToFeedAnimals == "animalsFood"){
                rabbitCoop.animalsFeeding();
                animalFood -=10;
            }else if(isSomethingToFeedAnimals == null){
                rabbitCoop.animalsNotFeeding();
            }
       }
    }
    // when animals die
    public void removedDeadAnimals(){
        for(Barn barn :barns){
            barn.removesDeadAnimal();
        }
        for(ChickenCoop chickenCoop : chickenCoops){
            chickenCoop.removesDeadAnimal();
        }
        for(DuckCoop duckCoop : duckCoops){
            duckCoop.removesDeadAnimal();
        }
        for(RabbitCoop rabbitCoop : rabbitCoops){
            rabbitCoop.removesDeadAnimal();
        }
    }
    // egging, milking, killing xd
    public void allAnimalsMakeRawMaterial(){
        for(Barn barn : barns){
             barn.milkingCow();
        }
        for(ChickenCoop chickenCoop : chickenCoops){
           chickenCoop.Egging();
        }
        for(DuckCoop duckCoop : duckCoops){
           duckCoop.Egging();
        }
        for(RabbitCoop rabbitCoop : rabbitCoops){
           rabbitCoop.killRabbitAndMakeMeat();
        }
    }
    //if we want one type of animals make items. For example only duck make eggs.
    public void makeRawMaterialFromOneTypeOfAnimal(String typeOfAnimal){
       if(typeOfAnimal == "cow") {
           for (Barn barn : barns) {
               barn.milkingCow();
           }
       }
       else if(typeOfAnimal == "chicken") {
           for (ChickenCoop chickenCoop : chickenCoops) {
               chickenCoop.Egging();
           }
       }
       else if(typeOfAnimal == "duck") {
           for (DuckCoop duckCoop : duckCoops) {
               duckCoop.Egging();
           }
       }
       else if(typeOfAnimal == "rabbit") {
           for (RabbitCoop rabbitCoop : rabbitCoops) {
               rabbitCoop.killRabbitAndMakeMeat();
           }
       }
    }

    //gathering sum
    public void addRawMaterialToSum(){
       for(Barn barn : barns){
           sumOfMilk += barn.milkAmount;
       }
       for(ChickenCoop chickenCoop : chickenCoops){
           sumOfchickenEggAmount += chickenCoop.chickenEggAmount;
       }
       for(DuckCoop duckCoop : duckCoops){
            sumOfduckEggAmount += duckCoop.duckEggAmount;
       }
       for(RabbitCoop rabbitCoop : rabbitCoops){
            sumOfRabbitMeatAmount += rabbitCoop.rabbitMeatAmount;
       }
    }


    public void sellOneTypeOfRawMaterial(String typeOfAnimal, Player player,Merchant merchant, Double howMuch, Integer howMuch1){
        if(typeOfAnimal == "cow" && sumOfMilk>0.0){
            sumOfMilk -= howMuch;
            player.cash += (howMuch * merchant.priceForOneLiterOfMilk);
            System.out.println("You have sold " + howMuch + " liters of milk. You have earned " + (howMuch * merchant.priceForOneLiterOfMilk) + " coins.");
        }else if(typeOfAnimal == "duck" && sumOfduckEggAmount>0){
            sumOfduckEggAmount -= howMuch1;
            player.cash += (howMuch1 * merchant.priceForOneDuckEgg);
            System.out.println("You have sold " + howMuch1 + " duck eggs. You have earned " + (howMuch1 * merchant.priceForOneDuckEgg) + " coins.");
        }else if(typeOfAnimal == "chicken" && sumOfchickenEggAmount>0){
            sumOfchickenEggAmount -= howMuch1;
            player.cash += (howMuch1 * merchant.priceForOneChickenEgg);
            System.out.println("You have sold " + howMuch1 + " chicken eggs. You have earned " + (howMuch1 * merchant.priceForOneChickenEgg) + " coins.");
        }else if(typeOfAnimal == "rabbit" && sumOfRabbitMeatAmount>0){
            sumOfRabbitMeatAmount -= howMuch;
            player.cash += (howMuch * merchant.priceForOneKgRabbitMeat);
            System.out.println("You have sold " + howMuch + " kg of rabbit meat. You have earned " + (howMuch * merchant.priceForOneKgRabbitMeat) + " coins.");
        }
    }



    // -------------------------------------------- END OF ANIMAL AREA -------------------------------------------------------------






   //-------------------------------------------     BUYING AND SELLING ANIMAL AREA ----------------------------------------------------

    public void sellAnimal(String species,Integer howMuch, Player player, Merchant merchant, Integer animalBuildingNumber) {
        Integer selledAnimals = 0;
        if(species == "cow" ) {
           if(barns[animalBuildingNumber].howManyAnimalsIsThere()>=howMuch) {
               do {
                   for (Animal animal : barns[animalBuildingNumber].cows) {
                       if (animal != null) {
                           barns[animalBuildingNumber].remove(animal);
                           if (animal.isAdult()) {
                               player.cash += merchant.priceForAdultCow;
                           } else {
                               player.cash += merchant.priceForYoungCow;
                           }
                       }
                   }
               }
               while (selledAnimals == howMuch);
               System.out.println("You sold "+ howMuch + "animals, species: "+ species);
           }
           else{
               System.out.println("You don't have so many animals for sale. Animal species: "+ species);
           }
        }
        else if(species == "chicken" ) {
            if(chickenCoops[animalBuildingNumber].howManyAnimalsIsThere()>=howMuch) {
                do {
                    for (Animal animal : chickenCoops[animalBuildingNumber].chickens) {
                        if (animal != null) {
                            chickenCoops[animalBuildingNumber].remove(animal);
                            if (animal.isAdult()) {
                                player.cash += merchant.priceForAdultChicken;
                            } else {
                                player.cash += merchant.priceForYoungChicken;
                            }
                        }
                    }
                }
                while (selledAnimals == howMuch);
                System.out.println("You sold "+ howMuch + "animals, species: "+ species);
            }
            else{
                System.out.println("You don't have so many animals for sale. Animal species: "+ species);
            }
        }
        else if(species == "duck" ) {
            if(duckCoops[animalBuildingNumber].howManyAnimalsIsThere()>=howMuch) {
                do {
                    for (Animal animal : duckCoops[animalBuildingNumber].ducks) {
                        if (animal != null) {
                            duckCoops[animalBuildingNumber].remove(animal);
                            if (animal.isAdult()) {
                                player.cash += merchant.priceForAdultDuck;
                            } else {
                                player.cash += merchant.priceForYoungDuck;
                            }
                        }
                    }
                }
                while (selledAnimals == howMuch);
                System.out.println("You sold "+ howMuch + "animals, species: "+ species);
            }
            else{
               System.out.println("You don't have so many animals for sale. Animal species: "+ species);
             }
        }
        else if(species == "rabbit" ) {
            if(rabbitCoops[animalBuildingNumber].howManyAnimalsIsThere()>=howMuch) {
                do {
                    for (Animal animal : rabbitCoops[animalBuildingNumber].rabbits) {
                        if (animal != null) {
                            rabbitCoops[animalBuildingNumber].remove(animal);
                            if (animal.isAdult()) {
                                player.cash += merchant.priceForAdultRabbit;
                            } else {
                                player.cash += merchant.priceForYoungRabbit;
                            }
                        }
                    }
                }
                while (selledAnimals == howMuch);
                System.out.println("You sold "+ howMuch + "animals, species: "+ species);
            }
            else{
                System.out.println("You don't have so many animals for sale. Animal species: "+ species);
            }
        }
   }

    // animalBuildingNumber is number of Barn for expample.
    public void buyAnimal(String species,Integer howMuch, Player player, Merchant merchant, Integer animalBuildingNumber){
       if(species == "cow"){
           if(player.cash>=merchant.priceForYoungCow){
               if(barns[animalBuildingNumber].isFreePlaceForAnimals(howMuch)) {
                   for (Integer i = merchant.cowNumber; i < merchant.cowNumber + howMuch; i++) {
                       barns[animalBuildingNumber].add(merchant.cows[i]);
                   }
                   merchant.cowNumber = howMuch;
                   player.cash -= merchant.priceForYoungCow;
               }
               else{
                   System.out.println("You don't have "+ howMuch + " free place for cows in barn number: " + animalBuildingNumber);
               }
           }
           else{
               System.out.println("You don't have enough money to buy:  " + howMuch + " " + species);
           }
       }
       else if(species == "duck"){
           if(player.cash>=merchant.priceForYoungDuck){
               if(duckCoops[animalBuildingNumber].isFreePlaceForAnimals(howMuch)) {
                   for (Integer i = merchant.duckNumber; i < merchant.duckNumber + howMuch; i++) {
                       duckCoops[animalBuildingNumber].add(merchant.ducks[i]);
                   }
                   merchant.duckNumber = howMuch;
                   player.cash -= merchant.priceForYoungDuck;
               }
               else{
                   System.out.println("You don't have "+ howMuch + " free place for ducks in duck coop number: " + animalBuildingNumber);
               }
           }
           else{
               System.out.println("You don't have enough money to buy:  " + howMuch + " " + species);
           }
       }
       else if(species == "chicken"){
           if(player.cash>=merchant.priceForYoungChicken){
               if(chickenCoops[animalBuildingNumber].isFreePlaceForAnimals(howMuch)) {
                   for (Integer i = merchant.chickenNumber; i < merchant.chickenNumber + howMuch; i++) {
                       chickenCoops[animalBuildingNumber].add(merchant.chickens[i]);
                   }
                   merchant.chickenNumber = howMuch;
                   player.cash -= merchant.priceForYoungChicken;
               }
               else{
                   System.out.println("You don't have "+ howMuch + " free place for chickens in chicken coop number: " + animalBuildingNumber);
               }
           }
           else{
               System.out.println("You don't have enough money to buy:  " + howMuch + " " + species);
           }
       }
       else if(species == "rabbit"){
           if(player.cash>=merchant.priceForYoungRabbit){
               if(rabbitCoops[animalBuildingNumber].isFreePlaceForAnimals(howMuch)) {
                   for (Integer i = merchant.rabbitNumber; i < merchant.rabbitNumber + howMuch; i++) {
                       rabbitCoops[animalBuildingNumber].add(merchant.rabbits[i]);
                   }
                   merchant.rabbitNumber = howMuch;
                   player.cash -= merchant.priceForYoungRabbit;
               }
               else{
                   System.out.println("You don't have "+ howMuch + " free place for rabbits in rabbit coop number: " + animalBuildingNumber);
               }
           }
           else{
               System.out.println("You don't have enough money to buy:  " + howMuch + " " + species);
           }
       }

   }

    // ------------------------------------------ END OF BUYING AND SELLING ANIMAL AREA ------------------------------------------------------





    //--------------------------------------------  BUYING AND SELLING BUILDINGS AREA-----------------------------------------------------------

    public void buyBuilding(String whatTypeOfBuilding, Player player, Merchant merchant){
        if(whatTypeOfBuilding == "NormalChickenCoop"){
             if(player.cash >= merchant.normalChickenCoopToSell[merchant.normalChickenCoopNumber].value) {
                 addChickenCoop(merchant.normalChickenCoopToSell[merchant.normalChickenCoopNumber]);
                 merchant.normalChickenCoopNumber += 1;
                 player.cash -= merchant.normalChickenCoopToSell[merchant.normalChickenCoopNumber].value;
                 System.out.println("You have bought normal chicken coop.");
             }
             else{
                 System.out.println("You don't have enough money to buy normal chicken coop.");
             }
        }
        else if(whatTypeOfBuilding == "BigChickenCoop"){
            if(player.cash >= merchant.bigChickenCoopToSell[merchant.bigChickenCoopNumber].value) {
                addChickenCoop(merchant.bigChickenCoopToSell[merchant.bigChickenCoopNumber]);
                merchant.bigChickenCoopNumber += 1;
                player.cash -= merchant.bigChickenCoopToSell[merchant.bigChickenCoopNumber].value;
                System.out.println("You have bought big chicken coop.");
            }
            else{
                System.out.println("You don't have enough money to buy big chicken coop.");
            }
        }
        else if(whatTypeOfBuilding == "NormalDuckCoop"){
            if(player.cash >= merchant.normalDuckCoopToSell[merchant.normalDuckCoopNumber].value) {
                addDuckCoop(merchant.normalDuckCoopToSell[merchant.normalDuckCoopNumber]);
                merchant.normalDuckCoopNumber += 1;
                player.cash -= merchant.normalDuckCoopToSell[merchant.normalDuckCoopNumber].value;
                System.out.println("You have bought normal duck coop.");
            }
            else{
                System.out.println("You don't have enough money to buy normal duck coop.");
            }
        }
        else if(whatTypeOfBuilding == "BigDuckCoop"){
            if(player.cash >= merchant.bigDuckCoopToSell[merchant.bigDuckCoopNumber].value) {
                addDuckCoop(merchant.bigDuckCoopToSell[merchant.bigDuckCoopNumber]);
                merchant.bigDuckCoopNumber += 1;
                player.cash -= merchant.bigDuckCoopToSell[merchant.bigDuckCoopNumber].value;
                System.out.println("You have bought big duck coop.");
            }
            else{
                System.out.println("You don't have enough money to buy big duck coop.");
            }
        }
        else if(whatTypeOfBuilding == "NormalRabbitCoop"){
            if(player.cash >= merchant.normalRabbitCoopToSell[merchant.normalRabbitCoopNumber].value) {
                addRabbitCoop(merchant.normalRabbitCoopToSell[merchant.normalRabbitCoopNumber]);
                merchant.normalRabbitCoopNumber += 1;
                player.cash -= merchant.normalRabbitCoopToSell[merchant.normalRabbitCoopNumber].value;
                System.out.println("You have bought normal rabbit coop.");
            }
            else{
                System.out.println("You don't have enough money to buy normal rabbit coop.");
            }
        }
        else if(whatTypeOfBuilding == "BigRabbitCoop"){
            if(player.cash >= merchant.bigRabbitCoopToSell[merchant.bigRabbitCoopNumber].value) {
                addRabbitCoop(merchant.bigRabbitCoopToSell[merchant.bigRabbitCoopNumber]);
                merchant.bigRabbitCoopNumber += 1;
                player.cash -= merchant.bigRabbitCoopToSell[merchant.bigRabbitCoopNumber].value;
                System.out.println("You have bought big rabbit coop.");
            }
            else{
                System.out.println("You don't have enough money to buy big rabbit coop.");
            }
        }
        else if(whatTypeOfBuilding == "NormalBarn"){
            if(player.cash >= merchant.normalBarnsToSell[merchant.normalBarnNumber].value) {
                addBarn(merchant.normalBarnsToSell[merchant.normalBarnNumber]);
                merchant.normalBarnNumber += 1;
                player.cash -= merchant.normalBarnsToSell[merchant.normalBarnNumber].value;
                System.out.println("You have bought normal barn.");
            }
            else{
                System.out.println("You don't have enough money to buy normal barn.");
            }
        }
        else if(whatTypeOfBuilding == "BigBarn"){
            if(player.cash >= merchant.bigBarnsToSell[merchant.bigBarnNumber].value) {
                addBarn(merchant.bigBarnsToSell[merchant.bigBarnNumber]);
                merchant.bigBarnNumber += 1;
                player.cash -= merchant.bigBarnsToSell[merchant.bigBarnNumber].value;
                System.out.println("You have bought big barn.");
            }
            else{
                System.out.println("You don't have enough money to buy big barn.");
            }
        }
    }

    //selling building
    public void sellBarn(Integer number,Player player){
       if(barns[number].howManyAnimalsIsThere()==0) {
           removeBarn(number);
           player.cash += barns[number].value;
           System.out.println("You have sold barn number: "+ number);
       }
       else{
           System.out.println("You can't sell barn with animals in it!");
       }
    }
    public void sellChickenCoop(Integer number,Player player){
        if(chickenCoops[number].howManyAnimalsIsThere()==0) {
            removeChickenCoop(number);
            player.cash += chickenCoops[number].value;
            System.out.println("You have sold chicken coop number: "+ number);
        }
        else{
            System.out.println("You can't sell chicken coop with animals in it!");
        }
    }
    public void sellDuckCoop(Integer number,Player player){
        if(duckCoops[number].howManyAnimalsIsThere()==0) {
            removeDuckCoop(number);
            player.cash += duckCoops[number].value;
            System.out.println("You have sold duck coop number: "+ number);
        }
        else{
            System.out.println("You can't sell duck coop with animals in it!");
        }
    }
    public void sellRabbitCoop(Integer number,Player player){
        if(rabbitCoops[number].howManyAnimalsIsThere()==0) {
            removeRabbitCoop(number);
            player.cash += rabbitCoops[number].value;
            System.out.println("You have sold rabbit coop number: "+ number);
        }
        else{
            System.out.println("You can't sell rabbit coop with animals in it!");
        }
    }


    // ----------------------------------------- END OF SELLING AND BUYING BUILDING AREA -------------------------------------------------



}
