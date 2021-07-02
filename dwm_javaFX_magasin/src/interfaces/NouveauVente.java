package interfaces;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ligneCommande.LigneCommande;
import produit.Produit;
import produit.ProduitHandler;
import vente.VenteHandler;

public class NouveauVente {

	VenteHandler handler=new VenteHandler(this);
	ProduitHandler produitHandler=new ProduitHandler(this);
	
	ListeProduits listProduit;
	ListeClients listClient;
	NouveauPaiement nouveauPaiement;
	ListeVentes listeVentes;
	
	
	
	VBox root =new VBox();
	HBox hbox1=new HBox();
	VBox vboxL = new VBox();
	VBox vboxR = new VBox();
	HBox hboxBtn = new HBox();
	HBox hboxTitle=new HBox();
	HBox hboxCmdBtn=new HBox();
	GridPane grid1 = new GridPane();
	GridPane grid2 = new GridPane();
	GridPane grid3 = new GridPane();
	Scene scene = new Scene(root);
	Stage window =new Stage();

	
	TableColumn<LigneCommande, Long> idCmdColumn=new TableColumn<>("Id");
	TableColumn<LigneCommande, String> designationCmdColumn=new TableColumn<>("Designation");
	TableColumn<LigneCommande, Double> prixCmdColumn=new TableColumn<>("Prix");
	TableColumn<LigneCommande, Integer> qteCmdColumn=new TableColumn<>("Qte");
	TableColumn<LigneCommande, Double> sousTotalColumn=new TableColumn<>("Sous-total");
	TableColumn<LigneCommande, Long> idProduitColumn=new TableColumn<>("Id_produit");
	TableColumn<LigneCommande, Long> idVenteColumn=new TableColumn<>("Id_vente");
	
	
	public TableView <LigneCommande> commandeList=new TableView<>();
	
	public ObservableList<LigneCommande> commandeObservableList= FXCollections.observableArrayList();

	
	TableColumn<Produit, Long> idColumn=new TableColumn<>("Id");
	TableColumn<Produit, String> designationColumn=new TableColumn<>("Designation");
	TableColumn<Produit, Double> prixColumn=new TableColumn<>("Prix");
	TableColumn<Produit, Integer> qteColumn=new TableColumn<>("Qte");
	TableColumn<Produit, LocalDate> dateColumn=new TableColumn<>("Date");
	
	
	public TableView <Produit> produitList=new TableView<>();

	
	public ObservableList<Produit> produitObservableList= FXCollections.observableArrayList();

	
	MenuBar menuBar;
	Menu produitsMenu;
	Menu clientsMenu;
	Menu ventesMenu;
	Menu paimentsMenu;
	Menu helpMenu;
	
	MenuItem listVentes;
	MenuItem listPaiements;
	MenuItem helpItem;
	

	
	Label Produits;
	Label Clients;
	Label Ventes;
	Label Paiments;
	Label Inventaire;
	Label Help;
	Screen screen;
	
	Label lblTitle;
	
	Label lblNumVente;
	Label lblNomClient;
	Label lblDate;
	
	
	public Label lblCodeCmd;
	Label lblDesignation;
	Label lblPrix;
	Label lblQte;
	
	public Label id_produit=new Label();
	public TextField id_client=new TextField();

	
	
	Label lblTotal;
	public Label lblTotalVal;
	

	
	public TextField numVenteInput;
	public Label lblClientInput;
	public DatePicker dateInput;
	
	
	public TextField codeCmdInput;
	public TextField designationInput;
	public TextField prixInput;
	public TextField qteInput;
	

	
	Button ajouterBtn;
	Button rechercheBtn;
	Button annulerBtn;
	Button modifierBtn;
	Button supprimerBtn;
	
	Button ajouterCmdBtn;
	Button modifierCmdBtn;
	Button supprimerCmdBtn;
	
	Button nouveauVente;
	Button modifierVente;
	Button supprimerVente;
	Button nouveauFacture;
	Button annuler;
	
	
	Font font;
	
	private void createCompnents() {
		
		
		hbox1.setSpacing(5);

		vboxL.setPrefWidth(1000);
		vboxL.setPrefHeight(780);
		vboxL.setSpacing(20);
		
		vboxR.setPrefWidth(950);
		vboxR.setPrefHeight(780);
		vboxR.setSpacing(20);
		

		
		hboxBtn.setPrefHeight(180);
		hboxBtn.setSpacing(200);
		
		hboxCmdBtn.setSpacing(50);

		hboxTitle.setSpacing(650);
		

		menuBar=new MenuBar();
		
		Produits= new Label("Produits");
		Clients= new Label("Clients");
		Ventes= new Label("Ventes");
		Paiments= new Label("Paiments");
		Inventaire= new Label("Inventaire");
		Help= new Label("Help");
		
		produitsMenu=new Menu("");
		clientsMenu=new Menu("");
		ventesMenu=new Menu("");
		paimentsMenu=new Menu("");
		helpMenu=new Menu("");
		
		produitsMenu.setGraphic(Produits);
		clientsMenu.setGraphic(Clients);
		ventesMenu.setGraphic(Ventes);
		paimentsMenu.setGraphic(Paiments);
		helpMenu.setGraphic(Help);
		
		menuBar.getMenus().addAll(produitsMenu,clientsMenu,ventesMenu,paimentsMenu,helpMenu);
		
		
//		newProduit=new MenuItem("Nouveau");
//		listProduits=new MenuItem("Liste");
//		
//		newClient=new MenuItem("Nouveau");
//		listClients=new MenuItem("Liste");
		

		listVentes=new MenuItem("Liste");
		

		listPaiements=new MenuItem("Liste");
		
		helpItem=new MenuItem("?");
		

		ventesMenu.getItems().addAll(listVentes);		
		paimentsMenu.getItems().addAll(listPaiements);
					
		helpMenu.getItems().addAll(helpItem);
		
		
		lblTitle = new Label("Nouvelle Vente");
		lblTitle.setTranslateX(800);
		
		
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 12);

		lblNumVente = new Label("N�:");
		lblNomClient=new Label("Client: ");
		lblClientInput=new Label("");
		lblDate=new Label("Date: ");
		
		lblCodeCmd=new Label("Code.c:");
		lblDesignation = new Label("Design:");
		lblPrix=new Label("Prix:");
		lblQte=new Label("Qte:");
		
		
		lblTotal = new Label("Total: ");
		lblTotalVal= new Label("0");
		
		numVenteInput= new TextField();
		designationInput= new TextField();
		qteInput= new TextField();
		dateInput=new DatePicker();
		prixInput=new TextField();
		codeCmdInput= new TextField();

	
		
		rechercheBtn=new Button("Rechercher");
		annulerBtn=new Button("Annuler");
		supprimerBtn=new Button("Supprimer");
		modifierBtn=new Button("Modifier");
	    ajouterBtn = new Button("Ajouter");
	    
	    ajouterCmdBtn= new Button("Ajouter");
		modifierCmdBtn=new Button("Modifier");
		supprimerCmdBtn=new Button("Supprimer");
	    
	    nouveauVente=new Button("Enregistrer");
	    modifierVente=new Button("Modifier");
	    supprimerVente=new Button("Supprimer");
		nouveauFacture=new Button("Reglement");
		annuler=new Button("Annuler");
		

		
		idColumn.setPrefWidth(80);
		designationColumn.setPrefWidth(350);
		prixColumn.setPrefWidth(180);
		qteColumn.setPrefWidth(120);
		dateColumn.setPrefWidth(230);
		

		produitList.setPrefSize( 0, 450);			
		produitList.getColumns().addAll(idColumn,
		designationColumn,prixColumn,qteColumn,dateColumn);
		
		
		produitList.setItems(produitObservableList);
		
		idColumn.setCellValueFactory(
			    new PropertyValueFactory<Produit,Long>("id_produit")
			);
		designationColumn.setCellValueFactory(
			    new PropertyValueFactory<Produit,String>("designation")
			);
		qteColumn.setCellValueFactory(
			    new PropertyValueFactory<Produit,Integer>("qte")
			);
		prixColumn.setCellValueFactory(
			    new PropertyValueFactory<Produit,Double>("prix")
			);
		dateColumn.setCellValueFactory(
			    new PropertyValueFactory<Produit,LocalDate>("date")
			);
		
		
		
		idCmdColumn=new TableColumn<>("Id");
		designationCmdColumn=new TableColumn<>("Designation");
		prixCmdColumn=new TableColumn<>("Prix");
		qteCmdColumn=new TableColumn<>("Qte");
		sousTotalColumn=new TableColumn<>("Sous-Total");
		
		idCmdColumn.setPrefWidth(100);
		designationCmdColumn.setPrefWidth(330);
		prixCmdColumn.setPrefWidth(180);
		qteCmdColumn.setPrefWidth(100);
		sousTotalColumn.setPrefWidth(230);
		
		commandeList=new TableView<>();
		commandeList.setPrefSize( 0, 800);			
		commandeList.getColumns().addAll(idCmdColumn,
		designationCmdColumn,prixCmdColumn,qteCmdColumn,sousTotalColumn,idProduitColumn,idVenteColumn);
		
		
		commandeList.setItems(commandeObservableList);
		
		idCmdColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Long>("id_commande")
			);
		designationCmdColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,String>("designation")
			);
		qteCmdColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Integer>("qte")
			);
		prixCmdColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Double>("prix")
			);
		sousTotalColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Double>("sous_total")
			);
		idProduitColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Long>("id_produit")
			);
		idVenteColumn.setCellValueFactory(
			    new PropertyValueFactory<LigneCommande,Long>("id_vente")
			);
		

		grid1.add(lblNumVente, 0, 0); 
	    grid1.add(numVenteInput, 1, 0); 
	    grid1.add(lblNomClient, 0, 1);       
	    grid1.add(lblClientInput, 1, 1); 
	    grid1.add(lblDate, 0, 2);
	    grid1.add(dateInput, 1, 2);
	    
	    
	    grid2.add(lblCodeCmd, 0, 0); 
	    grid2.add(codeCmdInput, 1, 0); 
	    grid2.add(lblDesignation, 0, 1);       
	    grid2.add(designationInput, 1, 1); 
	    grid2.add(lblPrix, 0, 2);
	    grid2.add(prixInput, 1, 2);
	    grid2.add(lblQte, 0, 3);       
	    grid2.add(qteInput, 1, 3);
	    grid2.setVgap(10);
	   
	    
	    grid3.add(lblTotal, 0,0);       
	    grid3.add(lblTotalVal, 1, 0);
	    grid3.setVgap(10);
	    
	   
		
	}
	
	private void addNodestoPane() {
		
	      
		hboxTitle.getChildren().addAll(lblTitle);
		hbox1.getChildren().addAll(vboxL,vboxR);
		hboxCmdBtn.getChildren().addAll(ajouterCmdBtn,modifierCmdBtn,supprimerCmdBtn);
		vboxR.getChildren().addAll(grid1,produitList,hboxCmdBtn,grid2);
		vboxL.getChildren().addAll(grid3,commandeList);
		hboxBtn.getChildren().addAll(nouveauVente,modifierVente,supprimerVente,nouveauFacture,
	    annuler);
		
		root.getChildren().addAll(menuBar,hboxTitle,hbox1,hboxBtn);
		
	}
	
	
	public void initWindow(){
		window.setScene(scene);
		window.setTitle("Gestion de Magasin  -  Nouvelle Vente");
		window.setMaximized(true);
		window.show();
		
	}
	
	private void addStyleToNodes(){
		scene.getStylesheets().add("css/style.css");
		hboxTitle.getStyleClass().addAll("hbox","padding");
		

		vboxL.getStyleClass().add("padding");
		vboxR.getStyleClass().add("padding");
		grid1.getStyleClass().add("borderBottom");
		hboxBtn.getStyleClass().addAll("padding2");
		hboxBtn.setAlignment(Pos.CENTER_LEFT);
		menuBar.getStyleClass().add("menuStyle");
		
		Produits.getStyleClass().addAll("textWhite","cursor");
		Clients.getStyleClass().addAll("textWhite","cursor");
		Ventes.getStyleClass().addAll("textWhite","cursor");
		Paiments.getStyleClass().addAll("textWhite","cursor");
		Inventaire.getStyleClass().addAll("textWhite","cursor");
		Help.getStyleClass().addAll("textWhite","cursor");
		

		

		listVentes.getStyleClass().addAll("cursor");

		listPaiements.getStyleClass().addAll("cursor");			
		
		helpItem.getStyleClass().addAll("cursor");
		
		lblTitle.getStyleClass().add("titleFont");

		
		lblNumVente.getStyleClass().addAll("font");
		lblNomClient.getStyleClass().addAll("font");
		lblPrix.getStyleClass().addAll("font"); 
		lblQte.getStyleClass().addAll("font"); 
		lblDate.getStyleClass().addAll("font");
		lblCodeCmd.getStyleClass().addAll("font");
		lblDesignation.getStyleClass().addAll("font");
		
		lblTotal.getStyleClass().addAll("font");
		lblTotalVal.getStyleClass().addAll("font");
		 
		numVenteInput.getStyleClass().addAll("fontListe","inputFont"); 
		designationInput.getStyleClass().addAll("fontListe","inputFont"); 
		qteInput.getStyleClass().addAll("fontListe","inputFont");
		prixInput.getStyleClass().addAll("fontListe","inputFont");
		dateInput.getStyleClass().addAll("fontListe","inputFont"); 
		lblClientInput.getStyleClass().addAll("fontListe","inputFont");
		codeCmdInput.getStyleClass().addAll("fontListe","inputFont");
		designationInput.getStyleClass().addAll("fontListe","inputFont");
		
	
		
		
		
		
		rechercheBtn.getStyleClass().addAll("font","btn","cursor"); 
		annulerBtn.getStyleClass().addAll("font","btn","cursor");
		supprimerBtn.getStyleClass().addAll("font","btn","cursor"); 
		modifierBtn.getStyleClass().addAll("font","btn","cursor");	
		ajouterBtn.getStyleClass().addAll("font","btn","cursor");
		
		ajouterCmdBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
		modifierCmdBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
		supprimerCmdBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
		
		nouveauVente.getStyleClass().addAll("font","btn","cursor","btnAction");
		modifierVente.getStyleClass().addAll("font","btn","cursor","btnAction");
		supprimerVente.getStyleClass().addAll("font","btn","cursor","btnAction");
		nouveauFacture.getStyleClass().addAll("font","btn","cursor","btnAction");
		annuler.getStyleClass().addAll("font","btn","cursor","btnAction");

		
	}
	private void emptyVal() {
		
		codeCmdInput.setText(""); 
		designationInput.setText(""); 
		qteInput.setText(""); 
		prixInput.setText("");
		
	}
	
	private void addEvent() {
		
		Produits.setOnMouseClicked((mouseEvent) -> {
			listProduit= new ListeProduits();
			window.close();
	    });
		Clients.setOnMouseClicked((mouseEvent) -> {
			listClient= new ListeClients();
			window.close();
	    });
		listVentes.setOnAction(event ->{
			listeVentes =new ListeVentes();
			window.close();
		});

		listPaiements.setOnAction(event ->{
			
		});
		produitList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			produitHandler.selectItemVente();
		});
		commandeList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			handler.selectItemCmd();
		});
		ajouterCmdBtn.setOnAction(event ->{
			handler.addCommandeToTable();				
			emptyVal();
		});
		nouveauVente.setOnAction(event ->{
			handler.addVente();
			commandeList.getItems().clear();
			handler.updateListLigneCommande();

		});
		modifierCmdBtn.setOnAction(event ->{
			commandeList.getItems().clear();
			handler.modifyCmd();

		});
		supprimerCmdBtn.setOnAction(event ->{
			commandeList.getItems().clear();
			handler.removeCmd();
		});
		annulerBtn.setOnAction(event ->{
			window.close();
			
		});
		nouveauFacture.setOnAction(event ->{
			
			nouveauPaiement = new NouveauPaiement();
			nouveauPaiement.lblIdClientVal.setText(id_client.getText());
			nouveauPaiement.lblClientVal.setText(lblClientInput.getText());
			nouveauPaiement.lblNumVenteVal.setText(numVenteInput.getText());
			nouveauPaiement.lblDateVal.setText(dateInput.getValue().toString());
			nouveauPaiement.lblTotalVal.setText(lblTotalVal.getText());
			nouveauPaiement.lblResteVal.setText(lblTotalVal.getText());
			nouveauPaiement.lblNumVenteVal.setVisible(true);
			window.close();
			
		});

		
	}
	
	
	public NouveauVente(){
		
		initWindow();
		createCompnents();
		produitHandler.updateListProduitVente();
		addNodestoPane();
		addStyleToNodes();
		addEvent();
		
		
	
	}
	
	
	
}

