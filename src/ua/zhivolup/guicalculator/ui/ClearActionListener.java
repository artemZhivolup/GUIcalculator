package ua.zhivolup.guicalculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearActionListener implements ActionListener {

    JTextField textField;

    public ClearActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp = textField.getText();
        textField.setText(temp.substring(0, temp.length()-1));
    }
}
