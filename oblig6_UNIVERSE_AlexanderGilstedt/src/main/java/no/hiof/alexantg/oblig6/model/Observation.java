package no.hiof.alexantg.oblig6.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDate;

public class Observation implements Comparable<Observation> {

    private static int increment=0;

    private int id=0;
    private String name;
    private Animal animal;
    private Location location;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate localDate;
    private int number;
    private String pictureUrl;
    private String notes;

    public Observation( int id,String name, Animal animal, Location location, LocalDate localDate, int count, String pictureUrl, String notes) {
        this.id=id;
        this.name=name;
        this.animal = animal;
        this.location = location;
        this.localDate = localDate;
        this.number = count;
        this.pictureUrl = pictureUrl;
        this.notes = notes;
    }

    public Observation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String localDateToString (){
      return this.localDate.toString();
    }

    //overider to-string metoden//
    @Override
    public String toString() {
       return " The " + name + " were made at this date: " +  localDateToString() +  " on this planet: " + location.getOnPlanet().getName() +
             ". " + number + " animals where spotted. " + "Here is what the discoverer had to say: " + notes;
    }

    //sorterer de ulike observasjonene//
    @Override
    public int compareTo(Observation otherObservation) {
        return (int) (this.getId() - otherObservation.getId());
    }
}
