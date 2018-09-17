import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Age;
	private JTextField Username;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	Connection x=null;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try
				{
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
		}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		x=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterDetails = new JLabel("Enter Details");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setFont(new Font("Times New Roman", Font.BOLD, 46));
		lblEnterDetails.setBounds(162, 11, 361, 99);
		contentPane.add(lblEnterDetails);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(28, 151, 105, 37);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(162, 151, 383, 37);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSurname.setBounds(28, 199, 105, 37);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(28, 253, 105, 37);
		contentPane.add(lblAge);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(28, 311, 105, 37);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(28, 371, 105, 39);
		contentPane.add(lblPassword);
		
		Surname = new JTextField();
		Surname.setColumns(10);
		Surname.setBounds(162, 199, 383, 37);
		contentPane.add(Surname);
		
		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(162, 253, 383, 37);
		contentPane.add(Age);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(162, 311, 383, 37);
		contentPane.add(Username);
		
		Password = new JPasswordField();
		Password.setBounds(162, 372, 383, 38);
		contentPane.add(Password);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				String query="insert into Admin (Name,Surname,Age,Username,Password) values (?,?,?,?,?)";
				PreparedStatement pst=x.prepareStatement(query);
				pst.setString(1, Name.getText());
				pst.setString(2, Surname.getText());
				pst.setString(3, Age.getText());
				pst.setString(4, Username.getText());
				pst.setString(5, Password.getText());
				pst.execute();
				JOptionPane.showMessageDialog(null,"You Are Successfully Registered!");
				Name.setText("");
				Surname.setText("");
				Age.setText("");
				Username.setText("");
				Password.setText("");
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(79, 434, 158, 47);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Start.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(258, 434, 158, 47);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name.setText("");
				Surname.setText("");
				Age.setText("");
				Username.setText("");
				Password.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(433, 434, 158, 47);
		contentPane.add(btnClear);
	}
}
