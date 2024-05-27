package model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/commune";
	Connection connect;
	public DAO(){
		try{
			connect = DriverManager.getConnection(url, "root", "root");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void query(String requete){
		if(requete == null) throw new IllegalArgumentException("Requete null");
		try(Statement st = connect.createStatement()){
			try{
				Class.forName(driver);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				// System.out.println(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
