package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.dao.CommuneDAO;

import java.io.IOException;
import java.net.URL;

import controller.Controller;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = new URL("file:../ressources/Acceuil.fxml");
            Parent root = FXMLLoader.load(fxmlLocation);
            stage.setTitle("SAE commune bretonne");
            stage.setScene(new Scene(root));
		
		    stage.centerOnScreen();

            stage.setMinWidth(798);
		    stage.setMinHeight(425);

            stage.show();

        } catch (IOException e) {
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // CommuneDAO c = new CommuneDAO();
        // c.findAll("");
        launch(args);
    }
}
