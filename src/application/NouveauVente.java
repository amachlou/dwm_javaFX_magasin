package application;


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
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import produit.Produit;
import produit.ProduitHandler;
import vente.LigneCommande;
import vente.VenteHandler;

public class NouveauVente {

	VenteHandler handler=new VenteHandler(this);
	ProduitHandler produitHandler=new ProduitHandler(this);
	
	ListeProduits listProduit;
	ListeClients listClient;
	NouveauPaiement nouveauPaiement;
	ListeVentes listeVentes;
	
	
	
	VBox root =new VBox();
	HBox hboxCenter=new HBox();
	VBox vboxLeft = new VBox();
	VBox vboxRight = new VBox();
	HBox hboxActions = new HBox();
//	HBox hboxBtn = new HBox();
	HBox hboxTop=new HBox();
	HBox hboxCmdBtn=new HBox();
	HBox hboxBottom=new HBox();
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
	
//	MenuItem newProduit;
//	MenuItem listProduits;	
//	MenuItem newClient;
//	MenuItem listClients;	
	MenuItem newVente;
	MenuItem listVentes;
	MenuItem newPaiement;
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
	Label lblCopyright;
	
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
//	TextField clientInput;
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
	Button supprimerVente;
	Button nouveauFacture;
	Button annuler;
	
	
	Font font;
	
	private void createCompnents() {
		
		
		hboxCenter.setSpacing(5);

		vboxLeft.setPrefWidth(1000);
		vboxLeft.setPrefHeight(780);
		vboxLeft.setSpacing(20);
		
		vboxRight.setPrefWidth(950);
		vboxRight.setPrefHeight(780);
		vboxRight.setSpacing(20);
		
//		hboxBtn.setPrefHeight(100);
//		hboxBtn.setSpacing(200);
		
		hboxActions.setPrefHeight(80);
		hboxActions.setSpacing(200);
		
		hboxCmdBtn.setSpacing(50);

		hboxTop.setSpacing(650);
		hboxBottom.setPrefHeight(50);
		

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
		
		newVente=new MenuItem("Nouveau");
		listVentes=new MenuItem("Liste");
		
		newPaiement=new MenuItem("Nouveau");
		listPaiements=new MenuItem("Liste");
		
		helpItem=new MenuItem("?");
		
//		produitsMenu.getItems().addAll(newProduit,listProduits);
//		clientsMenu.getItems().addAll(newClient,listClients);

		ventesMenu.getItems().addAll(newVente,listVentes);		
		paimentsMenu.getItems().addAll(newPaiement,listPaiements);
					
		helpMenu.getItems().addAll(helpItem);
		
		
		lblTitle = new Label("Nouveau Vente");
		
		lblCopyright= new Label("Copyright © 2021, Gestion Magasin");
		
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 12);
		lblCopyright.setFont(font);
		lblCopyright.setTranslateX(900);
		
		lblNumVente = new Label("N°:");
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
//		clientInput=new TextField();
	
		
		rechercheBtn=new Button("Rechercher");
		annulerBtn=new Button("Annuler");
		supprimerBtn=new Button("Supprimer");
		modifierBtn=new Button("Modifier");
	    ajouterBtn = new Button("Ajouter");
	    
	    ajouterCmdBtn= new Button("Ajouter");
		modifierCmdBtn=new Button("Modifier");
		supprimerCmdBtn=new Button("Supprimer");
	    
	    nouveauVente=new Button("Enregistrer");
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
		
	      
		hboxBottom.getChildren().addAll(lblCopyright);
		hboxTop.getChildren().addAll(lblTitle);
		hboxCenter.getChildren().addAll(vboxRight,vboxLeft);
//		hboxBtn.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
		hboxCmdBtn.getChildren().addAll(ajouterCmdBtn,modifierCmdBtn,supprimerCmdBtn);
		vboxRight.getChildren().addAll(grid1,grid2,hboxCmdBtn,produitList);
		vboxLeft.getChildren().addAll(grid3,commandeList);
		hboxActions.getChildren().addAll(nouveauVente,supprimerVente,nouveauFacture,
	    annuler);
		
		root.getChildren().addAll(menuBar,hboxTop,hboxActions,hboxCenter,hboxBottom);
		
	}
	
	
	public void initWindow(){
		window.setScene(scene);
		window.setTitle("Gestion de Magasin  -  Acceuil");
		window.getIcons().add(new Image("css/logo_icon.png"));
		window.setMaximized(true);
		window.show();
		
	}
	
	private void addStyleToNodes(){
		scene.getStylesheets().add("css/application.css");
		hboxTop.getStyleClass().addAll("hbox","padding");
		hboxBottom.getStyleClass().addAll("menuStyle","padding");
		
//		hboxBtn.setAlignment(Pos.CENTER_LEFT);
//		hboxBtn.getStyleClass().add("padding2");
		vboxLeft.getStyleClass().add("padding");
		vboxRight.getStyleClass().add("padding");
		grid1.getStyleClass().add("borderBottom");
		hboxActions.getStyleClass().addAll("actionColor","padding2");
		hboxActions.setAlignment(Pos.CENTER_LEFT);
		menuBar.getStyleClass().add("menuStyle");
		
		Produits.getStyleClass().addAll("textWhite","cursor");
		Clients.getStyleClass().addAll("textWhite","cursor");
		Ventes.getStyleClass().addAll("textWhite","cursor");
		Paiments.getStyleClass().addAll("textWhite","cursor");
		Inventaire.getStyleClass().addAll("textWhite","cursor");
		Help.getStyleClass().addAll("textWhite","cursor");
		
//		newProduit.getStyleClass().addAll("cursor");
//		listProduits.getStyleClass().addAll("cursor");
//		
//		newClient.getStyleClass().addAll("cursor");
//		listClients.getStyleClass().addAll("cursor");
		
		newVente.getStyleClass().addAll("cursor");
		listVentes.getStyleClass().addAll("cursor");
		
		newPaiement.getStyleClass().addAll("cursor");
		listPaiements.getStyleClass().addAll("cursor");			
		
		helpItem.getStyleClass().addAll("cursor");
		
		lblTitle.getStyleClass().add("titleFont");
		lblCopyright.getStyleClass().add("textWhite");

		
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
//		TextField clientInput.getStyleClass().addAll("fontListe","inputFont"); 
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
		supprimerVente.getStyleClass().addAll("font","btn","cursor","btnAction");
		nouveauFacture.getStyleClass().addAll("font","btn","cursor","btnAction");
		annuler.getStyleClass().addAll("font","btn","cursor","btnAction");

		
	}
	private void emptyInput() {
		
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
		newPaiement.setOnAction(event ->{
			nouveauPaiement=new NouveauPaiement();
			window.close();

		});
		listPaiements.setOnAction(event ->{
			
		});
//		listProduits.setOnAction(event ->{
//			listProduit= new ListeProduits();
//			window.close();
//		});
//		newClient.setOnAction(event ->{
//			ajoutClient= new NouveauClient();
//			window.close();
//		});
//		listClients.setOnAction(event ->{
//			listClient= new ListeClients();
//			window.close();
//		});
		produitList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			produitHandler.selectItemVente();
		});
		commandeList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			handler.selectItemCmd();
		});
		ajouterCmdBtn.setOnAction(event ->{
			handler.addCommandeToTable();				
			emptyInput();
		});
		nouveauVente.setOnAction(event ->{
			handler.addVente();
			commandeList.getItems().clear();
			handler.updateListLigneCommande();

		});
		modifierCmdBtn.setOnAction(event ->{
			commandeList.getItems().clear();
			handler.modify();

		});
		supprimerCmdBtn.setOnAction(event ->{
			commandeList.getItems().clear();
			handler.remove();

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

