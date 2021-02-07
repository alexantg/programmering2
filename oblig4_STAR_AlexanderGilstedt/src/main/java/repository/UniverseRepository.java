package repository;

import model.Moon;
import model.Planet;
import model.PlanetSystem;
import model.Star;

import java.util.ArrayList;

public class UniverseRepository implements IUniverseRepository {
    private ArrayList<PlanetSystem> planetSystems= new ArrayList<>();

    //konstruktør som tar et planetsystem som parameter og legger det til i listen//

    public UniverseRepository(){
        //lager solsystemet med tilhørende stjerne og planeter//
        Star sun= new Star("Sun", 695500, 1.9891E30, 577.0);
        Star kepler11= new Star("Kepler 11",1.889E30,710310, 5680);

        Planet earth= new Planet("Earth", 5.97E24, 6371,1,0.017,365,sun,"https://upload.wikimedia.org/wikipedia/commons/9/97/The_Earth_seen_from_Apollo_17.jpg");
        Planet mars= new Planet("Mars",6.39E23,3389.5,1.524,0.093,687,sun,"https://upload.wikimedia.org/wikipedia/commons/0/02/OSIRIS_Mars_true_color.jpg");
        Planet jupiter= new Planet("Jupiter",1.898E27,69911,5.20440,0.049,4380,sun,"https://upload.wikimedia.org/wikipedia/commons/5/50/Jupiter%2C_image_taken_by_NASA%27s_Hubble_Space_Telescope%2C_June_2019_-_Edited.jpg");
        Planet uranus= new Planet("Uranus",8.681E25,25362,19.2184,0.046,30660,sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Uranus2.jpg/480px-Uranus2.jpg");
        Planet saturn= new Planet("Saturn",5.683E26,58232,9.5826,0.057,10585,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg/480px-Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg");
        Planet neptune= new Planet("Neptune",1.024E26,24622,30.11,0.010,60225,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Neptune_Full_%28cropped%29.jpg/480px-Neptune_Full_%28cropped%29.jpg");
        Planet mercury= new Planet("Mercury", 3.283E23,2439.7,0.387,0.206,88,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Transit_Of_Mercury%2C_May_9th%2C_2016.png/480px-Transit_Of_Mercury%2C_May_9th%2C_2016.png");
        Planet venus= new Planet("Venus",4.867E24,6051.8,0.723,0.007,225,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/SDO%27s_Ultra-high_Definition_View_of_2012_Venus_Transit_%28304_Angstrom_Full_Disc_02%29.jpg/480px-SDO%27s_Ultra-high_Definition_View_of_2012_Venus_Transit_%28304_Angstrom_Full_Disc_02%29.jpg");

        Planet kepler11b= new Planet("Kepler-11b",2.56796E25,12550.0,1.36134E7,0.045,10, kepler11,"https://upload.wikimedia.org/wikipedia/commons/7/76/Kepler-11b_%28Exoplanete%29.jpg");
        Planet kepler11c= new Planet("Kepler-11c", 8.0622E25,20068,1.5857E7,0.026,13, kepler11,"https://upload.wikimedia.org/wikipedia/commons/c/c9/Kepler-11c_%28Exoplanete%29.jpg");
        Planet kepler11d= new Planet("Kepler-11d",3.64292E25,21852,2.3786E7,0.004,22,kepler11, "https://upload.wikimedia.org/wikipedia/commons/c/c9/Kepler-11c_%28Exoplanete%29.jpg");
        Planet kepler11e= new Planet("Kepler-11e",5.01648E25,28796,2.9021E7,0.012,31,kepler11, "https://upload.wikimedia.org/wikipedia/commons/c/c9/Kepler-11c_%28Exoplanete%29.jpg");
        Planet kepler11f= new Planet("Kepler-11f",1.37356E25,16628,3.7399E7,0.013,36,kepler11, "https://upload.wikimedia.org/wikipedia/commons/c/c9/Kepler-11c_%28Exoplanete%29.jpg");
        Planet kepler11g= new Planet("Kepler-11g", 1.7916E27,23317,6.9114E7,0.015,118,kepler11,"https://upload.wikimedia.org/wikipedia/commons/3/30/Kepler-11g_%28Exoplanete%29.jpg");


        //måner jorden
        Moon maanen= new Moon("The Moon", 7.34E22, 1737.10,27,"https://upload.wikimedia.org/wikipedia/commons/e/e1/FullMoon2010.jpg");
        earth.setMoons(maanen);

        //måner jupiter
        Moon io= new Moon("Metis", 8.91E22,421700 ,1.77,"https://upload.wikimedia.org/wikipedia/commons/7/7b/Io_highest_resolution_true_color.jpg");
        Moon europa= new Moon("Europa", 4.79E22, 670900,3.51,"https://upload.wikimedia.org/wikipedia/commons/e/e4/Europa-moon-with-margins.jpg");
        Moon ganymede= new Moon("Ganymede", 1.48E23, 2634,7.15,"https://upload.wikimedia.org/wikipedia/commons/f/f2/Ganymede_g1_true-edit1.jpg");
        Moon callisto= new Moon("Callisto", 1.075E23, 2410.3,16.68,"https://upload.wikimedia.org/wikipedia/commons/e/e9/Callisto.jpg");
        jupiter.setMoons(io);
        jupiter.setMoons(europa);
        jupiter.setMoons(ganymede);
        jupiter.setMoons(callisto);

        //måner mars
        Moon phobos= new Moon("Phobos", 1.06E16,112667,0.318,"https://upload.wikimedia.org/wikipedia/commons/5/5c/Phobos_colour_2008.jpg");
        Moon deimos= new Moon("Deimos", 1.47E15,6.2+-0.6,1.26,"https://upload.wikimedia.org/wikipedia/commons/8/8d/Deimos-MRO.jpg");
        mars.setMoons(phobos);
        mars.setMoons(deimos);

        //måner neptune//
        Moon larissa= new Moon("Larissa", 4.2E18, 94+-5.4,0.55,"https://upload.wikimedia.org/wikipedia/commons/5/5b/Larissa_1.jpg");
        Moon proteus= new Moon("Proteus", 4.4E19, 210+-7,1.12,"https://upload.wikimedia.org/wikipedia/commons/8/83/Proteus_%28Voyager_2%29.jpg");
        Moon triton= new Moon("Triton", 2.12E22, 1353,5.87,"https://upload.wikimedia.org/wikipedia/commons/a/a6/Triton_moon_mosaic_Voyager_2_%28large%29.jpg");
        Moon despina= new Moon("Despina", 2.2E18, 78.0+-4.7,0.334,"https://upload.wikimedia.org/wikipedia/commons/5/5f/Despina.jpg");
        neptune.setMoons(larissa);
        neptune.setMoons(proteus);
        neptune.setMoons(triton);
        neptune.setMoons(despina);

        //måner saturn//
        Moon titan= new Moon("Titan", 1.35E23,2574.3,15.49,"https://upload.wikimedia.org/wikipedia/commons/4/45/Titan_in_true_color.jpg");
        Moon enceladus= new Moon("Enceladus", 1.80E20,251.1,1.37,"https://upload.wikimedia.org/wikipedia/commons/8/83/PIA17202_-_Approaching_Enceladus.jpg");
        Moon mimas= new Moon("Mimas", 3.74E19,198,0.942,"https://upload.wikimedia.org/wikipedia/commons/b/bc/Mimas_Cassini.jpg");
        Moon tethys= new Moon("Tethys", 6.174E20,531.1,1.88,"https://upload.wikimedia.org/wikipedia/commons/b/bc/PIA18317-SaturnMoon-Tethys-Cassini-20150411.jpg");
        Moon lapetus= new Moon("Lapetus", 1.805E21,734.5,79.32,"https://upload.wikimedia.org/wikipedia/commons/c/c9/Iapetus_as_seen_by_the_Cassini_probe_-_20071008.jpg");
        saturn.setMoons(titan);
        saturn.setMoons(enceladus);
        saturn.setMoons(mimas);
        saturn.setMoons(tethys);
        saturn.setMoons(lapetus);

        //måner uranus
        Moon umbriel= new Moon("Umbriel",1.275E21,584.1,4.144,"https://upload.wikimedia.org/wikipedia/commons/2/2f/PIA00040_Umbrielx2.47.jpg");
        Moon titania= new Moon("Titania",3.40E21,788.4,8.70,"https://upload.wikimedia.org/wikipedia/commons/2/2e/Titania_%28moon%29_color%2C_edited.jpg");
        Moon oberon= new Moon("Oberon",3.076E21,761.4,13.463,"https://upload.wikimedia.org/wikipedia/commons/0/09/Voyager_2_picture_of_Oberon.jpg");
        Moon ariel= new Moon("Ariel",1.251E21,578.9,2.520,"https://upload.wikimedia.org/wikipedia/commons/5/59/Ariel_%28moon%29.jpg");
        uranus.setMoons(umbriel);
        uranus.setMoons(titania);
        uranus.setMoons(oberon);
        uranus.setMoons(ariel);


        //lager solsystemer og legger til planetene//
        PlanetSystem solarSystem= new PlanetSystem("Solarsystem", sun,"https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");
        PlanetSystem kepler= new PlanetSystem("Kepler 11-system", kepler11, "https://upload.wikimedia.org/wikipedia/commons/6/64/Kepler11.png");

        solarSystem.setPlanets(earth);
        solarSystem.setPlanets(mars);
        solarSystem.setPlanets(jupiter);
        solarSystem.setPlanets(uranus);
        solarSystem.setPlanets(saturn);
        solarSystem.setPlanets(neptune);
        solarSystem.setPlanets(mercury);
        solarSystem.setPlanets(venus);

        kepler.setPlanets(kepler11b);
        kepler.setPlanets(kepler11c);
        kepler.setPlanets(kepler11d);
        kepler.setPlanets(kepler11e);
        kepler.setPlanets(kepler11f);
        kepler.setPlanets(kepler11g);


        //leger til solsystemet i listen//

        planetSystems.add(solarSystem);
        planetSystems.add(kepler);
    }


    public ArrayList<PlanetSystem> getAllPlanetSystems(){
        return this.planetSystems;
    }

    //henter et planet system//
    public PlanetSystem getPlanetSystem(String name){
        PlanetSystem finalSystem= planetSystems.get(0);

        for (PlanetSystem oneSystem: planetSystems){
            if(name.equals(oneSystem.getName())){
                finalSystem= oneSystem;
            }
        }
        return finalSystem ;
    }

    //metode for å returnere alle planeter i et solsytem

    public ArrayList<Planet> getAllPlanets(String name){
        ArrayList<Planet> planets= new ArrayList<>();

        for (PlanetSystem oneSystem: planetSystems){
            if(name.equals(oneSystem.getName())){
                planets= oneSystem.getPlanets();
            }
        }
        return new ArrayList<>(planets);
    }

    //metode for å returnere en planet//
    public Planet getPlanet(String name, String planetName){

        for (PlanetSystem system: planetSystems){
            if (name.equals(system.getName())){
                for(Planet planet: system.getPlanets()){
                    if(planetName.equals(planet.getName())){
                        return planet;
                    }
                }
            }
        }
        return null;
    }

    //metoder for å hente alle planeter som er registrert på en planet

    public ArrayList<Moon> getAllMoons(String systemName, String planetName){
        ArrayList<Moon> moons= new ArrayList<>();

        for(PlanetSystem oneSystem: planetSystems){
            if(systemName.equals(oneSystem.getName())){
                for(Planet onePlanet: oneSystem.getPlanets()){
                    if(planetName.equals(onePlanet.getName())){
                        moons= onePlanet.getMoons();
                    }
                }
            }
        }
        return moons;
    }

    //metode for å returnere en spesifikk planet//
    public Moon getMoon(String systemName, String planetName, String moonName){
        Moon finalMoon= new Moon();
        for(PlanetSystem system: planetSystems){
            if(systemName.equals(system.getName())){
                for(Planet planet: system.getPlanets()){
                    if(planetName.equals(planet.getName())){
                        for(Moon oneMoon: planet.getMoons()){
                            if(moonName.equals(oneMoon.getName())){
                                finalMoon=oneMoon;
                            }
                        }
                    }
                }
            }
        }
        return finalMoon;
    }
}
