 package javaproject.com;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class registrationform implements ActionListener {
	JFrame frame=new JFrame();
String gender[]= {"Male","Female","Other"};
JLabel nameLabel=new JLabel("NAME");
JLabel genderLabel=new JLabel("GENDER");
JLabel fathernameLabel=new JLabel("FATHER NAME");
JLabel passwordLabel=new JLabel("PASSWORD");
JLabel confirmpasswordLabel=new JLabel("CONFIRM PASSWORD");
JLabel cityLabel=new JLabel("CITY");
JLabel emailLabel=new JLabel("E-MAIL");
JButton registerButton=new JButton("REGISTER");
JButton resetButton=new JButton("RESET");
JTextField nameTextField=new JTextField();
JComboBox genderComboBox=new JComboBox(gender);
JTextField fatherTextField=new JTextField();
JPasswordField passwordField=new JPasswordField();
JPasswordField confirmpasswordField=new JPasswordField();
JTextField cityTextField=new JTextField();
JTextField emailTextField=new JTextField();

registrationform(){
	createwindow();
	setLocationAndSize();
	addComponentsToFrame();
	actionEvent();
}
public void createwindow() {

	
	frame.setTitle("Registration Form");
	frame.setBounds(40,40,380,600);
	frame.getContentPane().setBackground(Color.PINK);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	
}
public void setLocationAndSize() {
	nameLabel.setBounds(20,20,40,70);
	genderLabel.setBounds(20,70,80,70);
	fathernameLabel.setBounds(20,120,100,70);
	passwordLabel.setBounds(20,170,100,70);
	confirmpasswordLabel.setBounds(20,220,140,70);
	cityLabel.setBounds(20,270,100,70);
	emailLabel.setBounds(20,320,100,70);
	nameTextField.setBounds(180,43,165,23);
	genderComboBox.setBounds(180,93,165,23);
	fatherTextField.setBounds(180,143,165,23);
	passwordField.setBounds(180,193,165,23);
	confirmpasswordField.setBounds(180,243,165,23);
	cityTextField.setBounds(180,293,165,23);
	emailTextField.setBounds(180,343,165,23);
	registerButton.setBounds(60,400,100,35);
	resetButton.setBounds(200,400,100,35);
	
}
public void addComponentsToFrame() {
	frame.add(nameLabel);
	frame.add(genderLabel);
	frame.add(fathernameLabel); 
	frame.add(passwordLabel);
	frame.add(confirmpasswordLabel);
	frame.add(cityLabel);
	frame.add(emailLabel);
	frame.add(nameTextField);
	frame.add(genderComboBox);
	frame.add(fatherTextField);
	frame.add(passwordField);
	frame.add(confirmpasswordField);
	frame.add(cityTextField);
	frame.add(emailTextField);
	frame.add(registerButton);
	frame.add(resetButton);
	
	
}
public void actionEvent() {
	registerButton.addActionListener(this);
	resetButton.addActionListener(this);
}
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==registerButton) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/countries","root","root");
			PreparedStatement ps=connection.prepareStatement("insert into stu2 values(?,?,?,?,?,?,?)");
			ps.setString(1,nameTextField.getText());
			ps.setString(2, genderComboBox.getSelectedItem().toString());
			ps.setString(3, fatherTextField.getText());
			ps.setString(4, passwordField.getText());
			ps.setString(5, confirmpasswordField.getText());
			ps.setString(6, cityTextField.getText());
			ps.setString(7, emailTextField.getText());
			if(passwordField.getText().equalsIgnoreCase(confirmpasswordField.getText()))
			{
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Registered Successfully");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "password did not match");
				
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	if(e.getSource()==resetButton) {
		nameTextField.setText(null);
		genderComboBox.setSelectedItem(null);
		fatherTextField.setText(null);
		passwordField.setText(null);
		confirmpasswordField.setText(null);
		cityTextField.setText(null);
		emailTextField.setText(null);
	}
}
public static void main(String[] args) {
	new registrationform();
}
}

