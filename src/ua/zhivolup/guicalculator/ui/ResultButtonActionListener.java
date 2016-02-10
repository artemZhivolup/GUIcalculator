package ua.zhivolup.guicalculator.ui;

import ua.zhivolup.guicalculator.service.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonActionListener implements ActionListener {

    CalcFrame parent;

    public ResultButtonActionListener(CalcFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = parent.textField.getText();
        int index;
        double firstValue = 0;
        double secondValue = 0;
        char operator = '\u0000';

        if (operation.indexOf("+") != -1){
            operator = '+';
            index = operation.indexOf("+");
            firstValue = Double.valueOf(operation.substring(0, index));
            secondValue = Double.valueOf(operation.substring(index + 1));
        } else if (operation.indexOf("-") != -1){
            operator = '-';
            index = operation.indexOf("-");
            firstValue = Double.valueOf(operation.substring(0, index));
            secondValue = Double.valueOf(operation.substring(index + 1));
        } else if (operation.indexOf("*") != -1){
            operator = '*';
            index = operation.indexOf("*");
            firstValue = Double.valueOf(operation.substring(0, index));
            secondValue = Double.valueOf(operation.substring(index + 1));
        } else if (operation.indexOf("/") != -1){
            operator = '/';
            index = operation.indexOf("/");
            firstValue = Double.valueOf(operation.substring(0, index));
            secondValue = Double.valueOf(operation.substring(index + 1));
        } else {
            throw new IllegalArgumentException("NotSupportedOperation" + operator);
        }

        double result = Calculator.calculate(firstValue, secondValue, operator);
        parent.display.setText(parent.display.getText() + operation + "=" + result  + "\n");
        parent.textField.setText("");
    }
}
