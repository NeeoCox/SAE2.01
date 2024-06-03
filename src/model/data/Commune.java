package model.data;
import java.util.ArrayList;

import model.dao.CommuneDAO;

/**
 * Commune
 */
public class Commune {


	private int idCommune;
	private String nomCommune;
	private ArrayList<Commune> listeVoisine;
	private ArrayList<Gare> listeGare;
	private CommuneDAO c;

	public Commune(int idCommune, String nomCommune){
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.idCommune = idCommune;
		this.nomCommune = nomCommune;
		this.listeGare = new ArrayList<Gare>();
		this.listeVoisine = new ArrayList<Commune>();
	}

	public Commune(int idCommune, String nomCommune,ArrayList<Commune> listeVoisine,ArrayList<Gare> listeGare){
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		if(listeGare == null) throw new IllegalArgumentException("Liste Gare null");
		if(listeVoisine == null) throw new IllegalArgumentException("Liste voisine null");
		this.idCommune = idCommune;
		this.nomCommune = nomCommune;
		this.listeGare = listeGare;
	}

	public int getIdCommune() {
		return idCommune;
	}

	public ArrayList<Gare> getListeGare() {
		return listeGare;
	}

	public String getNomCommune() {
		return nomCommune;
	}
	public ArrayList<Commune> getListeVoisine() {
		return listeVoisine;
	}

	public void setIdCommune(int idCommune) {
		if(idCommune < 0) throw new IllegalArgumentException("id Negatif");
		this.idCommune = idCommune;
	}
	public void setListeGare(ArrayList<Gare> listeGare) {
		if(listeGare == null) throw new IllegalArgumentException("Liste Gare null");
		this.listeGare = listeGare;
	}

	public void setListeVoisine(ArrayList<Commune> listeVoisine) {
		if(listeVoisine == null) throw new IllegalArgumentException("Liste voisine null");
		this.listeVoisine = listeVoisine;
	}
	public void setNomCommune(String nomCommune) {
		if(nomCommune == null) throw new IllegalArgumentException("Nom null");
		if(nomCommune.length() == 0) throw new IllegalArgumentException("Nom inexistant");
		this.nomCommune = nomCommune;
	}
	public boolean checkAnnee(int annee){
		boolean ret = false;
		String idCommuneS = "" + this.idCommune;
		ArrayList<Integer> a = c.setAnnee(idCommuneS);
		for (Integer integer : a) {
			if (integer == annee) {
				ret = true;
			}
		}
		return ret;

	}
	public boolean estVoisine(Commune commu){
		boolean ret = false;
		if (commu != null) {
			for (Commune commune : this.listeVoisine) {
				if (commune.equals(commu)) {
					ret = true;
				}
			}
		}
		return ret;
	}
	
}