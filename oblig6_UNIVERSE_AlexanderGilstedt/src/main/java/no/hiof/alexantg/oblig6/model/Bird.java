package no.hiof.alexantg.oblig6.model;

public class Bird extends Animal {
    private boolean canFly;
    private double weight;
    private double topSpeedKmh;

    public Bird(String name, String scientificName, int numberofLegs, boolean canFly, double weight, double topSpeedKmh) {
        super(name, scientificName, numberofLegs);
        this.canFly = canFly;
        this.weight = weight;
        this.topSpeedKmh = topSpeedKmh;
    }

    public Bird(){

    }


    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTopSpeedKmh() {
        return topSpeedKmh;
    }

    public void setTopSpeedKmh(double topSpeedKmh) {
        this.topSpeedKmh = topSpeedKmh;
    }

    public String canBirdFly(){
        if(this.canFly){
            return " It can absolutely fly ";
        }
       else if(!this.canFly){
            return " I Wouldn't count on this guy flying";
        }
       return null;
    }

    @Override
    public String toString() {
        return " The bird named " + getName() + " is actually called " + getScientificName() + " It has " + getNumberofLegs() +
                " legs " + canBirdFly();
    }
}
