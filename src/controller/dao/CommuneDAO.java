package controller.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.data.*;


public class CommuneDAO extends DAO<Commune> {



	public ArrayList<Commune> findAll(){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); Statement st = connect.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM commune");
			while(rs.next()){
				int id = rs.getInt("idCommune");
				String nom = rs.getString("nomCommune");
				result.add(new Commune(id, nom));
			}
		}catch(SQLException e){
			
		}
		return result;
	}

	public ArrayList<Integer> setAnnee(String id){
		ArrayList<Integer> result = new ArrayList<Integer>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM donneesannuelles WHERE laCommune= ? ")){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("lAnnee"));
			}
		}catch(SQLException e){

		}
		return result;
	}

	public ArrayList<Integer> setAnnee(int id){
		return setAnnee(String.valueOf(id));
	}

	public ArrayList<Commune> voisine(String id){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM voisinage JOIN Commune ON communeVoisine = idCommune WHERE commune= ?  ")){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result.add(new Commune(rs.getInt("communeVoisine"),rs.getString("nomCommune")));
			}
		}catch(SQLException e){

		}
		return result;
	}
	public ArrayList<Integer> voisine(int id){
		return setAnnee(String.valueOf(id));
	}

	
	public ArrayList<Gare> gare(String id){
		ArrayList<Gare> result = new ArrayList<Gare>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM Gare WHERE laCommune= ? ")){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result.add(new Gare(rs.getInt("codeGare"),rs.getString("nomGare"),rs.getBoolean("estFret"),rs.getBoolean("estVoyageur")));
			}
		}catch(SQLException e){

		}
		return result;
	}

	public ArrayList<Gare> gare(int id){
		return gare(String.valueOf(id));
	}

}
