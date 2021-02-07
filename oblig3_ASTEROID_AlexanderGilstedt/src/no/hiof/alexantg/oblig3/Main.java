package no.hiof.alexantg.oblig3;

public class Main{

    public static void main(String[]args){

        Star sun= new Star("Sun", 695500, 1.9891E30, 577.0);

        Planet earth= new Planet("Earth", 5.97E24, 6371,1,0.017,365,sun);
        Planet mars= new Planet("Mars",6.39E23,3389.5,1.524,0.093,687,sun);
        Planet jupiter= new Planet("Jupiter",1.898E27,69911,5.20440,0.049,4380,sun);
        Planet uranus= new Planet("Uranus",8.681E25,25362,19.2184,0.046,30660,sun);
        Planet saturn= new Planet("Saturn",5.683E26,58232,9.5826,0.057,10585,sun);
        Planet neptune= new Planet("Neptune",1.024E26,24622,30.11,0.010,60225,sun);
        Planet mercury= new Planet("Mercury", 3.283E23,2439.7,0.387,0.206,88,sun);
        Planet venus= new Planet("Venus",4.867E24,6051.8,0.723,0.007,225,sun);


        //lager et nytt solsystem og bruker set-metoder for å legge til noen planeter planeter
        PlanetSystem solarSystem= new PlanetSystem("Solar-system",sun);

        solarSystem.setPlanets(earth);
        solarSystem.setPlanets(mars);
        solarSystem.setPlanets(jupiter);
        solarSystem.setPlanets(mercury);
        solarSystem.setPlanets(saturn);

        System.out.println(solarSystem.toString());

        //printer en skille-linje
        System.out.println("*********************************************");

        //printer ut informasjon til oppgave 2.4
        System.out.println( "Saturn is " +  saturn.findMjup() + " Mjup");
        System.out.println("Saturn is " +  saturn.findRjup() + " Rjup");

        System.out.println();

        System.out.println("Sun is "+ sun.findMsun() + " Msun");
        System.out.println("Sun is " + sun.findRsun()+" Rsun");
        //slutt på 2.4

        //printer ut informasjon til oppgave 2.5
        System.out.println();
        System.out.println("Surface gravity on neptune is: " + neptune.surfaceGravity());

        //slutt på 2.5


        //printer ut informasjon til oppgave 2.6 oblig2
        System.out.println();
        System.out.println("Largest planet is: " + solarSystem.getLargestPlanet());
        System.out.println("Smallest planet is: " +solarSystem.getSmallestPlanet());


        //slutt på oppgave 2.6

        System.out.println();

        //Bonusoppgave 3.1//
        System.out.println( "Mars is " +  mars.findMearth() +  " Rearth");
        System.out.println(  "Mars is " + mars.findRearth() + " Mearth");
        //Slutt på bonus 3.1//


        //--------------------------------//
        //Utskrift til oblig3 begynner her//
        //--------------------------------//

        System.out.println();
        System.out.println("----OBLIG3----- ");

        //2.2 oblig 3//
        System.out.println();
        System.out.println(solarSystem.getPlanetByName(earth.getName()));
        System.out.println(solarSystem.getPlanetByName(saturn.getName()));


        //2.5 oblig3//
        System.out.println("Jordens avstand til solen ved: ");
        for (int i=0; i<=360; i+=90){
            System.out.println(String.format(" %s grader: %.2f km", i, earth.distanceToCentralBody(i)));

        }
        //slutt på 2.5//


        //2.6 oblig3//

        System.out.println();
        System.out.println("Jordens hastighet ved:");
        for (int i=0; i<=180; i+=45){
            System.out.println(String.format("%s grader: %.2f km/s",i, earth.orbitingVelocity(earth.distanceToCentralBody(i))));
        }

        //3.1 oblig3//
        System.out.println();
        for (int i=0; i<=180; i+=45){
            System.out.println(String.format("%s grader: %.2f km/s",i, earth.orbitingVelocityMs(earth.distanceToCentralBody(i))));
        }


        //3.2 oblig3//
        System.out.println();
        System.out.println(String.format("Max avstand Jorden-Solen  %.0f km ", earth.maxDistance()));
        System.out.println(String.format("Min avstand Jorden-Solen %.0f km", earth.minDistance()));


        //3.4 oblig3//
        System.out.println();
        System.out.println(String.format("Avstand mellom %s og %s er %.2f km etter 180 dager ",mars.getName(), saturn.getName(),earth.distanceBetween(saturn,180)));

    }

}