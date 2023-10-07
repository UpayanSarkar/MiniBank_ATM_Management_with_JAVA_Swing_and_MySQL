package bank.management.system;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JTextArea totalAmountField;
    JButton back, deposit;
    String pinnumber;
    boolean depositMade = false;

    Deposit(String pinnumber) {
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

        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setBounds(190, 300, 700, 35);
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

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        deposit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deposit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deposit.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deposit.setBackground(Color.white);
            }
        });
        image.add(deposit);

        back = new JButton("Go Back");
        back.setBounds(170, 485, 150, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setBackground(Color.white);
            }
        });
        image.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Deposit Page");
        setSize(900, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        if (pinnumber.isEmpty()) {
            deposit.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            if (depositMade) {
                JOptionPane.showMessageDialog(this, "You can only make one deposit at a time. Go back and come again to deposit more.", "Already Deposited", JOptionPane.WARNING_MESSAGE);
            } else {
                String number = amount.getText();
                Date date = new Date();

                if (number.isEmpty() || number.equals("0")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid amount to deposit.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        double depositAmount = Double.parseDouble(number);

                        if (depositAmount > 0) {
                            try {
                                Conn conn = new Conn();
                                String insertQuery = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', 'Deposit', '" + depositAmount + "')";
                                conn.s.executeUpdate(insertQuery);

                                totalAmountField.setText("Added: RS " + depositAmount);

                                amount.setText("");
                                depositMade = true;
                                deposit.setEnabled(false);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please enter a valid amount greater than zero.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

