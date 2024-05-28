package controller.model.data;

/**
 * Gare
 */
public class Gare {
	/** le code de la gare */
	private int codeGare;
	/** le nom de la gare */
	private String nomGare;
	/** le  */
	private boolean estFret;
	private boolean estVoyageur;

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
	 * Getter de codeGare
	 * @return codeGare (int)
	 */
	public int getCodeGare() {
		return this.codeGare;
	}
	
	/**
	 * Getter de nomGare
	 * @return nomGare (String)
	 */
	public String getNomGare() {
		return this.nomGare;
	}
	
	/**
	 * Getter de estFret
	 * @return estFret (boolean)
	 */
	public boolean getEstFret(){
		return this.estFret;
	}

	/**
	 * Getter de estVoyageur
	 * @return estVoyageur (boolean)
	 */
	public boolean getEstVoyageur(){
		return this.estVoyageur;
	}


	/**
	 * Setter de codeGare 
	 * @param codeGare le code de la gare
	 */
	public void setCodeGare(int codeGare) {
		if(codeGare <0) throw new IllegalArgumentException("Code Gare negatif");
		if(nomGare == null) throw new IllegalArgumentException("Nom null");
		if(nomGare.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.codeGare = codeGare;
	}
	
	/**
	 * Setter de nomGare
	 * @param nomGare le nom de la gare
	 */
	public void setNomGare(String nomGare) {
		this.nomGare = nomGare;
	}

	/**
	 * Setter de estFret
	 * @param estFret vrai si la gare accueil des frets ; faux sinon
	 */
	public void setEstFret(boolean estFret) {
		this.estFret = estFret;
	}

	/**
	 * Setter de estVoyageur
	 * @param estVoyageur vrai si la gare accueil des voyageurs ; faux sinon
	 */
	public void setEstVoyageur(boolean estVoyageur) {
		this.estVoyageur = estVoyageur;
	}


	
}