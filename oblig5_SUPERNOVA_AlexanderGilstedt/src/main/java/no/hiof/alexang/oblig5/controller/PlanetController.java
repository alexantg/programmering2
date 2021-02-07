package no.hiof.alexang.oblig5.controller;

import io.javalin.http.Context;
import no.hiof.alexang.oblig5.repository.IUniversityRepository;
import no.hiof.alexang.oblig5.model.Planet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlanetController {
    private IUniversityRepository universeRepository;

    public PlanetController(IUniversityRepository universityRepository) {
        this.universeRepository = universityRepository;
    }

    public void getPlanets(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String queryPar = context.queryParam("sort_by");

        ArrayList<Planet> planets = universeRepository.getPlanets(planetSystemName);

        ArrayList<Planet> planetsUnsorted= universeRepository.getPlanets(planetSystemName);


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
    public void getPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        context.json(universeRepository.getPlanet(planetSystemName, planetName));

    }

    //lager et planetobject fra input i schema- create eller update//
    public Planet planetFromScheme(Context context){

        double semiMajorAxis=0;
        double eccentricity=0;
        double orbitalPeriod=0;
        double mass=Double.parseDouble(context.formParam("mass"));
        double radius= Double.parseDouble(context.formParam("radius"));

        String planetName= context.formParam("name");
        String pictureUrl= context.formParam("pictureUrl");
        //legger inn default bilde fra vue-fil hvis ruten er tom//
        if(pictureUrl.isEmpty()){
            pictureUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png";
        }

        try{
          semiMajorAxis=Double.parseDouble(context.formParam("semiMajorAxis"));
        }
        catch (NumberFormatException e){
            semiMajorAxis=0.0;
        }
        try{
            eccentricity= Double.parseDouble(context.formParam("eccentricity"));
        }
        catch (NumberFormatException e){
            eccentricity=0;
        }
        try{
            orbitalPeriod= Double.parseDouble(context.formParam("orbitalPeriod"));
        }
        catch (NumberFormatException e){
            orbitalPeriod=0;
        }

        return new Planet(planetName,mass,radius,semiMajorAxis,eccentricity,orbitalPeriod,pictureUrl);
    }

    //metode som kaller lag en ny planet//
    public void createPlanet(Context context){
        String planetSystemName = context.pathParam("planet-system-id");

        universeRepository.createPlanet(planetSystemName,planetFromScheme(context));
        String url = "http://localhost:7000/planet-systems/"+planetSystemName;
        context.redirect(url);
    }

    //metode som kaller oppdater-planet//
    public void updatePlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        universeRepository.updatePlanet(planetSystemName, planetName,planetFromScheme(context));

        String url = "http://localhost:7000/planet-systems/"+planetSystemName;
        context.redirect(url);
    }

    //metode som kaller slett-planet//
    public void deletePlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        universeRepository.deletePlanet(planetSystemName,planetName);
        String url = "http://localhost:7000/planet-systems/"+planetSystemName;
        context.redirect(url);
    }
}
