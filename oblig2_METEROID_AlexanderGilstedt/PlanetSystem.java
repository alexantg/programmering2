
package alexantg.oblig2;

import java.util.ArrayList;
import java.util.Collections;

class PlanetSystem{

    private String name;
    private Star centerStar;
    private ArrayList<Planet> planets= new ArrayList<>();


    //konstruktør

    PlanetSystem(String name, Star centerStar)
    {
        this.name= name;
        this.centerStar= centerStar;
    }


    //get/ set-metoder

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

    @Override
    public String toString() {
        return "Name: " + getName() + ". Center star: " + getCenterStar() + " Some planets: " + "\n" + getPlanets();
    }

    //metode  for å finne største planet først basert på radius, deretter masse

    public Planet getLargestPlanet() {
        double maxRad=-1;
        double maxMasse=-1;

        Planet finalPlanet= new Planet();

        ArrayList<Double> listRadius= new ArrayList<>();

        for(Planet onePlanet: planets){
            listRadius.add(onePlanet.getRadius());
        }

        double maxRadius= Collections.max(listRadius);
        int freq= Collections.frequency(listRadius, maxRadius);

        if(freq>1){
            for(Planet secPlanet: planets){
               if(secPlanet.getMass()>maxMasse){
                   maxMasse= secPlanet.getMass();
                   finalPlanet=secPlanet;
               }
            }
        }
        else{
            for(Planet thrdPlanet: planets){
                if(thrdPlanet.getRadius()>maxRad){
                    maxRad=thrdPlanet.getRadius();
                    finalPlanet= thrdPlanet;

                }
            }
        }
        return finalPlanet;
    }

    //metode for å finne minste planet, sammenlikner basert på radius, eller evt masse

    public Planet getSmallestPlanet(){
        double minRad= planets.get(0).getRadius();
        double minMass= planets.get(0).getMass();

        Planet finalPlanet= new Planet();

        ArrayList<Double> listRadius= new ArrayList<>();

        for(Planet onePlanet: planets){
            listRadius.add(onePlanet.getRadius());
        }

        double minRadius= Collections.min(listRadius);
        int freq= Collections.frequency(listRadius, minRadius);

        if(freq>1){
            for(Planet secPlanet: planets){
                if(secPlanet.getMass()<minMass){
                    minMass= secPlanet.getMass();
                    finalPlanet=secPlanet;
                }
            }
        }
        else{
            for(Planet thrdPlanet: planets){
                if(thrdPlanet.getRadius()<minRad){
                    minRad=thrdPlanet.getRadius();
                    finalPlanet= thrdPlanet;

                }
            }
        }
        return finalPlanet;

    }

}