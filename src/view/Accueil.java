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
			/*String nomImg = "C:/Users/Administrateur/Desktop/Dossier_avec_tout/BUTnfo/SAE/Gros_SAE/Java/img/pikmin.png";
			imageView = new ImageView();

			try{
				image = new Image(nomImg);
				imageView.setImage(image);
			}
			catch(Exception e){
				System.out.println(" Erreur lors du chargement " + e.getMessage());
			}*/
			

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
