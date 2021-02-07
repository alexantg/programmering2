package alexantg.oblig2;

public class Star {

        private String name;
        private double radius;
        private double mass;
        private double effectiveTemp;

        //konstruktør

        public Star(String name, double radius, double mass, double effectiveTemp){
            this.name= name;
            this.radius=radius;
            this.mass= mass;
            this.effectiveTemp= effectiveTemp;
        }

        //get og set-metoder
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getMass() {
            return mass;
        }

        public void setMass(double mass) {
            this.mass = mass;
        }

        public double getEffectiveTemp() {
            return effectiveTemp;
        }

        public void setEffectiveTemp(double effectiveTemp) {
            this.effectiveTemp = effectiveTemp;
        }

        @Override
        public String toString() {
            return "(The "+  getName() + " | Radius: " +  getRadius() + " | km Mass:  " +  getMass() + "kg | Effective temperature: "+  getEffectiveTemp() + " |(Celcius))" + "\n \n";
        }

        //metoder for å finne Msun og Rsun//

        public double findMsun(){
            double oneMsun=1.98892E30;
            return this.mass/oneMsun;
        }

        public double findRsun(){
            double oneRsun= 695700.0;

            return this.radius/oneRsun;

        }

    }
