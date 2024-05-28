package view;
import controller.*;
import model.dao.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App extends Application {
	public void start(Stage stage){
		View _view = new View();
		
		Controller _controller = new Controller(_view);
		
		DAO d = new DAO("jdbc:mysql://localhost:3306/commune");
		_view.show();
	}
	public static void main(String[] args) {
		launch(args);

		
	}



}
