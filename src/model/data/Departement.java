package model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


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
		if(nom != nom.toUpperCase()) throw new IllegalArgumentException("Le nom doit etre en majuscule");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
		this.listeCommunes = new ArrayList<Commune>();
		this.listeAeroport = new ArrayList<Aeroport>();
	}

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

	public int nbGare(){
		int ret = 0;
		for (Commune commune : this.listeCommunes) {
			if (commune == null) {throw new IllegalArgumentException();}
			ret = ret + commune.getListeGare().size();
		}
		return ret;
	}
}