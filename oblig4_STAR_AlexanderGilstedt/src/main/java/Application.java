import controller.MoonController;
import controller.PlanetController;
import controller.PlanetSystemController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;
import repository.UniverseRepository;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        //oppgave 2.3//
          app.get("/", new Handler() {
                @Override
                public void handle(@NotNull Context ctx) throws Exception {
                    ctx.result("Hello, world");
                }
          });

        //views//
        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));

        app.get("/planet-systems/:planet-system-id/planets", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));

        app.get("/planet-systems/:planet-system-id/planets/:planet-id/moons/:moon-id", new VueComponent("moon-detail"));



        //API//

        UniverseRepository universeRepository= new UniverseRepository();
        PlanetSystemController planetSystemController= new PlanetSystemController(universeRepository);
        PlanetController planetController= new PlanetController(universeRepository);
        MoonController moonController= new MoonController(universeRepository);

        app.get("api/planet-systems", ctx -> planetSystemController.getAllPlanetSystems(ctx));
        app.get("api/planet-systems/:planet-system-id", ctx -> planetSystemController.getOnePlanetSystem(ctx));

        app.get("api/planet-systems/:planet-system-id/planets",ctx -> planetController.getAllPlanets(ctx));
        app.get("api/planet-systems/:planet-system-id/planets/:planet-id", ctx -> planetController.getPlanet(ctx));

        app.get("api/planet-systems/:planet-system-id/planets/:planet-id/moons/:moon-id", ctx -> moonController.getMoon(ctx));

    }
}

