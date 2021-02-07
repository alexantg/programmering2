 public class Oppgave2_2 {

  public static void main(String[] args) {

   //definerer en rekke variabler

   double vekt;
   int masse;
   double gravJorda;
   double gravMaanen;

   masse = 80;
   gravJorda = 9.81;
   gravMaanen = 9.81 * 0.17;

   //regner ut vekten på månen

   vekt = masse * gravMaanen;

   // skriver ut informasjonen
   System.out.println("Vekten på månen er " + vekt + " N.");


  }

 }