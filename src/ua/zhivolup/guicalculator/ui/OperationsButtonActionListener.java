package ua.zhivolup.guicalculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationsButtonActionListener implements ActionListener {

    CalcFrame parent;

    public OperationsButtonActionListener(CalcFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = ((JButton) e.getSource()).getText();
        parent.textField.setText(parent.textField.getText() + buttonName);
    }
}
