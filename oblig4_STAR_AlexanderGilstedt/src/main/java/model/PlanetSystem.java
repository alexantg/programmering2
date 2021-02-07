package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class PlanetSystem implements Comparable<CelestialBody> {

    private String name;
    private Star centerStar;
    private String pictureUrl;
    private ArrayList<Planet> planets= new ArrayList<>();


    public PlanetSystem(String name, Star centerStar, String pictureUrl)
    {
        this.name= name;
        this.centerStar= centerStar;
        this.pictureUrl= pictureUrl;
    }


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

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Planet planet) {
        this.planets.add(planet);
    }

    //metode for å returnere minste planet
   public Planet getSmallestPlanet() {
        if(planets.size() == 0)
            return null;

        Planet smallestPlanet = planets.get(0);

        for (Planet currentPlanet : planets) {
            if (currentPlanet.getRadius() < smallestPlanet.getRadius()) {
                smallestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == smallestPlanet.getRadius()) {
                if (currentPlanet.getMass() < smallestPlanet.getMass())
                    smallestPlanet = currentPlanet;
            }
        }

        return smallestPlanet;
    }


    //metode for å finne største planet//

    public Planet getLargestPlanet() {
        if (planets.size() == 0)
            return null;

        Planet largestPlanet = planets.get(0);

        for (Planet currentPlanet : planets) {
            if (currentPlanet.getRadius() > largestPlanet.getRadius()) {
                largestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == largestPlanet.getRadius()) {
                if (currentPlanet.getMass() > largestPlanet.getMass())
                    largestPlanet = currentPlanet;
            }
        }

        return largestPlanet;
    }


    //2.3, hente planet basert på navn

    public Planet getPlanetByName(String planetName){

        Planet finalPlanet= planets.get(0);

        for(Planet planetObject: planets){
            if(planetName.equals(planetObject.getName())){
                finalPlanet= planetObject;
            }
        }
        return finalPlanet;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ". Center star: " + getCenterStar() + " Some planets: " + "\n" + getPlanets();
    }

    @Override
    public int compareTo(@NotNull CelestialBody o) {
        return 0;
    }
}