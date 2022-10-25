import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame mainFrame;
    JTextField input;

    Font font = new Font("Dialog",Font.BOLD,30);


    public void init() {
        mainFrame = new JFrame("Simple-Calculator");        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(700, 525);
		mainFrame.setLayout(null);

        input = new JTextField();
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setFont(font);
        input.setBounds(50, 25, 600, 50);
        
        mainFrame.add(input);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }    
}
