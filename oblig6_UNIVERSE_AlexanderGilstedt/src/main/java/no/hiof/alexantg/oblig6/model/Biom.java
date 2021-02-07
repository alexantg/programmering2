package no.hiof.alexantg.oblig6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biom {

    //Collection of predifined types//
    public enum types{Desert, Tundra, Savanna, Forrest, TropicalForrest, Ice}

    private types type;
    private double tempInCelcius;
    private double rainFallYearInMm;

    public Biom() {
    }

    public Biom(types type) {
        this.type = type;
    }


    //Returns a list of the different types//
    public static List<types> getAllTypes(){
        List<types> types= Arrays.asList(Biom.types.values());
        types.toArray();
        return types;
    }


    public types getType() {
        return type;
    }

    public void setType(types type) {
        this.type = type;
    }

    @JsonIgnore
    public double getTempInCelcius() {
        return tempInCelcius;
    }

    @JsonIgnore
    public void setTempInCelcius(double tempInCelcius) {
        this.tempInCelcius = tempInCelcius;
    }

    @JsonIgnore
    public double getRainFallYearInMm() {
        return rainFallYearInMm;
    }

    @JsonIgnore
    public void setRainFallYearInMm(double rainFallYearInMm) {
        this.rainFallYearInMm = rainFallYearInMm;
    }

    //
    @Override
    public String toString() {
        return type.name();
    }
}
