package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton loginButton,clear,signup;//globally defining to access into func
    JTextField cardTextField;
    JPasswordField pinTextField;
    JCheckBox showPasswordCheckBox;
    Login(){
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);// set the layout manager of a container to null, effectively disabling any automatic layout behavior.
        setTitle("Automated Teller Machine");
        //app icon img
         ImageIcon appIcon = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appIcon.getImage());

        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.jpg"));
        /*
        ClassLoader.getSystemResource method is commonly used to load resources
        bundled within the application's JAR file or classpath.
        */
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        /*
        getImage() method returns the Image associated with the ImageIcon.
        .getScaledInstance(100, 100, Image.SCALE_DEFAULT): 
        This method call scales the original Image to the desired dimensions of 100x100 pixels using the SCALE_DEFAULT scaling algorithm.
        */
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100,10,100,100);
        add(label);
        /*
        i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT) to fit into UI components. The scaled image is stored in Image object i2. 
        and  ImageIcon (i3) is created from the scaled Image (i2), allowing easy display in Swing components like JLabel.
        This approach separates original and scaled images for flexibility and code clarity,
        enhancing the ability to show images at different sizes in a Swing GUI.
        */
        //WELCOME
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        //CARD DETAIL
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,145,400,40);
        add(cardno);
        
        //cardfield
         cardTextField = new JTextField();
         cardTextField.setBounds(270,150,230,30);
         cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        //pin
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,215,400,40);
        add(pin);
        //pinfield
         pinTextField = new JPasswordField();
         pinTextField.setBounds(270,220,230,30);
         pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //3 buttons 
         loginButton =new JButton("SIGN IN");
        loginButton.setBounds(270,300,100,30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                // hover effect using MouseAdapter
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.BLACK);
            }
        });
        add(loginButton);
        //view password
        // Toggle button to show/hide password
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(390, 255, 120, 30);
        showPasswordCheckBox.setBackground(Color.white);
        showPasswordCheckBox.addActionListener(this);
        showPasswordCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(showPasswordCheckBox);
        //CLEAR BUTTON
        clear =new JButton("CLEAR");
        clear.setBounds(400,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
                //hover effect using MouseAdapter
            clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                clear.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear.setBackground(Color.BLACK);
            }
        });
        add(clear);
        //SIGN UP
        signup =new JButton("SIGN UP");
        signup.setBounds(270,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
            // hover effect using MouseAdapter
            signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signup.setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setBackground(Color.BLACK);
            }
        });
        add(signup);
        
        getContentPane().setBackground(Color.white); //: This method returns the content pane of a JFrame. 
        //The content pane is a container where you typically add your Swing components.
        setSize(700,480);//frame length
        setResizable(false); // Prevent resizing
        setLocationRelativeTo(null);
        setVisible(true);
        //setLocation(350,200);
        
    }

    //actionListener
    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == loginButton) {
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();

        // Check if the card number is correct
        String cardQuery = "select * from login where cardnumber = '" + cardnumber + "'";
        /*
        This constructs an SQL query to select all rows from the "login" table 
        where the "cardnumber" column matches the entered card number.
        */
        String pinQuery = "select * from login where cardnumber = '" + cardnumber + "' and pinnumber = '" + pinnumber + "'";

        /*
        This constructs an SQL query to select all rows from the "login" table
        where both the "cardnumber" and "pinnumber" columns match the entered card number and PIN.
        */
        try {
            ResultSet cardResult = conn.s.executeQuery(cardQuery);
            /*
            This executes the cardQuery SQL query and stores the result set in the cardResult variable.
            */
            ResultSet pinResult = null; // Initialize pinResult

            if (cardResult.next()) {//method is used to move the cursor to the next row of the result set. It returns a boolean value, indicating whether there is another row in the result set or not.
                // Card number is correct, now check the PIN
                pinResult = conn.s.executeQuery(pinQuery);
                /*
                    his executes the pinQuery SQL query to check if the PIN is correct and stores the result set in the pinResult variable.
                */
                if (pinResult.next()) {
                    // Both card number and PIN are correct
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    // Card number is correct, but PIN is incorrect
                    JOptionPane.showMessageDialog(null, "Incorrect PIN");
                }
            } else {
                // Card number is incorrect
                JOptionPane.showMessageDialog(null, "Incorrect card number");
            }

            // Close the pinResult if it was opened
            if (pinResult != null) {
                pinResult.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == clear) {
        cardTextField.setText("");
        pinTextField.setText("");
    } else if (ae.getSource() == signup) {
        setVisible(false);
        new SignupOne().setVisible(true);
    } else if (ae.getSource() == showPasswordCheckBox) {
        if (showPasswordCheckBox.isSelected()) {
            pinTextField.setEchoChar((char) 0); // Show password
        } else {
            pinTextField.setEchoChar('\u25cf'); // Mask password
        }
        /*
           Setting it to (char) 0 effectively shows the actual characters entered.
\u25cf. This character represents a black circle, and 
           it's commonly used to mask passwords in password fields.
           */
    }
}



    public static void main(String[] args) {
        new Login();
    }
}
