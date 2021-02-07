package no.hiof.alexantg.oblig6.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import no.hiof.alexantg.oblig6.model.*;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MapOfLifeRepository implements IMapOfLifeRepository {

    ArrayList<Observation> observationsFromFile= new ArrayList<>();

    private String source;

    public MapOfLifeRepository(String source){
        this.source=source;
    }

    //using json-jackson to print observations to file//
    public void printObservationsToFile(ArrayList<Observation> observationsIn){
        ObjectMapper objectMapper= new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(source), observationsIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Observation> readObserVationsFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            Observation[] observationsArray = objectMapper.readValue(new File(source), Observation[].class);
            observationsFromFile.addAll(Arrays.asList(observationsArray));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return observationsFromFile;
    }


    @Override
    public ArrayList<Observation> getAllObservations() {
            return observationsFromFile;
    }

    @Override
    public Observation getObservation(String name) {
        for(Observation observation: observationsFromFile){
            if(name.equals(observation.getName())){
                return observation;
            }
        }
        return null;
    }

    @Override
    public Location getObserVationLocation(String observationName) {
        return null;
    }

    @Override
    public Planet getPlanetFromObservation(String obserationName) {
        for(Observation observation: observationsFromFile){
            if(obserationName.equals(observation.getName())){
                return observation.getLocation().getOnPlanet();
            }
        }
        return null;
    }

    @Override
    public Animal getAnimalObserved(String observationName) {
        Animal anAnimal= getObservation(observationName).getAnimal();
        return anAnimal;
    }

    @Override
    public void deleteObservation(String observationName) {

        observationsFromFile.remove(getObservation(observationName));

      printObservationsToFile(observationsFromFile);
    }

    @Override
    public void createObservation(Observation observation) {
        observationsFromFile.add(observation);
        printObservationsToFile(observationsFromFile);
    }

    @Override
    public void updateObservation(String observationName, Observation observation) {

    }
}
