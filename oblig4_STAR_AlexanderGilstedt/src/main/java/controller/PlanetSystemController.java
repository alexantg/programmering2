package controller;

import io.javalin.http.Context;
import model.Planet;
import model.PlanetSystem;
import org.jetbrains.annotations.NotNull;
import repository.UniverseRepository;

import java.util.ArrayList;


public class PlanetSystemController {

    private UniverseRepository universeRepository;

    public PlanetSystemController(UniverseRepository universeRepository){
        this.universeRepository= universeRepository;
    }


    //henter alle planetsystemer
    public void getAllPlanetSystems(@NotNull Context context){

        ArrayList<PlanetSystem> allSystems= universeRepository.getAllPlanetSystems();
        context.json(allSystems);

    }

    //henter en spesifikt planetsystem
    public void getOnePlanetSystem(@NotNull Context context){
        String name= context.pathParam("planet-system-id");

        PlanetSystem planetSystem= universeRepository.getPlanetSystem(name);
        context.json(planetSystem);

    }

}
