package view;
import controller.*;
import model.dao.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App extends Application {
	public void start(Stage stage){
		View _view = new View();
		
		Controller _controller = new Controller(_view);
		
		Scenario.testDAO();

		
		
		_view.show();
	}
	public static void main(String[] args) {
		launch(args);

		
	}



}
