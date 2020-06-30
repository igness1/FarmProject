package com.company;

public class Field {

    public final Double size=1.0; //in hectare
    public  String typeOfPlantThatGrow = null;
    public Plant plant;


    public Boolean isSown=false;
    public Boolean readyToGather=false;
    public Boolean wateredAndWeeding=false;

    public Double oatHarvest=0.0;
    public Double wheatHarvest=0.0;
    public Double lettuceHarvest=0.0;
    public Double strawberryHarvest=0.0;


    public void sowTheField(String typeOfPlantToSow){
        if(typeOfPlantToSow=="oat"){
            typeOfPlantThatGrow="oat";
            isSown=true;
            plant = new Plant("oat");
            System.out.println("You sowed this field with " +typeOfPlantToSow + ".");
        }
        if(typeOfPlantToSow=="wheat"){
            typeOfPlantThatGrow="wheat";
            isSown=true;
            plant = new Plant("wheat");
            System.out.println("You sowed this field with " +typeOfPlantToSow + ".");
        }
        if(typeOfPlantToSow=="lettuce"){
            typeOfPlantThatGrow="lettuce";
            isSown=true;
            plant = new Plant("lettuce");
            System.out.println("You sowed this field with " +typeOfPlantToSow + ".");
        }
        if(typeOfPlantToSow=="strawberry"){
            typeOfPlantThatGrow="strawberry";
            isSown=true;
            plant = new Plant("strawberry");
            System.out.println("You sowed this field with " +typeOfPlantToSow + ".");
        }
    }

    public void wateringAndWeeding(){
        wateredAndWeeding = true;
        System.out.println("You watered and weeded your field with " + typeOfPlantThatGrow);
    }

    public void plantsGrowing(){
        if(wateredAndWeeding==true) {
            if(isSown) {
                plant.plantGrow();
                wateredAndWeeding = false;
                System.out.println("Plants on this field are growing! weeeee");
            }
            else {
                System.out.println("No plant to grow on this field.");
            }
        }
        else{
            System.out.println("You didn't care about this field this week.");;
        }
    }

    public void checkIfReadyToGather(){
        if(plant.currentHight==plant.hightWhenAduld){
            readyToGather= true;
        }
    }
    //gathering harvest and field is empty then and player is able to sow it again.
    public void gatherHarvest(){
        if(isSown) {
            checkIfReadyToGather();
            if (readyToGather == true) {
                if (typeOfPlantThatGrow == "oat") {
                    oatHarvest = 1.0;
                    typeOfPlantThatGrow = null;
                    isSown = false;
                    readyToGather = false;
                }
                if (typeOfPlantThatGrow == "wheat") {
                    wheatHarvest += 1.0;
                    typeOfPlantThatGrow = null;
                    isSown = false;
                    readyToGather = false;
                }
                if (typeOfPlantThatGrow == "lettuce") {
                    lettuceHarvest += 1.0;
                    typeOfPlantThatGrow = null;
                    isSown = false;
                    readyToGather = false;
                }
                if (typeOfPlantThatGrow == "strawberry") {
                    strawberryHarvest += 1.0;
                    typeOfPlantThatGrow = null;
                    isSown = false;
                    readyToGather = false;
                }
                System.out.println("You gather from field with " + typeOfPlantThatGrow + " harvest.");
            } else {
                System.out.println("Plants on this field are not ready to gather, let them grow and try next time.");
            }
        }
        else{
            System.out.println("No harvest to gather because field is empty, sow field.");
        }

    }

    @Override
    public String toString(){
        if(isSown){
            checkIfReadyToGather();
             return "Field :   Plant species that grow: "+ this.typeOfPlantThatGrow + " | Is it ready to gather harvest?: " +this.readyToGather;
        }
        else{
            return "Empty field. Ready to plant something on it.";
        }
    }
}
