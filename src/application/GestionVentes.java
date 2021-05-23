	package application;
	
	
	import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
	import javafx.scene.control.Button;
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

	public class GestionVentes {
	
		VenteHandler handler=new VenteHandler(this);
		
		
		public ListeProduits listProduit;
		NouveauClient ajoutClient;
		ListeClients listClient;
		ProduitHandler pHandler=new ProduitHandler(listProduit);
		
		
		VBox root =new VBox();
		HBox hboxCenter=new HBox();
		VBox vboxLeft = new VBox();
		VBox vboxRight = new VBox();
		HBox hboxActions = new HBox();
//		HBox hboxBtn = new HBox();
		HBox hboxTop=new HBox();
		HBox hboxCmdBtn=new HBox();
		HBox hboxBottom=new HBox();
		GridPane grid1 = new GridPane();
		GridPane grid2 = new GridPane();
		GridPane grid3 = new GridPane();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		TableColumn<LigneCommande,Long> idCmdColumn;
		TableColumn<LigneCommande,String> designationCmdColumn;
		TableColumn<LigneCommande,Double> prixCmdColumn;
		TableColumn<LigneCommande,Integer> qteCmdColumn;
		TableColumn<LigneCommande,LocalDate> sousTotalColumn;
		
		TableView <LigneCommande> commandeList;
		
		
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
		Menu inventaireMenu;
		Menu helpMenu;
		
		MenuItem newProduit;
		MenuItem listProduits;	
		MenuItem newClient;
		MenuItem listClients;	
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
		
		Label lblCodeCmd;
		Label lblDesignation;
		Label lblPrix;
		Label lblQte;
		
		Label lblTotal;
		Label lblTotalVal;
		

		
		TextField numVenteInput;
//		TextField clientInput;
		public Label lblClientInput;
		TextField dateInput;
		
		public Label lblcodeCmd;
		TextField designationInput;
		TextField prixInput;
		TextField qteInput;
		

		
		Button ajouterBtn;
		Button rechercheBtn;
		Button annulerBtn;
		Button modifierBtn;
		Button supprimerBtn;
		
		Button ajouterCmdBtn;
		Button modifierCmdBtn;
		Button supprimerCmdBtn;
		
		Button nouveauVente;
		Button listVentes;
		Button nouveauFacture;
		Button listFactures;
		
		
		Font font;
		
		private void createCompnents() {
			
			
			hboxCenter.setSpacing(5);

			vboxLeft.setPrefWidth(1000);
			vboxLeft.setPrefHeight(780);
			vboxLeft.setSpacing(20);
			
			vboxRight.setPrefWidth(950);
			vboxRight.setPrefHeight(780);
			vboxRight.setSpacing(20);
			
//			hboxBtn.setPrefHeight(100);
//			hboxBtn.setSpacing(200);
			
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
			inventaireMenu=new Menu("");
			helpMenu=new Menu("");
			
			produitsMenu.setGraphic(Produits);
			clientsMenu.setGraphic(Clients);
			ventesMenu.setGraphic(Ventes);
			paimentsMenu.setGraphic(Paiments);
			inventaireMenu.setGraphic(Inventaire);
			helpMenu.setGraphic(Help);
			
			menuBar.getMenus().addAll(produitsMenu,clientsMenu,ventesMenu,paimentsMenu,inventaireMenu,helpMenu);
			
			
			newProduit=new MenuItem("Nouveau");
			listProduits=new MenuItem("Liste");
			
			newClient=new MenuItem("Nouveau");
			listClients=new MenuItem("Liste");
			
			helpItem=new MenuItem("?");
			
			produitsMenu.getItems().addAll(newProduit,listProduits);
			clientsMenu.getItems().addAll(newClient,listClients);
			helpMenu.getItems().addAll(helpItem);
			
			
			lblTitle = new Label("Gestion des Produits");
			
			lblCopyright= new Label("Copyright © 2021, Gestion Magasin");
			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);
			lblCopyright.setFont(font);
			lblCopyright.setTranslateX(900);
			
			lblNumVente = new Label("N°:");
			lblNomClient=new Label("Client: ");
			lblClientInput=new Label("");
			lblDate=new Label("Date:");
			
			lblCodeCmd=new Label("Code.c:");
			lblDesignation = new Label("Design:");
			lblPrix=new Label("Prix:");
			lblQte=new Label("Qte:");
			
			lblTotal = new Label("Total: ");
			lblTotalVal= new Label("69520");
			
			numVenteInput= new TextField();
			designationInput= new TextField();
			qteInput= new TextField();
			dateInput= new TextField();
			prixInput=new TextField();
			lblcodeCmd= new Label();
//			clientInput=new TextField();
		
			
			rechercheBtn=new Button("Rechercher");
			annulerBtn=new Button("Annuler");
			supprimerBtn=new Button("Supprimer");
			modifierBtn=new Button("Modifier");
		    ajouterBtn = new Button("Ajouter");
		    
		    ajouterCmdBtn= new Button("Ajouter");
			modifierCmdBtn=new Button("Modifier");
			supprimerCmdBtn=new Button("Supprimer");
		    
		    nouveauVente=new Button("Enregistrer");
			listVentes=new Button("Supprimer");
			nouveauFacture=new Button("Reglement");
			listFactures=new Button("Annuler");
			
	
			
			idColumn.setPrefWidth(100);
			designationColumn.setPrefWidth(400);
			prixColumn.setPrefWidth(200);
			qteColumn.setPrefWidth(140);
			dateColumn.setPrefWidth(240);
			
	
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
			sousTotalColumn=new TableColumn<>("Date");
			
			idCmdColumn.setPrefWidth(100);
			designationCmdColumn.setPrefWidth(400);
			prixCmdColumn.setPrefWidth(200);
			qteCmdColumn.setPrefWidth(140);
			sousTotalColumn.setPrefWidth(240);
			
			commandeList=new TableView<>();
			commandeList.setPrefSize( 0, 800);			
			commandeList.getColumns().addAll(idCmdColumn,
			designationCmdColumn,prixCmdColumn,qteCmdColumn,sousTotalColumn);
			
			grid1.add(lblNumVente, 0, 0); 
		    grid1.add(numVenteInput, 1, 0); 
		    grid1.add(lblNomClient, 0, 1);       
		    grid1.add(lblClientInput, 1, 1); 
		    grid1.add(lblDate, 0, 2);
		    grid1.add(dateInput, 1, 2);
		    
		    
		    grid2.add(lblCodeCmd, 0, 0); 
		    grid2.add(lblcodeCmd, 1, 0); 
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
//			hboxBtn.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
			hboxCmdBtn.getChildren().addAll(ajouterCmdBtn,modifierCmdBtn,supprimerCmdBtn);
			vboxRight.getChildren().addAll(grid1,grid2,hboxCmdBtn,produitList);
			vboxLeft.getChildren().addAll(grid3,commandeList);
			hboxActions.getChildren().addAll(nouveauVente,listVentes,nouveauFacture,
		    listFactures);
			
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
			
//			hboxBtn.setAlignment(Pos.CENTER_LEFT);
//			hboxBtn.getStyleClass().add("padding2");
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
			
			newProduit.getStyleClass().addAll("cursor");
			listProduits.getStyleClass().addAll("cursor");
			
			newClient.getStyleClass().addAll("cursor");
			listClients.getStyleClass().addAll("cursor");
			
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
//			TextField clientInput.getStyleClass().addAll("fontListe","inputFont"); 
			lblClientInput.getStyleClass().addAll("fontListe","inputFont");
			lblcodeCmd.getStyleClass().addAll("fontListe","inputFont");
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
			listVentes.getStyleClass().addAll("font","btn","cursor","btnAction");
			nouveauFacture.getStyleClass().addAll("font","btn","cursor","btnAction");
			listFactures.getStyleClass().addAll("font","btn","cursor","btnAction");

			
		}
		
		private void addEvent() {

			listProduits.setOnAction(event ->{
				listProduit= new ListeProduits();
				window.close();
			});
			newClient.setOnAction(event ->{
				ajoutClient= new NouveauClient();
				window.close();
			});
			listClients.setOnAction(event ->{
				listClient= new ListeClients();
				window.close();
			});
			
			
		}
		
		
		public GestionVentes(){
			
			initWindow();
			createCompnents();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}



