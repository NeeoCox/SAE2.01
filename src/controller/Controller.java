package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

	public Controller(View view){
		this._view = view;
		_view.getExportBtn().setOnAction(this);
	}


	public void handle(ActionEvent e){
		if(e.getSource() == _view.getExportBtn()){
			System.out.println("export");
			// this.export();
		} 
	}



	private void export(String fileName){
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			// TODO 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}