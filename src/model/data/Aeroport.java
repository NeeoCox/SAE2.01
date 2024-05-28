package controller.model.data;


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

    public String emplacementAeroport(Departement d){
        String ret = "";
        for (Aeroport aeroport : d.getListeAeroport()) {
            if (aeroport.getNom().equals(this.nom)) {
                ret = ret + d.getNomDep() + "a un aeroport";
            }
        }
        return ret;
    }
}
