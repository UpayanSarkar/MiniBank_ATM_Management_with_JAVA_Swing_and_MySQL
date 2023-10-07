package bank.management.system;
    import java.awt.*;
    import javax.swing.*;
    import java.util.*;
    import java.awt.event.*;
    import java.awt.event.ActionEvent;
    import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,
            cityTextField,pinTextField;
    JDateChooser dateChooser;
    JRadioButton male,female,married,single,others;
    ButtonGroup gendergroup,maritalgroup;
    JButton next;
    
     private String[] states = {
        "","Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
        "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala",
        "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
        "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
        "Uttar Pradesh", "Uttarakhand", "West Bengal"
    };
      private JComboBox<String> stateComboBox;
      long random;
    SignupOne(){
        
        //app icon img
         ImageIcon appicon = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appicon.getImage());

        //
    
    
    Random ran=new Random();
    random=Math.abs((ran.nextLong()%9000L)+1000L);
    /*
    ran.nextLong() % 9000L : . This is done to constrain the range of possible values to between 
    0 and 8999 (inclusive). Math.abs() ensures that the value is non-negative , + 1000L : shifts the 
    range of possible values from the previous 0-8999 to a new range of 1000-9999.
    */
     JLabel formno= new JLabel("APPLICATION FORM NO. "+random);
    formno.setFont(new Font("Raleway",Font.BOLD,38));
    formno.setBounds(140,20,600,40);
    add(formno);
    //heading 
    JLabel personalDetails= new JLabel("Page 1 : Personal Details ");
    personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
    personalDetails.setBounds(290,80,400,30);
    add(personalDetails);
    //name
    JLabel name= new JLabel("Name:");
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,140,100,30);
    add(name);
    ////////////nameTextField/////////////////
    nameTextField=new JTextField();
    nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
    nameTextField.setBounds(300, 140, 400,30);
    add(nameTextField);
    
    //Guardian name
    JLabel  fname= new JLabel("Guardian Name:");
     fname.setFont(new Font("Raleway",Font.BOLD,20));
     fname.setBounds(100,190,200,30);
    add( fname);
    ////////////fnameTextField/////////////////
    fnameTextField=new JTextField();
    fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
    fnameTextField.setBounds(300, 190, 400,30);
    add(fnameTextField);
    //DOB
    JLabel dob=new JLabel("Date of Birth:");
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,240,200,30);
    add(dob);
    //////////DOB///////////
    dateChooser=new JDateChooser();
    dateChooser.setBounds(300,240,400,30);
    dateChooser.setForeground(new Color(105,105,105));
    dateChooser.getDateEditor().setEnabled(false); // Disable text field
   //
   // Set background color for disabled area in JDateChooser
        JComponent dateEditor = dateChooser.getDateEditor().getUiComponent();
        dateEditor.setBackground(Color.BLACK);  // Change to your desired background color
   //

    
    add(dateChooser);
    
    
    //gender
    JLabel gender=new JLabel("Gender:");
    gender.setFont(new Font("Raleway",Font.BOLD,20));
    gender.setBounds(100,290,200,30);
    add(gender);
    //////male female/////////////
    male=new JRadioButton("Male");
    male.setBounds(300,290,60,30);
    male.setBackground(Color.WHITE);
    add(male);
    
    female=new JRadioButton("Female");
    female.setBounds(450,290,70,30);
    female.setBackground(Color.WHITE);
    add(female);
    
    gendergroup=new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);
    //email
    JLabel email=new JLabel("Email Address:");
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,340,200,30);
    add(email);
    ////////////emailTextField/////////////////
    emailTextField=new JTextField();
    emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
    emailTextField.setBounds(300, 340, 400,30);
    add(emailTextField);
    //Marital status
    JLabel marital=new JLabel("Marital Status:");
    marital.setFont(new Font("Raleway",Font.BOLD,20));
    marital.setBounds(100,390,200,30);
    add(marital);
    ////////////marital//////////////////
    married=new JRadioButton("Married");
    married.setBounds(300,390,100,30);
   married.setBackground(Color.WHITE);
    add(married);
    
    single=new JRadioButton("Single");
    single.setBounds(450,390,100,30);
   single.setBackground(Color.WHITE);
    add(single);
    
    others=new JRadioButton("Others");
    others.setBounds(630,390,100,30);
    others.setBackground(Color.WHITE);
    add(others);
    
    
    maritalgroup=new ButtonGroup();
    maritalgroup.add( married);
    maritalgroup.add(single);
    maritalgroup.add(others);
    //Address
    JLabel address=new JLabel("Address:");
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,440,200,30);
    add(address);
    ////////////addressTextField/////////////////
    addressTextField=new JTextField();
    addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
    addressTextField.setBounds(300, 440, 400,30);
    add(addressTextField);
    //city
    JLabel city=new JLabel("City:");
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,490,200,30);
    add(city);
    ////////////cityTextField/////////////////
    cityTextField=new JTextField();
    cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
    cityTextField.setBounds(300, 490, 400,30);
    add(cityTextField);
    //state
    JLabel state=new JLabel("State:");
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,540,200,30);
    add(state);
    ////////////////state///////////////////
        stateComboBox = new JComboBox<>(states);
        stateComboBox.setFont(new Font("Raleway", Font.BOLD, 20));
        stateComboBox.setBounds(300, 540, 400, 30);
        stateComboBox.setBackground(Color.WHITE);
        add(stateComboBox);
    //pin-code
    JLabel pincode=new JLabel("Pincode:");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,590,200,30);
    add(pincode);
    ////////////pinTextField/////////////////
    pinTextField=new JTextField();
    pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
    pinTextField.setBounds(300, 590, 400,30);
    add(pinTextField);
    
    /////////////buttons///////////////
    next=new JButton("Next");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(620,660,80,30);
    next.setCursor(new Cursor(Cursor.HAND_CURSOR));
     //hover effect using MouseAdapter
            next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                next.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                next.setBackground(Color.BLACK);
            }
        });
            next.addActionListener(this);
    add(next);
    
    
    
    
    
    
    
    
    
    
    //for panel base section
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setTitle("Sign up");    
    setSize(850,800);
    setResizable(false); 
    setLocationRelativeTo(null);
    getContentPane().setBackground(Color.white);
    setVisible(true);
    //for panel base section
}
   @Override
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;//by concat made long to string
        String name=nameTextField.getText();
        String guardian=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }
        else if (female.isSelected()){
            gender="Female";
        }
         String email=emailTextField.getText();
         String marital=null;
         if (single.isSelected()) {
            marital="Single";
        }
         else if(married.isSelected()){
             marital="Married";
         }
         else if(others.isSelected()){
             marital="Others";
         }
         String address=addressTextField.getText();
         String city=cityTextField.getText();
         String state=(String) stateComboBox.getSelectedItem(); // Get selected state
         String pin=pinTextField.getText();
         
         ///////////validation//////////////////////
         try {
    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Name is required");
    } else if (guardian.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Guardian name is required");
    } else if (dob.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Date of Birth is required");
    } else if (!male.isSelected() && !female.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select a gender");
    } else if (!email.matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+)\\.([A-Za-z]{2,})$")) {
        JOptionPane.showMessageDialog(null, "Invalid email address");
    } else if (!single.isSelected() && !married.isSelected() && !others.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select a marital status");
    } else if (address.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Address is required");
    } else if (city.isEmpty()) {
        JOptionPane.showMessageDialog(null, "City is required");
    } else if (state.isEmpty() || state.equals("")) {
        JOptionPane.showMessageDialog(null, "Please select a state");
    } else if (!pin.matches("\\d{6}")) {
        JOptionPane.showMessageDialog(null, "Invalid pin code. It should be a 6-digit number");
    } else {
        Conn c = new Conn();
        String query = "INSERT INTO signup (formno, name, guardian, dob, gender, email, marital, address, city, state, pin) " +
                       "VALUES ('" + formno + "', '" + name + "', '" + guardian + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
        c.s.executeUpdate(query);
        setVisible(false);
        new SignupTwo(formno).setVisible(true); //passing fromno in respect to fill page to of same person
    }
} catch (Exception e) {
    e.printStackTrace(); // Print the exception for debugging purposes
}

    }
    
    
    public static void main(String[] args) {
        new SignupOne();
    }
    
}
