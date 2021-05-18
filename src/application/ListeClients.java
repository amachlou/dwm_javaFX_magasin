	package application;
	
	
	import java.time.LocalDate;

import client.Client;
import client.ClientHandler;
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

	public class ListeClients {
	
		ClientHandler handler=new ClientHandler(this);
		
		NouveauProduit ajoutProduit;
		ListeProduits listProduit;
		NouveauClient ajoutClient;
		GestionVentes gestionventes;
		GestionPaiements gestionpaiements;
		
		VBox root =new VBox();
		HBox hboxCenter=new HBox();
		VBox vboxCenter = new VBox();
		VBox vboxCenter2 = new VBox();
		HBox hboxActions = new HBox();
		HBox hboxBtn = new HBox();
		HBox hboxTop=new HBox();
		HBox hboxBottom=new HBox();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		TableColumn<Client,Long> idColumn;
		TableColumn<Client,String> nomColumn;
		TableColumn<Client,String> prenomColumn;
		TableColumn<Client,String> telColumn;
		TableColumn<Client,String> emailColumn;
		
		public TableView <Client> clientList;
		
		public ObservableList<Client> clientObservableList= FXCollections.observableArrayList();
		
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
		
		Label lblNumClient;
		Label lblNom;
		Label lblPrenom;
		Label lblTel;
		Label lblEmail;
		
		public TextField IdClientInput;
		public TextField NomInput;
		public TextField PrenomInput;
		public TextField TelInput;
		public TextField EmailInput;
		
		Label lblrecherche;
		public TextField rechercheInput;
		
		Button ajouterBtn;
		Button rechercheBtn;
		Button annulerBtn;
		Button modifierBtn;
		Button supprimerBtn;
		
		Button nouveauVente;
		Button listVentes;
		Button nouveauFacture;
		Button listFactures;
		
		Font font;
		
		private void createCompnents() {
			
			
			hboxCenter.setSpacing(100);

			vboxCenter.setPrefWidth(900);
			vboxCenter.setPrefHeight(750);
			vboxCenter.setSpacing(20);
			
			vboxCenter2.setPrefWidth(1100);
			vboxCenter2.setPrefHeight(700);
			vboxCenter2.setSpacing(10);
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);
			
			hboxActions.setPrefHeight(100);
			hboxActions.setSpacing(200);

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
			
			lblNumClient=new Label("N° : ");
			lblNom=new Label("Nom : ");
			lblPrenom=new Label("Prenom : ");
			lblTel=new Label("Telephone : ");
			lblEmail =new Label("Email : ");
			
			IdClientInput= new TextField();
			NomInput= new TextField();
			PrenomInput= new TextField();
			TelInput= new TextField();
			EmailInput= new TextField();
		
			rechercheInput=new TextField();
			lblrecherche= new Label("Rechercher");
			
			rechercheBtn=new Button("Rechercher");
			annulerBtn=new Button("Annuler");
			supprimerBtn=new Button("Supprimer");
			modifierBtn=new Button("Modifier");
		    ajouterBtn = new Button("Ajouter");
		    
		    nouveauVente=new Button("Nouveau Vente");
			listVentes=new Button("Liste de Ventes");
			nouveauFacture=new Button("Nouveau Facture");
			listFactures=new Button("Liste de Factures");
			
			
		    idColumn=new TableColumn<>("N°");
			nomColumn=new TableColumn<>("Nom");
			prenomColumn=new TableColumn<>("Prenom");
			telColumn=new TableColumn<>("Telephone");
			emailColumn=new TableColumn<>("Email");
			
			
			idColumn.setPrefWidth(100);
			nomColumn.setPrefWidth(200);
			prenomColumn.setPrefWidth(200);
			telColumn.setPrefWidth(200);
			emailColumn.setPrefWidth(350);
			
			
			clientList=new TableView<>();
			clientList.setPrefSize( 0, 700);
			clientList.getColumns().addAll(idColumn,
			nomColumn,prenomColumn,telColumn,emailColumn);
			
			clientList.setItems(clientObservableList);
			
			
			idColumn.setCellValueFactory(
				    new PropertyValueFactory<Client,Long>("id_client")
				);
			nomColumn.setCellValueFactory(
				    new PropertyValueFactory<Client,String>("nom")
				);
			prenomColumn.setCellValueFactory(
				    new PropertyValueFactory<Client,String>("prenom")
				);
			telColumn.setCellValueFactory(
				    new PropertyValueFactory<Client,String>("tel")
				);
			emailColumn.setCellValueFactory(
				    new PropertyValueFactory<Client,String>("email")
				);
			
		}
		
		private void addNodestoPane() {
			
			hboxBottom.getChildren().addAll(lblCopyright);
			hboxTop.getChildren().addAll(lblTitle);
			vboxCenter2.getChildren().addAll(lblrecherche,rechercheInput,clientList);
			hboxCenter.getChildren().addAll(vboxCenter,vboxCenter2);
			hboxBtn.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
			vboxCenter.getChildren().addAll(lblNumClient,IdClientInput,lblNom,NomInput,
			lblPrenom,PrenomInput,lblTel,TelInput,lblEmail,EmailInput);
			hboxActions.getChildren().addAll(nouveauVente,listVentes,nouveauFacture,
		    listFactures);
			
			root.getChildren().addAll(menuBar,hboxTop,hboxActions,hboxCenter,hboxBtn,hboxBottom);
			
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
			
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().add("padding2");
			vboxCenter.getStyleClass().add("padding");
			hboxActions.getStyleClass().addAll("actionColor","padding2");
			hboxActions.setAlignment(Pos.CENTER_LEFT);
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
			
			lblNumClient.getStyleClass().addAll("font");
			lblNom.getStyleClass().addAll("font");
			lblPrenom.getStyleClass().addAll("font"); 
			lblTel.getStyleClass().addAll("font"); 
			lblEmail.getStyleClass().addAll("font");
			
			rechercheInput.getStyleClass().addAll("fontListe","inputFont"); 
			lblrecherche.getStyleClass().addAll("font");
			 
			IdClientInput.getStyleClass().addAll("font","inputFont"); 
			NomInput.getStyleClass().addAll("font","inputFont"); 
			PrenomInput.getStyleClass().addAll("font","inputFont");
			TelInput.getStyleClass().addAll("font","inputFont");
			EmailInput.getStyleClass().addAll("font","inputFont"); 
			
			rechercheBtn.getStyleClass().addAll("font","btn","cursor"); 
			annulerBtn.getStyleClass().addAll("font","btn","cursor");
			supprimerBtn.getStyleClass().addAll("font","btn","cursor"); 
			modifierBtn.getStyleClass().addAll("font","btn","cursor");	
			ajouterBtn.getStyleClass().addAll("font","btn","cursor");
			
			nouveauVente.getStyleClass().addAll("font","btn","cursor","btnAction");
			listVentes.getStyleClass().addAll("font","btn","cursor","btnAction");
			nouveauFacture.getStyleClass().addAll("font","btn","cursor","btnAction");
			listFactures.getStyleClass().addAll("font","btn","cursor","btnAction");

			
		}
		
		private void emptyInput() {
			IdClientInput.setText(""); 
			NomInput.setText(""); 
			PrenomInput.setText(""); 
			TelInput.setText(""); 
			EmailInput.setText("");
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
			nouveauVente.setOnAction(event ->{
				gestionventes = new GestionVentes();
				window.close();
			});
			nouveauFacture.setOnAction(event ->{
				gestionpaiements = new GestionPaiements();
				window.close();
			});
			ajouterBtn.setOnAction(event ->{
				handler.addClick();
				clientList.getItems().clear();
				handler.updateListClients();
				emptyInput();
				
			});
			annulerBtn.setOnAction(event ->{
				window.close();
				
			});
			
			supprimerBtn.setOnAction(event ->{
				handler.remove();
				clientList.getSelectionModel().clearSelection();
				clientList.getItems().clear();
				handler.updateListClients();
				emptyInput();
			});
			
			modifierBtn.setOnAction(event ->{
				handler.modify();
				clientList.getItems().clear();
				handler.updateListClients();
				emptyInput();
			});
			
			clientList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
				handler.selectItem();
			});
			
			rechercheBtn.setOnAction(event ->{
				clientList.getItems().clear();
				handler.search();
				emptyInput();
			});
			
			
		}
		
		
		public ListeClients(){
			
			initWindow();
			createCompnents();
			handler.updateListClients();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}



