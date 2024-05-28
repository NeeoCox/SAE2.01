package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.dao.CommuneDAO;
import model.data.Commune;
import view.*;
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

	CommuneDAO _c;

	public Controller(){
		_c = new CommuneDAO();
	}

	public void handleSubmitButtonAction(ActionEvent e){
		System.out.println("exporter");
	}


	public void recherche(ActionEvent e){
		System.out.println("ok");
		if(villeAChercher == null ||villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println(a.size());
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