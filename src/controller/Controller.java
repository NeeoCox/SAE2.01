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
import model.data.Departement;
import model.data.Gare;
import model.dao.DAO;
import model.dao.DepartementDAO;
import model.dao.GareDAO;
import javafx.scene.*;
/**
 * Controller
 */
public class Controller {

	private int perm;
	private static Stage stage;
	private List<Commune> communes;
	private ArrayList<Commune> communesVoisine;
	private ArrayList<Gare> gares;
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
	DepartementDAO _d;

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
		this.exportCommune();
	}


	public void recherche(ActionEvent e){
		if(tableauAdmin != null){
		System.out.println("recherche");
		clear(tableauAdmin);
		String[] header = {"Ann\u00e9e","id Commune","id Departement","Nom","Population","Transport","Budget","Taux d'inflation","Nb maison","Nb Appart","prix moyen","prix m2 moyen","surface moyenne","depense culturelle"};
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
					String[] tab = {String.valueOf(commune.getAnnee()), String.valueOf(commune.getIdCommune()),String.valueOf(_c.getDepartement(commune.getIdCommune()).getIdDep()), String.valueOf(commune.getNomCommune()), String.valueOf(commune.getPopulation()),trans,String.valueOf(commune.getBudgetTotal()), String.valueOf(commune.getTauxInflation()),String.valueOf(commune.getNbMaison()),String.valueOf(commune.getNbAppart()),String.valueOf(commune.getPrixMoyen()),String.valueOf(commune.getPrixM2Moyen()),String.valueOf(commune.getSurfaceMoy()),String.valueOf(commune.getDepCulturelleTotal())};
					this.addDataRow(this.tableauAdmin,tab);
					
					
				}
			}
			if(this.tableauAdmin != null){ //créer la dernière ligne pour ajouter une commune
				String[] empty = new String[14];
				for (int i = 0; i < empty.length ;i++) {
					empty[i] = "";
				}
				this.addDataRow(this.tableauAdmin,empty);
				
			}

		}
	}
	}

	public void modifier(ActionEvent ev) {
        System.out.println("modifier : " + this.modificationEnCours);

		System.out.println("taille tableauA " +tableauA.size());
		if (!modificationEnCours) {
			for (int i = 0; i < tableauA.size(); i += 14) {
				System.out.println("for tableaA");
           
                boolean filled = true;
                for (int j = i; j < i + 1; j++) {
                    if (tableauA.get(j).getText().equals("")) filled = false;
                }
                if (filled) {
					System.out.println("i="+i+" i ==" +(i == tableauA.size() - 14));
                    if (i == tableauA.size() - 14) {
						Commune c = this.createNewFullCommune(i);
						Departement d = new Departement(i);
                        System.out.println("create"+c.getIdCommune());
                        _c.create(c,d);
                    } else {
                        _c.update(this.createNewFullCommune(i));
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
					Departement d = new Departement(BUTTON_INDEX*15+2);
                    _c.create(this.createNewFullCommune(BUTTON_INDEX * 15),d);
                } else {
                    _c.delete(this.createNewFullCommune(BUTTON_INDEX * 15));
                }
            });
        }

		if (!modificationEnCours) 
        	tableauA.clear();
		this.recherche(ev);
		System.out.println("modieifation qui change ete :" + this.modificationEnCours);
		this.modificationEnCours = !this.modificationEnCours;
		System.out.println("maintenatn :" + this.modificationEnCours);
        
        
    }

	private Commune createNewFullCommune(int i){
		String nom = tableauA.get(i+3).getText();
		int[] integeri = {i,i+1,i+2,i+4,i+8,i+9};
		int[] floatsi = {i+6,i+7,i+10,i+11,i+12,i+13};
		int[] integer = new int[integeri.length];
		float[] floats = new float[floatsi.length];
		for (int j = 0; j < integer.length;j++) {
			System.out.println("internet : "+tableauA.get(integeri[j]).getText());
			integer[j] = Integer.parseInt(tableauA.get(integeri[j]).getText());
		}
		for (int j = 0; j < floats.length;j++) {
			System.out.println("flaotes : "+tableauA.get(floatsi[j]).getText());
			floats[j] = Float.parseFloat(tableauA.get(floatsi[j]).getText());
		}

		return new Commune(integer[1], nom, integer[0], floats[1], integer[3], integer[4], floats[4], floats[3], floats[5], floats[1], floats[0], integer[3]);
	}

	private void addDataRow(GridPane tab, boolean header, String[] info) {
		int rowIndex = tab.getRowCount();
	
		if (!this.modificationEnCours && !header) {
			for (int i = 0; i < info.length; i++) {
				TextField t = new TextField(info[i]);
				tableauA.add(t);
				tab.add(t, i, rowIndex);
			}
	
			if (info.length > 0 && info[0].isEmpty()) {
				Button addButton = new Button("Add");
				addButton.setOnAction(event -> addNewCommune());
				tab.add(addButton, 14, rowIndex);
			} else {
				Button b = new Button("Delete");
                b.setOnAction(event -> {
                    int index = (rowIndex - 1) * 14; // Calculate the correct index based on rowIndex
                    Commune communeToDelete = createNewFullCommune(index);
                    _c.delete(communeToDelete);
                    recherche(new ActionEvent()); // Refresh the grid
                });
                tab.add(b, 14, rowIndex);
                buttonDel.add(b);
			}
		} else {
			buttonDel.clear();
			for (int i = 0; i < info.length; i++) {
				Label t = new Label(info[i]);
				tab.add(t, i, rowIndex);
			}
		}
	}

	
	private void addNewCommune() {
		int rowIndex = tableauA.size() / 14 - 1; // Calculate the index of the last row
		Commune newCommune = createNewFullCommune(rowIndex * 14);
		Departement newDepartement = new Departement(newCommune.getIdCommune());
		_c.create(newCommune, newDepartement);
		this.recherche(new ActionEvent());
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
			exportCommune();
			
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

	private void exportCommune(){
		String file = "communeData.csv";
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            // Write CSV header
            out.println("idCommune;nomCommune;annee;taux;nbMaison;nbAppart;prixM2Moyen;prixMoyen;surface;depCulturelleTotal;bugdet;population;listeVoisine;listeGare");
			this.communes = _c.findAll();
			
			String gareList ="";
			String comList ="";

            for (Commune commune : this.communes) {
				gareList = "";
				comList ="";

				this.gares = _g.gare(commune.getIdCommune());
				this.communesVoisine = commune.getListeVoisine();

				for(Gare gare : this.gares){
					gareList = gareList + gare.getCodeGare() + " | ";
				}
				for(Commune communeV : this.communesVoisine){
					comList = comList + communeV.getIdCommune()+ " | ";
				}
                out.println(commune.getIdCommune() + ";" +
							commune.getNomCommune() + ";" +
							commune.getAnnee() + ";" +
							commune.getTauxInflation() + ";" +
							commune.getNbMaison() + ";" +
							commune.getNbAppart() + ";" +
							commune.getPrixM2Moyen() + ";" +
							commune.getPrixMoyen() + ";" +
							commune.getSurfaceMoy() + ";" +
							commune.getDepCulturelleTotal() + ";" +
							commune.getBudgetTotal() + ";" +
							commune.getPopulation() + ";" +
							comList + ";" +
							gareList);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}