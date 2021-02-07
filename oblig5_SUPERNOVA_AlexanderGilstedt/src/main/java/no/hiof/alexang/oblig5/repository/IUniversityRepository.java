package no.hiof.alexang.oblig5.repository;

import no.hiof.alexang.oblig5.model.Planet;
import no.hiof.alexang.oblig5.model.PlanetSystem;

import java.util.ArrayList;

public interface IUniversityRepository {
    PlanetSystem getPlanetSystem(String planetSystemName);
    ArrayList<PlanetSystem> getPlanetSystems();
    Planet getPlanet(String planetSystemName, String planet);
    ArrayList<Planet> getPlanets(String planetSystemName);
    void createPlanet(String planetSystemName, Planet planet);
    void deletePlanet(String planetSystemName, String planetName);
    void updatePlanet(String planetSystemName, String planetName, Planet planet);
}
