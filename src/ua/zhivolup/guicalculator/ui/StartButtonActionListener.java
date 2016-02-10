package ua.zhivolup.guicalculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonActionListener implements ActionListener {

    JTextField textField;
    JTextArea display;
    double firstValue = 0.0;
    String operation = "+";

    public StartButtonActionListener(JTextField textField, JTextArea display) {
        this.textField = textField;
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double secondValue = Double.valueOf(textField.getText());
        if("+".equals(operation)){
            display.setText(display.getText() + (firstValue+secondValue) + "");
        }
        if("-".equals(operation)){
            display.setText(display.getText() + (firstValue-secondValue) + "");
        }
        if("*".equals(operation)){
            display.setText(display.getText() + (firstValue*secondValue) + "");
        }
        if("/".equals(operation)){
            display.setText(display.getText() + (firstValue/secondValue) + "");
        }
    }
}
