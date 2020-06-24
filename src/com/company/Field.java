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
        }
        if(typeOfPlantToSow=="wheat"){
            typeOfPlantThatGrow="wheat";
            isSown=true;
            plant = new Plant("wheat");
        }
        if(typeOfPlantToSow=="lettuce"){
            typeOfPlantThatGrow="lettuce";
            isSown=true;
            plant = new Plant("lettuce");
        }
        if(typeOfPlantToSow=="strawberry"){
            typeOfPlantThatGrow="strawberry";
            isSown=true;
            plant = new Plant("strawberry");
        }
    }

    public void wateringAndWeeding(){
        wateredAndWeeding = true;
        System.out.println("You watered and weeded your field with " + typeOfPlantThatGrow);
    }

    public void plantsGrowing(){
        if(wateredAndWeeding=true) {
            plant.plantGrow();
            wateredAndWeeding = false;
            System.out.println("Plants on this field are growing! weeeee");
        }
    }

    public void checkIfReadyToGather(){
        if(plant.currentHight==plant.hightWhenAduld){
            readyToGather= true;
            System.out.println("Plants are ready to gather on this field.");
        }
    }
    //gathering harvest and field is empty then and player is able to sow it again.
    public void gatherHarvest(){
      checkIfReadyToGather();
      if(readyToGather=true) {
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
          System.out.println("You gather from field with "+ typeOfPlantThatGrow + " harvest.");
      }else{
          System.out.println("Plants on this field are not ready to gather, let them grow and try next time.");
      }

    }
}
