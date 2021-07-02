	package interfaces;
	
	
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
import vente.VenteHandler;

	public class ListeClients {
	
		ClientHandler clientHandler=new ClientHandler(this);
		VenteHandler venteHandler;
		
		ListeProduits listProduit;
		NouveauVente nouveauVente;
		NouveauPaiement gestionpaiements;
		NouveauPaiement nouveauPaiement;
		ListeVentes listeVentes;

		
		VBox root =new VBox();
		HBox hbox1=new HBox();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		HBox hboxBtn = new HBox();
		HBox hboxBtn1 = new HBox();
		HBox hboxTitle=new HBox();
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
		
		MenuItem listVentes;
		MenuItem listPaiements;
		MenuItem helpItem;
		
		Label Produits;
		Label Clients;
		Label Ventes;
		Label Paiments;
		Label Help;
		Screen screen;
		
		Label lblTitle;
		
		Label lblNumClient;
		Label lblNom;
		Label lblPrenom;
		Label lblTel;
		Label lblEmail;
		
		public TextField lblIdClient;
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
		
		Button ajoutVente;
		Button ventesList;
		Button nouveauFacture;
		Button listFactures;
		
		Font font;
		
		private void createCompnents() {
			
			
			hbox1.setSpacing(100);

			vbox1.setPrefWidth(900);
			vbox1.setPrefHeight(750);
			vbox1.setSpacing(20);
			
			vbox2.setPrefWidth(1100);
			vbox2.setPrefHeight(800);
			vbox2.setSpacing(10);
			
			hboxBtn1.setPrefHeight(100);
			hboxBtn1.setSpacing(20);
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);

			hboxTitle.setSpacing(650);
			
			
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
			
			listVentes=new MenuItem("Liste");

			listPaiements=new MenuItem("Liste");

			
			helpItem=new MenuItem("?");


			ventesMenu.getItems().addAll(listVentes);
				
			paimentsMenu.getItems().addAll(listPaiements);

			helpMenu.getItems().addAll(helpItem);
			
			
			lblTitle = new Label("Gestion des Clients");
			lblTitle.setTranslateX(800);
			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);

			
			lblNumClient=new Label("N° : ");
			lblNom=new Label("Nom : ");
			lblPrenom=new Label("Prenom : ");
			lblTel=new Label("Telephone : ");
			lblEmail =new Label("Email : ");
			
			lblIdClient= new TextField();
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
		    
		    ajoutVente=new Button("Nouveau Vente");
			ventesList=new Button("Liste de Ventes");
			nouveauFacture=new Button("Nouveau Paiement");
			listFactures=new Button("Liste de Paiement");
			
			
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
			
			hboxTitle.getChildren().addAll(lblTitle);
			vbox2.getChildren().addAll(lblrecherche,rechercheInput,clientList);
			hbox1.getChildren().addAll(vbox2,vbox1);
			hboxBtn1.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
			vbox1.getChildren().addAll(lblNumClient,lblIdClient,lblNom,NomInput,
			lblPrenom,PrenomInput,lblTel,TelInput,lblEmail,EmailInput,hboxBtn1);
			hboxBtn.getChildren().addAll(ajoutVente,ventesList,nouveauFacture,
		    listFactures);
			
			root.getChildren().addAll(menuBar,hboxTitle,hbox1,hboxBtn);
			
		}
		
		
		public void initWindow(){
			window.setScene(scene);
			window.setTitle("Gestion de Magasin  -  Acceuil");
			window.setMaximized(true);
			window.show();
			
		}
		
		private void addStyleToNodes(){
			scene.getStylesheets().add("css/style.css");
			hboxTitle.getStyleClass().addAll("hbox","padding");
			hboxBottom.getStyleClass().addAll("menuStyle","padding");
			
			hboxBtn1.setAlignment(Pos.CENTER_LEFT);
			hboxBtn1.getStyleClass().addAll("padding2");
			vbox1.getStyleClass().add("padding");
			hboxBtn.getStyleClass().addAll("padding2");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			menuBar.getStyleClass().add("menuStyle");
			
			Produits.getStyleClass().addAll("textWhite","cursor");
			Clients.getStyleClass().addAll("textWhite","cursor");
			Ventes.getStyleClass().addAll("textWhite","cursor");
			Paiments.getStyleClass().addAll("textWhite","cursor");
			Help.getStyleClass().addAll("textWhite","cursor");
			
			
			listVentes.getStyleClass().addAll("cursor");

			listPaiements.getStyleClass().addAll("cursor");			

			helpItem.getStyleClass().addAll("cursor");
			
			lblTitle.getStyleClass().add("titleFont");
			
			lblNumClient.getStyleClass().addAll("font");
			lblNom.getStyleClass().addAll("font");
			lblPrenom.getStyleClass().addAll("font"); 
			lblTel.getStyleClass().addAll("font"); 
			lblEmail.getStyleClass().addAll("font");
			
			rechercheInput.getStyleClass().addAll("fontListe","inputFont"); 
			lblrecherche.getStyleClass().addAll("font");
			 
			lblIdClient.getStyleClass().addAll("font","inputFont"); 
			NomInput.getStyleClass().addAll("font","inputFont"); 
			PrenomInput.getStyleClass().addAll("font","inputFont");
			TelInput.getStyleClass().addAll("font","inputFont");
			EmailInput.getStyleClass().addAll("font","inputFont"); 
			
			rechercheBtn.getStyleClass().addAll("font","btn","cursor"); 
			annulerBtn.getStyleClass().addAll("font","btn","cursor");
			supprimerBtn.getStyleClass().addAll("font","btn","cursor"); 
			modifierBtn.getStyleClass().addAll("font","btn","cursor");	
			ajouterBtn.getStyleClass().addAll("font","btn","cursor");
			
			ajoutVente.getStyleClass().addAll("font","btn","cursor","btnAction");
			ventesList.getStyleClass().addAll("font","btn","cursor","btnAction");
			nouveauFacture.getStyleClass().addAll("font","btn","cursor","btnAction");
			listFactures.getStyleClass().addAll("font","btn","cursor","btnAction");

			
		}
		
		private void emptyVal() {
			lblIdClient.setText(""); 
			NomInput.setText(""); 
			PrenomInput.setText(""); 
			TelInput.setText(""); 
			EmailInput.setText("");
			rechercheInput.setText("");
		}
		
		private void addEvent() {
			Produits.setOnMouseClicked((mouseEvent) -> {
				listProduit= new ListeProduits();
				window.close();
		    });
				
				listVentes.setOnAction(event ->{
					listeVentes =new ListeVentes();
					window.close();

				});
			
				listPaiements.setOnAction(event ->{
					

				});
				annulerBtn.setOnAction(event ->{
					window.close();
					
				});
				
			ajoutVente.setOnAction(event ->{
				nouveauVente = new NouveauVente();
				nouveauVente.id_client.setText(lblIdClient.getText());
				nouveauVente.lblClientInput.setText(NomInput.getText()+" "+PrenomInput.getText());				
				window.close();
			});
			nouveauFacture.setOnAction(event ->{
				gestionpaiements = new NouveauPaiement();
				gestionpaiements.lblIdClientVal.setText(lblIdClient.getText());
				gestionpaiements.lblClientVal.setText(NomInput.getText()+" "+PrenomInput.getText());
				gestionpaiements.numVenteList.setVisible(true);
				window.close();
			});
			ajouterBtn.setOnAction(event ->{
				clientHandler.addClick();
				clientList.getItems().clear();
				clientHandler.updateListClients();
				emptyVal();
				
			});
			annulerBtn.setOnAction(event ->{
				window.close();
				
			});
			
			supprimerBtn.setOnAction(event ->{
				clientHandler.remove();
				clientList.getSelectionModel().clearSelection();
				clientList.getItems().clear();
				clientHandler.updateListClients();
				emptyVal();
			});
			
			modifierBtn.setOnAction(event ->{
				clientHandler.modify();
				clientList.getItems().clear();
				clientHandler.updateListClients();
				emptyVal();
			});
			
			clientList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
				clientHandler.selectItem();
			});
			
			rechercheBtn.setOnAction(event ->{
				clientList.getItems().clear();
				clientHandler.search();
				emptyVal();
			});
			
			
			
		}
		
		
		public ListeClients(){
			
			initWindow();
			createCompnents();
			clientHandler.updateListClients();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}



