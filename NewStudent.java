import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent frame = new NewStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection c=null;
	private JTextField rno;
	private JTextField na;
	private JTextField su;
	private JTextField age;
	public NewStudent() {
		c=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(174, 22, 350, 47);
		contentPane.add(lblNewLabel);
		
		JLabel rn = new JLabel("Roll No");
		rn.setFont(new Font("Tahoma", Font.BOLD, 18));
		rn.setBounds(52, 122, 100, 35);
		contentPane.add(rn);
		
		JLabel n = new JLabel("Name");
		n.setFont(new Font("Tahoma", Font.BOLD, 18));
		n.setBounds(52, 168, 100, 35);
		contentPane.add(n);
		
		JLabel s = new JLabel("Surname");
		s.setFont(new Font("Tahoma", Font.BOLD, 18));
		s.setBounds(52, 214, 100, 35);
		contentPane.add(s);
		
		JLabel y = new JLabel("Year");
		y.setFont(new Font("Tahoma", Font.BOLD, 18));
		y.setBounds(52, 266, 100, 35);
		contentPane.add(y);
		
		JLabel d = new JLabel("Div");
		d.setFont(new Font("Tahoma", Font.BOLD, 18));
		d.setBounds(52, 312, 100, 35);
		contentPane.add(d);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(52, 358, 100, 35);
		contentPane.add(lblAge);
		
		rno = new JTextField();
		rno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rno.setBounds(156, 122, 318, 30);
		contentPane.add(rno);
		rno.setColumns(10);
		
		na = new JTextField();
		na.setFont(new Font("Tahoma", Font.PLAIN, 15));
		na.setColumns(10);
		na.setBounds(156, 163, 318, 30);
		contentPane.add(na);
		
		su = new JTextField();
		su.setFont(new Font("Tahoma", Font.PLAIN, 15));
		su.setColumns(10);
		su.setBounds(156, 219, 318, 30);
		contentPane.add(su);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 15));
		age.setColumns(10);
		age.setBounds(156, 358, 318, 30);
		contentPane.add(age);
		
		JComboBox ye = new JComboBox();
		ye.setFont(new Font("Tahoma", Font.BOLD, 18));
		ye.setModel(new DefaultComboBoxModel(new String[] {"FE", "SE", "TE", "BE"}));
		ye.setBounds(162, 276, 148, 20);
		contentPane.add(ye);
		
		JComboBox di = new JComboBox();
		di.setFont(new Font("Tahoma", Font.BOLD, 18));
		di.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		di.setBounds(162, 322, 148, 20);
		contentPane.add(di);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s="Insert into Student (RollNo,Name,Surname,Year,Div,Age) values (?,?,?,?,?,?)";
					PreparedStatement pst=c.prepareStatement(s);
					pst.setString(1,rno.getText());
					pst.setString(2,na.getText());
					pst.setString(3,su.getText());
					pst.setString(4,(String)ye.getSelectedItem());
					pst.setString(5,(String)di.getSelectedItem());
					pst.setString(6,age.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Student Registered");
				}
				catch(Exception e1)
			{
					JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(151, 416, 119, 35);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu m=new Menu();
				m.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(295, 416, 119, 35);
		contentPane.add(btnBack);
	}
}
