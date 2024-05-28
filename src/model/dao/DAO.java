package model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public abstract class DAO<T> {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/basae";
	Connection connect;


	Connection createConnection() throws SQLException{
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return DriverManager.getConnection(this.url, "root", "root");
	}

	/**
	 * Demande une requete depuis la base
	 * @param requete la requete en mySQL 
	 * @param colonne la colonne selection
	 * @return une ArrayList de String qui peut etre converti avec toBoolean, toInteger ou toFloat
	 */
	public ArrayList<String> query(String requete,String colonne){
		ArrayList<String> a = new ArrayList<String>();
		
		if(requete == null) throw new IllegalArgumentException("Requete null");
		if(colonne == null) throw new IllegalArgumentException("colonne null");
		try(Statement st = connect.createStatement()){
			try{
				Class.forName(driver);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				a.add(rs.getString(colonne));
			}
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return a;
		
	}

	public abstract ArrayList<T> findAll();

	/**
	 * Converti une ArrayList de String qui représente des BOOLEAN mySQL en boolean java
	 * @param ARofBooleanAsString l'ArrayList de String
	 * @return une ArrayList de Boolean
	 */
	public static ArrayList<Boolean> toBoolean(ArrayList<String> ARofBooleanAsString){
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		for (String s : ARofBooleanAsString) {
			if(s.equals("0")) result.add(false);
			else if (s.equals("1")) result.add(true);
			else throw new IllegalArgumentException("ArrayList invalide");
		}
		return result;
	}

	/**
	 * Converti une ArrayList de String qui représente des INT mySQL en Integer java
	 * @param ARofIntegerAsString l'ArrayList de String
	 * @return une ArrayList de Integer
	 */
	public ArrayList<Integer> toInteger(ArrayList<String> ARofIntegerAsString){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (String s : ARofIntegerAsString) {
			try {
				int i = Integer.parseInt(s);
				result.add(i);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("ArrayList invalide");
			}
		}
		return result;
	}

	/**
	 * Converti une ArrayList de String qui représente des FLOAT mySQL en Float java
	 * @param ARofFloatAsString l'ArrayList de String
	 * @return une ArrayList de Float
	 */
	public ArrayList<Float> toFloat(ArrayList<String> ARofFloatAsString){
		ArrayList<Float> result = new ArrayList<Float>();
		for (String s : ARofFloatAsString) {
			try {
				float i = Float.parseFloat(s);
				result.add(i);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("ArrayList invalide");
			}
		}
		return result;
	}
}
