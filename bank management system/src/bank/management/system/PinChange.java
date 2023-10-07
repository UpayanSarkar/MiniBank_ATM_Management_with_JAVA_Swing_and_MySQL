package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JButton change, back;
    JPasswordField newPinField, reenterPinField;
    JTextArea newPasswordTextArea;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        // Setting up the JFrame
        setLayout(null);
            //app icon img
         ImageIcon appIcon7 = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appIcon7.getImage());

        //
        ImageIcon i1 = new ImageIcon(Login.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change PIN");
        text.setBounds(300, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // New PIN input field
        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 14));
        newPinField.setBounds(250, 415, 200, 20);
        image.add(newPinField);

        // Re-entered PIN input field
        reenterPinField = new JPasswordField();
        reenterPinField.setFont(new Font("Raleway", Font.BOLD, 14));
        reenterPinField.setBounds(250, 445, 200, 20);
        image.add(reenterPinField);

        // New Password text area (read-only)
        newPasswordTextArea = new JTextArea();
        newPasswordTextArea.setFont(new Font("Raleway", Font.BOLD, 14));
        newPasswordTextArea.setBounds(250, 350, 200, 40);
        newPasswordTextArea.setEditable(false); // Make it read-only
        newPasswordTextArea.setLineWrap(true); // Enable line wrapping
        image.add(newPasswordTextArea);

        // New Pin label
        JLabel newpin = new JLabel("New Pin ");
        newpin.setBounds(180, 415, 700, 20);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System", Font.BOLD, 16));
        image.add(newpin);

        // Re-enter Pin label
        JLabel rnewpin = new JLabel("Re-enter Pin");
        rnewpin.setBounds(180, 445, 700, 20);
        rnewpin.setForeground(Color.WHITE);
        rnewpin.setFont(new Font("System", Font.BOLD, 16));
        image.add(rnewpin);

        // Change button
        change = new JButton("Change");
        change.setBounds(355, 520, 150, 30);
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Hover effect using MouseAdapter
        change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                change.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                change.setBackground(Color.WHITE);
            }
        });
        change.addActionListener(this); // Register the action listener
        image.add(change);

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
        
        if (pinnumber.isEmpty()) {
            change.setEnabled(false);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Change PIN Page");
        setSize(900, 900);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            String newPin = new String(newPinField.getPassword());
            String reenterPin = new String(reenterPinField.getPassword());

            // Check if newPin and reenterPin are not empty
            if (newPin.isEmpty() || reenterPin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            // Check if newPin and reenterPin are 4-digit numeric values
            if (!isNumeric(newPin) || !isNumeric(reenterPin) || newPin.length() != 4 || reenterPin.length() != 4) {
                JOptionPane.showMessageDialog(this, "New PIN and Re-entered PIN must be 4-digit numeric values.");
                return;
            }

            // Check if newPin and reenterPin match
            if (!newPin.equals(reenterPin)) {
                JOptionPane.showMessageDialog(this, "New PIN and Re-entered PIN do not match.");
                return;
            }

            // Database operations to change the password in three tables
            // Database operations to change the password in three tables
// Database operations to change the password in three tables
try {
    Conn conn = new Conn();

    if (pinnumber != null && !pinnumber.isEmpty()) { // Check for null and empty
        // Assuming you have SQL update statements ready for each table
        String updateBankNameTable = "UPDATE bank SET pin = '" + reenterPin + "' WHERE pin = '" + pinnumber + "'";
        String updateLoginTable = "UPDATE login SET pinnumber = '" + reenterPin + "' WHERE pinnumber = '" + pinnumber + "'";
        String updateSignupThreeTable = "UPDATE signupthree SET pinnumber = '" + reenterPin + "' WHERE pinnumber = '" + pinnumber + "'";

        System.out.println("Updating bank table with query: " + updateBankNameTable); // Add this line
        System.out.println("Updating login table with query: " + updateLoginTable); // Add this line
        System.out.println("Updating signupthree table with query: " + updateSignupThreeTable); // Add this line

        // Execute updates
        int bankUpdateResult = conn.s.executeUpdate(updateBankNameTable);
        int loginUpdateResult = conn.s.executeUpdate(updateLoginTable);
        int signupUpdateResult = conn.s.executeUpdate(updateSignupThreeTable);

        // Display the update results
        System.out.println("Update result for bank table: " + bankUpdateResult);
        System.out.println("Update result for login table: " + loginUpdateResult);
        System.out.println("Update result for signupthree table: " + signupUpdateResult);

        // Display success message or perform other actions
        if (bankUpdateResult > 0 && loginUpdateResult > 0 && signupUpdateResult > 0) {
            JOptionPane.showMessageDialog(this, "Password changed successfully!");

            // Set the new PIN in the newPasswordTextArea
            newPasswordTextArea.setText("New PIN: " + reenterPin);
        } else {
            JOptionPane.showMessageDialog(this, "Error changing password. Please try again later.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid PIN. Please try again.");
    }
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error changing password. Please try again later.");
}



        }
    }

    // Method to check if a string is numeric
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
