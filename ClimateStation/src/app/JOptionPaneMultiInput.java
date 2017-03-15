package app;

import javax.swing.*;

public class JOptionPaneMultiInput {

    public String[] promptInputs() {
        JTextField name = new JTextField(15);
        JTextField weight = new JTextField(15);
        JTextField circumference = new JTextField(15);
        JTextField legLength = new JTextField(15);
        JPanel myPanel = new JPanel();
        Box boxArea =Box.createVerticalBox();
        
        boxArea.add(new JLabel("Full Name: "));
        boxArea.add(name);
        boxArea.add(Box.createVerticalBox()); // a spacer
        boxArea.add(new JLabel("Weight [kg]: "));
        boxArea.add(weight);
        boxArea.add(new JLabel("Shoulder Circumference [m]: "));
        boxArea.add(circumference);
        boxArea.add(new JLabel("Leg Length [m]: "));
        boxArea.add(legLength);
        
        myPanel.add(boxArea);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter the Athlete's info", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Full Name: " + name.getText());
            System.out.println("Area [m^2]: ");
        }

        return new String[]{name.getText(), weight.getText(),
        circumference.getText(),legLength.getText()};
    }

}
