package app;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    private DefaultTableModel model;
    private ArrayList<String> list500;
    private ArrayList<String> list1500;
    private ArrayList<String> list2000;
    private int listIndex;
    private String athletesReferenceTime;
    private String[] refCond;

    public Athlete(String name, float weight, float circumference, float legLength, DefaultTableModel model) {
        this.name = name;
        this.weight = weight;
        this.circumference = circumference;
        this.legLength = legLength;
        this.model = model;
        calculateSurfaceArea(weight, circumference, legLength);
        listIndex = 1;
    }

    public void incrementListIndex() {
        listIndex++;
    }

    public void decrementListIndex() {
        listIndex--;
    }

    private void calculateSurfaceArea(float weight, float circumference, float legLength) {
        surfaceArea = 0.0f;
    }

    public String getName() {
        return name;
    }

    public float getSurfaceArea() {
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

    public float getLegLength() {
        return legLength;
    }

    public void setLegLength(float legLength) {
        this.legLength = legLength;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public int getListIndex() {
        return listIndex;
    }

    void setAthletesReferenceTime(String time, String temp_1, String temp_2, String temp_3, String airP, String hum) {
        this.athletesReferenceTime=time;
        setReferenceConditions(temp_1,temp_2,temp_3,airP,hum);
    }

    private void setReferenceConditions(String temp_1, String temp_2, String temp_3, String airP, String hum) {
        this.refCond=new String[]{temp_1,temp_2,temp_3,airP,hum};
    }
    public String[] getReferenceCondtitions(){
        return refCond;
    }
    public String getReferenceTime(){
        return athletesReferenceTime;
    }

}
