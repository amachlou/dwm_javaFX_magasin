	package application;
	
	
	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.glass.events.MouseEvent;

import Login.LoginDaoImpl;
import client.ClientDaoImpl;
import client.IClientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	public class ListeProduits {
		
		ProduitHandler handler=new ProduitHandler(this);
		NouveauProduit ajoutProduit;
		ListeProduits listProduit;
		NouveauClient ajoutClient;
		ListeClients listClient;
		GestionVentes gestionVente;
		
		
		VBox root =new VBox();
		HBox hboxCenter=new HBox();
		VBox vboxCenter = new VBox();
		VBox vboxCenter2 = new VBox();
		HBox hboxTotal = new HBox();
		HBox hboxBtn = new HBox();
		HBox hboxTop=new HBox();
		HBox hboxBottom=new HBox();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		
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
		
		MenuItem newProduit;
		MenuItem listProduits;	
		MenuItem newClient;
		MenuItem listClients;	
		MenuItem helpItem;
		
		Label Produits;
		Label Clients;
		Label Ventes;
		Label Paiments;
		Label Help;
		Screen screen;
		
		Label lblTitle;
		Label lblCopyright;
		
		Label lblProduitId;
		Label lblDesignation;
		Label lblPrix;
		Label lblQte;
		Label lblDate;

		
		public Label titleInput;
		public TextField designationInput;
		public TextField prixInput;
		public TextField qteInput;
		public DatePicker dateInput;
		
		Label lblrecherche;
		public TextField rechercheInput;
		
		Button ajouterBtn;
		Button rechercheBtn;
		Button annulerBtn;
		Button modifierBtn;
		Button supprimerBtn;
		
		Label lblTotals;
		public Label lblNumTotal;
		
		Font font;
		
		private void createCompnents() {
			

			hboxCenter.setSpacing(30);

			vboxCenter.setPrefWidth(800);
			vboxCenter.setPrefHeight(700);
			vboxCenter.setSpacing(20);
			
			vboxCenter2.setPrefWidth(1100);
			vboxCenter2.setPrefHeight(700);
			vboxCenter2.setSpacing(10);
	
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);
			
			hboxTotal.setPrefHeight(70);

			hboxTop.setSpacing(650);
			
			
			menuBar=new MenuBar();
			hboxBottom.setPrefHeight(50);
			

			
			Produits= new Label("Produits");
			Clients= new Label("Clients");
			Ventes= new Label("Ventes");
			Paiments= new Label("Paiments");
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
			
			lblProduitId = new Label("Id : ");
			lblDesignation=new Label("Designation : ");
			lblPrix=new Label("Prix : ");
			lblQte=new Label("Quantité : ");
			lblDate=new Label("Date saisie : ");

			
			
			titleInput= new Label("");
			designationInput= new TextField();
			qteInput= new TextField();
			dateInput= new DatePicker();
			prixInput=new TextField();
			
			rechercheInput=new TextField();
			lblrecherche= new Label("Rechercher");
			
			rechercheBtn=new Button("Rechercher");
			annulerBtn=new Button("Annuler");
			supprimerBtn=new Button("Supprimer");
			modifierBtn=new Button("Modifier");
		    ajouterBtn = new Button("Ajouter");
			
			
			
			
			idColumn.setPrefWidth(100);
			designationColumn.setPrefWidth(400);
			prixColumn.setPrefWidth(200);
			qteColumn.setPrefWidth(140);
			dateColumn.setPrefWidth(240);
			
			
			produitList.setPrefSize( 0, 650);	
			
			produitList.getColumns().addAll(idColumn,
			designationColumn,qteColumn,prixColumn,dateColumn);
			
			produitList.setItems(produitObservableList);
			gestionVente=new GestionVentes();
			gestionVente.produitList.setItems(produitObservableList);

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

			
			lblTotals=new Label("Total : ");
			lblNumTotal =new Label("5000");

			
		}
	
		
		private void addNodestoPane() {
			
			hboxBottom.getChildren().addAll(lblCopyright);
			hboxTop.getChildren().addAll(lblTitle);
			hboxTotal.getChildren().addAll(lblTotals,lblNumTotal);
			vboxCenter2.getChildren().addAll(lblrecherche,rechercheInput,produitList);
			hboxCenter.getChildren().addAll(vboxCenter,vboxCenter2);
			hboxBtn.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
			vboxCenter.getChildren().addAll(lblProduitId,titleInput,lblDesignation,designationInput,
			lblPrix,prixInput,lblQte,qteInput,lblDate,dateInput);
			
			root.getChildren().addAll(menuBar,hboxTop,hboxCenter,hboxBtn,hboxTotal,hboxBottom);
			
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
			hboxTotal.getStyleClass().addAll("hbox","padding2","textWhite","fontListe");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().add("padding2");
			vboxCenter.getStyleClass().add("padding");
			menuBar.getStyleClass().add("menuStyle");
			
			Produits.getStyleClass().addAll("textWhite","cursor");
			Clients.getStyleClass().addAll("textWhite","cursor");
			Ventes.getStyleClass().addAll("textWhite","cursor");
			Paiments.getStyleClass().addAll("textWhite","cursor");
			Help.getStyleClass().addAll("textWhite","cursor");
			
			newProduit.getStyleClass().addAll("cursor");
			listProduits.getStyleClass().addAll("cursor");
			
			newClient.getStyleClass().addAll("cursor");
			listClients.getStyleClass().addAll("cursor");
			
			helpItem.getStyleClass().addAll("cursor");
			
			lblTitle.getStyleClass().add("titleFont");
			lblCopyright.getStyleClass().add("textWhite");
			
			lblProduitId.getStyleClass().addAll("font");
			lblDesignation.getStyleClass().addAll("font");
			lblPrix.getStyleClass().addAll("font"); 
			lblQte.getStyleClass().addAll("font"); 
			lblDate.getStyleClass().addAll("font");
			
			rechercheInput.getStyleClass().addAll("fontListe","inputFont"); 
			lblrecherche.getStyleClass().addAll("font");
			 
			titleInput.getStyleClass().addAll("font","inputFont"); 
			designationInput.getStyleClass().addAll("font","inputFont"); 
			qteInput.getStyleClass().addAll("font","inputFont");
			prixInput.getStyleClass().addAll("font","inputFont");
			dateInput.getStyleClass().addAll("font","inputFont"); 
			
			rechercheBtn.getStyleClass().addAll("font","btn","cursor"); 
			annulerBtn.getStyleClass().addAll("font","btn","cursor");
			supprimerBtn.getStyleClass().addAll("font","btn","cursor"); 
			modifierBtn.getStyleClass().addAll("font","btn","cursor");	
			ajouterBtn.getStyleClass().addAll("font","btn","cursor");
			
			lblTotals.getStyleClass().addAll("titleFont","padding");
			lblNumTotal.getStyleClass().addAll("titleFont","padding");
			
			idColumn.getStyleClass().addAll("inputFont");
			designationColumn.getStyleClass().addAll("inputFont");
			prixColumn.getStyleClass().addAll("inputFont");
			qteColumn.getStyleClass().addAll("inputFont");
			dateColumn.getStyleClass().addAll("inputFont");
			
		}
		
		private void emptyInput() {
			titleInput.setText(""); 
			designationInput.setText(""); 
			qteInput.setText(""); 
			dateInput.setValue(null);
			prixInput.setText("");
			rechercheInput.setText("");
		}
		
		
		private void addEvent() {
			newProduit.setOnAction(event ->{
				ajoutProduit= new NouveauProduit();
				window.close();
			});
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
			
			
			ajouterBtn.setOnAction(event ->{
				handler.addClick();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyInput();
				
			});
			annulerBtn.setOnAction(event ->{
				window.close();
				
			});
			
			supprimerBtn.setOnAction(event ->{
				handler.remove();
				produitList.getSelectionModel().clearSelection();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyInput();
			});
			
			modifierBtn.setOnAction(event ->{
				handler.modify();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyInput();
			});
			
			produitList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
				handler.selectItem();
			});
			
			rechercheBtn.setOnAction(event ->{
				produitList.getItems().clear();
				handler.search();
				emptyInput();
			});
	
			
		}
		
		
		public ListeProduits(){
			initWindow();
			createCompnents();
			handler.updateListProduits();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
			
		}
		
		
		
	}



