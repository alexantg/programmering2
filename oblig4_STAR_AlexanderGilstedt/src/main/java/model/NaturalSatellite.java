package model;

import static model.Planet.GRAV_CONST;

public abstract class NaturalSatellite extends CelestialBody {

    private double semiMajorAxis;
    private double eccentricity;
    private double orbitalPeriod;
    private CelestialBody centralCelestialBody;

    public static final double ONE_AU= 149597871;

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        super(name, mass, radius, pictureUrl);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }


    public NaturalSatellite(String name, double mass, double radius, double orbitalPeriod, String pictureUrl) {
        super(name, mass, radius, pictureUrl);
        this.orbitalPeriod= orbitalPeriod;

    }


    public NaturalSatellite(){};

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }


    //oppgave 2.6

    public double orbitingVelocity(double distance){
        double velocity=0;
        velocity= Math.sqrt((GRAV_CONST*this.centralCelestialBody.getMass())/(distance*1000));
        velocity= velocity/1000;

        return velocity;
    }

    //bonus 3.1//
    public double orbitingVelocityMs(double distance){
        return this.orbitingVelocity(distance)*1000;
    }

    //oppgave 2.5
    public double distanceToCentralBody(double degrees){
        double distance=0;
        double r;

        r=(this.semiMajorAxis*(1-Math.pow(this.eccentricity,2))/(1+this.eccentricity*Math.cos(Math.toRadians(degrees))));
        distance=r*ONE_AU;

        return distance;
    }

    //bonus 3.2//
    public double distanceToCentralBodyRad(double radians){
        return distanceToCentralBody(Math.toDegrees(radians));

    }

    //bonus 3.3//
    public double maxDistance(){
       double max= -1;
       double counter=0;
        counter= 360/this.getOrbitalPeriod();

        for(double i=0; i<=this.getOrbitalPeriod(); i= i+counter){
            if(max<distanceToCentralBody(i)){
                max= distanceToCentralBody(i);
            }
        }
        return max;
    }

    public double minDistance(){
        double min= Double.MAX_VALUE;
        double counter=0;
        counter= 360/this.getOrbitalPeriod();

        for(double i=0; i<=this.getOrbitalPeriod(); i=i+counter){
            if(min>distanceToCentralBody(i)){
                min=distanceToCentralBody(i);
            }
        }
        return min;
    }
    //slutt bonus 3.3//


    //bonus 3.4//

    public double distanceBetween(Planet planet1, int days){
        double finalDistance=0;
        //finner økning i grader (per dag)
        double count1= 360/this.getOrbitalPeriod();
        double count2= 360/planet1.getOrbitalPeriod();

        double degAfter1= count1*days;
        double degAfter2= count2*days;

        double distance1= this.distanceToCentralBody(degAfter1);
        double distance2= planet1.distanceToCentralBody(degAfter2);

        //finner vinkelen mellom to sider//
        double angle=0;

        if(degAfter1>degAfter2){
            angle=degAfter1- degAfter2;
        }
        else if(degAfter2>degAfter1){
            angle=degAfter2-degAfter1;
        }

        //implementerer cosinus-prinsippet for å finne avstanden//

        finalDistance= (Math.pow(distance1,2)+Math.pow(distance2,2)) - (2*distance1*distance2* Math.cos(Math.toRadians(angle)));
        finalDistance=Math.sqrt(finalDistance);

        return finalDistance;

    }

    @Override
    public String toString(){
      return  "Name: " + this.getName() + " | Semi-Major-Axis " + this.getSemiMajorAxis() + " | Eccentricity " + this.getEccentricity() + "| Orbital Period "+
                this.getOrbitalPeriod() + " | Central celestial body " + this.getCentralCelestialBody();
    }

}
