package model.data;

import java.util.ArrayList;

import controller.dao.CommuneDAO;

public class Scenario {
	public static void main(String[] args) {
		
		
	}


	public static void testDAO(){
		CommuneDAO c = new CommuneDAO();
		ArrayList<Commune> a = c.voisine("22001");
		System.out.println("Commune Voisine");
		for (Commune i : a) {
			System.out.println("id: "+i.getIdCommune());	
			System.out.println("nom: "+i.getNomCommune());
			System.out.println("----");	
		}



		System.out.println("Gare");
		ArrayList<Gare> g = c.gare("56260");
		for (Gare g1 : g) {
			System.out.println("nom: "+g1.getNomGare());
		}
	}
}
