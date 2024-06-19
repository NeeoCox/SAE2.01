package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import controller.model.dao.DAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.*;
/**
 * Controller
 */
public class Controller implements EventHandler<ActionEvent> {

	private View _view;
	private DAO _dao;

	public Controller(View view){
		this._view = view;
		_view.getAccueil().getHeader().getExportBtn().setOnAction(this);
	}


	public void handle(ActionEvent e){
		if(e.getSource() == _view.getAccueil().getHeader().getExportBtn()){
			System.out.println("export");
			// this.export();
		} 


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
}