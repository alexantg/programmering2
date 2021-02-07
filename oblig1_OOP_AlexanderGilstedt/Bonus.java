  import java.util.Scanner;
  
  
//definerer en ny klasse: planet
  class Planet{

    //instansevariabler
   private double radius; 
   private double grav;
   private String navn;

    //lager en konstruktør for et planet-objekt

    public Planet(String navn, double radius, double grav){ 
 
      this.navn= navn; 
      this.radius=radius;
      this.grav= grav; 
   }

    //get og set-metoder

   public String getName(){ 
       return navn; 
   }

   public void setName(String navn){ 
       this.navn= navn; 
   }

    public double getRadius(){
       return radius; 
   }

   public void setRadius(double radius){
       this.radius= radius; 
   }

   public double getGrav(){
       return grav; 
   }

   public void setGrav(double grav){
       this.grav= grav; 
   }

}

public class Bonus{

    public static void main(String[] args){

        //lager et nytt objekt av typen scanner

        Scanner sc= new Scanner(System.in);

        //scanner ser etter neste linje og lagrer det som en string

        System.out.println("Skriv inn navn på planeten: ");
        String navn= sc.nextLine();

        System.out.println("Skriv inn radius til planeten: ");
        double radius= sc.nextDouble();

        System.out.println("Skriv inn gravitasjon på planeten: ");
        double gravitasjon= sc.nextDouble();


        //bruker input verdiene til å lage et planet objekt

        Planet planet = new Planet(navn, radius, gravitasjon);

        System.out.println("Planeten " + planet.getName() + " har en radius på " + planet.getRadius() + " km og en gravitasjon på " + planet.getGrav() + "m/s^2");

    }

}