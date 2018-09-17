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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection c=null;
	private JTextField bno;
	private JTextField bna;
	private JTextField q;
	/**
	 * Create the frame.
	 */
	public NewBook() {
		c=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setBounds(165, 11, 253, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(30, 116, 79, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel bn = new JLabel("Book Name");
		bn.setFont(new Font("Tahoma", Font.BOLD, 18));
		bn.setBounds(10, 164, 110, 35);
		contentPane.add(bn);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(30, 215, 79, 35);
		contentPane.add(lblQuantity);
		
		bno = new JTextField();
		bno.setBounds(147, 116, 224, 30);
		contentPane.add(bno);
		bno.setColumns(10);
		
		bna = new JTextField();
		bna.setBounds(147, 169, 224, 30);
		contentPane.add(bna);
		bna.setColumns(10);
		
		q = new JTextField();
		q.setBounds(147, 215, 224, 30);
		contentPane.add(q);
		q.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s="Insert into books (BookNo,BookName,Quantity) values (?,?,?)";
					PreparedStatement pst=c.prepareStatement(s);
					pst.setString(1, bno.getText());
					pst.setString(2, bna.getText());
					pst.setString(3, q.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Added");
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(104, 291, 89, 66);
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
		btnBack.setBounds(221, 291, 89, 66);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bno.setText("");
				bna.setText("");
				q.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(331, 291, 119, 66);
		contentPane.add(btnClear);
	}
}
