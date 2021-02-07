package no.hiof.alexang.oblig5;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.alexang.oblig5.controller.PlanetController;
import no.hiof.alexang.oblig5.controller.PlanetSystemController;
import no.hiof.alexang.oblig5.repository.UniverseCSVRepository;
import no.hiof.alexang.oblig5.repository.UniverseJSONRepository;

//import no.hiof.alexang.oblig5.repository.UniverseDBRepository;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/planet-systems"));


      //  String url = "jdbc:mysql://localhost:3306/universedbrepository?useSSL=false&serverTimezone=UTC";
      //  String bruker = "root";
      //  String password = "3341GrsTv";


      //  UniverseDBRepository universeDBRepository= new UniverseDBRepository(url,bruker,password);


        UniverseCSVRepository universeCSVRepository= new UniverseCSVRepository("planets_4000.csv");
        UniverseJSONRepository universeJSONRepository = new UniverseJSONRepository("planets_4000.json");

        PlanetSystemController planetSystemController = new PlanetSystemController(universeJSONRepository);
        PlanetController planetController = new PlanetController(universeJSONRepository);

        //views//
        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));


        //api//
        app.get("api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("api/planet-systems/:planet-system-id", planetSystemController::getPlanetSystem);

        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getPlanet);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", planetController::deletePlanet);
        app.post("/api/planet-systems/:planet-system-id/planets/:planet-id/update", planetController::updatePlanet);
        app.post("/api/planet-systems/:planet-system-id/createplanet", planetController::createPlanet);

    }



}
