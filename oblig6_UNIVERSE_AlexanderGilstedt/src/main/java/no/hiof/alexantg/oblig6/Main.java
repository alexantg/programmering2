package no.hiof.alexantg.oblig6;

import no.hiof.alexantg.oblig6.model.*;
import no.hiof.alexantg.oblig6.repository.MapOfLifeRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

      MapOfLifeRepository mapOfLifeRepository= new MapOfLifeRepository("observations.json");

        //planet-objects//
        Planet Kepler1397b = new Planet("Kepler-1397b", 10938.276, 0);
        Planet K2100= new Planet("K2-100",848754.0 ,2.4463715999999998E30);
        Planet WASP38b= new Planet("Wasp-38 b", 87935.16, 6.52912E27);

        //Biom-objects//
        Biom forrest= new Biom(Biom.types.Forrest);
        Biom savanna = new Biom(Biom.types.Savanna);
        Biom tundra= new Biom(Biom.types.Tundra);
        Biom tropicalForrest= new Biom(Biom.types.TropicalForrest);
        Biom desert= new Biom(Biom.types.Desert);

        //location objects// adding bioms//
        Location upNorthKepler= new Location("North Kepler 1397b", 10.752245, 59.913868, Kepler1397b);
        upNorthKepler.setBiom(tundra);
        upNorthKepler.listToString();

        Location centralK2100= new Location("Central Kepler K2100", 2.213749,46.227638,K2100);
        centralK2100.setBiom(forrest);
        centralK2100.setBiom(savanna);
        centralK2100.listToString();

        Location southWasp= new Location("South WASP-38 b", -43.172897, -22.906847, WASP38b);
        southWasp.setBiom(tropicalForrest);
        southWasp.listToString();

        Location westWasp=new Location("West WASP-38 b", 114.109497, 22.396427, WASP38b);
        westWasp.setBiom(desert);
        westWasp.listToString();


        //creating some animal-objects
        Bird eagle= new Bird("Yoshi", "Golden eagle", 2, true, 3.6, 51.2);
        Bird sparrow= new Bird("Bill", "House sparrow",  2, true , 0.24, 46);
        Invertebrate snail= new Invertebrate("Phil", "Lymnae", 0, true, 0.4 );
        Amphibian frog= new Amphibian("Ethan", "True toad",  4, false, "Both on sea and land");
        Invertebrate ant= new Invertebrate("Anstead", "Formicidae",   6, false, 0.15);
        Bird owl= new Bird("Beau", "Strigiformes",  2,  true, 1.5, 55);

        //creating som observations//
        Observation observation1= new Observation(1,"Snail-observation", snail, westWasp, LocalDate.of(2019,5,11),3,"https://upload.wikimedia.org/wikipedia/commons/5/53/Snail-wiki-120-Zachi-Evenor.jpg","Spotted some snails. Think i am going to head home");
        Observation observation2= new Observation(2,"Sparrow-observation", sparrow, centralK2100, LocalDate.of(2018, 2, 28),1, "https://upload.wikimedia.org/wikipedia/commons/6/6e/Passer_domesticus_male_%2815%29.jpg", "Great find");
        Observation observation3= new Observation(3,"Eagle-observation", eagle, upNorthKepler, LocalDate.now(),1, "https://upload.wikimedia.org/wikipedia/commons/d/d6/Golden_Eagle_in_flight_-_5.jpg","Traveled far and wide, found this guy");
        Observation observation4= new Observation(4,"Frog-observation", frog, southWasp, LocalDate.of(2020, 3,8),5,"https://upload.wikimedia.org/wikipedia/commons/c/c1/Variegated_golden_frog_%28Mantella_baroni%29_Ranomafana.jpg","Absolutely stunning");
        Observation observation5= new Observation(5,"Ant-observation", ant, westWasp, LocalDate.of(2015,6,20),20, "https://upload.wikimedia.org/wikipedia/commons/2/2c/Bullant_head_detail.jpg", "Not really a fan of ants, but got some pictures");
        Observation observation6= new Observation(6,"Owl-observation", owl, centralK2100, LocalDate.of(2012, 12,12),2, "https://upload.wikimedia.org/wikipedia/commons/f/f2/Eastern_Barn_Owl_%28Tyto_javanica_stertens%29%2C_Raigad%2C_Maharashtra.jpg","Did not expect to find this, but glad i did");

        //creating a list to keep the observations//
        ArrayList<Observation> observations= new ArrayList<>();
        observations.add(observation1);
        observations.add(observation2);
        observations.add(observation3);
        observations.add(observation4);
        observations.add(observation5);
        observations.add(observation6);

        for(Observation observation: observations){
            System.out.println(observation + "\n");
        }

        //prints to file
        mapOfLifeRepository.printObservationsToFile(observations);

        System.out.println("**********************************************");
        System.out.println();
        System.out.println(mapOfLifeRepository.readObserVationsFromFile());

    }

}
