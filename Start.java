import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class Start {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.YELLOW);
		frame.setBounds(100, 100, 712, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Login = new JButton("LOGIN");
		Login.setSelectedIcon(new ImageIcon("C:\\Users\\PRASHANT\\eclipse-workspace\\LibraryManagementSystem\\Icons\\icons8-Login Filled-50.png"));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login l=new Login();
				l.setVisible(true);
			}
		});
		Login.setFont(new Font("Tahoma", Font.BOLD, 18));
		Login.setBounds(114, 112, 187, 92);
		frame.getContentPane().add(Login);
		
		JButton Register = new JButton("REGISTER");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				Register r=new Register();
				r.setVisible(true);
			}
		});
		Register.setFont(new Font("Tahoma", Font.BOLD, 18));
		Register.setBounds(472, 112, 187, 92);
		frame.getContentPane().add(Register);
		
		JLabel lblWelcomeToLibrary = new JLabel("Welcome to Library!");
		lblWelcomeToLibrary.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblWelcomeToLibrary.setBounds(169, 32, 380, 52);
		frame.getContentPane().add(lblWelcomeToLibrary);
		
		JLabel lblNewUserregister = new JLabel("New User?");
		lblNewUserregister.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewUserregister.setBounds(286, 242, 92, 52);
		frame.getContentPane().add(lblNewUserregister);
		
		JLabel lblRegister = new JLabel("Register!");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegister.setBounds(296, 292, 92, 34);
		frame.getContentPane().add(lblRegister);
		
		
	}

	
	

		
	}
