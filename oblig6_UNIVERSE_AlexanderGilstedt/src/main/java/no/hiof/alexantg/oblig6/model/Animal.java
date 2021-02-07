package no.hiof.alexantg.oblig6.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.tools.javac.code.Attribute;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Invertebrate.class, name = "invertebrate"),
        @JsonSubTypes.Type(value= Bird.class, name= "bird"),
        @JsonSubTypes.Type(value= Amphibian.class, name= "amphibian")
})

public abstract class Animal implements Comparable<Animal> {

    private String name;
    private String scientificName;
    private int numberofLegs;


    public Animal(String name, String scientificName, int numberofLegs) {
        this.name = name;
        this.scientificName = scientificName;
        this.numberofLegs = numberofLegs;
    }

    public Animal(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public int getNumberofLegs() {
        return numberofLegs;
    }

    public void setNumberofLegs(int numberofLegs) {
        this.numberofLegs = numberofLegs;
    }


    //overrider to-string metoden//
    @Override
    public String toString() {
        return null;
    }


    //sorterer dyr basert på navn//Alfabetisk rekkefølge//
    @Override
    public int compareTo(Animal otherAnimal) {
        return this.name.compareTo(otherAnimal.getName());
    }
}

