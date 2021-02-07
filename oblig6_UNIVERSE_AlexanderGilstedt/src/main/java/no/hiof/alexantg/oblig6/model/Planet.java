package no.hiof.alexantg.oblig6.model;

public class Planet {

    private String name;
    private double radius;
    private double mass;

    public Planet(String name, double radius, double mass) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public Planet(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "The " + name + " has a radius of " + radius + " km, and a mass of " + mass +  "kg";
    }
}
