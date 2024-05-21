package modele;



public class Departement {
	private int idDep;
	private String nomDep;
	private float invesCulturel2019;
	
	public Departement(int id,String nom,float inves){
		if(nom == null) throw new RuntimeException("Nom null");
		if(nom.length() == 0) throw new RuntimeException("Nom inexistant");
		this.idDep = id;
		this.nomDep = nom;
		this.invesCulturel2019 = inves;
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

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	public void setInvesCulturel2019(float invesCulturel2019) {
		this.invesCulturel2019 = invesCulturel2019;
	}
	public void setNomDep(String nomDep) {
		if(nomDep == null) throw new RuntimeException("Nom null");
		if(nomDep.length() == 0) throw new RuntimeException("Nom inexistant");
		this.nomDep = nomDep;
	}
	
}