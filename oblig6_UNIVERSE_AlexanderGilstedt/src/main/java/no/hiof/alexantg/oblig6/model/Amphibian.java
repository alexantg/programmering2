package no.hiof.alexantg.oblig6.model;

public class Amphibian extends Animal{

    private boolean hasTale;
    private String habitat;

    public Amphibian(String name, String scientificName, int numberofLegs, boolean hasTale, String habitat) {
        super(name, scientificName, numberofLegs);
        this.hasTale = hasTale;
        this.habitat = habitat;
    }

    public Amphibian(){

    }

    public boolean isHasTale() {
        return hasTale;
    }

    public void setHasTale(boolean hasTale) {
        this.hasTale = hasTale;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String doesTaleExist(){
        if (this.hasTale){
            return "It has a tale";
        }
        else if(!this.hasTale){
            return "It does not have a tale";
        }
        return null;
    }

    //overider to-string metoden//
    @Override
    public String toString() {
        return getName() + " is actually a " + getScientificName() + " and has " + getNumberofLegs() +  " legs "+ doesTaleExist();
    }
}
