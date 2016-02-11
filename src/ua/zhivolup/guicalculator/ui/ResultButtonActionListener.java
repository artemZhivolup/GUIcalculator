package ua.zhivolup.guicalculator.ui;

import ua.zhivolup.guicalculator.service.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonActionListener implements ActionListener {

    private CalcFrame parent;
    private JDialog errorWindow;

    public ResultButtonActionListener(CalcFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = parent.getTextField().getText();
        int index = 0;
        char operator = '\u0000';
        char [] operations = {'+', '-', '*', '/'};

        for (char character : operations) {
            index = value.indexOf(String.valueOf(character));
            if (index != -1) {
                operator = character;
                break;
            }
        }
        if (index == 0 || index == -1){
            errorPane();
        }

        double firstValue = Double.valueOf(value.substring(0, index));
        double secondValue = Double.valueOf(value.substring(index + 1));
        double result = Calculator.calculate(firstValue, secondValue, operator);

        parent.getDisplay().setText(parent.getDisplay().getText() + value + "=" + result  + "\n");
        parent.getTextField().setText("");
    }

    private JOptionPane errorPane(){
        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, "Not supported operation.", "Error!", JOptionPane.ERROR_MESSAGE);
        return optionPane;
    }
}
