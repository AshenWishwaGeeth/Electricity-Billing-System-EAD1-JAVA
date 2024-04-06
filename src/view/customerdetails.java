package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.mysql.cj.xdevapi.Statement;

public class customerdetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerdetails frame = new customerdetails();
					frame.setVisible(true);
					frame.setLayout(null);
					frame.setTitle(" customer details");
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
	public customerdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
Font font4 = new Font("Aharoni", Font.PLAIN, 30);
		
		Font font1 = new Font("Arial", Font.BOLD, 24);
		Border brd1 = BorderFactory.createLineBorder(Color.black);
		
		JLabel lblmain= new JLabel("Customer details");
		
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

		
		String url = "jdbc:mysql://localhost:3307/electricityfinal"; 
        String username = "root"; 
        String password = "";

     
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customerdtails"); 

            // Create a table for jpl2
            JTable table = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(70, 80, 700, 420);
            contentPane.add(scrollPane);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();

      
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // Create data array
        Object[][] data = new Object[100][columnCount];

        int rowCount = 0;
        while (resultSet.next() && rowCount < 100) { 
            for (int i = 1; i <= columnCount; i++) {
                data[rowCount][i - 1] = resultSet.getObject(i);
            }
            rowCount++;
        }

        return new DefaultTableModel(data, columnNames);
}


	}


