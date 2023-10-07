
package bank.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BalanceEnquiry extends JFrame {
    String pinnumber;
    JButton back;
    JTextArea viewbalanceTextArea;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        // Setting up the JFrame
        setLayout(null);
         //app icon img
         ImageIcon appIcon6 = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appIcon6.getImage());

        //
        ImageIcon i1 = new ImageIcon(Login.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Your total Balance");
        text.setBounds(260, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        //
        // New balance view text area (read-only)
        viewbalanceTextArea = new JTextArea();
        viewbalanceTextArea.setFont(new Font("Raleway", Font.BOLD, 14));
        viewbalanceTextArea.setBounds(210, 400, 240, 40);
        viewbalanceTextArea.setEditable(false); // Make it read-only
        viewbalanceTextArea.setLineWrap(true); // Enable line wrapping
        // Set internal margin to add space around the text
        int topPadding = 10;
        int leftPadding = 50;
        int bottomPadding = 5;
        int rightPadding = 5;
        viewbalanceTextArea.setMargin(new Insets(topPadding, leftPadding, bottomPadding, rightPadding));
        image.add(viewbalanceTextArea);
        //
        // Go Back button
        back = new JButton("Go Back");
        back.setBounds(170, 520, 150, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        });
        // Hover effect using MouseAdapter
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setBackground(Color.WHITE);
            }
        });
        image.add(back);
        //
        // Fetch and display the balance from the database
        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            double balance = 0.0;
            boolean balanceFound = false; // Add a flag to check if the balance was found

            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(resultSet.getString("amount"));
                    balanceFound = true; // Set the flag to true if a deposit was found
                } else {
                    balance -= Double.parseDouble(resultSet.getString("amount"));
                }
            }

            if (balanceFound) {
                viewbalanceTextArea.setText(String.format("%.2f", balance)); // Format and set the balance in the text area
            } else {
                viewbalanceTextArea.setText("Balance not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Balance Enquiry");
        setSize(900, 900);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
