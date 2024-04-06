package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Addcustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcustomer frame = new Addcustomer();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("Add customer");
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
	public Addcustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.gray);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		Border brd = BorderFactory.createLineBorder(Color.orange);
		Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		Font font3 = new Font("Arial", Font.BOLD, 20);
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Border brd1 = BorderFactory.createLineBorder(Color.black);
		
		JLabel imageLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon ("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\hicon1.jpg"); 
        Image image = imageIcon.getImage().getScaledInstance(200, 550, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(480, 100,250,400);
        
        contentPane.add(imageLabel);

		JLabel lbl10 = new JLabel("Add Customer");
		JLabel lbl4 = new JLabel("Name");
		JLabel lbl5 = new JLabel("Meter No");
		JLabel lbl6 = new JLabel("Address");
		JLabel lbl7 = new JLabel("City");
		JLabel lbl8 = new JLabel("Email");
		JLabel lbl9 = new JLabel("Phone Number");
		JLabel lbl11 = new JLabel("Username");
		JLabel lbl12 = new JLabel("Password");
		
		JTextField us = new JTextField();
		JTextField pw = new JTextField();
		JTextField name = new JTextField();
		JTextField m = new JTextField();
		JTextField ad = new JTextField();
		JTextField city = new JTextField();
		JTextField email = new JTextField();
		JTextField pn = new JTextField();
		
		JButton btnADD = new JButton("ADD");
		JButton btnclear = new JButton("CLEAR");
		JButton btnexit = new JButton("EXIT");
		JButton btns = new JButton("SEARCH");
		JButton btndelete = new JButton("DELETE");
		

		name.setBounds(210, 160,220, 30);
		name.setBorder(brd);

		m.setBounds(210, 100,220, 30);
		m.setBorder(brd);

		ad.setBounds(210, 220,220, 30);
		ad.setBorder(brd);

		city.setBounds(210, 280,220, 30);
		city.setBorder(brd);

		email.setBounds(210, 340,220, 30);
		email.setBorder(brd);

		pn.setBounds(210, 400,220, 30);
		pn.setBorder(brd);

		us.setBounds(210, 460,220, 30);
		us.setBorder(brd);

		pw.setBounds(210, 520,220, 30);
		pw.setBorder(brd);

		lbl4.setBounds(50, 160,300, 30);
		lbl4.setFont(font3);

		lbl5.setBounds(50, 100,300, 30);
		lbl5.setFont(font3);

		lbl6.setBounds(50, 220,300, 30);
		lbl6.setFont(font3);

		lbl7.setBounds(50, 280,300, 30);
		lbl7.setFont(font3);

		lbl8.setBounds(50, 340,300, 30);
		lbl8.setFont(font3);

		lbl9.setBounds(50, 400,300, 30);
		lbl9.setFont(font3);

		lbl10.setBounds(20, 30,300, 30);
		lbl10.setFont(font4);
		
		lbl11.setBounds(50, 460,300, 30);
		lbl11.setFont(font3);
		
		lbl12.setBounds(50, 520,300, 30);
		lbl12.setFont(font3);
		
		contentPane.add(lbl4);
		contentPane.add(lbl5);
		contentPane.add(lbl6);
		contentPane.add(lbl7);
		contentPane.add(lbl8);
		contentPane.add(lbl9);
		contentPane.add(lbl10);
		contentPane.add(lbl11);
		contentPane.add(lbl12);

		

		contentPane.add(name);
		contentPane.add(m);
		contentPane.add(ad);
		contentPane.add(city);
		contentPane.add(email);
		contentPane.add(pn);
		contentPane.add(us);
		contentPane.add(pw);
		
		btnADD.setBounds(40, 600,120, 30);
		
		btnADD.setBackground(Color.blue);
		btnADD.setForeground(Color.WHITE);
		btnADD.setFont(font1);
		btnADD.setBorder(brd1);
		btnADD.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nameText = name.getText();
				String mText = m.getText();
				String adText = ad.getText();
				String cityText = city.getText();
				String emailText = email.getText();
				String pnText = pn.getText();
				String usernameText = us.getText();
				String passwordText = pw.getText();
				
				
				if (nameText.isEmpty() || mText.isEmpty() || adText.isEmpty() ||
                        cityText.isEmpty() || emailText.isEmpty() || pnText.isEmpty() || usernameText.isEmpty() || passwordText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill  all fields.");
                        return; 
                       
                    }
				
				
				
			
				
				 


				// Database connection parameters
				String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
				String dbUsername = "root";
				String dbPassword = "";

				try {
					// Create a database connection

					Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

					// Create a SQL query to insert data into the database
					String sql = "INSERT INTO customerdtails(name, meternumber, address, city, email, phonenumber,username,password) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";

					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, nameText);
					preparedStatement.setString(2, mText);
					preparedStatement.setString(3, adText);
					preparedStatement.setString(4, cityText);
					preparedStatement.setString(5, emailText);
					preparedStatement.setString(6, pnText);
					preparedStatement.setString(7, usernameText);
					preparedStatement.setString(8, passwordText);

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

			private boolean isValidPhoneNumber(String pnText) {
				
				return false;
			}
		});

		btnclear.setBounds(180, 600,120, 30);
		
		btnclear.setBackground(Color.blue);
		btnclear.setForeground(Color.WHITE); 
		btnclear.setFont(font1);
		btnclear.setBorder(brd1);
		btnclear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				name.setText("");
				m.setText("");
				ad.setText("");
				city.setText("");
				email.setText("");
				pn.setText("");
				us.setText("");
				pw.setText("");

			}

		});
		
		

		btnexit.setBounds(460, 520,120, 30);
		
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

		btns.setBounds(320, 600,120, 30);
		
		btns.setBackground(Color.blue);
		btns.setForeground(Color.WHITE);
		btns.setFont(font1);
		btns.setBorder(brd1);
		btns.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String searchm = m.getText();
		String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
        String dbUsername = "root";
        String dbPassword = "";

        try {
       
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

         
            String sql = "SELECT * FROM customerdtails WHERE meternumber = ?";

        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchm);

        
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
         
                name.setText(resultSet.getString("name"));
                
                ad.setText(resultSet.getString("address"));
                city.setText(resultSet.getString("city"));
                email.setText(resultSet.getString("email"));
                pn.setText(resultSet.getString("phonenumber"));
                us.setText(resultSet.getString("email"));
                pw.setText(resultSet.getString("phonenumber"));
            } else {
               
                JOptionPane.showMessageDialog(null, "customer with meternumber " + searchm + " not found.");
            }

       
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error.");
        }
    }
});

		btndelete.setBounds(460, 600,120, 30);
		
		btndelete.setBackground(Color.blue);
		btndelete.setForeground(Color.WHITE);
		btndelete.setFont(font1);
		btndelete.setBorder(brd1);
		btndelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String meternumber = m.getText();

		        System.out.println("Deleting customer with meternumber: " + meternumber);

		        String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
		        String username = "root";
		        String password = "";
		       
		        
		       
		        try {
		            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		            String deleteQuery = "DELETE FROM customerdtails WHERE meternumber=?";
		            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

		            deleteStatement.setString(1, meternumber);

		            int rowsDeleted = deleteStatement.executeUpdate();

		            deleteStatement.close();
		            connection.close();

		            if (rowsDeleted > 0) {
		                
		                JOptionPane.showMessageDialog(contentPane, "Data Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                
		                name.setText("");
		                ad.setText("");
		                city.setText("");
		                email.setText("");
		                pn.setText("");
		                us.setText("");
		                pw.setText("");
		                m.setText("");
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "No data deleted. Meter number not found.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		    }
		});

        
                
               
                
            
        

		contentPane.add(btns); 
		contentPane.add(btnADD);
		contentPane.add(btnclear);
		contentPane.add(btnexit);
		contentPane.add(btndelete);
	

		
	}

}
