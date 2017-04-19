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
    private DefaultTableModel model;
    private int listIndex;
    private String athletesReferenceTime;
    private String[] refCond;

    public Athlete(String name, float weight, DefaultTableModel model) {
        this.name = name;
        this.weight = weight;
        this.model = model;
        listIndex = 1;
    }

    public void incrementListIndex() {
        listIndex++;
    }

    public void decrementListIndex() {
        listIndex--;
    }

    private void calculateSurfaceArea(float weight, float circumference, float legLength) {
        //unimplemented
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
