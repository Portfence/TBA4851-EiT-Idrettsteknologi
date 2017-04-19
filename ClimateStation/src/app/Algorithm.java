package app;

/**
 *
 * @author Gruppe 4 -Idrettsteknologi - EiT 2017
 */
public class Algorithm {
    
    // CONSTANTS
    private final double gravityConstant  = 9.81; // Gravity Constant
    private final double Md = 0.028964;// Molecular mass for calculating air resistance
    private final double Mv = 0.018016;
    private final double R  = 8.31447;
    
    // REFERENCE CONSTANTS
    private final double referenceRound  = 30.0; // Gravity Constant
    private final double refIceTemp =-5;// Molecular mass for calculating air resistance
    private final double refWind = 0;
    private final double refRelHumid  = 0.4;
    private final double refAirPressure  = 1e5;
    private final double refAirTemp  = 10.0;
    
    //PARAMTERS

    public double calculateReferenceConditions(double athlWeight, double athlArea){
        // distance after steady state [m]
        double distance = 400;
        
        // average speed [m/s]
        double refSpeed = distance/referenceRound;
        
        //constant friction because it is a reference round
        double refIceFriction=getIceFriction(refSpeed, refIceTemp);
        
        //PARAMETERS FOR CALCULATING AIR RESISTANCE
        double refPv = refRelHumid*6.1078*Math.pow(10, (7.5*refAirTemp)/(refAirTemp+237.3));
        double refPd = refAirPressure - refPv;
        
        // Convert to Kelvin
        double refRT=R*(refAirTemp+273.15);
        
        //Air Density for reference conditions
        double refAirDensity = (refPd*Md+refPv*Mv)/refRT;
        
        //Friction of Air in Watts[W]
        double refFrictionAirPower = 0.5*refAirDensity*athlArea*refSpeed*Math.pow(refSpeed-refWind,2);
        double refFrictionIcePower = refSpeed*athlWeight*gravityConstant*refIceFriction;
        double refTotalPower = refFrictionAirPower+refFrictionIcePower;
        
        // Returns the combined power of ice and air friction
        return refTotalPower;
    }
    
    public double calculateActualConditions(double roundTime, double iceTemperature, double wind, double relHumidity, double airPressure, double airTemp, double athlWeight, double athlArea){
        double distance = 400;
        double speed=distance/roundTime;
        double iceFriction = getIceFriction(speed, iceTemperature);
        double Pv = relHumidity*6.1078*Math.pow(10, (7.5*airTemp)/(airTemp+237.3));
        double Pd = airPressure - Pv;
        double RT = R*(airTemp+273.15);
        
        return 0;
    }
    
    /**
     * chooses the appropriate ice friction coefficient 
     * @param speed
     * @param iceTemperature
     * @return 
     */
    public double getIceFriction(double speed,double iceTemperature){
        double[] iceFrictionArray = new double[]{0.000175*speed+0.0034, 0.00015*speed+0.0035 ,(1/7500)*speed+0.0036};
        double iceFriction;
        
        if (iceTemperature >-5 && iceTemperature <=-1){
            iceFriction = (iceTemperature+1)/(-4)*(iceFrictionArray[1]-iceFrictionArray[0])+iceFrictionArray[0];
        }
        else if(iceTemperature >=-10 && iceTemperature <= -5){
            iceFriction=(iceTemperature+5)/(-5)*(iceFrictionArray[2]-iceFrictionArray[1])+iceFrictionArray[1];
        }   
        else if (iceTemperature > -1){
            iceFriction = iceFrictionArray[0];
        }
        else{
            iceFriction = iceFrictionArray[2];
        }
        return iceFriction;
    }
    
}
