package application;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import produit.Produit;

public class HomeWindow {
	
	NouveauProduit ajoutProduit;
	ListeProduits listProduit;
	NouveauClient ajoutClient;
	ListeClients listClient;
	
	VBox root =new VBox();
	HBox hboxTop=new HBox();
	HBox hboxBottom=new HBox();
	Scene scene = new Scene(root);
	Stage window =new Stage();
	
	TableColumn<Produit,Long> idColumn;
	TableColumn<Produit,String> designationColumn;
	TableColumn<Produit,Double> prixColumn;
	TableColumn<Produit,Integer> qteColumn;
	TableColumn<Produit,Double> totalColumn;
	TableColumn<Produit,LocalDate> dateColumn;
	
	TableView <Produit> homeList;
	
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
	
	MenuButton menuBtn;
	MenuItem logout;
	
	Label lblTitle;
	Label lblCopyright;
	
	Font font;
	
	private void createCompnents() {

		hboxTop.setSpacing(800);
		
		hboxBottom.setMaxHeight(200);
		
		menuBar=new MenuBar();
		hboxBottom.setMaxHeight(150);
		
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
		
		menuBtn =  new MenuButton("Jihane Arfi");
		menuBtn.setMaxWidth(250);
		menuBtn.setMaxHeight(20);
		menuBtn.setAlignment(Pos.CENTER_RIGHT);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 15);
		menuBtn.setFont(font);
		menuBtn.setTextFill(Color.DEEPSKYBLUE);
		menuBtn.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		
		logout = new MenuItem("Logout");
		menuBtn.getItems().addAll(logout);
		
		lblTitle = new Label("Acceuil");
		
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 30);
		lblTitle.setFont(font);
		lblTitle.setTextFill(Color.WHITE);
			
		
		lblCopyright= new Label("Copyright © 2021, Gestion Magasin");
		
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 12);
		lblCopyright.setFont(font);
		lblCopyright.setTextFill(Color.WHITE);
		lblCopyright.setTranslateX(450);
	
	}
	
	private void addNodestoPane() {
		hboxTop.getChildren().addAll(lblTitle,menuBtn);
		hboxBottom.getChildren().addAll(lblCopyright);
		root.getChildren().addAll(menuBar,hboxTop,hboxBottom);
	}
	
	
	public void initWindow(){
		window.setScene(scene);
		window.setMaximized(true);
		window.setTitle("Gestion de Magasin  -  Acceuil");
		window.getIcons().add(new Image("css/logo_icon.png"));
		window.show();
	}
	
	private void addStyleToNodes(){
		scene.getStylesheets().add("css/application.css");
		hboxTop.getStyleClass().addAll("hbox","padding");
		hboxBottom.getStyleClass().addAll("menuStyle","padding");
		menuBtn.getStyleClass().add("cursor");
		
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
		
	}
	
	
	public HomeWindow(){
		
		initWindow();
		createCompnents();
		addNodestoPane();
		addStyleToNodes();
		addEvent();
		
	
	}
	
	
	
}
