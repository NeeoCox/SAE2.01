package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Accueil extends BorderPane {

	Header header;
	public Accueil(){
		header = new Header();
		this.setTop(header);
	}

	public Header getHeader() {
		return header;
	}


	/**
	 * Header
	 */
	public class Header extends GridPane {
		private Button exportBtn;
		private TextField searchBar;
		private Button searchBtn;
		private Button loginBtn;
		private ImageView imageView;
		private Image image;

		public Header(){
			//image = new Image(getClass().getResourceAsStream("../img/pikmin.png"));
			//imageView.setImage(image);
			exportBtn = new Button("Exporter en .csv");
			searchBar = new TextField();
			searchBtn = new Button("Search");
			loginBtn = new Button("Login");
			this.getChildren().addAll(exportBtn,searchBar,searchBtn);



		}

		public Button getExportBtn() {
			return exportBtn;
		}
		
	}
}
