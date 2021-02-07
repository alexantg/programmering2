package no.hiof.alexantg.oblig3;

public abstract class CelestialBody {

    private String name;
    private double mass;
    private double radius;

    public CelestialBody(String name,double radius, double mass) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Name: "+ getName() + " | Radius:  " + getRadius() + " km | Mass: " + getMass() + " kg " + "\n";
    }



}
