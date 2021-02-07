class Planet { //lager planet-klassen

    private double radius;
    private double grav;
    private String navn;

    public Planet(String navn, double radius, double grav) { // lager konstruktør for planet-objektet

        this.navn = navn; //variabelen navn i denne klassen skal være lik argumentet som blir sendt med konstruktøren
        this.grav = grav;
        this.radius = radius;
    }

    public String getNavn() { //metode for å hente den private variabelen utenfor en annen klasse
        return navn;
    }

    public void setNavn(String navn) { //metode for å endre den private variabelen fra en annen klasse
        this.navn = navn;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getGrav() {
        return grav;
    }

    public void setGrav(double grav) {
        this.grav = grav;
    }

    public void printInfo() {
        System.out.println("Planeten " + navn + " har en radius på " + radius + " km og en gravitasjon på " + grav + " m/s^2.");
    }

}

public class Oppgave2_3 {

    public static void main(String[] args) {

        Planet mars = new Planet("Mars", 3389.5, 3.711); //lager et nytt planet objekt
        Planet jorda = new Planet("Jorda", 6371.0, 9.81);


        //bruker print metoden for å skrive ut informasjon om planetene

        mars.printInfo();
        jorda.printInfo();

    }

}