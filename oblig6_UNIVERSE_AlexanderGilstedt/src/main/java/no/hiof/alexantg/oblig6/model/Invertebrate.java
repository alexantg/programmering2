package no.hiof.alexantg.oblig6.model;

public class Invertebrate extends Animal{

    private boolean livesAtSea;
    private double length;

    public Invertebrate(String name, String scientificName, int numberofLegs, boolean livesAtSea, double length) {
        super(name, scientificName, numberofLegs);
        this.livesAtSea = livesAtSea;
        this.length = length;
    }

    public Invertebrate(){

    }

    public boolean isLivesAtSea() {
        return livesAtSea;
    }

    public void setLivesAtSea(boolean livesAtSea) {
        this.livesAtSea = livesAtSea;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String doesItLiveAtSea(){
        if(this.livesAtSea){
            return " Born to swim ";
        }
        if(!this.livesAtSea){
            return " Prefers the dry land ";
        }
        return null;
    }

    @Override
    public String toString() {
        return "The" + getName() + "is actually called " + getScientificName() + " it has " + getNumberofLegs() + doesItLiveAtSea();
    }
}
