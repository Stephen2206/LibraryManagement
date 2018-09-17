import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection c=null;
	/**
	 * Create the frame.
	 */
	public Login() {
		c=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(239, 11, 304, 96);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(74, 156, 142, 70);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(68, 241, 142, 70);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(223, 156, 320, 49);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(224, 247, 317, 49);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String q="Select * from Admin where Username=? and Password=?";
					PreparedStatement pst=c.prepareStatement(q);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
					ResultSet r=pst.executeQuery();
					int b=0;
					while(r.next())
					{
						b++;
					}
					if(b==1)
					{
						JOptionPane.showMessageDialog(null,"Login Successful");
						pst.close();
						r.close();
						dispose();
						Menu m=new Menu();
						m.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Username and Password");
					}
					
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLogin.setBounds(226, 353, 166, 56);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnClear.setBounds(402, 353, 166, 56);
		contentPane.add(btnClear);
	}

}
