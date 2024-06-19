package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Commune;
import model.data.Departement;
import model.data.Gare;


public class CommuneDAO extends DAO<Commune> {

	public List<Commune> findAll(){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM commune, donneesannuelles, annee WHERE commune.idCommune = donneesannuelles.laCommune AND donneesannuelles.lAnnee = annee.annee")){
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("idCommune");
				String nom = rs.getString("nomCommune");
				result.add(new Commune(id, nom,rs.getInt("lAnnee"),rs.getFloat("tauxInflation"),rs.getInt("nbMaison"),rs.getInt("nbAppart"),rs.getFloat("prixM2Moyen"),rs.getFloat("prixMoyen"),rs.getFloat("SurfaceMoy"),rs.getFloat("depensesCulturellesTotales"),rs.getFloat("budgetTotal"),rs.getInt("population")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	

	public Departement getDepartement(String idCommune){
		Departement result = null;
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM departement JOIN Commune ON leDepartement = idDep WHERE idCommune = ? ")){
			st.setString(1, idCommune);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("idDep");
				String nom = rs.getString("nomDep");
				int inves = rs.getInt("investissementCulturel2019");
				result = new Departement(id,nom,inves);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public Departement getDepartement(int idCommune){
		return getDepartement(String.valueOf(idCommune));
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
				//result.add(new Commune(rs.getInt("communeVoisine"),rs.getString("nomCommune"),rs.getInt("")));
			}
		}catch(SQLException e){

		}
		return result;
	}
	public ArrayList<Integer> voisine(int id){
		return setAnnee(String.valueOf(id));
	}

	
	

	
	public int create(Commune commune){
		int result = -1;
		String query = "INSERT INTO Commune() VALUES ('"+commune.getIdCommune()+","+commune.getNomCommune()+","+this.getDepartement(String.valueOf(commune.getIdCommune())).getIdDep()+"')";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}

		String queryDA ="INSERT INTO donneesannuelles (lAnnee,laCommune,nbMaison,nbAppart,prixMoyen,prixM2Moyen,SurfaceMoy,depensesCulturellesTotales,budgetTotal,population)";
		queryDA +=" VALUES ("+commune.getAnnee()+", "+commune.getIdCommune()+", "+commune.getNbMaison()+", "+commune.getNbAppart()+", "+commune.getPrixMoyen()+", "+commune.getPrixM2Moyen()+", "+commune.getSurfaceMoy()+", "+commune.getDepCulturelleTotal()+", "+commune.getBudgetTotal()+", "+commune.getPopulation()+")";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(queryDA);
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}
	
	public ArrayList<Commune> find(String nomVille){
		ArrayList<Commune> result = new ArrayList<Commune>();
		try(Connection connect = createConnection(); PreparedStatement st = connect.prepareStatement("SELECT * FROM commune, donneesannuelles, annee WHERE commune.idCommune = donneesannuelles.laCommune AND donneesannuelles.lAnnee = annee.annee AND commune.nomCommune = ?")){
			st.setString(1, nomVille.toUpperCase());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("idCommune");
				String nom = rs.getString("nomCommune");
				result.add(new Commune(id, nom,rs.getInt("lAnnee"),rs.getFloat("tauxInflation"),rs.getInt("nbMaison"),rs.getInt("nbAppart"),rs.getFloat("prixM2Moyen"),rs.getFloat("prixMoyen"),rs.getFloat("SurfaceMoy"),rs.getFloat("depensesCulturellesTotales"),rs.getFloat("budgetTotal"),rs.getInt("population")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}





	
	public int update(Commune commune){
		int result = -1;
		String query = "UPDATE Commune SET nomCommune='"+commune.getNomCommune() +"', leDepartement='"+this.getDepartement(commune.getIdCommune()).getIdDep()+"' WHERE idCommune="+commune.getIdCommune();
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}

		String queryDA = "UPDATE donneesannuelles SET nbMaison='"+commune.getNbMaison()+"', nbAppart='"+commune.getNbAppart()+"', prixMoyen='"+commune.getPrixMoyen()+"', prixM2Moyen='"+commune.getPrixM2Moyen()+"', SurfaceMoy='"+commune.getSurfaceMoy()+"', depensesCulturellesTotales='"+commune.getDepCulturelleTotal()+"', budgetTotal='"+commune.getBudgetTotal()+"', population='"+commune.getPopulation()+"' WHERE lAnnee="+commune.getAnnee()+" AND laCommune="+commune.getIdCommune();

		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(queryDA);
		}catch(SQLException e){
			e.printStackTrace();
		}

		String queryI = "UPDATE annee SET tauxInflation='"+commune.getTauxInflation()+"' WHERE annee="+commune.getAnnee();
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(queryI);
		}catch(SQLException e){
			e.printStackTrace();
		}


		return result;
	}


	public int delete(Commune commune){
		int result = -1;
		String queryDA = "DELETE FROM donneesannuelles WHERE idCommune ='"+commune.getIdCommune()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(queryDA);
		}catch(SQLException e){
			e.printStackTrace();
		}
		String query = "DELETE FROM commune WHERE idCommune ='"+commune.getIdCommune()+"'";
		try(Connection connect = createConnection();Statement st = connect.createStatement()){
			result = st.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}




		return result;
	}
	
}