package no.hiof.alexang.oblig5.repository;

import no.hiof.alexang.oblig5.model.Planet;
import no.hiof.alexang.oblig5.model.PlanetSystem;
import no.hiof.alexang.oblig5.model.Star;

import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;


public class UniverseCSVRepository implements IUniversityRepository {

    private String source;

    HashMap <String, PlanetSystem> planetSystems = new HashMap < > ();

    public UniverseCSVRepository(String source) {
        this.source = source;

        String line = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {

            while ((line = bufferedReader.readLine()) != null) {
                String[] currentArray = line.split(",");

                PlanetSystem planetSystem = new PlanetSystem();
                Star star = new Star();
                Planet planet = new Planet(currentArray[7], Double.parseDouble(currentArray[8]), Double.parseDouble(currentArray[9]), Double.parseDouble(currentArray[10]), Double.parseDouble(currentArray[11]), Double.parseDouble(currentArray[12]), star, currentArray[13]);

                if (!planetSystems.containsKey(currentArray[0])) {
                    star = new Star(currentArray[2], Double.parseDouble(currentArray[3]), Double.parseDouble(currentArray[4]), Double.parseDouble(currentArray[5]), currentArray[6]);
                    planetSystem = new PlanetSystem(currentArray[0], star, currentArray[1]);
                    planetSystem.addPlanet(planet);
                }

                if (planetSystems.containsKey(currentArray[0])) {
                    planetSystem = getPlanetSystem(currentArray[0]);
                    planetSystem.addPlanet(planet);
                }

                planetSystems.put(currentArray[0], planetSystem);
            }

            printToFile(planetSystems, source);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printToFile(HashMap <String, PlanetSystem> list, String source) {
        Thread printThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try (
                        FileWriter fileWriter = new FileWriter(source)) {
                    for (String key: list.keySet()) {
                        for (Planet planet: list.get(key).getPlanets()) {
                            fileWriter.write(list.get(key).toString() + "," + list.get(key).getPlanet(planet.getName()).toString() + "\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        printThread.start();
    }

    @Override
    public PlanetSystem getPlanetSystem(String name) {

        return planetSystems.get(name);
    }

    @Override
    public ArrayList <PlanetSystem> getPlanetSystems() {
        ArrayList <PlanetSystem> planetSystemsList = new ArrayList < > ();
        for (String key: planetSystems.keySet()) {
            planetSystemsList.add(planetSystems.get(key));
        }
        return planetSystemsList;
    }

    @Override
    public Planet getPlanet(String name, String planetName) {
        return planetSystems.get(name).getPlanet(planetName);
    }

    @Override
    public ArrayList <Planet> getPlanets(String planetSystemName) {
        return planetSystems.get(planetSystemName).getPlanets();
    }

    @Override
    public void createPlanet(String planetSystemName, Planet planet) {

        Star celeStialBody = planetSystems.get(planetSystemName).getCenterStar();

        ArrayList < Planet > planetList = getPlanets(planetSystemName);
        planet.setCentralCelestialBody(celeStialBody);
        planetList.add(planet);

        planetSystems.get(planetSystemName).addPlanets(planetList);
        printToFile(planetSystems, source);
    }


    @Override
    public void deletePlanet(String planetSystemName, String planetName) {

        ArrayList <Planet> planetList = getPlanets(planetSystemName);

        planetList.remove(getPlanet(planetSystemName,planetName));

        planetSystems.get(planetSystemName).addPlanets(planetList);
        printToFile(planetSystems, source);
    }

    @Override
    public void updatePlanet(String planetSystemName, String planetName, Planet planet) {
        Star celeStialBody = planetSystems.get(planetSystemName).getCenterStar();
        planet.setCentralCelestialBody(celeStialBody);

        deletePlanet(planetSystemName, planetName);
        createPlanet(planetSystemName, planet);

        printToFile(planetSystems, source);
    }

}