import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	Connection a=null;
	private JTable table;
	private JTable table_1;
	public Menu() {
		a=Connector.db4();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 574);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAddNew = new JMenu("Add New");
		menuBar.add(mnAddNew);
		
		JMenuItem mntmStudentData = new JMenuItem("Student Data");
		mntmStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				NewStudent s=new NewStudent();
				s.setVisible(true);
			}
		});
		mntmStudentData.setSelected(true);
		mnAddNew.add(mntmStudentData);
		
		JMenuItem mntmBook = new JMenuItem("Book");
		mntmBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewBook b=new NewBook();
				b.setVisible(true);
			}
		});
		mnAddNew.add(mntmBook);
		
		JMenu mnIssueABook = new JMenu("Issue A Book");
		mnIssueABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(mnIssueABook);
		
		JMenuItem mntmIssue = new JMenuItem("Issue");
		mntmIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Issue i=new Issue();
				i.setVisible(true);
				
			}
		});
		mntmIssue.setSelected(true);
		mnIssueABook.add(mntmIssue);
		
		JMenu mnReturn = new JMenu("Return");
		menuBar.add(mnReturn);
		
		JMenuItem mntmReturnBook = new JMenuItem("Return Book");
		mntmReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Return r=new Return();
				r.setVisible(true);
			}
		});
		mnReturn.add(mntmReturnBook);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 87, 702, 149);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblStatistics = new JLabel("STATISTICS");
		lblStatistics.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatistics.setBounds(10, 11, 221, 41);
		contentPane.add(lblStatistics);
		
		JLabel lblIssued = new JLabel("Issued");
		lblIssued.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIssued.setBounds(20, 50, 87, 26);
		contentPane.add(lblIssued);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReturn.setBounds(20, 256, 87, 26);
		contentPane.add(lblReturn);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="Select * from Issue";
				try {
					PreparedStatement pst=a.prepareStatement(s);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(599, 54, 123, 23);
		contentPane.add(btnUpdate);
		
		JButton button = new JButton("UPDATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="Select * from Return";
				try {
					PreparedStatement pst=a.prepareStatement(s);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(599, 275, 123, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 327, 702, 149);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
