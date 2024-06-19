package model.data;


public class Aeroport {
	/**
     * this attribut is used to store the name of the airport
     */
    private String nom;
    /**
     * this attribut is used to store the address of the airport
     */
    private String adresse;

    /**
     * this method is set the airport attribut depending on it's parameters
     * @param nom, the name of the airport
     * @param adresse, the address of the airport
     */
    public Aeroport(String nom, String adresse){
        if ((nom != null) && (adresse != null)) {
            this.nom = nom;
            this.adresse = adresse;
        }
    }
    /**
     * this method is used to get the name of the airport
     * @return, a string/ the airport's name
     */
    public String getNom(){
        return this.nom;
    }
    /**
     * this method is used to get the address of the airport
     * @return, a string/ the airport's address
     */
    public String getAdresse(){
        return this.adresse;
    }
    /**
     * this method is used to set the airport's address
     * @param adress, the new/ given address
     */
    public void setAdresse(String adress){
        if (adress != null) {
            this.adresse = adress;
        }
    }
    /**
     * this method is used to set the airport's name
     * @param nom, the new /given name
     */
    public void setNom(String nom){
        if (nom != null) {
            this.nom = nom;
        }
    }
    /**
     * this method is used to know in which departement the airport is situated and give back it's name
     * @param d, the departement we check if he is in
     * @return, the departement name that have the airport
     */
    public String emplacementAeroport(Departement d){
        String ret = "";
        if(d == null){throw new IllegalArgumentException("Il faut un departement non null");}
        for (Aeroport aeroport : d.getListeAeroport()) {
            if (aeroport.getNom().equals(this.nom)) {
                ret = ret + "L'aeroport est dans le departement : " + d.getNomDep();
            }
        }
        return ret;
    }
}
