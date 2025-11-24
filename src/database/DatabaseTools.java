package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTools {
	public Connection conn=null;
	public Connection getConn() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");					
			String DBURL= "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String DBUSER = "root";										
			String DBPASS = "root";										
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
