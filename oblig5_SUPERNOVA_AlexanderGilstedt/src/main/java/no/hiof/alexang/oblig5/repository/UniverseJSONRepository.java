package no.hiof.alexang.oblig5.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.alexang.oblig5.model.Planet;
import no.hiof.alexang.oblig5.model.PlanetSystem;
import no.hiof.alexang.oblig5.model.Star;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UniverseJSONRepository implements IUniversityRepository{

    ArrayList<PlanetSystem> planetSystemListeFraFil = new ArrayList<>();
    private String source;

    public UniverseJSONRepository(String source){
        this.source= source;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.PROPERTY);

        try {
            PlanetSystem[] planetSystemsArray = objectMapper.readValue(new File(source), PlanetSystem[].class);
            planetSystemListeFraFil.addAll(Arrays.asList(planetSystemsArray));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //egen metode som kan lese
    public ArrayList<PlanetSystem> readFromFile(String source){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.PROPERTY);

        try {
            PlanetSystem[] planetSystemsArray = objectMapper.readValue(new File(source), PlanetSystem[].class);
            planetSystemListeFraFil.addAll(Arrays.asList(planetSystemsArray));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return planetSystemListeFraFil;
    }

    //Metode/tråd for å skrive dataen tilbake til filen//

    public void printToFile(ArrayList<PlanetSystem> planetSystems, String source) throws IOException {

          Thread printThread= new Thread(new Runnable() {
              @Override
              public void run() {
                  ObjectMapper objectMapper= new ObjectMapper();

                  try {
                      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(source), planetSystems);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          });
          printThread.start();
    }

    //metode for å hente ett planetsystem
    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        for(PlanetSystem oneSystem: planetSystemListeFraFil){
            if(planetSystemName.equals(oneSystem.getName())){
                return oneSystem;
            }
        }
        return null;
    }

    //metode for å hente alle planetsystemer
    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return planetSystemListeFraFil;
    }

    @Override
    public Planet getPlanet(String planetSystemName, String planet) {
        for(PlanetSystem oneSystem: planetSystemListeFraFil){
            if(planetSystemName.equals(oneSystem.getName())){
                for(Planet onePlanet: oneSystem.getPlanets()){
                    if(planet.equals(onePlanet.getName())){
                        return onePlanet;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
        for(PlanetSystem oneSystem: planetSystemListeFraFil){
            if(planetSystemName.equals(oneSystem.getName())){
                return oneSystem.getPlanets();
            }
        }
        return null;
    }

    @Override
     public void createPlanet(String planetSystemName,Planet planet){
        //logikk for å gi planet-objektet en center-star

        Star celeStialBody= new Star();
        for(PlanetSystem system: planetSystemListeFraFil){
            if(planetSystemName.equals(system.getName())){
                celeStialBody= system.getCenterStar();
            }
        }

        ArrayList<Planet> planetList= getPlanets(planetSystemName);
        planet.setCentralCelestialBody(celeStialBody);
        planetList.add(planet);
        getPlanetSystem(planetSystemName).addPlanets(planetList);

        try {
            printToFile(planetSystemListeFraFil,source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    //OBS- tar utgangspunkt i at alle planeter har unike navn//
    public void deletePlanet(String planetSystemName, String planetName) {

        ArrayList<Planet> planetList= getPlanets(planetSystemName);

        planetList.removeIf(planet -> planetName.equals(planet.getName()));
        getPlanetSystem(planetSystemName).addPlanets(planetList);

        try {
            printToFile(planetSystemListeFraFil,source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //metode for å oppdatere en planet//
    @Override
    public void updatePlanet(String planetSystemName, String planetName, Planet planet) {
        Star celeStialBody= new Star();

        for(PlanetSystem system: planetSystemListeFraFil){
            if(planetSystemName.equals(system.getName())){
                celeStialBody= system.getCenterStar();
            }
        }
        ArrayList<Planet> planetList= getPlanets(planetSystemName);
        planet.setCentralCelestialBody(celeStialBody);

        //sletter planeten som jobbes med, og legger den oppdaterte inn på nytt//
        for(Planet onePlanet: planetList){
            if(planetName.equals(onePlanet.getName())){
                deletePlanet(planetSystemName,onePlanet.getName());
                createPlanet(planetSystemName, planet);
            }
        }
        try {
            printToFile(planetSystemListeFraFil,source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
