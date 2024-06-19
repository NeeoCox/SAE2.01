package model.data;

/**
 * Gare
 */
public class Gare {
	/** the id of the train station */
	private int codeGare;
	/** the name of the train station */
	private String nomGare;
	/** true if the train station is used to transport marchandise  */
	private boolean estFret;
	/** true if the train station is used to transport people */
	private boolean estVoyageur;

	/**
	 * 
	 * @param codeGare
	 * @param nomGare
	 * @param estFret
	 * @param estVoyageur
	 */
	public Gare(int codeGare, String nomGare, boolean estFret, boolean estVoyageur){
		if(codeGare <0) throw new IllegalArgumentException("Code Gare negatif");
		if(nomGare == null) throw new IllegalArgumentException("Nom null");
		if(nomGare.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.codeGare = codeGare;
		this.nomGare = nomGare;
		this.estFret = estFret;
		this.estVoyageur = estVoyageur;
	}


	/**
	 * used to get the train station's id
	 * @return codeGare (int)
	 */
	public int getCodeGare() {
		return this.codeGare;
	}
	
	/**
	 * used to get the train station's name
	 * @return nomGare (String)
	 */
	public String getNomGare() {
		return this.nomGare;
	}
	
	/**
	 * used to get if the train station is used for marchandise
	 * @return estFret (boolean)
	 */
	public boolean getEstFret(){
		return this.estFret;
	}

	/**
	 * used to get if the train station is used for transporting people
	 * @return estVoyageur (boolean)
	 */
	public boolean getEstVoyageur(){
		return this.estVoyageur;
	}


	/**
	 * this method is used to set the id of the train station 
	 * @param codeGare the train station's id
	 */
	public void setCodeGare(int codeGare) {
		if(codeGare <0) throw new IllegalArgumentException("Code Gare negatif");
		if(nomGare == null) throw new IllegalArgumentException("Nom null");
		if(nomGare.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.codeGare = codeGare;
	}
	
	/**
	 * this method is used to set the name of the train station
	 * @param nomGare the train station's name
	 */
	public void setNomGare(String nomGare) {
		this.nomGare = nomGare;
	}

	/**
	 * this method is used to set if the train station is used to transport marchandise
	 * @param estFret true if the train station is used for marchandise; else false
	 */
	public void setEstFret(boolean estFret) {
		this.estFret = estFret;
	}

	/**
	 * this method is used to set if the train staion is used to transport people
	 * @param estVoyageur true if used to transport people; else false
	 */
	public void setEstVoyageur(boolean estVoyageur) {
		this.estVoyageur = estVoyageur;
	}

	/**
	 * this method is used to check if a train station is in a list within a commune
	 * @param c, the commune we wanna check if the train station is in
	 * @return, true if it's in the commune; else false
	 */
	public boolean communeGare(Commune c){
		boolean ret = false;
		if(c == null){throw new IllegalArgumentException("la commune ne doit pas etre null");}
		for (Gare gare : c.getListeGare()) {
			if(gare.getCodeGare() == this.codeGare){
				ret = true;
			}
		}
		return ret;
	}
	
}