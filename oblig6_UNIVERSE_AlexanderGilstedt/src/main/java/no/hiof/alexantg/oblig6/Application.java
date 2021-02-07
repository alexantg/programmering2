package no.hiof.alexantg.oblig6;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.alexantg.oblig6.controller.MolController;
import no.hiof.alexantg.oblig6.repository.MapOfLifeRepository;

public class Application{

    public static void main(String[] args) {

    Javalin app = Javalin.create().start(7000);
    app.config.enableWebjars();

    MapOfLifeRepository mapOfLifeRepository= new MapOfLifeRepository("observations.json");

    //need to read the observations back to an arraylist in order to use repository//
    mapOfLifeRepository.readObserVationsFromFile();
    MolController controller= new MolController(mapOfLifeRepository);

        app.before("/", ctx -> ctx.redirect("/observations"));

    //views//

        app.get("/observations", new VueComponent("observations-overview"));
        app.get("/observations/create", new VueComponent("create-observation"));
        app.get("/observations/:observation-id", new VueComponent("observation-detail"));
        app.get("/observations/:observation-id/animal", new VueComponent("animal-detail"));



    //api//

        //Return different biom-types//
        app.get("api/observations/biomTypes", controller::getBiomTypes);

        app.get("api/observations", controller::getAllObservations);

        app.get("api/observations/:observation-id", controller::getObservation);

        app.get("api/observations/:observation-id/animal", controller::getAnimal);

        app.post("api/observations/create", controller::createObservation);

        app.get("api/observations/:observation-id/:location-id/planet", controller::getPlanetFromObservation);

        //CRUD//
        app.get("api/observations/:observation-id/delete",controller::deleteObservation);






  }
}
