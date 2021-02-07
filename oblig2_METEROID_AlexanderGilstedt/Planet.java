package alexantg.oblig2;

public class Planet {


        private String name;
        private double mass;
        private double radius;

        public Planet(String name, double mass, double radius){
            this.name= name;
            this.mass= mass;
            this.radius= radius;

        }

        //tom konstruktør//
        public Planet(){

        }

        //get/set -metoder

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMass() {
            return mass;
        }

        public void setMass(double mass) {
            this.mass = mass;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }


        // to-string metoden//
        @Override
        public String toString() {
            return "Name: "+ getName() + " | Radius:  " + getRadius() + " km | Mass: " + getMass() + " kg " +  "\n";
        }

        //metode for å returnere jupiter masse//

        public double findMjup(){
            double oneMjup= 1.898E27;
            return this.mass/oneMjup;
        }

        //metode for å returnere jupiter radius//

        public double findRjup(){
            double oneRjup= 71942.0;
            return (this.radius/ oneRjup);
        }

        //metode for å returnere jord-masse//

        public double findMearth(){
            double oneMearth= 5.972E24;
            return (this.mass/oneMearth);
        }

        public double findRearth(){
            double oneRearth= 6371;
            return (this.radius/oneRearth);
        }



        //metode for å returere gravitasjon//

        public double surfaceGravity(){
            double gravityConstant=0.00000000006674;

            return (gravityConstant*this.mass)/Math.pow(this.radius*1000,2);

        }
    }


