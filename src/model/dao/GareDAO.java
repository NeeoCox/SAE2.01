package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Commune;
import model.data.Gare;

public class GareDAO extends DAO<Gare> {
	/**
	 * 
	 * @param gare la gare à ajouter
	 * @param commune la commune où est la gare
	 * @return -1 si il n'a pas été ajouté ; sinon le nombre de gare ajouter
	 */
	public int create(Gare gare,Commune commune){
		int result = -1;
		String query = "INSERT INTO Gare(codeGare,nomGare,estFret,estVoyageur,laCommune) VALUES ('"+gare.getCodeGare()+","+gare.getNomGare()+","+gare.getEstFret()+","+commune.getIdCommune()+"')";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Gare> research(int codeGare){
		List<Gare> result = new ArrayList<Gare>();
		try(Connection connect = createConnection(); Statement st = connect.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM Gare WHERE codeGare ="+codeGare); // requête que tu veux faire
			while(rs.next()){
				int code = rs.getInt("codeGare"); //type de la colonne et son nom
				String nomGare = rs.getString("nomGare");
				boolean estFret = rs.getBoolean("estFret");
				boolean estVoyageur = rs.getBoolean("estVoyageur");

				result.add(new Gare(code,nomGare,estFret,estVoyageur));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}





	public int update(Gare gare,Commune commune){
		int result = -1;
		String query = "UPDATE Gare SET codeGare='"+ gare.getCodeGare() +"', nomGare='"+gare.getNomGare() +"', estFret='"+gare.getEstFret()+"', estVoyageur='"+gare.getEstVoyageur()+"', laCommune='"+commune.getIdCommune()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public int delete(Gare gare){
		int result = -1;
		String query = "DELETE FROM gare WHERE codeGare ='"+gare.getCodeGare()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Gare> gare(String id){
		ArrayList<Gare> result = new ArrayList<Gare>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM Gare WHERE laCommune= ?")){
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