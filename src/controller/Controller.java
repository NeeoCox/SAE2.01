package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import model.dao.CommuneDAO;
import model.data.Commune;
import model.dao.DAO;
import javafx.scene.*;
import javafx.scene.paint.Color;
/**
 * Controller
 */
public class Controller {

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

	CommuneDAO _c;

	public Controller(){
		_c = new CommuneDAO();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void export(ActionEvent e){
		System.out.println("exporter");
		// this.export();
	}


	public void recherche(ActionEvent e){
		if(villeAChercher == null ||villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println(a.size());
	}


	public void versPageLogin(ActionEvent e){
		
		System.out.println("login");
		this.changerDePage("file:../ressources/Login.fxml");

	}

	public void connecter(ActionEvent ev){
		DAO.setUsername(mail.getText());
		DAO.setPwd(mdp.getText());
		this.versPageAccueil(ev);
		
		System.out.println("ok");
		System.out.println(mail.getText());
		System.out.println(mdp.getText());
	}


	public void versPageAccueil(ActionEvent ev){
		System.out.println("accueil");
		this.changerDePage("file:../ressources/Accueil.fxml");
		menuButton.setText("Accueil");
	}

	public void versPageCreationDeCompte(ActionEvent ev){
		System.out.println("creation");
		this.changerDePage("file:../ressources/Creation.fxml");
	}
	

	public void versPageContact(ActionEvent ev){
		System.out.println("contact");
		this.changerDePage("file:../ressources/Contact.fxml");
		menuButton.setText("Contact");
	}

	public void versPageActu(ActionEvent ev){
		System.out.println("actu");
		this.changerDePage("file:../ressources/Actualite.fxml");
		menuButton.setText("Actualité");

	}

	private void changerDePage(String url) {
		Scene scene = null;
		try{
			Parent root = FXMLLoader.load(new URL(url));
			scene = new Scene(root);
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		this.stage.setResizable(false);
		this.stage.setScene(scene);
		
		this.stage.centerOnScreen();
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

}