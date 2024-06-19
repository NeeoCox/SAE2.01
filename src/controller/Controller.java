package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import model.dao.CommuneDAO;
import model.data.Commune;
import model.data.Gare;
import model.dao.DAO;
import model.dao.GareDAO;
import javafx.scene.*;
/**
 * Controller
 */
public class Controller {

	private int perm;
	private static Stage stage;
	@FXML
	private Button exporter;
	@FXML
	TextField villeAChercher;
	@FXML
	Button recherche;
	@FXML
	Button connexion;
	@FXML
	TextField mail;
	@FXML
	TextField mdp;
	@FXML
	Label labelIncorrect;
	@FXML
	MenuButton menuButton;
	@FXML
    private GridPane tableauAdmin;
	boolean modificationEnCours;
	List<TextField> tableauA;
	List<Button> buttonDel;

	CommuneDAO _c;
	GareDAO _g;

	public Controller(){
		this.perm = -1;
		_c = new CommuneDAO();
		_g = new GareDAO();
		modificationEnCours = false;
		tableauA = new ArrayList<TextField>();
		buttonDel = new ArrayList<Button>();
	}

	public void setStage(Stage stage) {
		Controller.stage = stage;
	}

	public void export(ActionEvent e){
		System.out.println("exporter");
		// this.export();
	}


	public void recherche(ActionEvent e){
		
		System.out.println("recherche");
		clear(tableauAdmin);
		String[] header = {"Ann\u00e9e","id Commune","Nom","Population","Transport","Budget","Taux d'inflation","Nb maison","Nb Appart","prix moyen","prix m2 moyen","surface moyenne","depense culturelle"};
		this.addDataRow(tableauAdmin,true, header);
		if(villeAChercher == null || villeAChercher.getText().length() == 0) throw new IllegalArgumentException("Bar de recherche vide");
		ArrayList<Commune> a = _c.find(villeAChercher.getText().toUpperCase());
		System.out.println("Taille recherche ="+a.size());
		if(a.size() > 0){
			for (Commune commune : a) { // créer toutes les lignes
				commune.setListeGare(_g.gare(commune.getIdCommune()));
				String trans = "";
				boolean estFret = false;
				boolean estVoyageur = false;
				ArrayList<Gare> g = commune.getListeGare();
				for (Gare gare : g) {
					if(gare.getEstFret()) estFret = true; 
					if(gare.getEstVoyageur()) estVoyageur = true;
				}
				if(!estFret && !estVoyageur) trans = "non";
				if(estFret) trans = "fret";
				if(estFret && estVoyageur) trans += " ";
				if(estVoyageur) trans += "voyageur";

				
				if(this.tableauAdmin != null){
					String[] tab = {String.valueOf(commune.getAnnee()), String.valueOf(commune.getIdCommune()), String.valueOf(commune.getNomCommune()), String.valueOf(commune.getPopulation()),trans,String.valueOf(commune.getBudgetTotal()), String.valueOf(commune.getTauxInflation()),String.valueOf(commune.getNbMaison()),String.valueOf(commune.getNbAppart()),String.valueOf(commune.getPrixMoyen()),String.valueOf(commune.getPrixM2Moyen()),String.valueOf(commune.getSurfaceMoy()),String.valueOf(commune.getDepCulturelleTotal())};
					this.addDataRow(this.tableauAdmin,tab);
					
					
				}
			}
			if(this.tableauAdmin != null){ //créer la dernière ligne pour ajouter une commune
				String[] empty = new String[13];
				for (int i = 0; i < empty.length ;i++) {
					empty[i] = "";
				}
				this.addDataRow(this.tableauAdmin,empty);
				
			}

		}
	}

	public void modifier(ActionEvent ev) {
        System.out.println("modifier" + this.modificationEnCours);

        for (int i = 0; i < tableauA.size(); i += 13) {
            if (modificationEnCours) {
                boolean filled = true;
                for (int j = i; j < i + 13; j++) {
                    if (tableauA.get(j).getText().equals("")) filled = false;
                }
                if (filled) {

                    if (i == tableauA.size() - 13) {
                        // _c.create(this.createNewFullCommune(i));
                        System.out.println("create");
                    } else {
                        // _c.update(this.createNewFullCommune(i));
                        System.out.println("update");
                    }
                }
            }
        }

        for (int j = 0; j < buttonDel.size(); j++) {
            final int BUTTON_INDEX = j;
            buttonDel.get(j).setOnAction(event -> {
                System.out.println(buttonDel.get(BUTTON_INDEX).getText() + " was clicked! " + BUTTON_INDEX);
                if (BUTTON_INDEX == buttonDel.size() - 1) {
                    _c.create(this.createNewFullCommune(BUTTON_INDEX * 13));
                } else {
                    _c.delete(this.createNewFullCommune(BUTTON_INDEX * 13));
                }
            });
        }

        tableauA.clear();
        this.modificationEnCours = !this.modificationEnCours;
        this.recherche(ev);
    }

	private Commune createNewFullCommune(int i){
		String nom = tableauA.get(i+2).getText();
		System.out.println(nom);
		int[] integer = {Integer.parseInt(tableauA.get(i+1).getText()),Integer.parseInt(tableauA.get(i).getText()),Integer.parseInt(tableauA.get(i+7).getText()),Integer.parseInt(tableauA.get(i+8).getText())};
		System.out.println(Arrays.toString(integer));
		float[] floats = {Float.parseFloat(tableauA.get(i+6).getText()),Float.parseFloat(tableauA.get(i+9).getText()),Float.parseFloat(tableauA.get(i+10).getText()),Float.parseFloat(tableauA.get(i+11).getText()),Float.parseFloat(tableauA.get(i+12).getText()),Float.parseFloat(tableauA.get(i+5).getText()),Float.parseFloat(tableauA.get(i+3).getText())};
		System.out.println(Arrays.toString(floats));

		return new Commune(integer[0], nom, integer[1], floats[0], integer[2], integer[3], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6]);
	}

	private void addDataRow(GridPane tab,boolean header,String[] info) {
        int rowIndex = tab.getRowCount();

        if(this.modificationEnCours && !header){
			for (int i = 0; i < info.length; i++) {
				TextField t = new TextField(info[i]);
				tableauA.add(t);
				tab.add(t, i, rowIndex);
			}
			Button b = new Button("Delete");
			tab.add(b, 13, rowIndex);
			buttonDel.add(b);
		}else{
			buttonDel.clear();
			for (int i = 0; i < info.length; i++) {
				Label t = new Label(info[i]);
				tab.add(t, i, rowIndex);
			}
		}


    }

	private void addDataRow(GridPane tab, String[] info){
		this.addDataRow(tab, false, info);
	}


	public void versPageLogin(ActionEvent e){
		
		System.out.println("login");
		this.changerDePage("file:../ressources/Login.fxml");

	}

	public void connecter(ActionEvent ev){
		DAO.setUsername(mail.getText());
		DAO.setPwd(mdp.getText());
		
		this.setPerm(mail.getText(),mdp.getText());

		if(perm > 0)
			this.versPageAdmin(ev);
		else
			this.versPageGuest(ev);
		System.out.println(mail.getText());
		System.out.println(mdp.getText());
	}

	private void setPerm(String mail, String passwd){
		if(mail.equals("root") && passwd.equals("root")) this.perm = 1;
	}

	public void versPageAccueil(ActionEvent ev){
		System.out.println("accueil");
		this.changerDePage("file:../ressources/Accueil.fxml");
	}

	public void versPageCreation(ActionEvent ev){
		System.out.println("creation");
		this.changerDePage("file:../ressources/Creation.fxml");
	}

	public void versPageAdmin(ActionEvent ev){
		System.out.println("admin");
		this.changerDePage("file:../ressources/Admin.fxml");
	}

	public void versPageGuest(ActionEvent ev){
		System.out.println("admin");
		this.changerDePage("file:../ressources/Guest.fxml");
	}

	public void versPageContact(ActionEvent ev){
		System.out.println("contact");
		this.changerDePage("file:../ressources/Contact.fxml");
	}

	public void versPageActu(ActionEvent ev){
		System.out.println("actu");
		this.changerDePage("file:../ressources/Actualite.fxml");

	}

	private void changerDePage(String url) {
		try {
			FXMLLoader loader = new FXMLLoader(new URL(url));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Controller.stage.setScene(scene);
			Controller.stage.centerOnScreen();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Exporte la base en .csv
	 * @param fileName nom du fichier à exporter
	 */
	private void export(String fileName){
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			_c.findAll();
		
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void clear(GridPane gridPane) {
		List<Node> firstRowNodes = gridPane.getChildren().stream()
			.filter(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 0)
			.collect(Collectors.toList());
	
		gridPane.getChildren().clear();

		gridPane.getChildren().addAll(firstRowNodes);
	}

}