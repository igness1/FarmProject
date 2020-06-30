package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player();
        Merchant merchant = new Merchant();

        System.out.println("WELCOME IN FARM STORY");
        System.out.println();
        System.out.println("You start the game with one of three farms to choose (selected randomly) and with 2000 coins.\n" +
                "This farm has empty fields (for cultivation), and zero animals (you have to buy animals)\n" +
                "and zero buildings (you have to buy them too).\n" +
                "You have 150 weeks to achieve the goal. If you fail, you lose.\n" +
                "At the start you have 10 bags of seeds from each plant species.\n" +
                "The goal of the game is to achieve richness(10 000.0 coins) as quickly as possible in the shortest possible time.\n" +
                "Time is defined by weeks. Maximum you can have 10 farms.\n" +
                "Sell harvest and items from animals, buy animals and buildings and develop your farm.\n" +
                "Earn and invest money into next farms to become a super farmer. Remember to take care of animals and crops.\n" +
                "Few tips: \n" +
                "- You have to feed animals once a week, otherwise they will starve.\n Remember to make sure you have anything to feed the animals. They must be fed to grow.\n" +
                "- You can't buy animals when you don't have place for them. Each type of animal has a building. For example: cows need barn.\n" +
                "- Gathering harvest and raw material from animals is done automatically once a week too.\n" +
                "- Animals give items,for example eggs, when they are adult. You can buy only young animals. They need time and food to grow, remember.");

        System.out.println("You can choose your first farm for free, without paying for it.\n" +
                "3 random farms, choose 1.");
        player1.getRandom3Farms(merchant);
        System.out.println();
        System.out.println( "Farm number 1: " + player1.randomFarm1.toString() );
        System.out.println( "Farm number 2: " + player1.randomFarm2.toString() );
        System.out.println( "Farm number 3: " + player1.randomFarm3.toString() );
        System.out.println();
        firstFarm(player1,merchant);
        System.out.println();
        readyToStart(player1,merchant);


    }
    public static void week(Player player, Merchant merchant){
        Integer weekNumber = 1;
        do {

            System.out.println("\nWEEK " + weekNumber);
            System.out.println();
            System.out.println("Your cash: " + player.cash + " coins.");
            System.out.println();
            System.out.println("Your farms:");
            player.presentYourFarms();
            System.out.println();
            System.out.println("Your buildings and animals there: ");
            player.presentBuildingAndAnimalsThere();
            System.out.println("Your fields: ");
            player.presentYourFields();
            System.out.println();
            menuWeek(player, merchant);

            for (Integer i = 0; i < player.farms.length; i++) {
                if (player.farms[i] != null) {
                    player.farms[i].animalGrowingOrNot();
                    player.farms[i].plantGrowing();
                    player.farms[i].gatheringHarvestFromAllField();
                    player.farms[i].removedDeadAnimals();
                    player.farms[i].AddHarvestsFromFieldsToSum();
                    player.farms[i].allAnimalsMakeRawMaterial();
                    player.farms[i].addRawMaterialToSum();
                }
            }

            weekNumber += 1;

        }
        while(weekNumber < 150);
        if(player.cash >= 10000.0) {
            System.out.println("You win the game! Congratulations!");
        }
        else{
            System.out.println("You lost the game! Congratulations!");
        }


    }
    public static void menuWeek(Player player, Merchant merchant){
        Integer answer = 0;
        do{
             System.out.println("\nWhat do you want to do this week?");
             System.out.println();
             System.out.println("1 -buildings management.");
             System.out.println("2 -animals management.");
             System.out.println("3 -fields management.");
             System.out.println("4 -farms management.");
             System.out.println("5 -end week and start next week.(Let the animals and plants grow :) )");
             Scanner scan = new Scanner(System.in);
             answer = scan.nextInt();
             if(answer == 1) {
                buildingManagement(player, merchant);
             }
             else if(answer == 2){
                animalManagement(player,merchant);
             }
             else if(answer == 3){
                fieldManagement(player,merchant);
             }
             else if(answer == 4){
                farmManagement(player,merchant);
             }
        }
        while (answer !=5);
    }
    public static void firstFarm(Player player, Merchant merchant){
        System.out.println("Enter the number of the farm with which you want to start the game.");
        Scanner scan = new Scanner(System.in);
        Integer numberOfFirstFarm = scan.nextInt();

        if(numberOfFirstFarm == 1){
            player.add(player.randomFarm1);
            merchant.removeFarm(player.randomFarm1);
            System.out.println("You choose your first farm. It was added to your farm list.");
        }
        else if(numberOfFirstFarm == 2){
            player.add(player.randomFarm2);
            merchant.removeFarm(player.randomFarm2);
            System.out.println("You choose your first farm. It was added to your farm list.");
        }
        else if(numberOfFirstFarm == 3){
            player.add(player.randomFarm3);
            merchant.removeFarm(player.randomFarm3);
            System.out.println("You choose your first farm. It was added to your farm list.");
        }
        else{
            System.out.println("You enter not correct number, try again.");
            firstFarm(player, merchant);
        }
    }
    public static void readyToStart(Player player, Merchant merchant){
        System.out.println("Ready to start a game? (Enter: yes/no)");
        Scanner scan1 = new Scanner(System.in);
        String answer = scan1.nextLine();
        if(answer.equals("yes") || answer.equals("YES") || answer.equals("Yes")){
        week(player,merchant);
        }
        else if(answer.equals("NO") || answer.equals("No") || answer.equals("no")){
            System.out.println("Okey, then goodbye :)");
            System.exit(0);
        }
        else{
            System.out.println("Incorrect answer, try again.");
            readyToStart(player,merchant);
        }
    }

    public static void buildingManagement(Player player, Merchant merchant){
        System.out.println("Buildings management menu:");
        System.out.println();
        System.out.println("1 - Buy building.");
        System.out.println("2 - Sell building.");
        System.out.println("3 - Return to main menu.");
        Scanner scan = new Scanner(System.in);
        Integer answer = scan.nextInt();
        switch (answer){
            case 1:
                player.buyBuilding(merchant);
                break;
            case 2:
                player.sellBuilding(merchant);
                break;
            case 3:
                break;
            default:
                System.out.println("Incorrect answer.Try again");
                buildingManagement(player,merchant);
                break;
        }
    }

    public static void animalManagement(Player player, Merchant merchant){
        System.out.println("Animals management menu:");
        System.out.println();
        System.out.println("1 - Buy animals.");
        System.out.println("2 - Sell animals.");
        System.out.println("3 - Feed animals(important!).");
        System.out.println("4 - Buy animal food.");
        System.out.println("5 - Sell raw material(egss, milk, meat).");
        System.out.println("6 - Return to main menu.");
        Scanner scan = new Scanner(System.in);
        Integer answer = scan.nextInt();
        switch (answer){
            case 1:
                player.buyAnimal(merchant);
                break;
            case 2:
                player.sellAnimal(merchant);
                break;
            case 3:
                player.feedAnimals();
                break;
            case 4:
                player.buyAnimalFood(merchant);
                break;
            case 5:
                player.sellRawMaterial(merchant);
                break;
            case 6:
                break;
            default:
                System.out.println("Incorrect answer. Try again");
                animalManagement(player,merchant);
                break;
        }
    }

    public static void fieldManagement(Player player, Merchant merchant){
        System.out.println("Field management menu: ");
        System.out.println();
        System.out.println("1 - Sow field.");
        System.out.println("2 - Water and green the fields.(Plants need this to grow)");
        System.out.println("3 - Sell harvest.");
        System.out.println("4 - Buy seeds.");
        System.out.println("5 - Return to main menu.");
        Scanner scan = new Scanner(System.in);
        Integer answer = scan.nextInt();
        switch (answer){
            case 1:
                player.sowField();
                break;
            case 2:
                player.waterAndGreenFields();
                break;
            case 3:
                player.sellHarvest(merchant);
                break;
            case 4:
                player.buySeeds(merchant);
                break;
            default:
                System.out.println("Incorrect answer.Try again");
                fieldManagement(player,merchant);
                break;
        }
    }

    public static void farmManagement(Player player,Merchant merchant){
        System.out.println("Farm management menu: ");
        System.out.println();
        System.out.println("1 - Buy farm.");
        System.out.println("2 - Sell farm");
        System.out.println("3 - Show my items.");
        System.out.println("4 - Return to main menu.");
        Scanner scan = new Scanner(System.in);
        Integer answer = scan.nextInt();
        switch (answer){
            case 1:
                player.buyFarm(merchant);
                break;
            case 2:
                player.sellFarm();
                break;
            case 3:
                for(Integer i=0;i<player.farms.length;i++){
                    if(player.farms[i] != null){
                        System.out.println("FARM NUMBER " + i);
                        System.out.println("Liters of milk: " + player.farms[i].sumOfMilk);
                        System.out.println("Number of chicken eggs: " + player.farms[i].sumOfchickenEggAmount);
                        System.out.println("Number of duck eggs: " + player.farms[i].sumOfduckEggAmount);
                        System.out.println("Kg of rabbit meat: " + player.farms[i].sumOfRabbitMeatAmount);
                        System.out.println("Sum of wheat harvest in tonnes: " + player.farms[i].sumOfwheatHarvest);
                        System.out.println("Sum of oat harvest in tonnes: " + player.farms[i].sumOfoatHarvest);
                        System.out.println("Sum of lettuce harvest in tonnes: " + player.farms[i].sumOfLettuceHarvest);
                        System.out.println("Sum of strawberry harvest in tonnes: " + player.farms[i].sumOfStrawberryHarvest);
                    }
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Incorrect answer.Try again");
                farmManagement(player,merchant);
                break;
        }
    }

}
