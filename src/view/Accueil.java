package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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
		private GridPane pane;
		private GridPane paneBar;

		public Header(){
			pane = new GridPane();
			paneBar = new GridPane();
			paneBar.setAlignment(Pos.CENTER);
			paneBar.setHgap(5);
			imageView = new ImageView(new Image("file:../ressources/img/pikmin.png"));

			this.add(imageView,1,0);

			exportBtn = new Button("Exporter");
			searchBar = new TextField();
			searchBtn = new Button("Search");
			loginBtn = new Button("Login");

			this.add(exportBtn,1,1);
			this.add(searchBar,2,1);
			this.add(searchBtn,3,1);
			this.add(loginBtn,4,1);

			

		}

		public Button getExportBtn() {
			return exportBtn;
		}
		
	}
}
