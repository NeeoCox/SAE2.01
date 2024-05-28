package model.dao;
import model.data.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Aeroport;
import model.data.Commune;

public class DepartementDAO extends DAO<Departement> {
	


	public ArrayList<Commune> commune(String id){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM Commune WHERE leDepartement = ? ")){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result.add(new Commune(rs.getInt("idCommune"),rs.getString("nomCommune")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Commune> commune(int id){
		return this.commune(String.valueOf(id));
	}
	
	
	
	
	public ArrayList<Aeroport> aeroports(String id){
		ArrayList<Aeroport> result = new ArrayList<Aeroport>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM aeroport WHERE leDepartement = ? ")){
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				result.add(new Aeroport());
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return result;
	}
	public ArrayList<Aeroport> aeroports(int id){
		return aeroports(String.valueOf(id));
	}
}
