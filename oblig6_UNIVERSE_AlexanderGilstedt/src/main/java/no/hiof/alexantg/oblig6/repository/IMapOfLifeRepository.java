package no.hiof.alexantg.oblig6.repository;

import no.hiof.alexantg.oblig6.model.Animal;
import no.hiof.alexantg.oblig6.model.Observation;
import no.hiof.alexantg.oblig6.model.Location;
import no.hiof.alexantg.oblig6.model.Planet;

import java.util.ArrayList;

public interface IMapOfLifeRepository{

    ArrayList<Observation> getAllObservations();
    Observation getObservation(String name);
    Location getObserVationLocation(String observationName);
    Planet getPlanetFromObservation(String obserationName);
    Animal getAnimalObserved(String observationName);

    void deleteObservation(String observationName);
    void createObservation(Observation observation);
    void updateObservation(String observationName, Observation observation);


}
