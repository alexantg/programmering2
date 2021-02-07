package no.hiof.alexantg.oblig6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Location {

    private String name;
    private double longitude;
    private double latitude;
    private Planet onPlanet;
    private String biomlistAsString;
    private List<Biom> bioms = new ArrayList<>();



    public Location(String name, double longitude, double latitude, Planet onPlanet) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.onPlanet = onPlanet;
    }

    public Location(){

    }

    public void addBioms(List<Biom> bioms){
        this.bioms.clear();
        this.bioms.addAll(bioms);
    }

    //Building a readable string from list of bioms//
    public void listToString () {
        StringJoiner joiner= new StringJoiner(",");
        StringBuilder builder = new StringBuilder();
        for (Biom biom : bioms) {
          //  builder.append(biom+ " ,");
            joiner.add(biom.toString());
        }
        biomlistAsString=joiner.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Planet getOnPlanet() {
        return onPlanet;
    }

    public void setOnPlanet(Planet onPlanet) {
        this.onPlanet = onPlanet;
    }
    public String getBiomlistAsString() {
        return biomlistAsString;
    }

    public void setBiomlistAsString(String biomlistAsString) {
        this.biomlistAsString = biomlistAsString;
    }

    @JsonIgnore
    public List<Biom> getBioms() {
        return bioms;
    }

    public void setBiom(Biom bioms) {
        this.bioms.add(bioms);
    }

    @Override
    public String toString() {
        return "The " + name + " is located at the planet " + onPlanet.getName() + " it consist of mainly " + getBioms();
    }
}
