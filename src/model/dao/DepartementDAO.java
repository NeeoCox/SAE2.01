package model.dao;
import model.data.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Aeroport;
import model.data.Commune;

public class DepartementDAO extends DAO<Departement> {
	


	public ArrayList<Commune> listeCommunes(String id){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM Commune WHERE leDepartement = ? ")){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				//result.add(new Commune(rs.getInt("idCommune"),rs.getString("nomCommune")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Commune> listeCommunes(int id){
		return this.listeCommunes(String.valueOf(id));
	}
	
	
	
	
	public ArrayList<Aeroport> listeAeroport(String id){
		ArrayList<Aeroport> result = new ArrayList<Aeroport>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM aeroport WHERE leDepartement = ? ")){
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				result.add(new Aeroport(rs.getString("nom"),rs.getString("adresse")));
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return result;
	}
	public ArrayList<Aeroport> listeAeroport(int id){
		return listeAeroport(String.valueOf(id));
	}

	public int create(Departement departement){
		int result = -1;
		String query = "INSERT INTO Departement(idDep,nomDep,investissementCulturel2019) VALUES ('"+departement.getIdDep()+","+departement.getNomDep()+","+departement.getInvesCulturel2019()+"')";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public int update(Departement departement){
		int result = -1;
		String query = "UPDATE Departement SET idDep='"+ departement.getIdDep() +"', nomDep='"+departement.getNomDep() +"', investissementCulturel2019='"+departement.getInvesCulturel2019()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}


	public int delete(Departement departement){
		int result = -1;
		String query = "DELETE FROM Departement WHERE idDep ='"+departement.getIdDep()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
