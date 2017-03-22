/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Albert
 */
import javax.swing.*;

public class JDisplayReferenceFrame {

    private final Athlete athlete;

    public JDisplayReferenceFrame(Athlete athlete) {
        this.athlete = athlete;
    }

    public void displayFrame() {
        String[] referenceConditions = athlete.getReferenceCondtitions();
        JPanel myPanel = new JPanel();
        
        Box boxAreaLeft = Box.createVerticalBox();
        Box boxAreaRight = Box.createVerticalBox();
        boxAreaLeft.add(new JLabel("Athlete's Name: "));
        boxAreaRight.add(new JLabel(athlete.getName()));
        boxAreaLeft.add(new JLabel("Reference Time: "));
        boxAreaRight.add(new JLabel(athlete.getReferenceTime()));
        boxAreaLeft.add(new JLabel("ºC (Top)"));
        boxAreaRight.add(new JLabel(referenceConditions[0]));
        boxAreaLeft.add(new JLabel("ºC (Middle) "));
        boxAreaRight.add(new JLabel(referenceConditions[1]));
        boxAreaLeft.add(new JLabel("ºC (Bottom) "));
        boxAreaRight.add(new JLabel(referenceConditions[2]));
        boxAreaLeft.add(new JLabel("Pressure [Pa] "));
        boxAreaRight.add(new JLabel(referenceConditions[3]));
        boxAreaLeft.add(new JLabel("Relative Humidity [%] "));
        boxAreaRight.add(new JLabel(referenceConditions[4]));
        myPanel.add(boxAreaLeft);
        myPanel.add(boxAreaRight);
       

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Ahlete's Reference Conditions", JOptionPane.OK_OPTION);

    }

}
