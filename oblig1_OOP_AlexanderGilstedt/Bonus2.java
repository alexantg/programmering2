  
    //programmet fungerer ikke optimalt i forhold til det oppgaven spør om//
  
  import java.util.Scanner;
    
  class Planet{ //lager klassen planet

   private String navn; 
   private double radius; 
   private double grav;


    public Planet(String navn,  double radius, double grav){ // lager en konstruktør for Planet-objekter
 
      this.navn= navn; //variabelen navn i denne klassen skal være lik argumentet som blir sendt med konstruktøren
      this.radius= radius;
      this.grav= grav; 
   }

    public String getName(){ //metode for å hente den private variabelen navn fra en annen klasse
        return navn; 
    }

    public void setName(String navn){ //metode for å sette en ny verdi til variabelen 
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

public class Bonus2{


    public static void main(String[] args){

        Scanner sc= new Scanner(System.in); //lager et nytt skanneobjekt

        System.out.println("Hvor mange planeter skal registres?"); //registrerer hvor mange
        int antall= sc.nextInt();

        Planet[] planet= new Planet[antall];  // lager en array som skal holde på referanser til antall planet-objekter som skal registreres


        for (int i=0; i<=planet.length-1; i++){ //en for løkke som kjører antall ganger (lik med hvor mange planeter som skal registreres)

             System.out.println("Skriv inn navnet på planeten");
            
              String navn= sc.next(); //ser etter neste linje, lagres som en string

            
            System.out.println("Skriv inn radiusen til planenten");
            
            double radius= sc.nextDouble(); // ser etter neste tall/ desimaltall og lagrer det som radius-verdi


            System.out.println("Skriv inn gravitasjonen på planeten");

            double grav=sc.nextDouble();  //ser etter neste tall/desimaltall og lagrer det som gravitasjons-verdi

            planet[i]= new Planet(navn, radius , grav); //indexen vi er på i arrayen skal inneholde objektet som blir opprettet av konstruktøren

        }

        for (int i=0; i<=planet.length-1; i++){ //looper over arrayen og henter informasjon for hvert objekt med get-metodene
            System.out.println("Planeten " + planet[i].getName() +  " har en radius på " + planet[i].getRadius()+ " km og en gravitasjon på " + planet[i]. getGrav()+ " m/s^2"); 
        }
    }
}
