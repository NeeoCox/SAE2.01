package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Accueil extends BorderPane {

	private Header header;
	private Menu menu;
	public Accueil(){
		header = new Header();
		menu = new Menu();
		this.setTop(header);
		// this.setRight(menu);
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
			exportBtn = new Button("Exporter");
			searchBar = new TextField();
			searchBtn = new Button("Search");
			loginBtn = new Button("Login");
			this.add(exportBtn,1,0);
			this.add(searchBar,2,0);
			this.add(searchBtn,3,0);
			this.add(loginBtn,4,0);



		}

		public Button getExportBtn() {
			return exportBtn;
		}
		
	}
}
