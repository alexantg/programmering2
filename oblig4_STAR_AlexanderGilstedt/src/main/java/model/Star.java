package model;

public class Star extends CelestialBody {

    public static final double ONE_MSUN=1.98892E30;
    public static final double ONE_RSUN= 695700.0;

    private double effectiveTemp;

    public Star(String name, double radius, double mass, double effectiveTemp){
        super(name,radius,mass);
        this.effectiveTemp=effectiveTemp;
    }

    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }


    //metoder for å finne sol-masse//

    public double findMsun(){
        return this.getMass()/ONE_MSUN;
    }

    public double findRsun(){
        return this.getRadius()/ONE_RSUN;
    }


    @Override
    public String toString() {
        return "(The "+  getName() + " | Radius: " +  getRadius() + " | km Mass:  " +  getMass() + "kg | Effective temperature: "+  getEffectiveTemp() + " |(Celcius))" + "\n \n";
    }






}
