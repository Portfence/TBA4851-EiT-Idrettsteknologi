package app;

import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public class Athlete {
    private final String name;
    private float weight;
    private String previousTime;
    private float circumference;
    private float legLength;
    private float surfaceArea;
    private ArrayList<String> list500;
    private ArrayList<String> list1500;
    private ArrayList<String> list2000;
    
    public Athlete(String name, float weight, float circumference, float legLength){
        this.name = name;
        this.weight=weight;
        this.circumference=circumference;
        this.legLength =legLength;
        calculateSurfaceArea(weight, circumference, legLength);
    }
    
    private void calculateSurfaceArea(float weight,float circumference,float legLength){
        surfaceArea=0.0f;
    }
    public String getName(){
        return name;
    }
    public float getSurfaceArea(){
        return weight;
    }
    public void setPreviousTime(String previousTime) {
        this.previousTime = previousTime;
    }

    public String getPreviousTime() {
        return previousTime;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCircumference() {
        return circumference;
    }

    public void setCircumference(float circumference) {
        this.circumference = circumference;
    }
    public float getLegLength(){
        return legLength;
    }
    public void setLegLength(float legLength){
        this.legLength=legLength;
    }
    
    
    
}
