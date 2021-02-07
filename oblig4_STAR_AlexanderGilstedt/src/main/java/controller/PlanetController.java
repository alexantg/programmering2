package controller;

import io.javalin.http.Context;
import model.Planet;
import org.jetbrains.annotations.NotNull;
import repository.UniverseRepository;

import java.util.ArrayList;
import java.util.Collections;

public class PlanetController {
    private UniverseRepository universeRepository;

    public PlanetController(UniverseRepository universeRepository){
        this.universeRepository= universeRepository;
    }

    //metode for å hente alle planeter i et solsystem, som sorterer på bakgrunn av logikk//
    public void getAllPlanets(@NotNull Context context){
        String name= context.pathParam("planet-system-id");
        String queryPar= context.queryParam("sort_by");

        ArrayList<Planet> planets= universeRepository.getAllPlanets(name);
        ArrayList<Planet> planetsUnsorted= universeRepository.getAllPlanets(name);


        if(queryPar.isBlank()){
            context.json(planetsUnsorted);
        }

        if(queryPar.equals("num")){
            context.json(planets);
        }

        if(queryPar.equals("mass")){
            planets.sort((Planet planet1, Planet planet2) -> (int) (planet2.getMass()-planet1.getMass()));
            context.json(planets);
        }

        if(queryPar.equals("name")) {
            Collections.sort(planets);
            context.json(planets);
        }

        if(queryPar.equals("radius")){
            planets.sort((Planet planet1, Planet planet2) -> (int) (planet2.getRadius()-planet1.getRadius()));
            context.json(planets);
        }

    }

    //henter en planet i et spesifikt solsystem//
    public void getPlanet(@NotNull Context context){
        String name= context.pathParam("planet-system-id");
        String planetName= context.pathParam("planet-id");

        Planet planet= universeRepository.getPlanet(name, planetName);
        context.json(planet);
    }



}
