package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("Home");
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.gray);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Border brd1 = BorderFactory.createLineBorder(Color.black);
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		
		JLabel lblmain = new JLabel("DASH BOARD");
		
		JButton btnadd = new JButton("Add Customer");
		JButton btnupdate = new JButton("update Customer");
		JButton btnd = new JButton("Customer Details");
		JButton btncal = new JButton("Calculate Bill");
		//JButton btngene = new JButton("Generate Bill");
		JButton btnbd = new JButton("Bill Details");
		
		JLabel imageLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon ("C:\\Users\\Jayaweera\\Desktop\\electricity\\Electricityfinal\\img\\download.jpg"); 
        Image image = imageIcon.getImage().getScaledInstance(500, 650, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(100, 420,800,250);
        
        contentPane.add(imageLabel);
		
		btnadd.setBounds(50, 150,250, 50);
		
		btnadd.setBackground(Color.yellow);
		btnadd.setFont(font1);
		btnadd.setBorder(brd1);
		btnadd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Addcustomer.main(new String[] {});
        		dispose();
			}

			
		});

		
       btnupdate.setBounds(50, 250,250, 50);
		
		btnupdate.setBackground(Color.yellow);
		btnupdate.setFont(font1);
		btnupdate.setBorder(brd1);
		btnupdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Updatecustomer.main(new String[] {});
        		dispose();
			}

		});
		
		 btnd.setBounds(200, 350,250, 50);
			
			btnd.setBackground(Color.yellow);
			btnd.setFont(font1);
			btnd.setBorder(brd1);
			btnd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					customerdetails.main(new String[] {});
	        		dispose();
				}

			});
		
		btncal.setBounds(400, 150,200, 50);
		
		btncal.setBackground(Color.yellow);
		btncal.setFont(font1);
		btncal.setBorder(brd1);
		btncal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				calculatebill.main(new String[] {});
        		dispose();
			}

		});
		
		
		
		

		btnbd.setBounds(400, 250,250, 50);
		
		btnbd.setBackground(Color.yellow);
		btnbd.setFont(font1);
		btnbd.setBorder(brd1);
		btnbd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				billdetaills.main(new String[] {});
        		dispose();
			}

		});
		
		lblmain.setBounds(30, 60,400, 30);
		lblmain.setFont(font4);
		lblmain.setForeground(Color.RED);
        
     
		
		contentPane.add(btnadd);
		contentPane.add(btnupdate);
		contentPane.add(btnd);
		
		contentPane.add(btncal);
		
		contentPane.add(btnbd);
		
		
		contentPane.add(lblmain);
		
	}
	

}
