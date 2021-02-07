package model;

import java.util.ArrayList;

public class Planet extends NaturalSatellite {

    //lager kostanter//
    public static final double ONE_MJUP= 1.898E27;
    public static final double ONE_RJUP= 71942.0;

    public static final double ONE_MEARTH= 5.972E24;
    public static final double ONE_REARTH= 6371;

    public static final double GRAV_CONST=0.00000000006674;

    private ArrayList<Moon> moons= new ArrayList<>();

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public void setMoons(Moon moon) {
        this.moons.add(moon);
    }

    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccesentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl){
        super(name,mass,radius, semiMajorAxis,eccesentricity,orbitalPeriod, centralCelestialBody, pictureUrl);
    }

    public Planet() {

    }

    //metode for å returnere jupiter masse//

    public double findMjup(){
        return this.getMass()/ONE_MJUP;
    }

    //metode for å returnere jupiter radius//

    public double findRjup(){
        return (this.getRadius()/ ONE_RJUP);
    }

    //metode for å returnere jord-masse//

    public double findMearth(){
        return (this.getMass()/ONE_MEARTH);
    }

    public double findRearth(){
        return (this.getRadius()/ONE_REARTH);
    }

    //metode for å returere gravitasjon//
    public double surfaceGravity(){

        return (GRAV_CONST*this.getMass())/Math.pow(this.getRadius()*1000,2);

    }

    @Override
    public String toString() {
        return "Name: "+ getName() + " | Radius:  " + getRadius() + " km | Mass: " + getMass() + " kg " + "\n";
    }

}

