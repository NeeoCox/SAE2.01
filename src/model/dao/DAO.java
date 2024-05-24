package model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jcbd:mysql://localhost/3306/commune";
	String requete;
	Connection connect;
	public DAO(){
		try{
			connect = DriverManager.getConnection(url, "root", "root");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void query(){
		
		try(Statement st = connect.createStatement()){
			
			try{
				Class.forName(driver);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				System.out.println(rs.getInt("codeGare"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
