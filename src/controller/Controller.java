package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.dao.CommuneDAO;
import model.data.Commune;
import view.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
/**
 * Controller
 */
public class Controller {

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

	CommuneDAO _c;

	public Controller(){
		_c = new CommuneDAO();
	}

	public void handleSubmitButtonAction(ActionEvent e){
		System.out.println("exporter");
	}


	public void recherche(ActionEvent e){
		if(villeAChercher == null ||villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println(a.size());
	}


	public void versPageLogin(ActionEvent e){
		System.out.println("login");
		Scene scene =null;
		try {
			Parent root = FXMLLoader.load(new URL("file:../ressources/Login.fxml"));
			scene= new Scene(root , 600, 500);
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
		Stage stage= (Stage) ((Node)e.getSource ()).getScene ().getWindow ();
		stage.setScene(scene);

	}

	public void connecter(ActionEvent e){
		//todo avoir des gens pour ce co
		if(!mail.getText().equals("admin") || !mdp.getText().equals("admin")) {
			labelIncorrect.setTextFill(Color.rgb(255, 0, 0));
			labelIncorrect.setText("identifiant ou mot de passe invalide");
			System.out.println("pas ok");
		}
		else System.out.println("ok");
		System.out.println(mail.getText());
		System.out.println(mdp.getText());
	}


	/**
	 * Exporte la base en .csv
	 * @param fileName nom du fichier à exporter
	 */
	private void export(String fileName){
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			
		
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


/* 

public class PleaseProvideControllerClassName {

    



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
 */
}