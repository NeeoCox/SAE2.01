package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import model.dao.CommuneDAO;
import model.data.Commune;
import model.data.Gare;
import model.dao.DAO;
import model.dao.GareDAO;
import javafx.scene.*;
/**
 * Controller
 */
public class Controller {

	private int perm;
	private static Stage stage;
	@FXML
	private Button exporter;
	@FXML
	TextField villeAChercher;
	@FXML
	Button recherche;
	@FXML
	Button connexion;
	@FXML
	TextField mail;
	@FXML
	TextField mdp;
	@FXML
	Label labelIncorrect;
	@FXML
	MenuButton menuButton;
	@FXML
    private GridPane tableauAdmin;

	CommuneDAO _c;
	GareDAO _g;

	public Controller(){
		this.perm = -1;
		_c = new CommuneDAO();
		_g = new GareDAO();
	}

	public void setStage(Stage stage) {
		Controller.stage = stage;
	}

	public void export(ActionEvent e){
		System.out.println("exporter");
		// this.export();
	}


	public void recherche(ActionEvent e){
		
		System.out.println("recherche");
		clear(tableauAdmin);
		this.addDataRow(tableauAdmin, "Nom de la ville", "Ann\u00e9e", "Nb Habitant", "Transport", "Budget");
		if(villeAChercher == null || villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println("Taille recherche ="+a.size());
		if(a.size() > 0){
			for (Commune commune : a) {
				commune.setListeGare(_c.gare(commune.getIdCommune()));
				String trans = "";
				boolean estFret = false;
				boolean estVoyageur = false;
				ArrayList<Gare> g = commune.getListeGare();
				for (Gare gare : g) {
					if(gare.getEstFret()) estFret = true; 
					if(gare.getEstVoyageur()) estVoyageur = true;
				}
				if(!estFret && !estVoyageur) trans = "non";
				if(estFret) trans = "fret";
				if(estFret && estVoyageur) trans += " ";
				if(estVoyageur) trans += "voyageur";

				
				if(this.tableauAdmin != null)
					this.addDataRow(this.tableauAdmin,String.valueOf(commune.getNomCommune()), String.valueOf(commune.getAnnee()), String.valueOf(commune.getPopulation()), trans,String.valueOf(commune.getBudgetTotal()));
			}
		}
	}

	private void addDataRow(GridPane tab,String nomVille, String annee, String nbHabitant, String transport,String budget) {
        int rowIndex = tab.getRowCount();
        
        tab.add(new Label(nomVille), 0, rowIndex);
        tab.add(new Label(annee), 1, rowIndex);
        tab.add(new Label(nbHabitant), 2, rowIndex);
        tab.add(new Label(transport), 3, rowIndex);
        tab.add(new Label(budget), 4, rowIndex);
    }

	public void versPageLogin(ActionEvent e){
		
		System.out.println("login");
		this.changerDePage("file:../ressources/Login.fxml");

	}

	public void connecter(ActionEvent ev){
		DAO.setUsername(mail.getText());
		DAO.setPwd(mdp.getText());
		
		this.setPerm(mail.getText(),mdp.getText());

		if(perm > 0)
			this.versPageAdmin(ev);
		else
			this.versPageGuest(ev);
		System.out.println(mail.getText());
		System.out.println(mdp.getText());
	}

	private void setPerm(String mail, String passwd){
		if(mail.equals("root") && passwd.equals("root")) this.perm = 1;
	}

	public void versPageAccueil(ActionEvent ev){
		System.out.println("accueil");
		this.changerDePage("file:../ressources/Accueil.fxml");
	}

	public void versPageCreation(ActionEvent ev){
		System.out.println("creation");
		this.changerDePage("file:../ressources/Creation.fxml");
	}

	public void versPageAdmin(ActionEvent ev){
		System.out.println("admin");
		this.changerDePage("file:../ressources/Admin.fxml");
	}
	public void versPageGuest(ActionEvent ev){
		System.out.println("admin");
		this.changerDePage("file:../ressources/Guest.fxml");
	}

	public void versPageContact(ActionEvent ev){
		System.out.println("contact");
		this.changerDePage("file:../ressources/Contact.fxml");
	}

	public void versPageActu(ActionEvent ev){
		System.out.println("actu");
		this.changerDePage("file:../ressources/Actualite.fxml");

	}

	private void changerDePage(String url) {
		try {
			FXMLLoader loader = new FXMLLoader(new URL(url));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Controller.stage.setScene(scene);
			Controller.stage.setResizable(false);
			Controller.stage.centerOnScreen();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Exporte la base en .csv
	 * @param fileName nom du fichier à exporte
	 */
	private void export(String fileName){
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			
		
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void clear(GridPane gridPane) {
    
    List<Node> firstRowNodes = gridPane.getChildren().stream()
        .filter(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 0)
        .collect(Collectors.toList());
   
    gridPane.getChildren().clear();

    gridPane.getChildren().addAll(firstRowNodes);
}
}