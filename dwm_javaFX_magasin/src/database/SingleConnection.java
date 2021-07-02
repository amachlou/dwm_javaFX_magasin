package database;

import java.sql.*;

public class SingleConnection {

	String db="magasin_java";
	String user="root";
	String pwd="";
	String url="jdbc:mysql://localhost:3306/"+db;
	
	private static Connection connection=null;
	
	private SingleConnection() {
		try {
			connection=DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		
		if(connection==null) new SingleConnection();
		
		return connection;
	}
	
}
