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
import model.dao.DAO;
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
			scene= new Scene(root);
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
		Stage stage= (Stage) ((Node)e.getSource ()).getScene ().getWindow ();
		stage.setScene(scene);

	}

	public void connecter(ActionEvent ev){
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

		stage.setMinWidth(536);
		stage.setMinHeight(383);
		stage.setMaxWidth(536);
		stage.setMaxHeight(383);

		stage.setResizable(false);

		stage.setScene(scene);
		
		stage.centerOnScreen();
		
		System.out.println("ok");
		System.out.println(mail.getText());
		System.out.println(mdp.getText());
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