package model.data;


public class Aeroport {
	
    private String nom;
    private String adresse;

    public Aeroport(String nom, String adresse){
        if ((nom != null) && (adresse != null)) {
            this.nom = nom;
            this.adresse = adresse;
        }
    }

    public String getNom(){
        return this.nom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public void setAdresse(String adress){
        if (adress != null) {
            this.adresse = adress;
        }
    }

    public void setNom(String nom){
        if (nom != null) {
            this.nom = nom;
        }
    }

    
}
