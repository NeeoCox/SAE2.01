package model.data;
import java.util.ArrayList;


/**
 * Commune
 */
public class Commune {

	/**
	 * this attribut is used to store the commune's id
	 */
	private int idCommune;
	/**
	 * this attribut is used to store the commune's name
	 */
	private String nomCommune;
	/**
	 * this attribut is used to store every neighbor communes
	 */
	private ArrayList<Commune> listeVoisine;
	/**
	 * this attribut is used to store every train station located in the commune
	 */
	private ArrayList<Gare> listeGare;
	
	private int année;

	private float tauxInflation;

	private int nbMaison;

	private int nbAppart;

	private float prixMoyen;

	private float prixM2Moyen;

	private float surfaceMoy;

	private float depCulturelleTotal;

	private float budgetTotal;

	private float population;

	/**
	 * this method is used to set all the attributs/create depending on the parameters, it's the first contructor
	 * @param idCommune, the commune's id
	 * @param nomCommune, the commune's name
	 */
	public Commune(int idCommune, String nomCommune, int annee, float taux, int nbMaison, int nbAppart, float prixM2Moyen, float prixMoyen, float surface, float depCulturelleTotal, float bugdet, float population){
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.idCommune = idCommune;
		this.nomCommune = nomCommune;
		this.année = annee;
		this.nbMaison = nbMaison;
		this.nbAppart = nbAppart;
		this.prixM2Moyen = prixM2Moyen;
		this.prixMoyen = prixMoyen;
		this.surfaceMoy = surface;
		this.depCulturelleTotal = depCulturelleTotal;
		this.budgetTotal = bugdet;
		this.population = population;
		this.listeGare = new ArrayList<Gare>();
		this.listeVoisine = new ArrayList<Commune>();
	}

	/**
	 * this metbhod is used to set all the attribut/create depending on the parameters, it's the second constructor
	 * @param idCommune, the commune's id
	 * @param nomCommune, the commune's name
	 * @param listeVoisine, the list containing all neighbour communes
	 * @param listeGare, the list containing all the train stations inside the commune
	 */
	public Commune(int idCommune, String nomCommune, int annee, float taux, int nbMaison, int nbAppart, float prixM2Moyen, float prixMoyen, float surface, float depCulturelleTotal, float bugdet, float population,ArrayList<Commune> listeVoisine,ArrayList<Gare> listeGare){
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		if(listeGare == null) throw new IllegalArgumentException("Liste Gare null");
		if(listeVoisine == null) throw new IllegalArgumentException("Liste voisine null");
		this.idCommune = idCommune;
		this.nomCommune = nomCommune;
		this.année = annee;
		this.nbMaison = nbMaison;
		this.nbAppart = nbAppart;
		this.prixM2Moyen = prixM2Moyen;
		this.prixMoyen = prixMoyen;
		this.surfaceMoy = surface;
		this.depCulturelleTotal = depCulturelleTotal;
		this.budgetTotal = bugdet;
		this.population = population;
		this.listeGare = listeGare;
		this.listeVoisine = listeVoisine;
	}
	/**
	 * this method is used to get the id of the commune
	 * @return, an int / commune's id
	 */
	public int getIdCommune() {
		return idCommune;
	}
	/**
	 * this method is used to get the list of train stations
	 * @return, an Array/ the list of train station
	 */
	public ArrayList<Gare> getListeGare() {
		return listeGare;
	}
	/**
	 * this method is used to get the name of the commune
	 * @return, a String/ the commune's name
	 */
	public String getNomCommune() {
		return nomCommune;
	}
	/**
	 * this method is used to get the list of neighbouring communes
	 * @return, an Array/ list full of commune
	 */
	public ArrayList<Commune> getListeVoisine() {
		return listeVoisine;
	}
	/**
	 * 
	 * @return
	 */
	public int getAnnee(){
		return this.année;
	}
	public float getTauxInflation(){
		return this.tauxInflation;
	}
	public int getNbMaison(){
		return nbMaison;
	}
	public int getNbAppart(){
		return nbAppart;
	}
	public float getPrixMoyen(){
		return this.prixMoyen;
	}
	public float getPrixM2Moyen(){
		return this.prixM2Moyen;
	}
	public float getSurfaceMoy(){
		return this.surfaceMoy;
	}
	public float getDepCulturelleTotal(){
		return this.depCulturelleTotal;
	}
	public float getBudgetTotal(){
		return this.budgetTotal;
	}
	public float getPopulation(){
		return this.population;
	}
	public void setAnnee(int annee){
		this.année = annee;
	}
	public void setTauxInflation(float taux){
		this.tauxInflation = taux;
	}
	public void setNbMaison(int nbMaison){
		this.nbMaison = nbMaison;
	}
	public void setNbAppart(int nbAppart){
		this.nbAppart = nbAppart;
	}
	public void setPrixMoyen(float prixMoyen){
		this.prixMoyen = prixMoyen;
	}
	public void setPrixM2Moyen(float prixM2Moyen){
		this.prixM2Moyen = prixM2Moyen;
	}
	public void setSurfaceMoy(float surface){
		this.surfaceMoy = surface;
	}
	public void setDepCulturelleTotal(float depense){
		this.depCulturelleTotal = depense;
	}
	public void setBudgetTotal(float budget){
		this.budgetTotal = budget;
	}
	public void setPopulation(float pop){
		this.population = pop;
	}
	/**
	 * this method is used to set the id depending of the parameter
	 * @param idCommune, an int representing the commune's id
	 */
	public void setIdCommune(int idCommune) {
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		this.idCommune = idCommune;
	}
	/**
	 * this method is used to set the train station array depending of the parameter
	 * @param listeGare, a list containing all the train stations
	 */
	public void setListeGare(ArrayList<Gare> listeGare) {
		if(listeGare == null) throw new IllegalArgumentException("Liste Gare null");
		this.listeGare = listeGare;
	}
	/**
	 * this method is used to set the commune Array depending of the parameter
	 * @param listeVoisine, a list containing all the neighbours
	 */
	public void setListeVoisine(ArrayList<Commune> listeVoisine) {
		if(listeVoisine == null) throw new IllegalArgumentException("Liste voisine null");
		this.listeVoisine = listeVoisine;
	}
	/**
	 * this method is used to set the name depending of the parameter
	 * @param nomCommune, a string representing the commune's name
	 */
	public void setNomCommune(String nomCommune) {
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.nomCommune = nomCommune;
	}
	/**
	 * this method is used to check if 2 communes are neighbours using the Array "communeVoisine"
	 * @param commu, the other commune
	 * @return, true if they are neighbours or false if they are not
	 */
	public boolean estVoisine(Commune commu){
		boolean ret = false;
		if (commu != null) {
			for (Commune commune : this.listeVoisine) {
				if (commune.equals(commu)) {
					ret = true;
				}
			}
		}else{
			throw new IllegalArgumentException("Cette commune n'est pas dans la liste");
		}
		return ret;
	}
	
}