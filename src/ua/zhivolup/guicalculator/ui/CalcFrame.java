package ua.zhivolup.guicalculator.ui;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

public class CalcFrame{

    JFrame frame = new JFrame();
    JScrollPane scrollPane;
    JTextArea display;
    JTextField textField;

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

    public JTextArea display(){
        display = new JTextArea(5, 23);
        display.setEditable(false);
        display.setLineWrap(true);
        return display;
    }

    /*public JScrollPane scrollPane(){
        scrollPane = new JScrollPane(display(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }*/

    public JPanel scrollPanePanel(){
        JPanel scrollPanePanel = new JPanel(new GridLayout(1, 1, 2, 2));
        scrollPane = new JScrollPane(display(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanePanel.add(scrollPane);
        return scrollPanePanel;
    }

    public JPanel textFieldPanel(){
        JPanel textFieldPanel = new JPanel(new GridLayout(1, 1, 2, 2));
        textField = new JTextField(23);
        textFieldPanel.add(textField);
        return textFieldPanel;
    }

    public JPanel textPanel(){
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(scrollPanePanel(), BorderLayout.PAGE_START);
        textPanel.add(textFieldPanel(), BorderLayout.PAGE_END);
        return textPanel;
    }

    public JPanel buttonPanel(){
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

        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonSum);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonSub);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonDelim);
        buttonPanel.add(button0);
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonMul);

        JButton[] numberedButtonArray = {button0, button1, button2, button3, button4, button5, button6, button7,
                button8, button9, buttonDelim};
        for (JButton button : numberedButtonArray){
            button.addActionListener(new NumderButtonsActionListener(this));
        }

        JButton[] operationButtonArray = {buttonSum, buttonSub, buttonDivide, buttonMul};
        for (JButton button : operationButtonArray){
            button.addActionListener(new OperationsButtonActionListener(this));
        }

        buttonStart.addActionListener(new ResultButtonActionListener(this));

        return buttonPanel;
    }

    public JPanel cleanButtonPanel(){
        JPanel clearButtonPanel = new JPanel(new GridLayout(1, 1, 2, 2));

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ClearActionListener(textField));
        clearButtonPanel.add(clearButton);
        return clearButtonPanel;
    }

}
