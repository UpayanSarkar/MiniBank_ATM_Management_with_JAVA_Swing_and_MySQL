package bank.management.system;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton back, withdrawalButton;
    JTextArea totalAmountField;
    String pinnumber;
    boolean withdrawalMade = false;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon appicon5 = new ImageIcon(Login.class.getResource("logo.jpg"));
        setIconImage(appicon5.getImage());

        setLayout(null);
        ImageIcon i1 = new ImageIcon(Login.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setBounds(180, 350, 310, 20);
        image.add(amount);

        totalAmountField = new JTextArea();
        totalAmountField.setFont(new Font("Raleway", Font.BOLD, 14));
        totalAmountField.setBounds(180, 400, 310, 60);
        totalAmountField.setEditable(false);
        totalAmountField.setLineWrap(true);
        image.add(totalAmountField);

        withdrawalButton = new JButton("Withdraw");
        withdrawalButton.setBounds(355, 485, 150, 30);
        withdrawalButton.setBackground(Color.WHITE);
        withdrawalButton.setForeground(Color.BLACK);
        withdrawalButton.addActionListener(this);
        withdrawalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawalButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdrawalButton.setBackground(Color.WHITE);
            }
        });
        image.add(withdrawalButton);

        back = new JButton("Go Back");
        back.setBounds(170, 485, 150, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Withdrawal Page");
        setSize(900, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        if (pinnumber.isEmpty()) {
            withdrawalButton.setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent ae) {
    try {
        String amountValue = amount.getText();
        Date date = new Date();
        if (ae.getSource() == withdrawalButton) {
            if (amountValue.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
            } else {
                Conn c1 = new Conn();

                ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Double.parseDouble(rs.getString("amount"));
                    } else {
                        balance -= Double.parseDouble(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amountValue)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                c1.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amountValue + "')");

                // Set the success message in the JTextArea
                totalAmountField.setText("Rs. " + amountValue + " Debited Successfully");

                // Clear the amount field
                amount.setText("");

                // Disable the "Withdraw" button after a successful withdrawal
                withdrawalButton.setEnabled(false);
                
                // Set the flag to indicate a withdrawal has been made
                withdrawalMade = true;
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("error: " + e);
    }
}

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
