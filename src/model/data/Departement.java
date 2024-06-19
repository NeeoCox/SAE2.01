package model.data;

import java.util.ArrayList;


public class Departement {
	/**
	 * this attribut is used to store the department id
	 */
	private int idDep;
	/**
	 * this attribut is used to store the department name
	 */
	private String nomDep;
	/**
	 * this attribut is used to store the department cultural investment
	 */
	private float invesCulturel2019;
	/**
	 * this attribut is used to store the department list of commune within it
	 */
	private ArrayList<Commune> listeCommunes;
	/**
	 * this attribut is used to store the department list of airports
	 */
	private ArrayList<Aeroport> listeAeroport;
	/**
	 * this method is used to create or set all the attributs of the class, the first contructor
	 * @param id, the departement's id
	 * @param nom, the departement's name
	 * @param inves, the departement's cultural investment
	 */
	public Departement(int id,String nom,float inves){
		if(inves < 0) throw new IllegalArgumentException("Investissement negatif");
		if(id < 0) throw new IllegalArgumentException("ID negatif");
		if(nom == null) throw new IllegalArgumentException("Nom null");
		if(nom.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		if(nom != nom.toUpperCase()) throw new IllegalArgumentException("Le nom doit etre en majuscule");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
		this.listeCommunes = new ArrayList<Commune>();
		this.listeAeroport = new ArrayList<Aeroport>();
	}
	/**
	 * this method is used to create or set all the attributs of the class, the second contructor
	 * @param id, the departement's id
	 * @param nom, the depatement's name
	 * @param inves, the departement's cultural investment
	 * @param communes, the departement's list of the communes within it
	 * @param aeroports, the departement's list of the ariports within it
	 */
	public Departement(int id,String nom,float inves,ArrayList<Commune> communes, ArrayList<Aeroport> aeroports){
		if(inves < 0) throw new IllegalArgumentException("Investissement negatif");
		if(id < 0) throw new IllegalArgumentException("ID negatif");
		if(nom == null) throw new IllegalArgumentException("Nom null");
		if(nom.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		if(listeCommunes == null) throw new IllegalArgumentException("Liste Commune null");
		if(listeAeroport == null) throw new IllegalArgumentException("Liste Aeroport null");
		if(nom != nom.toUpperCase()) throw new IllegalArgumentException("Le nom doit etre en majuscule");
		if(communes == null) throw new IllegalArgumentException("Il doit y avoir une liste de communes");
		if(aeroports == null) throw new IllegalArgumentException("Il faut une liste d'aeroports");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
		this.listeCommunes = communes;
		this.listeAeroport = aeroports;
	}
	/**
	 * this method is used to get the id of the departement
	 * @return, an int/ departement's id
	 */
	public int getIdDep() {
		return idDep;
	}
	/**
	 * this method is used to get the cultural investement
	 * @return, a float/ departement's investment 
	 */
	public float getInvesCulturel2019() {
		return invesCulturel2019;
	}
	/**
	 * this method is used to get the departement's name
	 * @return, a String/ departement's name
	 */
	public String getNomDep() {
		return nomDep;
	}
	/**
	 * this method is used to get the list of the communes within the departement
	 * @return, an Array/ list of communes within the departement
	 */
	public ArrayList<Commune> getListeCommunes() {
		return listeCommunes;
	}
	/**
	 * this method is used to set the id 
	 * @param idDep, the new id
	 */
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	/**
	 * this method is used to set the cultural investment
	 * @param invesCulturel2019, the new value
	 */
	public void setInvesCulturel2019(float invesCulturel2019) {
		if(invesCulturel2019 < 0) throw new IllegalArgumentException("Investissement negatif");
		this.invesCulturel2019 = invesCulturel2019;
	}
	/**
	 * this method is used to set the name
	 * @param nomDep, the new name
	 */
	public void setNomDep(String nomDep) {
		if(nomDep == null) throw new IllegalArgumentException("Nom null");
		if(nomDep.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.nomDep = nomDep;
	}
	/**
	 * this method is used to set the list of communes
	 * @param listeCommunes, the new list
	 */
	public void setListeCommunes(ArrayList<Commune> listeCommunes) {
		if(listeCommunes == null) throw new IllegalArgumentException("Liste Commune null");
		this.listeCommunes = listeCommunes;
	}
	/**
	 * this method is used to set the list of airports
	 * @param listeAeroport, the list of airports
	 */
	public void setListeAeroport(ArrayList<Aeroport> listeAeroport) {
		if(listeAeroport== null) throw new IllegalArgumentException("Liste Aeroport null");
		this.listeAeroport = listeAeroport;
	}
	/**
	 * this method is used to get the list of airports
	 * @return, an Array/ the list of airports
	 */
	public ArrayList<Aeroport> getListeAeroport() {
		return listeAeroport;
	}
	/**
	 * this method is used to compare the investment beetween 2 departements
	 * @param d, the departement you compare with
	 * @return, and int depending if one is higher, equal or lower
	 */
	public int compareInvessTo(Departement d){
		int ret = 0;
		if (d != null) {
			if(d.getInvesCulturel2019() == this.invesCulturel2019){
				ret = 1;
			}else if (d.getInvesCulturel2019() > this.invesCulturel2019) {
				ret = -1;
			}
		}else{
			throw new IllegalArgumentException("Le departement n'existe pas");
		}
		return ret;
	}
	/**
	 * this method is used to get the number of train stations in the departement
	 * @return, an int/ the number of train station within the departement
	 */
	public int nbGare(){
		int ret = 0;
		for (Commune commune : this.listeCommunes) {
			if (commune == null) {throw new IllegalArgumentException();}
			ret = ret + commune.getListeGare().size();
		}
		return ret;
	}
}