package view;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.*;

public class View extends Stage {

	private Scene scene;
	private Button exportBtn;
	private GridPane pane;

	public View(){
		this.init();
		pane.setAlignment(Pos.CENTER);
		pane.add(exportBtn,0,0);

		scene = new Scene(pane,250,250);
		setScene(scene);

	}

	private void init(){
		exportBtn = new Button("export");
		pane = new GridPane();
	}
	

	public Button getExportBtn() {
		return exportBtn;
	}
}
