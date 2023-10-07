package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    ButtonGroup groupaccount;
    JLabel number, card, l1, pin, pnumber, pindetail, carddetail, service;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno=formno;
        // app icon img
        ImageIcon appicon3 = new ImageIcon(Login.class.getResource("logo.jpg"));
        setIconImage(appicon3.getImage());
        // heading
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(210, 40, 400, 40);
        add(l1);

        // Account type
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        //
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        //
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        //
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);
        //
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        // card no
        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        number = new JLabel("xxxx-xxxx-xxxx-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        carddetail = new JLabel("This is your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(330, 340, 300, 20);
        add(carddetail);
        // pin
        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        pindetail = new JLabel("Your 4 Digit Pin");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(330, 400, 300, 30);
        add(pindetail);
        // services require
        service = new JLabel("Services Required :");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 250, 30);
        add(service);
        // c1
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        // c2
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        // c3
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        // c4
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        // c5
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        // c6
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        // c7
        c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.white);
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        // buttons
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(200, 720, 100, 30);
        submit.addActionListener(this);
        // effect
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submit.setBackground(Color.BLACK);
            }
        });
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(350, 720, 100, 30);
        cancel.addActionListener(this);
        // effect
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(Color.BLACK);
            }
        });
        add(cancel);

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Account Details");
        setSize(700, 820);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        
        Random random=new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        //String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
        String pinnumber = String.format("%04d", random.nextInt(10000));

        /*
             * Math.abs() is used to ensure that the generated number is positive. This is
             * important because card numbers and PINs are typically positive numbers.
             * 
             * random.nextLong() % 90000000L generates a random long integer between 0 and
             * 89,999,999. The % operator calculates the remainder when dividing the random
             * number by 90,000,000.
             * 
             * Math.abs(random.nextLong() % 90000000L) makes sure that the generated number
             * is positive.
             * 
             * 5040936000000000L is a constant value added to the generated number. This
             * constant is often used as a prefix for card numbers to indicate the issuer or
             * bank.
             */

        // Validate selected options
        String accountType = validateAccountType();
        String facility = validateFacilitySelection();
        boolean detailsDeclaredCorrect = isDetailsDeclaredCorrect();


        if (accountType != null && !facility.isEmpty() && detailsDeclaredCorrect) {
            // Perform database operations here
            Conn conn=new Conn();
            String query = "INSERT INTO signupthree (formno, accountType, cardnumber, pinnumber, facility) " +
               "VALUES ('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
            String query1 = "INSERT INTO login (formno, cardnumber, pinnumber) " +
               "VALUES ('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                try {
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query1);
                     JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n  Pin: "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                } catch (Exception e) {
                         e.printStackTrace(); // Handle the exception (e.g., print the stack trace for debugging)
                    }
        }
    } else if (ae.getSource() == cancel) {
        // Handle cancel button action here
        setVisible(false);
        new Login().setVisible(true);
    }
}
//validate the self declaration
// Validate the self-declaration
private boolean isDetailsDeclaredCorrect() {
    if (!c7.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please declare that the entered details are correct.");
        return false;
    }
    return true;
}
// Validate the selected account type
private String validateAccountType() {
    String accountType = null;

    if (r1.isSelected()) {
        accountType = "Saving Account";
    } else if (r2.isSelected()) {
        accountType = "Fixed Deposit Account";
    } else if (r3.isSelected()) {
        accountType = "Current Account";
    } else if (r4.isSelected()) {
        accountType = "Recurring Deposit Account";
    } else {
        JOptionPane.showMessageDialog(null, "Please select an account type.");
    }

    return accountType;
}

// Validate the selected facilities
private String validateFacilitySelection() {
    String facility = "";

    if (c1.isSelected()) {
        facility += "ATM CARD, ";
    }
    if (c2.isSelected()) {
        facility += "Internet Banking, ";
    }
    if (c3.isSelected()) {
        facility += "Mobile Banking, ";
    }
    if (c4.isSelected()) {
        facility += "Email & SMS Alerts, ";
    }
    if (c5.isSelected()) {
        facility += "Cheque Book, ";
    }
    if (c6.isSelected()) {
        facility += "E-Statement, ";
    }

    // Remove the trailing comma and space if there are selected facilities
    if (!facility.isEmpty()) {
        facility = facility.substring(0, facility.length() - 2); // Removes the last two characters (", ")
    } else {
        JOptionPane.showMessageDialog(null, "Please select at least one service.");
    }

    return facility;
}


    public static void main(String[] args) {
        new SignupThree("");
    }
}
