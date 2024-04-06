package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class paybill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paybill frame = new paybill();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle("Pay Bill");
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
	public paybill() {
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

		
		JLabel lblmain = new JLabel("Pay Monthly Bill");
		JLabel lblmn = new JLabel("Meter No:");
		JLabel lblmonth= new JLabel("Month");
		JLabel lblpa= new JLabel("pay amount");
		JLabel lblmb= new JLabel("Monthly Bill");
		JLabel lblm= new JLabel("");
		JLabel lblbill= new JLabel("");
		
		
        JTextField mn = new JTextField();
		JTextField pa = new JTextField();
		
		JButton btnpay = new JButton("PAY");
		JButton btnexit = new JButton("EXIT");
		JButton btncancel = new JButton("CLEAR");
		JButton btns = new JButton("SEARCH");
		
		mn.setBounds(350, 150,220, 30);
		mn.setBorder(brd);

		lblm.setBounds(350, 250,220, 30);
		lblm.setBorder(brd);
		
		lblbill.setBounds(350, 350,220, 30);
		lblbill.setBorder(brd);

		pa.setBounds(350, 450,220, 30);
		pa.setBorder(brd);
		
		lblmain.setBounds(20, 30,400, 30);
		lblmain.setFont(font4);

		lblmn.setBounds(100, 150,300, 30);
		lblmn.setFont(font3);

		lblmonth.setBounds(100, 250,300, 30);
		lblmonth.setFont(font3);

		lblmb.setBounds(100, 350,300, 30);
		lblmb.setFont(font3);
		
		lblpa.setBounds(100, 450,300, 30);
		lblpa.setFont(font3);
		
		
btnexit.setBounds(440, 550,180, 30);
		
		btnexit.setBackground(Color.blue);
		btnexit.setForeground(Color.WHITE);
		btnexit.setFont(font1);
		btnexit.setBorder(brd1);
		btnexit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				login.main(new String[] {});
        		dispose();
			}

		}); 
btnpay.setBounds(40, 550,180, 30);
		
		btnpay.setBackground(Color.blue);
		btnpay.setForeground(Color.WHITE);
		btnpay.setFont(font1);
		btnpay.setBorder(brd1);
		btnpay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				String payText = pa.getText();
				if (payText.isEmpty() ) {
                        JOptionPane.showMessageDialog(null, "Please enter pay amount.");
                        return; 
                       
                    }
				
				 JOptionPane.showMessageDialog(null, "Payment successfully.");

				
			}

		});
		btncancel.setBounds(240, 550,180, 30);
		btncancel.setBackground(Color.blue); 
		btncancel.setForeground(Color.WHITE);
		btncancel.setFont(font1);
		btncancel.setBorder(brd1);
		btncancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				mn.setText("");
				lblm.setText("");
				lblbill.setText("");
				pa.setText("");

			}

		});
		
btns.setBounds(500, 100,120, 30);
		
		btns.setBackground(Color.blue);
		btns.setForeground(Color.WHITE);
		btns.setFont(font1);
		btns.setBorder(brd1);
		btns.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String searchmn = mn.getText();
		String jdbcUrl = "jdbc:mysql://localhost:3307/electricityfinal";
        String dbUsername = "root";
        String dbPassword = "";

        try {
       
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

         
            String sql = "SELECT * FROM billdetails WHERE meternumber = ?";

        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchmn);

        
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
         
                mn.setText(resultSet.getString("meternumber"));
                lblm.setText(resultSet.getString("month"));
                lblbill.setText(resultSet.getString("monthlybill"));
                
               
               
                
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
		
		contentPane.add(btnpay);
		contentPane.add(btnexit);
		contentPane.add(btncancel);
		contentPane.add(btns);
		
		
		
		contentPane.add(lblmn);
		contentPane.add(lblmonth);
		contentPane.add(lblpa);
		contentPane.add(lblmain);
		contentPane.add(lblmb);
		contentPane.add(lblm);
		contentPane.add(lblbill);
		
		contentPane.add(mn);
		contentPane.add(pa);
		;
		


		
        
		
		
	}

}
