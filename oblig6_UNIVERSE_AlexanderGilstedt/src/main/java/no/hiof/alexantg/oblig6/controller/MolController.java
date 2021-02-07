package no.hiof.alexantg.oblig6.controller;

import io.javalin.http.Context;
import no.hiof.alexantg.oblig6.model.*;
import no.hiof.alexantg.oblig6.repository.IMapOfLifeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MolController {

    private IMapOfLifeRepository imapOfLifeRepository;

    public MolController(IMapOfLifeRepository iMapOfLifeRepository){
        this.imapOfLifeRepository= iMapOfLifeRepository;
    }

    //returns all observations
    public void getAllObservations(Context context){
        context.json(imapOfLifeRepository.getAllObservations());
    }

    //get specific observation//
    public void getObservation(Context context) {
        String name= context.pathParam("observation-id");
        context.json(imapOfLifeRepository.getObservation(name));
    }

    //get planet linked with observation//
    public void getPlanetFromObservation(Context context) {
        String observationName= context.pathParam("observation-id");

         context.json(imapOfLifeRepository.getPlanetFromObservation(observationName));
    }

    //Get animal linked with observation//
    public void getAnimal(Context context) {
        String observationName= context.pathParam("observation-id");
        context.json(imapOfLifeRepository.getAnimalObserved(observationName));
    }

    public void deleteObservation(Context context) {
        String observationName= context.pathParam("observation-id");
        imapOfLifeRepository.deleteObservation(observationName);

        context.redirect("/observations");
    }

    public void createObservation(Context context) {
        imapOfLifeRepository.createObservation(dataFromInputScheme(context));
        context.redirect("/observations");
    }

    public void updateObservation(Context context){
        String observationName= context.pathParam("observation-id");
        imapOfLifeRepository.updateObservation(observationName,dataFromInputScheme(context));
        context.redirect("/observations");
    }

    //Retrieving all biom-types as a list//
    public void getBiomTypes(Context context) {

        context.json(Biom.getAllTypes());
    }


    public Observation dataFromInputScheme(Context context) {

        //LOCATION//
        String locationName = context.formParam("locationName");
        double latitude;
        double longitude;

        String bioms []= context.formParam("bioms").split(",");
        List<String> listOfNames= Arrays.asList(bioms);
        List<Biom> listOfBioms= new ArrayList<>();
        for(String name: listOfNames){
            Biom biom = new Biom(Biom.types.valueOf(name));
            listOfBioms.add(biom);
        }

        try{
            latitude= Double.parseDouble(context.formParam("latitude"));
        }
        catch (Exception e){
            latitude=0.0;
        }
        try{
            longitude= Double.parseDouble(context.formParam("longitude"));
        }
        catch (Exception e){
            longitude=0.0;
        }

        //PLANET
        String planetName= context.formParam("planetName");
        double radius;
        double mass;

        try{
            radius= Double.parseDouble(context.formParam("radius"));
        }
        catch (Exception e){
            radius=0.0;
        }
        try{
            mass= Double.parseDouble(context.formParam("mass"));
        }
        catch (Exception e){
            mass=0.0;
        }
        Planet planet= new Planet(planetName,radius,mass);
        Location location= new Location(locationName,longitude,latitude,planet);
        location.addBioms(listOfBioms);
        location.listToString();

        //ANIMAL//
        String animalName= context.formParam("animalName");
        String scientificName= context.formParam("scientificName");
        String animalSelected=  context.formParam("selected");
        int numberOfLegs;

        //Bird-specifics//
        double topSpeed;
        double weight;
        String canFly="";
        boolean boolCanFly=false;

        //Amphibian specifics//
        String habitat= context.formParam("habitat");
        String hasTale="";
        boolean boolHasTale= false;

        //Invertebrate specifics//
        String livesAtSea="";
        boolean boolLivesAtSea=false;
        double length;


        try {
          numberOfLegs= Integer.parseInt(context.formParam("numberOfLegs"));
        }
        catch (Exception e){
            numberOfLegs=0;
        }
        try{
            canFly= context.formParam("canFly");
            if(canFly.equals("on")){
                boolCanFly=true;
            }
        }
        catch (Exception e){
            boolCanFly=false;
        }

        try{
            topSpeed= Double.parseDouble(context.formParam("topSpeed"));
        }
        catch (Exception e){
            topSpeed=0.0;
        }

        try{
            weight= Double.parseDouble(context.formParam("weight"));
        }
        catch (Exception e){
            weight=0.0;
        }

        try{
            hasTale= context.formParam("hasTale");
            if(hasTale.equals("on")){
                boolHasTale=true;
            }
        }
        catch (Exception e){
            boolHasTale=false;
        }

        try {
            livesAtSea= context.formParam("livesAtSea");
            if(livesAtSea.equals("on")){
                boolLivesAtSea=true;
            }
        }
        catch (Exception e){
            boolLivesAtSea=false;
        }
        try{
            length= Double.parseDouble(context.formParam("length"));
        }
        catch (Exception e){
            length=0.0;
        }

        //Creating an animal based on unique features//
        Animal animal= new Animal(){

        };

        if(animalSelected.equals("1")){
            animal= new Bird(animalName,scientificName,numberOfLegs,boolCanFly,weight,topSpeed);
        }

        if(animalSelected.equals("2")){
            animal= new Amphibian(animalName,scientificName,numberOfLegs,boolHasTale,habitat);
        }

        if(animalSelected.equals("3")){
            animal= new Invertebrate(animalName,scientificName,numberOfLegs,boolLivesAtSea,length);
        }


        //Observation data//
        int id;
        String observationName = context.formParam("name");
        int numberOfObservations;
        LocalDate finalDate = null;
        String date= context.formParam("date");
        String pictureUrl= context.formParam("pictureUrl");
        String notes= context.formParam("notes");

        try{
            id= Integer.valueOf(context.formParam("id"));
        }
        catch (Exception e){
            id=0;
        }

        try{
            numberOfObservations= Integer.valueOf(context.formParam("number"));
        }
        catch (Exception e){
            numberOfObservations=0;
        }

        try{
            finalDate= LocalDate.parse(date);
        }
        catch (Exception e){
            System.out.println("Could not convert string to date");
        }
        Observation observation = new Observation(id,observationName, animal, location, finalDate, numberOfObservations,pictureUrl,notes);


         return observation;
    }



}
