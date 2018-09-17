import java.util.Date;
import java.awt.EventQueue;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Issue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection c;
private JTextField bno;
private JTextField bname;
private JTextField rn;
private JTextField n;
private JTextField sur;
private JTextField y;
private JTextField d;
	/**
	 * Create the frame.
	 */
	public Issue() {
		c=Connector.db4();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(4, 38, 328, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBookNo = new JLabel("Book No");
		lblBookNo.setBounds(6, 16, 89, 20);
		panel.add(lblBookNo);
		lblBookNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(6, 67, 103, 20);
		panel.add(lblBookName);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		bno = new JTextField();
		bno.setBounds(121, 16, 103, 22);
		panel.add(bno);
		bno.setColumns(10);
		
		bname = new JTextField();
		bname.setBounds(119, 65, 155, 22);
		panel.add(bname);
		bname.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String q="Select * from Books where BookNo=?";
					PreparedStatement pst=c.prepareStatement(q);
					pst.setString(1, bno.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						String a=rs.getString("BookName");
						bname.setText(a);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Book No not found");
					}
					rs.close();
					pst.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(242, 17, 80, 23);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(353, 38, 323, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setBounds(6, 16, 89, 20);
		panel_1.add(lblRollNo);
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(6, 60, 89, 20);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(6, 103, 89, 20);
		panel_1.add(lblSurname);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(6, 141, 89, 20);
		panel_1.add(lblYear);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rn = new JTextField();
		rn.setBounds(102, 18, 103, 22);
		panel_1.add(rn);
		rn.setColumns(10);
		
		n = new JTextField();
		n.setBounds(102, 62, 103, 22);
		panel_1.add(n);
		n.setColumns(10);
		
		sur = new JTextField();
		sur.setBounds(102, 101, 103, 22);
		panel_1.add(sur);
		sur.setColumns(10);
		
		y = new JTextField();
		y.setBounds(105, 139, 103, 22);
		panel_1.add(y);
		y.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s="Select * from Student where RollNo=?";
					PreparedStatement p=c.prepareStatement(s);
					p.setString(1,rn.getText());
					ResultSet r=p.executeQuery();
					if(r.next())
					{
						String a=r.getString("Name");
						String b=r.getString("Surname");
						String c=r.getString("Div");
						String di=r.getString("Year");
						n.setText(a);
						sur.setText(b);
						y.setText(di);
						d.setText(c);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Roll No");
					}
					r.close();
					p.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnSearch.setBounds(228, 17, 89, 23);
		panel_1.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(105, 172, 103, 22);
		panel_1.add(d);
		
		JLabel lblDiv = new JLabel("Div");
		lblDiv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiv.setBounds(6, 174, 89, 20);
		panel_1.add(lblDiv);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s="Insert into Issue (BookNo,BookName,RollNo,Name,Surname,Year,Div,DateOfIssue) values (?,?,?,?,?,?,?,?)";
					Date cdate=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("dd/M/YYYY");
					String date=(String)sdf.format(cdate);
					PreparedStatement pst=c.prepareStatement(s);
					pst.setString(1, bno.getText());
					pst.setString(2, bname.getText());
					pst.setString(3, rn.getText());
					pst.setString(4, n.getText());
					pst.setString(5, sur.getText());
					pst.setString(6, y.getText());
					pst.setString(7, d.getText());
					pst.setString(8, date);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Issued");
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, e3);
				}
				
			}
		});
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnIssue.setBounds(377, 360, 89, 57);
		contentPane.add(btnIssue);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu x=new Menu();
				x.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(490, 360, 89, 57);
		contentPane.add(btnBack);
	}
}
