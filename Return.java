import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Return extends JFrame {

	private JPanel contentPane;
	private JTextField rn;
	private JTextField n;
	private JTextField sn;
	private JTextField y;
	private JTextField d;
	private JTextField na;
	private JTextField bno;
	private JTextField doi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
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
	public Return() {
		c=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RETURN BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(186, 11, 375, 85);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(28, 126, 407, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No");
		lblNewLabel_1.setBounds(6, 27, 92, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(6, 64, 92, 22);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(6, 115, 92, 14);
		panel.add(lblSurname);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(6, 157, 92, 14);
		panel.add(lblYear);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDiv = new JLabel("Div");
		lblDiv.setBounds(6, 204, 92, 14);
		panel.add(lblDiv);
		lblDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		rn = new JTextField();
		rn.setBounds(102, 16, 209, 29);
		panel.add(rn);
		rn.setColumns(10);
		
		n = new JTextField();
		n.setBounds(102, 64, 209, 29);
		panel.add(n);
		n.setColumns(10);
		
		sn = new JTextField();
		sn.setBounds(102, 111, 209, 29);
		panel.add(sn);
		sn.setColumns(10);
		
		y = new JTextField();
		y.setBounds(102, 153, 209, 29);
		panel.add(y);
		y.setColumns(10);
		
		d = new JTextField();
		d.setBounds(102, 200, 209, 29);
		panel.add(d);
		d.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s="Select * from Issue where RollNo=?";
					PreparedStatement p=c.prepareStatement(s);
					p.setString(1,rn.getText());
					ResultSet r=p.executeQuery();
					if(r.next())
					{
						String a=r.getString("Name");
						String b=r.getString("Surname");
						String c=r.getString("Div");
						String di=r.getString("Year");
						String bnum=r.getString("BookNo");
						String f=r.getString("BookName");
						String g=r.getString("DateOfIssue");
						n.setText(a);
						sn.setText(b);
						y.setText(di);
						d.setText(c);
						bno.setText(bnum);
						na.setText(f);
						doi.setText(g);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Book Not issued with this no");
					}
					r.close();
					p.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			
			}
			}
		);
		btnNewButton.setBounds(320, 18, 74, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(446, 130, 405, 145);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookno = new JLabel("BookNo");
		lblBookno.setBounds(12, 31, 92, 14);
		panel_1.add(lblBookno);
		lblBookno.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(12, 68, 92, 22);
		panel_1.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		na = new JTextField();
		na.setBounds(131, 68, 264, 29);
		panel_1.add(na);
		na.setColumns(10);
		
		bno = new JTextField();
		bno.setBounds(131, 20, 264, 29);
		panel_1.add(bno);
		bno.setColumns(10);
		
		JLabel label = new JLabel("Date of Issue");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(33, 437, 135, 14);
		contentPane.add(label);
		
		doi = new JTextField();
		doi.setColumns(10);
		doi.setBounds(164, 433, 209, 29);
		contentPane.add(doi);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s1="Delete from Issue where RollNo=?";
					PreparedStatement pst=c.prepareStatement(s1);
					pst.setString(1, rn.getText());
					pst.execute();
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, e3);
				}
				try
				{
					String s2="Insert into Return (BookNo,BookName,RollNo,Name,Surname,Year,Div,DateOfReturn) values (?,?,?,?,?,?,?,?)";
					Date cdate=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("dd/M/YYYY");
					String date=(String)sdf.format(cdate);
					PreparedStatement pst=c.prepareStatement(s2);
					pst.setString(1, bno.getText());
					pst.setString(2, na.getText());
					pst.setString(3, rn.getText());
					pst.setString(4, n.getText());
					pst.setString(5, sn.getText());
					pst.setString(6, y.getText());
					pst.setString(7, d.getText());
					pst.setString(8, date);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Returned");
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBounds(463, 416, 171, 54);
		contentPane.add(btnReturn);
		
		JButton btnMainMenu = new JButton("MAIN  MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu m=new Menu();
				m.setVisible(true);
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMainMenu.setBounds(644, 416, 171, 54);
		contentPane.add(btnMainMenu);
	}
}
