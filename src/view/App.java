package view;
import java.io.IOException;

import controller.*;
import model.dao.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/BasicApplication_css.fxml"));
			stage.setTitle("SAE commune bretonne");
			stage.setScene(new Scene(root, 500,500));
			stage.show();
		}
		catch(IOException e){
			
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);

		
	}
}
