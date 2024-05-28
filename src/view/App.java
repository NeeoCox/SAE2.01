package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = getClass().getClassLoader().getResource("BasicApplication_css.fxml");
            if (fxmlLocation == null) {
                System.out.println("FXML file not found!");
            } else {
                Parent root = FXMLLoader.load(fxmlLocation);
                stage.setTitle("SAE commune bretonne");
                stage.setScene(new Scene(root, 500, 500));
                stage.show();
            }
        } catch (IOException e) {
            System.out.println("Potit probleme");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
