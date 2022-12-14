import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame mainFrame;
    JTextField input;
    JLabel label;
    JPanel buttonPanel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton, 
    clearButton, clearEntryButton, backspaceButton, inverseButton, decimalButton, equalsButton;

    double number1=0;
    double number2=0;
    double result=0;
    char operator;

    Font font = new Font("Dialog",Font.BOLD,30);
    Border inputBorder = BorderFactory.createLineBorder(Color.black);


    public void init() {
        mainFrame = new JFrame("Simple-Calculator");        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500);
        mainFrame.setLayout(null);

        input = new JTextField();
        input.setEditable(false);
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setFont(font);
        input.setText("0");
        input.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        input.setBounds(50, 30, 600, 50);

        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(50, 15, 600, 15);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("C");
        clearEntryButton = new JButton("CE");
        backspaceButton = new JButton("←");
        inverseButton = new JButton("-(x)");
        decimalButton = new JButton(",");
        equalsButton = new JButton("=");   

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = clearButton;
        functionButtons[5] = clearEntryButton;
        functionButtons[6] = backspaceButton;
        functionButtons[7] = inverseButton;
        functionButtons[8] = decimalButton;
        functionButtons[9] = equalsButton;

        for(int i=0; i<10; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 115, 600, 300);
        buttonPanel.setLayout(new GridLayout(5,4, 5, 5));

        buttonPanel.add(functionButtons[0]);
        buttonPanel.add(functionButtons[1]);
        buttonPanel.add(functionButtons[2]);
        buttonPanel.add(functionButtons[3]);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(functionButtons[4]);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(functionButtons[5]);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);        
        buttonPanel.add(functionButtons[6]);
        buttonPanel.add(functionButtons[7]);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(functionButtons[8]);
        buttonPanel.add(functionButtons[9]);

        mainFrame.add(buttonPanel);
        mainFrame.add(input);
        mainFrame.add(label);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                if(input.getText().equals("0")) {
                    input.setText(String.valueOf(i));
                }
                else {
                    input.setText(input.getText() + String.valueOf(i));;
                }
            }
        }

        if(e.getSource() == decimalButton) {
            if(!input.getText().contains(".")) {
                input.setText(input.getText() + ".");        
            }
        }

        if(e.getSource() == inverseButton) {
            if(input.getText().startsWith("-")){
                input.setText(input.getText().substring(1));
            }
            else if(!input.getText().equals("0")) {
                input.setText("-" + input.getText());            
            }
        }

        if(e.getSource() == clearButton) {
            input.setText("0");
            label.setText("");
            operator = Character.MIN_VALUE;
            number1 = 0;
            number2 = 0;
            result = 0;
        }

        if(e.getSource() == clearEntryButton) {
            input.setText("0");
        }

        if(e.getSource() == backspaceButton) {
            if(input.getText().length() > 1){
                input.setText(input.getText().substring(0, input.getText().length() - 1));
            }
            else if(input.getText() != "0") {
                input.setText("0");
            }
        }

        if(e.getSource() == addButton) {
            if(operator == 0) {
                operator = '+';
                number1 = Double.parseDouble(input.getText());
                input.setText("0");    
                label.setText(number1 + " " + operator);
            }
            else {
                operator = '+';
                label.setText(number1 + " " + operator);
            }
        }

        if(e.getSource() == subtractButton) {
            if(operator == 0) {
                operator = '-';
                number1 = Double.parseDouble(input.getText());
                input.setText("0");   
                label.setText(number1 + " " + operator); 
            }
            else {
                operator = '-';
                label.setText(number1 + " " + operator);
            }
        }

        if(e.getSource() == multiplyButton) {
            if(operator == 0) {
                operator = '*';
                number1 = Double.parseDouble(input.getText());
                input.setText("0");
                label.setText(number1 + " " + operator);
            }
            else {
                operator = '*';
                label.setText(number1 + " " + operator);
            }
        }

        if(e.getSource() == divideButton) {
            if(operator == 0) {
                operator = '/';
                number1 = Double.parseDouble(input.getText());
                input.setText("0");
                label.setText(number1 + " " + operator);    
            }
            else {
                operator = '/';
                label.setText(number1 + " " + operator);
            }
        }
        
        if(e.getSource() == equalsButton) {
            if(operator != 0) {
                number2 = Double.parseDouble(input.getText());
                switch(operator) {
                    case '+':
                    result = number1 + number2;
                    break;
                    case '-':
                    result = number1 - number2;
                    break;
                    case '*':
                    result = number1 * number2;
                    break;
                    case '/':
                    result = number1 / number2;
                    break;
                }
                label.setText("");;               
                number1 = 0;
                number2 = 0;
                operator = Character.MIN_VALUE;                
                input.setText(String.valueOf(result));
                operator = Character.MIN_VALUE;
            }
            else {
                System.out.println("An operator was not defined");
            }
        }
       
    }    
}
