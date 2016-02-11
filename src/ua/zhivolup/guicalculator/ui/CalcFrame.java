package ua.zhivolup.guicalculator.ui;

import javax.swing.*;
import java.awt.*;

public class CalcFrame{

    private JFrame frame = new JFrame();
    private JScrollPane scrollPane;
    private JTextArea display;
    private JTextField textField;
    private NumderButtonsActionListener numderButtonsActionListener = new NumderButtonsActionListener(this);
    private OperationsButtonActionListener operationsButtonActionListener = new OperationsButtonActionListener(this);
    private ResultButtonActionListener resultButtonActionListener = new ResultButtonActionListener(this);

    public CalcFrame(){
        frame.setBounds(400, 400, 350, 320);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GUIcalculator");
        frame.add(textPanel(), BorderLayout.PAGE_START);
        frame.add(buttonPanel(), BorderLayout.CENTER);
        frame.add(cleanButtonPanel(), BorderLayout.EAST);
        frame.setVisible(true);
    }

    public JTextArea getDisplay() {
        return display;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JFrame getFrame() {
        return frame;
    }

    private JTextArea display(){
        display = new JTextArea(5, 23);
        display.setEditable(false);
        display.setLineWrap(true);
        return display;
    }

    private JPanel scrollPanePanel(){
        JPanel scrollPanePanel = new JPanel(new GridLayout(1, 1, 2, 2));
        scrollPane = new JScrollPane(display(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanePanel.add(scrollPane);
        return scrollPanePanel;
    }

    private JPanel textFieldPanel(){
        JPanel textFieldPanel = new JPanel(new GridLayout(1, 1, 2, 2));
        textField = new JTextField(23);
        textFieldPanel.add(textField);
        return textFieldPanel;
    }

    private JPanel textPanel(){
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(scrollPanePanel(), BorderLayout.PAGE_START);
        textPanel.add(textFieldPanel(), BorderLayout.PAGE_END);
        return textPanel;
    }

    private JPanel buttonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 2, 2));

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonSum = new JButton("+");
        JButton buttonDivide = new JButton("/");
        JButton buttonSub = new JButton("-");
        JButton buttonMul = new JButton("*");
        JButton buttonStart = new JButton("=");
        JButton buttonDelim = new JButton(".");

        JButton[] firstLine = {button7, button8, button9, buttonSum, button4, button5, button6, buttonSub,
                button1, button2, button3, buttonDivide, buttonDelim, button0, buttonStart, buttonMul};
        for (JButton button : firstLine) {
            buttonPanel.add(button);
        }

        JButton[] numberedButtonArray = {button0, button1, button2, button3, button4, button5, button6, button7,
                button8, button9, buttonDelim};
        for (JButton button : numberedButtonArray){
            button.addActionListener(numderButtonsActionListener);
        }

        JButton[] operationButtonArray = {buttonSum, buttonSub, buttonDivide, buttonMul};
        for (JButton button : operationButtonArray){
            button.addActionListener(operationsButtonActionListener);
        }

        buttonStart.addActionListener(resultButtonActionListener);

        return buttonPanel;
    }

    private JPanel cleanButtonPanel(){
        JPanel clearButtonPanel = new JPanel(new GridLayout(1, 1, 2, 2));

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ClearActionListener(textField));
        clearButtonPanel.add(clearButton);
        return clearButtonPanel;
    }

}
