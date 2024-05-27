package view;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class View extends Stage {

	private Scene scene;

	private GridPane pane;
	private Accueil accueil;


	public View(){
		this.init();
		/*pane.setAlignment(Pos.CENTER);
		pane.add(exportBtn,0,0);*/

		scene = new Scene(accueil,250,250);
		setScene(scene);

	}

	private void init(){
		pane = new GridPane();
		accueil = new Accueil();
	}
	
	public Accueil getAccueil() {
		return accueil;
	}

}
