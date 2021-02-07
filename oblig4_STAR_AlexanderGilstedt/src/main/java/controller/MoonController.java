package controller;
import io.javalin.http.Context;
import model.Moon;
import org.jetbrains.annotations.NotNull;
import repository.UniverseRepository;

import java.util.ArrayList;

public class MoonController {
    private UniverseRepository universeRepository;

    public MoonController(UniverseRepository universeRepository){
        this.universeRepository= universeRepository;
    }

    //metode for å hente alle måner//
   public void getAllMoons(@NotNull Context context){
        String name= context.pathParam("planet-system-id");
        String planetName= context.pathParam("planet-id");

        ArrayList<Moon> moons = universeRepository.getAllMoons(name, planetName);
        context.json(moons);
    }

    //metode for å hente en spesifikk måne//

    public void getMoon(@NotNull Context context){
        String systemName= context.pathParam("planet-system-id");
        String planetName= context.pathParam("planet-id");
        String moonName= context.pathParam("moon-id");

        Moon moon= universeRepository.getMoon(systemName,planetName,moonName);

        context.json(moon);
    }


}
