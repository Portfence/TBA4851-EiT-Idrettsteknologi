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
        
        myPanel.add(boxArea);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter the Athlete's info", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

        }

        return new String[]{name.getText(), weight.getText(),
        circumference.getText(),legLength.getText()};
    }

}
