package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class calculatebill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculatebill frame = new calculatebill();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("Calculate Bill");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculatebill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.gray);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border brd = BorderFactory.createLineBorder(Color.orange);
		Font font3 = new Font("Arial", Font.BOLD, 20);
		Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Border brd1 = BorderFactory.createLineBorder(Color.black);


		
		JLabel lblmain = new JLabel("Calculate Electricity Bill");
		JLabel lblmn = new JLabel("Meter No:");
		JLabel lblmonth= new JLabel("Month");
		JLabel lbluc= new JLabel("Units Cosumed");
		JLabel lblmb= new JLabel("Monthly Bill");
		JLabel lblbill= new JLabel("");
		
		JButton btns = new JButton("SUBMIT");
		JButton btncancel = new JButton("CANCEL");
		JButton btnexit = new JButton("EXIT");
		//JButton btngene = new JButton("GENERATE REPORT");
		
		JTextField mn = new JTextField();
		JTextField uc = new JTextField();
		
		String[] items = { "January", "February", "March", "April", "May", "June", "july", "August", "September",
				"October", "November", "december" };
		JComboBox<String> comboBox = new JComboBox<>(items);
		String selectedItem = (String) comboBox.getSelectedItem();
		
		mn.setBounds(350, 150,220, 30);
		mn.setBorder(brd);

		uc.setBounds(350, 350,220, 30);
		uc.setBorder(brd);
		
		lblbill.setBounds(350, 450,220, 30);
		lblbill.setBorder(brd);

		comboBox.setBounds(350, 250,220, 30);
		comboBox.setBorder(brd);
		
		lblmain.setBounds(20, 30,400, 30);
		lblmain.setFont(font4);
		
		lblmn.setBounds(100, 150,300, 30);
		lblmn.setFont(font3);

		lblmonth.setBounds(100, 250,300, 30);
		lblmonth.setFont(font3);

		lbluc.setBounds(100, 350,300, 30);
		lbluc.setFont(font3);
		
		lblmb.setBounds(100, 450,300, 30);
		lblmb.setFont(font3);
		
		btncancel.setBounds(240, 550,180, 30);
		
		btncancel.setBackground(Color.blue);
		btncancel.setForeground(Color.WHITE);
		btncancel.setFont(font1);
		btncancel.setBorder(brd1);
		btncancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				mn.setText("");
				comboBox.setSelectedItem("");
				uc.setText("");
				lblbill.setText("");

			}

		});
btnexit.setBounds(440, 550,180, 30);
		
		btnexit.setBackground(Color.blue);
		btnexit.setForeground(Color.WHITE);
		btnexit.setFont(font1);
		btnexit.setBorder(brd1);
		btnexit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				home.main(new String[] {});
        		dispose();
			}

		});
		
btns.setBounds(40, 550,180, 30);
		
		btns.setBackground(Color.blue); 
		btns.setForeground(Color.WHITE);
		btns.setFont(font1);
		btns.setBorder(brd1);
		   btns.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Calculate monthly bill
	                double unitconsumed = Double.parseDouble(uc.getText());
	                int monthlybill = (int) (unitconsumed * 100);
	                lblbill.setText(String.valueOf(monthlybill));

	                // Save data to the database
	                String meternumber = mn.getText();
	                String month = (String) comboBox.getSelectedItem();
	                String monthText = uc.getText();
	                String mbText = lblbill.getText();

	                // Database connection parameters
	                String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
	                String dbUsername = "root";
	                String dbPassword = "";

	                try {
	                    // Create a database connection
	                    Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

	                    // Create a SQL query to insert data into the database
	                    String sql = "INSERT INTO billdetails(meternumber, month, units, monthlybill) VALUES (?, ?, ?, ?)";

	                    // Create a PreparedStatement to safely execute the query
	                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	                    preparedStatement.setString(1, meternumber);
	                    preparedStatement.setString(2, month);
	                    preparedStatement.setString(3, monthText);
	                    preparedStatement.setString(4, mbText);

	                    // Execute the query
	                    int rowsAffected = preparedStatement.executeUpdate();

	                    // Check if the insertion was successful
	                    if (rowsAffected > 0) {
	                        JOptionPane.showMessageDialog(null, "Record added successfully.");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Failed to add record.");
	                    }

	                    preparedStatement.close();
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Database connection error.");
	                }
	            }
	        });
				
				

		

		
		contentPane.add(btncancel);
		contentPane.add(btnexit);
		contentPane.add(btns);
		
		
		contentPane.add(comboBox);
		contentPane.add(lblmn);
		contentPane.add(lblmonth);
		contentPane.add(lbluc);
		contentPane.add(lblmain);
		contentPane.add(lblmb);
		
		contentPane.add(mn);
		contentPane.add(uc);
		contentPane.add(lblbill);
		

	}

}
