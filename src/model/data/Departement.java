package view.model.data;

import java.util.ArrayList;

public class Departement {
	private int idDep;
	private String nomDep;
	private float invesCulturel2019;
	private ArrayList<Commune> listeCommunes;
	private ArrayList<Aeroport> listeAeroport;
	
	public Departement(int id,String nom,float inves){
		if(inves < 0) throw new IllegalArgumentException("Investissement negatif");
		if(id < 0) throw new IllegalArgumentException("ID negatif");
		if(nom == null) throw new IllegalArgumentException("Nom null");
		if(nom.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
		this.listeCommunes = new ArrayList<Commune>();
		this.listeAeroport = new ArrayList<Aeroport>();
	}

	public Departement(int id,String nom,float inves,ArrayList<Commune> listeCommunes,ArrayList<Aeroport> listeAeroport){
		if(inves < 0) throw new IllegalArgumentException("Investissement negatif");
		if(id < 0) throw new IllegalArgumentException("ID negatif");
		if(nom == null) throw new IllegalArgumentException("Nom null");
		if(nom.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		if(listeCommunes == null) throw new IllegalArgumentException("Liste Commune null");
		if(listeAeroport== null) throw new IllegalArgumentException("Liste Aeroport null");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
		this.listeCommunes = listeCommunes;
		this.listeAeroport = listeAeroport;
	}

	public int getIdDep() {
		return idDep;
	}

	public float getInvesCulturel2019() {
		return invesCulturel2019;
	}
	public String getNomDep() {
		return nomDep;
	}
	
	public ArrayList<Commune> getListeCommunes() {
		return listeCommunes;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	public void setInvesCulturel2019(float invesCulturel2019) {
		if(invesCulturel2019 < 0) throw new IllegalArgumentException("Investissement negatif");
		this.invesCulturel2019 = invesCulturel2019;
	}
	public void setNomDep(String nomDep) {
		if(nomDep == null) throw new IllegalArgumentException("Nom null");
		if(nomDep.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.nomDep = nomDep;
	}

	public void setListeCommunes(ArrayList<Commune> listeCommunes) {
		if(listeCommunes == null) throw new IllegalArgumentException("Liste Commune null");
		this.listeCommunes = listeCommunes;
	}
	
	public void setListeAeroport(ArrayList<Aeroport> listeAeroport) {
		if(listeAeroport== null) throw new IllegalArgumentException("Liste Aeroport null");
		this.listeAeroport = listeAeroport;
	}

	public ArrayList<Aeroport> getListeAeroport() {
		return listeAeroport;
	}
}