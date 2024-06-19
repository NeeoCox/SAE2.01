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
<<<<<<< HEAD
            URL fxmlLocation = new URL("file:../ressources/Accueil.fxml");
=======
            URL fxmlLocation = new URL("file:../ressources/Admin.fxml");
>>>>>>> 265b6c88ffb381d2cd660959b92990caac081c46
            Parent root = FXMLLoader.load(fxmlLocation);
            stage.setTitle("SAE commune bretonne");
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
