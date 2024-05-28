package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.*;
/**
 * Controller
 */
public class Controller implements EventHandler<ActionEvent> {

	private View _view;

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
			// TODO 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


/* 
import java.net.URL;
import java.util.ResourceBundle;

public class PleaseProvideControllerClassName {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
 */
}