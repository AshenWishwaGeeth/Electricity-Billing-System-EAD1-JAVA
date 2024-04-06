package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class coonection {
	Connection c;
	public Statement s;

	public coonection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3307/electricityfinal", "root", "");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}