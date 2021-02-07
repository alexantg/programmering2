package model;

public abstract class CelestialBody implements Comparable<CelestialBody>{

    private String name;
    private String pictureUrl;
    private double mass;
    private double radius;

    public CelestialBody(String name,double mass, double radius, String pictureUrl) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.pictureUrl= pictureUrl;

    }

    public CelestialBody(String name, double radius, double mass) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public CelestialBody(){};

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    //Oppgave 2.2//Sorterer på masse//
    @Override
    public int compareTo(CelestialBody celestialBody) {
        return this.getName().compareTo(celestialBody.getName());
    }

}
