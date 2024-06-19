package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.dao.DAO;

import java.io.IOException;
import java.net.URL;

import controller.Controller;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        try {
            
            Controller c = new Controller();
            System.out.println("setstage");
            c.setStage(stage);
            URL fxmlLocation = new URL("file:../ressources/Admin.fxml");
            Parent root = FXMLLoader.load(fxmlLocation);
            stage.setTitle("Commune Bretonne");
            stage.setScene(new Scene(root));
		
            stage.getIcons().add(new Image("file:../img/Logo.png"));

		    stage.centerOnScreen();


            stage.show();


        } catch (IOException e) {
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
