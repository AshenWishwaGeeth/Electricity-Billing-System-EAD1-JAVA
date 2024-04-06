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

public class Updatecustomer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatecustomer frame = new Updatecustomer();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("Update customer");
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
	public Updatecustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.gray);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imageLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon ("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\download.png"); 
        Image image = imageIcon.getImage().getScaledInstance(230, 650, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(450, 200,400,250);
        //imageLabel.setSize(530,100);
        contentPane.add(imageLabel);
		

		Border brd = BorderFactory.createLineBorder(Color.orange);
		Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		Font font3 = new Font("Arial", Font.BOLD, 20);
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Border brd1 = BorderFactory.createLineBorder(Color.black);

		JLabel lbl10 = new JLabel("Update Customer");
		JLabel lbl4 = new JLabel("Name");
		JLabel lbl5 = new JLabel("Meter No");
		JLabel lbl6 = new JLabel("Address");
		JLabel lbl7 = new JLabel("City");
		JLabel lbl8 = new JLabel("Email");
		JLabel lbl9 = new JLabel("Phone Number");
		JLabel lbl11 = new JLabel("Username");
		JLabel lbl12 = new JLabel("Password");
		
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		JTextField name = new JTextField();
		JTextField m = new JTextField();
		JTextField ad = new JTextField(); 
		JTextField city = new JTextField();
		JTextField email = new JTextField();
		JTextField pn = new JTextField();
		
		
		JButton btnclear = new JButton("CLEAR");
		JButton btnexit = new JButton("EXIT");
		JButton btns = new JButton("SEARCH");
		JButton btnupdate = new JButton("UPDATE");
		
		m.setBounds(210, 100,220, 30);
		m.setBorder(brd);
		
		name.setBounds(210, 160,220, 30);
		name.setBorder(brd);




		ad.setBounds(210, 220,220, 30);
		ad.setBorder(brd);

		city.setBounds(210, 280,220, 30);
		city.setBorder(brd);

		email.setBounds(210, 340,220, 30);
		email.setBorder(brd);

		pn.setBounds(210, 400,220, 30);
		pn.setBorder(brd);

		username.setBounds(210, 460,220, 30);
		username.setBorder(brd);

		password.setBounds(210, 520,220, 30);
		password.setBorder(brd);
        
		lbl5.setBounds(50, 100,300, 30);
		lbl5.setFont(font3);
		
		lbl4.setBounds(50, 160,300, 30);
		lbl4.setFont(font3);

		

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
		contentPane.add(username);
		contentPane.add(password);
		
		

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
				username.setText("");
				password.setText("");

			}

		});

		btnexit.setBounds(460, 600,120, 30);
		
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
                username.setText(resultSet.getString("email"));
                password.setText(resultSet.getString("phonenumber"));
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


		btnupdate.setBounds(40, 600,120, 30);
		
		btnupdate.setBackground(Color.blue);
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setFont(font1);
		btnupdate.setBorder(brd1);
		btnupdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
		        String dbUsername = "root";
		        String dbPassword = "";
		        
		        String na = name.getText();
		        String meternumber = m.getText();
                String address = ad.getText();
                String ci = city.getText();
                String em= email.getText();
                String phonenumber = pn.getText();
                String us= username.getText();
                String pw = password.getText();

		       
		        try {
		            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

		            String sql = "UPDATE customerdtails SET name = ?, address = ?, city = ?, email = ?, phonenumber = ?, username = ?, password = ? WHERE meternumber = ?";

		            // Create a PreparedStatement to safely execute the query
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setString(1, na);
		            preparedStatement.setString(2, address);
		            preparedStatement.setString(3, ci);
		            preparedStatement.setString(4, em);
		            preparedStatement.setString(5, phonenumber);
		            preparedStatement.setString(6, us);
		            preparedStatement.setString(7, pw);
		            preparedStatement.setString(8, meternumber); 

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "Customer information updated successfully.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Error updating customer information.");
		            }

		            preparedStatement.close();
		            connection.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database connection error.");
		        }
		    }
		});

		contentPane.add(btns);
		
		contentPane.add(btnclear);
		contentPane.add(btnexit);
		contentPane.add(btnupdate);
	

		
	}

}
