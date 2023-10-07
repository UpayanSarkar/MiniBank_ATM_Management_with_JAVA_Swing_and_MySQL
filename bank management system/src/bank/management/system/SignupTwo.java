package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    JComboBox<String> religionComboBox, categoryComboBox, educationComboBox, occupationComboBox;
    JTextField incomeTextField, panTextField, aadharTextField;
    JRadioButton seniorCitizenYes, seniorCitizenNo, existingAccountYes, existingAccountNo;
    JButton next;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;
        //app icon img
         ImageIcon appicon2 = new ImageIcon(Login.class.getResource("logo.jpg"));
          setIconImage(appicon2.getImage());

        //
        // Set title and heading
        setTitle("New Account Application Form - Page 2");
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);
        String[] religions = {"", "Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionComboBox = new JComboBox<>(religions);
        religionComboBox.setFont(new Font("Raleway", Font.BOLD, 20));
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        // Category
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 100, 30);
        add(categoryLabel);
        String[] categories = {"", "General", "SC", "ST", "OBC", "Other"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 100, 30);
        add(incomeLabel);
        incomeTextField = new JTextField();
        incomeTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeTextField.setBounds(300, 240, 400, 30);
        add(incomeTextField);

        // Education
        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 110, 30);
        add(educationLabel);
        String[] educationLevels = {"", "High School", "Bachelor's Degree", "Master's Degree", "PhD", "Other"};
        educationComboBox = new JComboBox<>(educationLevels);
        educationComboBox.setFont(new Font("Raleway", Font.BOLD, 20));
        educationComboBox.setBounds(300, 290, 400, 30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 340, 150, 30);
        add(occupationLabel);
        String[] occupations = {"", "Business", "Service", "Student", "Homemaker", "Other"};
        occupationComboBox = new JComboBox<>(occupations);
        occupationComboBox.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationComboBox.setBounds(300, 340, 400, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        // PAN Number
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 390, 150, 30);
        add(panLabel);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        // Aadhar Number
        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 440, 200, 30);
        add(aadharLabel);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        // Senior Citizen
        JLabel seniorCitizenLabel = new JLabel("Senior Citizen:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizenLabel.setBounds(100, 490, 200, 30);
        add(seniorCitizenLabel);
        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setBounds(300, 490, 60, 30);
        seniorCitizenYes.setBackground(Color.WHITE);
        add(seniorCitizenYes);
        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setBounds(450, 490, 70, 30);
        seniorCitizenNo.setBackground(Color.WHITE);
        add(seniorCitizenNo);
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorCitizenYes);
        seniorCitizenGroup.add(seniorCitizenNo);

        // Existing Account
        JLabel existingAccountLabel = new JLabel("Existing Account:");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 540, 200, 30);
        add(existingAccountLabel);
        existingAccountYes = new JRadioButton("Yes");
        existingAccountYes.setBounds(300, 540, 60, 30);
        existingAccountYes.setBackground(Color.WHITE);
        add(existingAccountYes);
        existingAccountNo = new JRadioButton("No");
        existingAccountNo.setBounds(450, 540, 70, 30);
        existingAccountNo.setBackground(Color.WHITE);
        add(existingAccountNo);
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountYes);
        existingAccountGroup.add(existingAccountNo);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Hover effect using MouseAdapter
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

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(850, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
   @Override
public void actionPerformed(ActionEvent ae) {
    String religion = (String) religionComboBox.getSelectedItem();
    String category = (String) categoryComboBox.getSelectedItem();
    String income = incomeTextField.getText();
    String education = (String) educationComboBox.getSelectedItem();
    String occupation = (String) occupationComboBox.getSelectedItem();
    String pan = panTextField.getText();
    String aadhar = aadharTextField.getText();
    boolean isSeniorCitizen = seniorCitizenYes.isSelected();
    boolean hasExistingAccount = existingAccountYes.isSelected();
       try{
    // Validate religion and category (should not be empty)
    if (religion.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select Religion");
    } else if (category.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select Category");
    }
    // Validate income (should be a numeric value)
    else if (!income.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Income should be a numeric value");
    }
    // Validate education (should not be empty)
    else if (education.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select Education");
    }
    // Validate occupation (should not be empty)
    else if (occupation.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select Occupation");
    }
    else if (!pan.matches("[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}")) {
    JOptionPane.showMessageDialog(null, "Invalid PAN number format");
}

    // Validate Aadhar (should be a 12-digit numeric value)
    else if (!aadhar.matches("\\d{12}")) {
        JOptionPane.showMessageDialog(null, "Invalid Aadhar number");
    }
    // Validate Senior Citizen selection
    else if (!isSeniorCitizen && !seniorCitizenNo.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select Senior Citizen status");
    }
    // Validate Existing Account selection
    else if (!hasExistingAccount && !existingAccountNo.isSelected()) {
        JOptionPane.showMessageDialog(null, "Please select Existing Account status");
    }
    else{
        Conn c = new Conn();
        String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account) " +
               "VALUES ('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + (isSeniorCitizen ? "Yes" : "No") + "', '" + (hasExistingAccount ? "Yes" : "No") + "')";

c.s.executeUpdate(query);
//signup 3
setVisible(false);
new SignupThree(formno).setVisible(true);
        
    }
}catch (Exception e) {
    e.printStackTrace(); // Print the exception for debugging purposes
}
}
   


    public static void main(String[] args) {
        new SignupTwo("");//no default cons will cause error so passing empty string
    }
}
