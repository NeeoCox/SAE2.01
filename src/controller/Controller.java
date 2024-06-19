package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import model.dao.*;
import model.data.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import model.dao.CommuneDAO;
import model.data.Aeroport;
import model.data.Commune;
import model.dao.DAO;
import javafx.scene.*;
import javafx.scene.paint.Color;
/**
 * Controller
 */
public class Controller {

	private static Stage stage;
	private ArrayList<Aeroport> listeAeroport;
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

	CommuneDAO _c;

	public Controller(){
		_c = new CommuneDAO();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void export(ActionEvent e){
		System.out.println("exporter");
		this.export("Donnée_Commune.csv");
	}


	public void recherche(ActionEvent e){
		if(villeAChercher == null ||villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println(a.size());
	}


	public void versPageLogin(ActionEvent e){

		System.out.println("login");
		this.changerDePage("file:../ressources/Login.fxml");

		stage.setResizable(false);
	}

	public void connecter(ActionEvent ev){
		//todo avoir des gens pour ce co
		labelIncorrect.setTextFill(Color.rgb(255, 0, 0));
		DAO.setUsername(mail.getText());
		DAO.setPwd(mdp.getText());
		Scene scene = null;
		try{
			Parent root = FXMLLoader.load(new URL("file:../ressources/Acceuil.fxml"));
			scene = new Scene(root, 536, 383);
			
		}catch(IOException ex){
			ex.printStackTrace();
			labelIncorrect.setText("problème de connection");
		}
		Stage stage= (Stage) ((Node)ev.getSource()).getScene().getWindow();

		stage.setMinWidth(798);
		stage.setMinHeight(425);
		
		stage.centerOnScreen();
		
		System.out.println("ok");
		System.out.println(mail.getText());
		System.out.println(mdp.getText());

		stage.setResizable(true);
	}

	public void versPageAccueil(ActionEvent ev){
		System.out.println("accueil");
		this.changerDePage("file:../ressources/Accueil.fxml");
		menuButton.setText("Accueil");
		stage.setResizable(true);
	}

	public void versPageCreationDeCompte(ActionEvent ev){
		System.out.println("creation");
		this.changerDePage("file:../ressources/Creation.fxml");
		stage.setResizable(true);
	}
	

	public void versPageContact(ActionEvent ev){
		System.out.println("contact");
		this.changerDePage("file:../ressources/Contact.fxml");
		menuButton.setText("Contact");
		stage.setResizable(true);
	}

	public void versPageActu(ActionEvent ev){
		System.out.println("actu");
		this.changerDePage("file:../ressources/Actualite.fxml");
		menuButton.setText("Actualité");
		stage.setResizable(true);

	}

	private void changerDePage(String url) {
		Scene scene = null;
		try{
			Parent root = FXMLLoader.load(new URL(url));
			scene = new Scene(root);
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		this.stage.setScene(scene);
		
		this.stage.centerOnScreen();
    }


	/**
	 * Exporte la base en .csv
	 * @param fileName nom du fichier à exporte
	 */
	private void export(String fileName){
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			out.print("cellule1,"); 
			out.print("cellule2"); 
 
			out.flush(); 
			out.close(); 
		
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void communeCSV(){
		String file = "communeCSV.csv";
		try(PrintWriter out = new PrintWriter(new FileWriter(file))) {
			out.println("nom;departement;adress");
			this.listeAeroport = getListeAeroport();
			for(Aeroport aeroport : listeAeroport){

			}
		}
		catch(IOException e) {
            e.printStackTrace();
        }
	}
	

}