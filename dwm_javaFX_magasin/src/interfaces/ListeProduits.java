	package interfaces;
	
	
	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.glass.events.MouseEvent;

import User.LoginDaoImpl;
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
		ListeProduits listProduit;
		ListeClients listClient;
		NouveauVente nouveauVente;
		NouveauPaiement nouveauPaiement;
		ListeVentes listeVentes;
		
		
		VBox root =new VBox();
		HBox hbox1=new HBox();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		HBox hbox2 = new HBox();
		HBox hboxBtn = new HBox();
		HBox hboxTitle=new HBox();
		
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
		
		Label lblProduitId;
		Label lblDesignation;
		Label lblPrix;
		Label lblQte;
		Label lblDate;

		
		public TextField  titleInput;
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
			

			hbox1.setSpacing(30);

			vbox1.setPrefWidth(800);
			vbox1.setPrefHeight(700);
			vbox1.setSpacing(20);
			
			vbox2.setPrefWidth(1100);
			vbox2.setPrefHeight(700);
			vbox2.setSpacing(10);
	
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(20);
			
			hbox2.setPrefHeight(70);

			hboxTitle.setSpacing(650);
			
			
			menuBar=new MenuBar();			

			
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
			
			

			listPaiements=new MenuItem("Liste");
			
			listVentes=new MenuItem("Liste");
			
			
			helpItem=new MenuItem("?");
			

			
			ventesMenu.getItems().addAll(listVentes);
			
			paimentsMenu.getItems().addAll(listPaiements);
			
			helpMenu.getItems().addAll(helpItem);
			
			
			lblTitle = new Label("Gestion des Produits");
			lblTitle.setTranslateX(800);
			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);

			
			lblProduitId = new Label("Id : ");
			lblDesignation=new Label("Designation : ");
			lblPrix=new Label("Prix : ");
			lblQte=new Label("Quantité : ");
			lblDate=new Label("Date saisie : ");

			
			
			titleInput= new TextField ();
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
			
			hboxTitle.getChildren().addAll(lblTitle);
			hbox2.getChildren().addAll(lblTotals,lblNumTotal);
			vbox2.getChildren().addAll(lblrecherche,rechercheInput,produitList);
			hbox1.getChildren().addAll(vbox2,vbox1);
			hboxBtn.getChildren().addAll(ajouterBtn,modifierBtn,supprimerBtn,rechercheBtn,annulerBtn);
			vbox1.getChildren().addAll(lblProduitId,titleInput,lblDesignation,designationInput,
			lblPrix,prixInput,lblQte,qteInput,lblDate,dateInput,hboxBtn);
			
			root.getChildren().addAll(menuBar,hboxTitle,hbox2,hbox1);
			
		}
		
		
		public void initWindow(){
			window.setScene(scene);
			window.setTitle("Gestion de Magasin  -  Liste des Produits");
			window.setMaximized(true);
			window.show();
			
		}
		
		private void addStyleToNodes(){
			scene.getStylesheets().add("css/style.css");
			hboxTitle.getStyleClass().addAll("hbox","padding");
			hbox2.getStyleClass().addAll("hbox","padding2","textWhite","fontListe");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().addAll("padding2");
			vbox1.getStyleClass().add("padding");
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
		
		private void emptyVal() {
			titleInput.setText(""); 
			designationInput.setText(""); 
			qteInput.setText(""); 
			dateInput.setValue(null);
			prixInput.setText("");
			rechercheInput.setText("");
		}
		
		
		private void addEvent() {
		
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
			
			ajouterBtn.setOnAction(event ->{
				handler.addClick();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyVal();
				
			});
			annulerBtn.setOnAction(event ->{
				window.close();
				
			});
			
			supprimerBtn.setOnAction(event ->{
				handler.remove();
				produitList.getSelectionModel().clearSelection();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyVal();
			});
			
			modifierBtn.setOnAction(event ->{
				handler.modify();
				produitList.getItems().clear();
				handler.updateListProduits();
				emptyVal();
			});
			
			produitList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
				handler.selectItem();
			});
			
			rechercheBtn.setOnAction(event ->{
				produitList.getItems().clear();
				handler.search();
				emptyVal();
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



