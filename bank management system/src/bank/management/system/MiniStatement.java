package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //app icon img
         ImageIcon appIcon5 = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appIcon5.getImage());

        //
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create a JPanel to hold the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // Create a JTextArea for displaying the statement
        JTextArea statementTextArea = new JTextArea(20, 40); // 20 rows, 40 columns
        statementTextArea.setEditable(false); // Make it read-only
        statementTextArea.setWrapStyleWord(true); // Word wrap
        statementTextArea.setLineWrap(true); // Line wrap
        JScrollPane scrollPane = new JScrollPane(statementTextArea);
        
        contentPanel.add(scrollPane, BorderLayout.CENTER); // Add the JTextArea to the JScrollPane and then to the content panel

        // Create and set the card number label
        JLabel cardNumberLabel = new JLabel();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber = '" + pinnumber + "'");
            while (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                String maskedCardNumber = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
                cardNumberLabel.setText("Card Number: " + maskedCardNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentPanel.add(cardNumberLabel, BorderLayout.NORTH); // Add the card number label to the content panel

        // Create and set the total balance label
        JLabel totalBalanceLabel = new JLabel();
        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                statementTextArea.append(rs.getString("date") + "\t" + rs.getString("type") + "\t" + rs.getString("amount") + "\n");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            totalBalanceLabel.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentPanel.add(totalBalanceLabel, BorderLayout.SOUTH); // Add the total balance label to the content panel

        setContentPane(contentPanel); // Set the content panel as the frame's content pane
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
