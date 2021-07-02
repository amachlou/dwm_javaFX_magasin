package interfaces;
	
import java.sql.Connection;

import User.Login;
import User.LoginDaoImpl;
import User.LoginHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	ListeProduits listProduit;
	ListeClients listClient;
	LoginHandler handler=new LoginHandler(this);
	
	
	MenuBar menuBar;
	
	Menu produitsMenu;
	Menu clientsMenu;
	Menu ventesMenu;
	Menu paimentsMenu;
	Menu helpMenu;
	
	Label Produits;
	Label Clients;
	Label Ventes;
	Label Paiments;
	Label Help;
	
	
	MenuItem listVentes;
	MenuItem listPaiements;
	MenuItem helpItem;
	
	VBox root =new VBox();
	private StackPane stack=new StackPane();
	private Scene scene =new Scene(root);
	Label usernameLabel=new Label("Nom d'utilisateur");
	public TextField userInput=new TextField("");
	Label passwordLabel=new Label("Mot de passe");
	Label title=new Label("Admin Authentification");
	public PasswordField passwordInput=new PasswordField();
	Button loginBtn = new Button("Login");
	ImageView view = new ImageView();
	Font font;

	
	private void addNodesToWindow() {

	    view.setFitWidth(1100);
	    view.setFitHeight(700);
	    view.fitWidthProperty().bind(root.widthProperty());
	    view.fitHeightProperty().bind(root.heightProperty());
	    
	    title.setMaxWidth(350);
		title.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 30);
	    title.setFont(font);
		title.setTextFill(Color.MEDIUMSLATEBLUE);
		title.setTranslateX(40);
		title.setTranslateY(-250);
	    
	    
		usernameLabel.setMaxWidth(350);
		usernameLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
	    usernameLabel.setFont(font);
		usernameLabel.setTextFill(Color.MEDIUMSLATEBLUE);
		usernameLabel.setTranslateX(40);
		usernameLabel.setTranslateY(-140);
		

		userInput.setMaxWidth(350);
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 20);
		userInput.setFont(font);
		userInput.setPromptText("Nom d'utilisateur");
		userInput.setTranslateX(40);
		userInput.setTranslateY(-100);
		

		passwordLabel.setMaxWidth(350);
		passwordLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
		passwordLabel.setFont(font);
		passwordLabel.setTextFill(Color.MEDIUMSLATEBLUE);
		passwordLabel.setTranslateX(40);
		passwordLabel.setTranslateY(-60);
				

		passwordInput.setMaxWidth(350);
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 20);
		passwordInput.setFont(font);
		passwordInput.setPromptText("Mot de passe");
		passwordInput.setTranslateX(40);
		passwordInput.setTranslateY(-20);
		

		loginBtn.setMaxWidth(350);
		loginBtn.setMaxHeight(40);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
		loginBtn.setFont(font);
		loginBtn.setTextFill(Color.WHITE);
		loginBtn.setBackground(new Background(new BackgroundFill(Color.MEDIUMSLATEBLUE, null, null)));
		loginBtn.setTranslateX(40);
		loginBtn.setTranslateY(40);
		
		
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
		

		menuBar.getMenus().addAll(clientsMenu,produitsMenu,ventesMenu
				,paimentsMenu,helpMenu);
		

		listPaiements=new MenuItem("Liste");

		listVentes=new MenuItem("Liste");

		helpItem=new MenuItem("?");
		

		ventesMenu.getItems().addAll(listVentes);
			
		paimentsMenu.getItems().addAll(listPaiements);

		helpMenu.getItems().addAll(helpItem);
		
		
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(
	            view,title,
	            usernameLabel,userInput,passwordInput,passwordLabel,loginBtn);
		root.getChildren().addAll(menuBar,stack);
	
	}
	
	private void addStyleToNodes(){
		scene.getStylesheets().add("css/style.css");
		root.getStyleClass().add("Main");
		usernameLabel.getStyleClass().add("labelTitle");
		loginBtn.getStyleClass().add("cursor");
		
		menuBar.getStyleClass().add("menuStyle");
		
		Produits.getStyleClass().addAll("textWhite","cursor");
		Clients.getStyleClass().addAll("textWhite","cursor");
		Ventes.getStyleClass().addAll("textWhite","cursor");
		Paiments.getStyleClass().addAll("textWhite","cursor");
		Help.getStyleClass().addAll("textWhite","cursor");
		
		
		listVentes.getStyleClass().addAll("cursor");
		
		listPaiements.getStyleClass().addAll("cursor");			

		helpItem.getStyleClass().addAll("cursor");
		

	}
	
	
	
	private void addEvent(Stage window) {
		loginBtn.setOnAction(event ->
		{
			
			handler.login(window);	
			
		});
	
		Clients.setOnMouseClicked((mouseEvent) -> {
			Login l =new Login();
			if(l.isLogin) {
				listClient=new ListeClients();
				window.close();
			}
			
	    });

		
		Clients.setOnMouseClicked((mouseEvent) -> {
			Login l =new Login();
			if(l.isLogin) {
				listProduit= new ListeProduits();
				window.close();
			}
		
			
		});
//		newVente.setOnAction(event ->{
//			   nouveauVente=new NouveauVente();
//			   window.close();
//			});
//			
//			listVentes.setOnAction(event ->{
//				
//
//			});
//			newPaiement.setOnAction(event ->{
//				nouveauPaiement=new NouveauPaiement();
//				window.close();
//
//			});
//			listPaiements.setOnAction(event ->{
//				
//
//			});
			
		
	}
	
	@Override
	public void start(Stage window) {
			addNodesToWindow();
			addStyleToNodes();
			addEvent(window);
			window.setScene(scene);
			window.setWidth(1100);
			window.setHeight(700);
			window.setResizable(false);
			window.setTitle("Gestion de Magasin");
			window.show();
		
	}
	

	public static void main(String[] args) {
		launch(args);
		
		
	}
}
