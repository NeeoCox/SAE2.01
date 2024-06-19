package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Aeroport;
import model.data.Departement;

public class AeroportDAO extends DAO<Aeroport> {

	public int create(Aeroport aeroport, Departement departement){
		int result = -1;
		String query = "INSERT INTO Aeroport(nom,adresse,leDepartement) VALUES ('"+aeroport.getNom()+","+aeroport.getAdresse()+","+departement.getIdDep()+"')";		
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Aeroport> research(Aeroport aeroport){ 
		List<Aeroport> result= new ArrayList<Aeroport>();
		try(Connection connect = createConnection(); Statement st = connect.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM Aeroport");
			while(rs.next()){
				String nom = rs.getString("nom");
				String addresse = rs.getString("addresse");
				result.add(new Aeroport(nom,addresse));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}


	public int update(Aeroport aeroport,Departement departement){
		int result = -1;
		String query = "UPDATE Aeroport SET nom='"+ aeroport.getNom() +"', addresse='"+aeroport.getAdresse() +"', leDepartement='"+departement.getIdDep()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public int delete(Aeroport aeroport){
		int result = -1;
		String query = "DELETE FROM Aeroport WHERE nom='"+aeroport.getNom()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
