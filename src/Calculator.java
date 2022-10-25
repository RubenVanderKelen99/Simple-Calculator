import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame mainFrame;
    JTextField input;
    JPanel buttonPanel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton, 
    clearButton, deleteButton, inverseButton, decimalButton, equalsButton;

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
        input.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        input.setBounds(50, 30, 600, 50);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("C");
        deleteButton = new JButton("←");
        inverseButton = new JButton("-(x)");
        decimalButton = new JButton(",");
        equalsButton = new JButton("=");

        addButton.setBounds(50, 115, 130, 60);
        subtractButton.setBounds(206, 115, 130, 60);
        multiplyButton.setBounds(363, 115, 130, 60);
        divideButton.setBounds(520, 115, 130, 60);
        clearButton.setBounds(520, 195, 130, 60);
        deleteButton.setBounds(520, 275, 130, 60);
        inverseButton.setBounds(50, 355, 130, 60);
        decimalButton.setBounds(363, 355, 130, 60);
        equalsButton.setBounds(520, 355, 130, 60);        

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = clearButton;
        functionButtons[5] = deleteButton;
        functionButtons[6] = inverseButton;
        functionButtons[7] = decimalButton;
        functionButtons[8] = equalsButton;

        for(int i=0; i<9; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
            mainFrame.add(functionButtons[i]);
        }

        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        mainFrame.add(input);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }    
}
