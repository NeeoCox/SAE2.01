package view;
import controller.*;
import model.dao.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	public void start(Stage stage){
		View _view = new View();
		Controller _controller = new Controller(_view);

		_view.show();
	}

	public static void main(String[] args) {
		DAO d = new DAO();
		d.query();

		//launch(args);
	}
}
