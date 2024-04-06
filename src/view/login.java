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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("LOGIN");
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		 JLabel imageLabel = new JLabel();
		 
		
		 
		 Font font1 = new Font("Arial", Font.BOLD, 24);
			Font font2 = new Font("Arial", Font.BOLD, 38);
			Font font3 = new Font("Arial", Font.BOLD, 20);
			Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		 
		
		 
		 JLabel lbl3 = new JLabel("Electricity Billing System");
		 JLabel lbl1 = new JLabel("Enter username");
		 JLabel lbl2 = new JLabel("Enter Password");
		 
		//JButton btn1 = new JButton("Login");
		ImageIcon ic1 = new ImageIcon("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\images.png");
        Image i1 = ic1.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        JButton btn1 = new JButton("LOGIN", new ImageIcon(i1));
        
		// JButton btn2 = new JButton
		 ImageIcon ic2 = new ImageIcon("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\download (1).png");
	        Image i2 = ic2.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
	        JButton btn2 = new JButton("CANCEL", new ImageIcon(i2));

		

			
		 

			JTextField usname = new JTextField();
			JPasswordField pass = new JPasswordField();
			
			Border brd = BorderFactory.createLineBorder(Color.orange);
			
		
		ImageIcon imageIcon = new ImageIcon ("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\1644057917-CEB-says-no-power-cuts-today-if-electricity-demand-remains-low-L.png"); 
        Image image = imageIcon.getImage().getScaledInstance(350, 650, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(10, 120,730,400);
      
        contentPane.add(imageLabel);
        
       
		lbl3.setBounds(100, 10,750,60);
		lbl3.setFont(font2);
		contentPane.add(lbl3);
		
		
		lbl1.setBounds(400, 200,300,30);
		lbl1.setFont(font3);
		contentPane.add(lbl1);

		
		lbl2.setBounds(400, 360,300,30);
		lbl2.setFont(font3);
		contentPane.add(lbl2);
		
		
		usname.setBounds(400, 250,250,40);
		usname.setBorder(brd);
		contentPane.add(usname);

		
		pass.setBounds(400, 410,250,40);
		pass.setBorder(brd);
		contentPane.add(pass);
		

		btn1.setBounds(380, 580,200,50);
		btn1.setBackground(Color.red);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(font1);
		contentPane.add(btn1);
		
		
		btn2.setBounds(40, 580,200,50);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn2.setFont(font1); 
		contentPane.add(btn2);
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				usname.setText("");
				pass.setText("");

			}

		});
		

	      btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username=usname.getText();
					String password = new String(pass.getPassword()); 
					
					String jdbcUrl="jdbc:mysql://localhost:3307/electricityfinal";
					String username1="root";
					String password1="";
					
					try {
					    Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);
					    
					    String sql = "SELECT * FROM customerdtails WHERE Username=? AND Password=?";
					    PreparedStatement searchStatement = connection.prepareStatement(sql);
					    
					    searchStatement.setString(1, username);
					    searchStatement.setString(2, password);
					    
					    ResultSet ret = searchStatement.executeQuery();
					    
					    if (ret.next()) {
					        viewmonthlybill.main(new String[] {});
					        dispose();
					    } else if (username.equals("admin") && password.equals("ad")) {
					        home.main(new String[] {});
					        dispose();
					    } else {
					        JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
					    }
					    
					    
					    ret.close();
					    searchStatement.close();
					    connection.close();
					} catch (Exception e2) {
					    e2.printStackTrace();
					}
				}


				
			});

		
		
		
		
		
		
	}

}
