
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class Transactions extends JFrame implements ActionListener {
    String pinnumber;
    JButton home,exit,balanceenquiry,deposit,withdraw,fastcash,ministatement,pinchange;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        //app icon img cause setUndecorated(true);
         ImageIcon appicon5 = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appicon5.getImage());

        //
    //screen image
         setLayout(null);
         ImageIcon i1 = new ImageIcon(Login.class.getResource("/icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image); 
      //
      JLabel text=new   JLabel("Please select your Transaction");
      text.setBounds(220,300,700,35);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
        //button deposit
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        deposit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(deposit);
        //button withdraw
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(withdraw);
        //button fastcash
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        fastcash.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(fastcash);
        //Button ministatement
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
         ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.black);
        ministatement.addActionListener(this);
        ministatement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(ministatement);
        //Button pin change
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        pinchange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(pinchange);
        //Button Balance Enquiry
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.setForeground(Color.black);
        balanceenquiry.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(balanceenquiry);
        //Button login home
        home=new JButton("Go Back");
        home.setBounds(170,520,150,30);
        home.setBackground(Color.white);
        home.setForeground(Color.black);
        home.addActionListener(this);
        // effect
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(Color.white);
            }
        });
        image.add(home);
        //Button exit
        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        // effect
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover effect using MouseAdapter
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(Color.white);
            }
        });
        image.add(exit);
        
        
        
        
        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Transaction Page");
        setSize(900,900);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==home){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);  
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
