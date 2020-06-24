package com.company;

public  class Plant {
    public final String species;
    public Double hightWhenAduld; //in cm
    public Double currentHight=0.0; // in cm


    protected Plant(String species) {
        this.species = species;
        if(species == "oat"){
            hightWhenAduld = 50.0;
        }
        else if(species == "wheat"){
            hightWhenAduld = 50.0;
        }
        else if(species == "lettuce"){
            hightWhenAduld =10.0;
        }
        else if(species == "strawberry"){
            hightWhenAduld = 15.0;
        }
    }

    public Double plantGrow(){
        if(currentHight<hightWhenAduld)
        {
            return currentHight += 3.0;

        }
        else{
            return currentHight;
        }
    }
}
