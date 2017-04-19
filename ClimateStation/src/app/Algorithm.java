package app;

import org.ejml.data.Complex64F;

/**
 *
 * @author Gruppe 4 -Idrettsteknologi - EiT 2017
 */
public class Algorithm {

    // CONSTANTS
    private final double gravityConstant = 9.81; // Gravity Constant
    private final double Md = 0.028964;// Molecular mass for calculating air resistance
    private final double Mv = 0.018016;
    private final double R = 8.31447;

    // REFERENCE CONSTANTS
    private final double refRoundTime = 30.0; // Gravity Constant
    private final double refIceTemp = -5;// Molecular mass for calculating air resistance
    private final double refWind = 0;
    private final double refRelHumid = 0.5;
    private final double refAirPressure = 1e5;
    private final double refAirTemp = 5.0;

    //PARAMTERS
    private double calculateReferenceConditions(double athlWeight, double athlArea) {
        // distance after steady state [m]
        double distance = 400;

        // average speed [m/s]
        double refSpeed = distance / refRoundTime;

        //constant friction because it is a reference round
        double refIceFriction = getIceFriction(refSpeed, refIceTemp);

        //PARAMETERS FOR CALCULATING AIR RESISTANCE
        double refPv = refRelHumid * 6.1078 * Math.pow(10, (7.5 * refAirTemp) / (refAirTemp + 237.3));
        double refPd = refAirPressure - refPv;

        // Convert to Kelvin
        double refRT = R * (refAirTemp + 273.15);

        //Air Density for reference conditions
        double refAirDensity = (refPd * Md + refPv * Mv) / refRT;

        //Friction of Air in Watts[W]
        double refFrictionAirPower = 0.5 * refAirDensity * athlArea * refSpeed * Math.pow(refSpeed - refWind, 2);
        double refFrictionIcePower = refSpeed * athlWeight * gravityConstant * refIceFriction;
        double refTotalPower = refFrictionAirPower + refFrictionIcePower;

        // Returns the combined power of ice and air friction
        return refTotalPower;
    }

    /**
     * act - ACTUAL
     *
     * @param roundTime
     * @param iceTemperature
     * @param wind
     * @param relHumidity
     * @param airPressure
     * @param airTemp
     * @param athlWeight
     * @param athlArea
     * @return
     */
    public Object[] calculateAdjustedTime(String roundTime, double iceTemperature, double wind, double relHumidity, double airPressure, double airTemp, double athlWeight, double athlArea) {
        double roundTimeDecimal = convertToDecimal(roundTime);
        double actDistance = 400;
        double actSpeed = actDistance / roundTimeDecimal;
        double actIceFriction = getIceFriction(actSpeed, iceTemperature);
        double actPv = relHumidity * 6.1078 * Math.pow(10, (7.5 * airTemp) / (airTemp + 237.3));
        double actPd = airPressure - actPv;
        double actRT = R * (airTemp + 273.15);
        double actAirDensity = (actPd * Md + actPv * Mv) / actRT;
        double cfAir = 0.5 * actAirDensity * athlArea;
        double cfIce = athlWeight * gravityConstant * actIceFriction;
        double totalRefPower = calculateReferenceConditions(athlWeight, athlArea);
        // compared to roots in matlab the order of the array has to be inversed
        // in the findRoots(rootsArr) function
        double[] rootsArr = new double[]{-totalRefPower, 0.0035 * athlWeight * gravityConstant, 0.00015 * athlWeight * gravityConstant, cfAir};
        RootsFunction r = new RootsFunction();
        Complex64F[] foundRoots = r.findRoots(rootsArr);

        double optimalSpeed = foundRoots[2].real;
        double optimalTime = actDistance / optimalSpeed;

        double timeIncrease = optimalTime - refRoundTime;
        double adjustedTime = roundTimeDecimal - timeIncrease;
        String normalAdjustedTime = convertToNormalStuff(adjustedTime);
        return new Object[]{normalAdjustedTime, timeIncrease};
    }

    /**
     * chooses the appropriate ice friction coefficient
     *
     * @param speed
     * @param iceTemperature
     * @return
     */
    public double getIceFriction(double speed, double iceTemperature) {
        double[] iceFrictionArray = new double[]{0.000175 * speed + 0.0034, 0.00015 * speed + 0.0035, (1 / 7500) * speed + 0.0036};
        double iceFriction;

        if (iceTemperature > -5 && iceTemperature <= -1) {
            iceFriction = (iceTemperature + 1) / (-4) * (iceFrictionArray[1] - iceFrictionArray[0]) + iceFrictionArray[0];
        } else if (iceTemperature >= -10 && iceTemperature <= -5) {
            iceFriction = (iceTemperature + 5) / (-5) * (iceFrictionArray[2] - iceFrictionArray[1]) + iceFrictionArray[1];
        } else if (iceTemperature > -1) {
            iceFriction = iceFrictionArray[0];
        } else {
            iceFriction = iceFrictionArray[2];
        }
        return iceFriction;
    }

    private double convertToDecimal(String roundTime) {
        String[] tokens = roundTime.split(":");
        int first = Integer.parseInt(tokens[0]);
        int second = Integer.parseInt(tokens[1]);
        String timeString = "" + first + "." + (second * 100/60);
        return Double.parseDouble(timeString);
    }

    private String convertToNormalStuff(double adjustedTime) {

        String formatted = String.format("%02f", adjustedTime);
        System.out.println(formatted);
        String[] tokens = formatted.split("\\,");
        System.out.println(tokens[0]);
        System.out.println(tokens[1]);
        String first = tokens[0];
        String second=tokens[1];
//        String first = String.format("%2d", Integer.parseInt(tokens[0]));
//        System.out.println(first);
//        String second = String.format("%2d", Integer.parseInt(tokens[1]));
//        System.out.println(second);
        return first+ ":"+second;
    }

}
