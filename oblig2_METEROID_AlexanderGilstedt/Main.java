package alexantg.oblig2;

public class Main{

    public static void main(String[]args){

        Star sun= new Star("Sun", 695500, 1.9891E30, 577.0);

        Planet earth= new Planet("Earth", 5.97E24, 6371);
        Planet mars= new Planet("Mars",6.39E23,3389.5);
        Planet jupiter= new Planet("Jupiter",1.898E27,69911);
        Planet uranus= new Planet("Uranus",8.681E25,25362);
        Planet saturn= new Planet("Saturn",5.683E26,58232);
        Planet neptune= new Planet("Neptune",1.024E26,24622);
        Planet mercury= new Planet("Mercury", 3.283E23,2439.7);
        Planet venus= new Planet("Venus",4.867E24,6051.8);


        //lager et nytt solsystem og bruker set-metoder for å legge til noen planeter planeter
        PlanetSystem solarSystem= new PlanetSystem("Solar-system", sun);

        solarSystem.setPlanets(earth);
        solarSystem.setPlanets(mars);
        solarSystem.setPlanets(jupiter);
        solarSystem.setPlanets(mercury);
        solarSystem.setPlanets(saturn);
        solarSystem.setPlanets(uranus);
        solarSystem.setPlanets(venus);
        solarSystem.setPlanets(neptune);

        System.out.println(solarSystem.toString());

        //printer en skille-linje
        System.out.println("*********************************************");

        //printer ut informasjon til oppgave 2.4

//        String.format("%s med areal: %.2f og omkrets %.2f", figur, figur.areal(), figur.omkrets()));

        System.out.println(String.format("Saturn is: %.2f Mjup",saturn.findMjup()));
        System.out.println(String.format("Saturn is %.2f Rjup", saturn.findRjup()));

        System.out.println();

        System.out.println(String.format("Sun is %.2f Msun", sun.findMsun()));
        System.out.println(String.format("Sun is %.2f Rsun", sun.findRsun()));
        //slutt på 2.4

        //printer ut informasjon til oppgave 2.5
        System.out.println();
        System.out.println(String.format("Surface gravity on Neptune is %.2f", neptune.surfaceGravity() ));


        //slutt på 2.5


        //printer ut informasjon til oppgave 2.6
        System.out.println();
        System.out.println("Largest planet is: " + solarSystem.getLargestPlanet());
        System.out.println("Smallest planet is: " +solarSystem.getSmallestPlanet());

        //slutt på oppgave 2.6


        //Bonusoppgave 3.1//
        System.out.println(String.format("Mars is %.2f Mearth", mars.findMearth()));
        System.out.println(String.format("Mars is %.2f Rearth", mars.findRearth()));
        //Slutt på bonus 3.1//

    }

}