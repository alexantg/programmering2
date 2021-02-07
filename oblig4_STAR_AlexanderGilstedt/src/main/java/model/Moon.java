package model;

public class Moon extends NaturalSatellite {

 public Moon(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl){
     super(name, mass, radius, semiMajorAxis,eccentricity,orbitalPeriod, centralCelestialBody,pictureUrl);
 }

 public Moon(String name, double mass, double radius, double orbitalPeriod, String pictureUrl){
     super(name, mass, radius, orbitalPeriod, pictureUrl);
 }
    public Moon() {

    }
}
