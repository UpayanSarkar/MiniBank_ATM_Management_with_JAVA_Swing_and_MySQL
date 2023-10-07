package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastCash extends JFrame implements ActionListener {
    JButton back, withdrawl, c100, c500, c1000, c2000, c5000, c10000;
    String pinnumber;
    JTextArea viewField;
    boolean withdrawalMade = false;
    
    List<Double> selectedWithdrawalAmounts = new ArrayList<>(); // List to store selected amounts

    FastCash(String pinnumber) {
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

        JLabel text = new JLabel("FastCash Withdrawal Service");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        viewField = new JTextArea();
        viewField.setFont(new Font("Raleway", Font.BOLD, 14));
        viewField.setBounds(180, 350, 310, 60);
        viewField.setEditable(false);
        viewField.setLineWrap(true);
        image.add(viewField);

        c100 = new JButton("100");
        c100.setBounds(170, 415, 150, 30);
        c100.setBackground(Color.white);
        c100.setForeground(Color.black);
        c100.addActionListener(this);
        c100.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c100);

        c500 = new JButton("500");
        c500.setBounds(355, 415, 150, 30);
        c500.setBackground(Color.white);
        c500.setForeground(Color.black);
        c500.addActionListener(this);
        c500.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c500);

        c1000 = new JButton("1000");
        c1000.setBounds(170, 450, 150, 30);
        c1000.setBackground(Color.white);
        c1000.setForeground(Color.black);
        c1000.addActionListener(this);
        c1000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c1000);

        c2000 = new JButton("2000");
        c2000.setBounds(355, 450, 150, 30);
        c2000.setBackground(Color.white);
        c2000.setForeground(Color.black);
        c2000.addActionListener(this);
        c2000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c2000);

        c5000 = new JButton("5000");
        c5000.setBounds(170, 485, 150, 30);
        c5000.setBackground(Color.white);
        c5000.setForeground(Color.black);
        c5000.addActionListener(this);
        c5000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c5000);

        c10000 = new JButton("10000");
        c10000.setBounds(355, 485, 150, 30);
        c10000.addActionListener(this);
        c10000.setBackground(Color.white);
        c10000.setForeground(Color.black);
        c10000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(c10000);

        withdrawl = new JButton("Withdrawal");
        withdrawl.setBounds(355, 520, 150, 30);
        withdrawl.setBackground(Color.white);
        withdrawl.setForeground(Color.black);
        withdrawl.addActionListener(this);
        withdrawl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
        withdrawl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawl.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdrawl.setBackground(Color.white);
            }
        });
        image.add(withdrawl);

        back = new JButton("Go Back");
        back.setBounds(170, 520, 150, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        });
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
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

        if (pinnumber.isEmpty()) {
            withdrawl.setEnabled(false);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Withdrawal Page");
        setSize(900, 900);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }
    
    @Override
public void actionPerformed(ActionEvent ae) {
    try {
        String buttonText = ((JButton) ae.getSource()).getText();
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        double balance = 0.0;

        while (rs.next()) {
            if (rs.getString("type").equals("Deposit")) {
                balance += Double.parseDouble(rs.getString("amount"));
            } else {
                balance -= Double.parseDouble(rs.getString("amount"));
            }
        }

        if (ae.getSource() != withdrawl && !buttonText.equals("Withdrawal")) {
            double amount = Double.parseDouble(buttonText);

            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
            } else {
                // Update the selected amount
                selectedWithdrawalAmounts.clear();
                selectedWithdrawalAmounts.add(amount);
                viewField.setText("Rs. " + amount + " selected for withdrawal.");
            }
        } else if (ae.getSource() == withdrawl) {
            if (!selectedWithdrawalAmounts.isEmpty()) {
                double totalWithdrawalAmount = selectedWithdrawalAmounts.get(0);

                if (withdrawalMade) {
                    JOptionPane.showMessageDialog(null, "You can only make one withdrawal at a time.");
                } else if (balance < totalWithdrawalAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance for Total Withdrawal");
                } else {
                    Date date = new Date();
                    c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+totalWithdrawalAmount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+totalWithdrawalAmount+" Debited Successfully");
                    
                    viewField.setText("Amount Debited Successfully: Rs. " + totalWithdrawalAmount);
                    withdrawalMade = true;
                    withdrawl.setEnabled(false);
                    
                    // Disable all money buttons after a successful withdrawal
                    c100.setEnabled(false);
                    c500.setEnabled(false);
                    c1000.setEnabled(false);
                    c2000.setEnabled(false);
                    c5000.setEnabled(false);
                    c10000.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No amount selected for withdrawal.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
