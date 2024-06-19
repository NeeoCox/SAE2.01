package controller.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/sae_104";
	private static String username = "root";
	private static String pwd = "root";
	Connection connect;


	static Connection createConnection() throws SQLException{
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return DriverManager.getConnection(url, username, pwd);
	}

	public static void setUsername(String username) {
		if(username == null) throw new IllegalArgumentException("username null");
		if(username.length() == 0) throw new IllegalArgumentException("username vide");
		DAO.username = username;
	}
	
	public static void setPwd(String pwd) {
		if(username == null) throw new IllegalArgumentException("mot de passe null");
		if(username.length() == 0) throw new IllegalArgumentException("mot de passe vide");
		DAO.pwd = pwd;
	}
}
