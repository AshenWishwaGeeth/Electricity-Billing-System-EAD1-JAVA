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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class billdetaills extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billdetaills frame = new billdetaills();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle(" Bill details");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public billdetaills() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Border brd1 = BorderFactory.createLineBorder(Color.black);
		
		JLabel lblmain= new JLabel("Bill details");
		
		JButton btnexit = new JButton("EXIT");
		

		lblmain.setBounds(20, 20,300, 30);
		lblmain.setFont(font4);
		
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
		
		contentPane.add(lblmain);
		contentPane.add(btnexit);


		
		
		DefaultTableModel model = new DefaultTableModel();

		String url = "jdbc:mysql://localhost:3307/electricityfinal";
		String username = "root";
		String password = "";

		String sqlSelect = "SELECT * FROM billdetails";

		try {
		    Connection connection = DriverManager.getConnection(url, username, password);

		    PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);

		    ResultSet resultSet = preparedStatement.executeQuery();

		    int columnCount = resultSet.getMetaData().getColumnCount();
		    for (int i = 1; i <= columnCount; i++) {
		        model.addColumn(resultSet.getMetaData().getColumnName(i));
		    }

		    while (resultSet.next()) {
		        Object[] row = new Object[columnCount];
		        for (int i = 0; i < columnCount; i++) {
		            row[i] = resultSet.getObject(i + 1);
		        }
		        model.addRow(row);
		    }

		    resultSet.close();
		    preparedStatement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (Exception e) {
		    e.printStackTrace();
		    
		}
		  // Create the JTable with the model and add it to a JScrollPane
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 80, 700, 420);
        contentPane.add(scrollPane);
	


	}} 


