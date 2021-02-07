package repository;

import model.Moon;
import model.Planet;
import model.PlanetSystem;

import java.util.ArrayList;

public interface IUniverseRepository {

    ArrayList<PlanetSystem> getAllPlanetSystems();
    PlanetSystem getPlanetSystem(String name);
    ArrayList<Planet> getAllPlanets(String name);
    Planet getPlanet(String name, String planetName);
    ArrayList<Moon> getAllMoons(String systemName, String planetName);
    Moon getMoon(String systemName, String planetName, String moonName);


}
