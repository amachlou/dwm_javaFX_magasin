package application;
	
import java.sql.Connection;

import Login.Login;
import Login.LoginDaoImpl;
import Login.LoginHandler;
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
import javafx.scene.image.Image;
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
	
	public Label lblError;
	
	MenuItem newProduit;
	MenuItem listProduits;	
	MenuItem newClient;
	MenuItem listClients;	
	MenuItem helpItem;
	
	VBox root =new VBox();
	private StackPane stack=new StackPane();
	private Scene scene =new Scene(root);
	Label usernameLabel=new Label("Username");
	public TextField userInput=new TextField();
	Label passwordLabel=new Label("Password");
	public PasswordField passwordInput=new PasswordField();
	Button loginBtn = new Button("Login");
	Image img = new Image("css/magasin_logo.jpg");
	ImageView view = new ImageView(img);
	Font font;

	
	private void addNodesToWindow() {
		// view properties
	    view.setFitWidth(1100);
	    view.setFitHeight(700);
	    view.fitWidthProperty().bind(root.widthProperty());
	    view.fitHeightProperty().bind(root.heightProperty());
	    
	    lblError=new Label("");
	    
	    // labeluser properties
		usernameLabel.setMaxWidth(350);
		usernameLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
	    usernameLabel.setFont(font);
		usernameLabel.setTextFill(Color.DEEPSKYBLUE);
		usernameLabel.setTranslateX(300);
		usernameLabel.setTranslateY(-100);
		
		// inputuser properties
		userInput.setMaxWidth(350);
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 20);
		userInput.setFont(font);
		userInput.setPromptText("Username");
		userInput.setTranslateX(300);
		userInput.setTranslateY(-60);
		
		// labeluser properties
		passwordLabel.setMaxWidth(350);
		passwordLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
		passwordLabel.setFont(font);
		passwordLabel.setTextFill(Color.DEEPSKYBLUE);
		passwordLabel.setTranslateX(300);
		passwordLabel.setTranslateY(-20);
				
		// inputpass properties
		passwordInput.setMaxWidth(350);
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 20);
		passwordInput.setFont(font);
		passwordInput.setPromptText("Password");
		passwordInput.setTranslateX(300);
		passwordInput.setTranslateY(20);
		
		// buttonlogin properties
		loginBtn.setMaxWidth(350);
		loginBtn.setMaxHeight(40);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
		loginBtn.setFont(font);
		loginBtn.setTextFill(Color.WHITE);
		loginBtn.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, null, null)));
		loginBtn.setTranslateX(300);
		loginBtn.setTranslateY(80);
		
		lblError.setMaxWidth(350);
		lblError.setTranslateX(300);
		lblError.setTranslateY(140);
		
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
		
		newProduit=new MenuItem("Nouveau");
		listProduits=new MenuItem("Liste");
		
		newClient=new MenuItem("Nouveau");
		listClients=new MenuItem("Liste");
		
		helpItem=new MenuItem("?");
		
		
		produitsMenu.getItems().addAll(newProduit,listProduits);
		clientsMenu.getItems().addAll(newClient,listClients);
		helpMenu.getItems().addAll(helpItem);
		
		
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(
	            view,
	            usernameLabel,userInput,passwordInput,passwordLabel,loginBtn,lblError);
		root.getChildren().addAll(menuBar,stack);
	
	}
	
	private void addStyleToNodes(){
		scene.getStylesheets().add("css/application.css");
		root.getStyleClass().add("Main");
		usernameLabel.getStyleClass().add("labelTitle");
		loginBtn.getStyleClass().add("cursor");
		
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
		
		lblError.getStyleClass().addAll("fontListe","error");
	}
	
	
	
	private void addEvent(Stage window) {
		loginBtn.setOnAction(event ->
		{
			
			handler.login(window);	
			
		});
	
		listClients.setOnAction(event ->{
			Login l =new Login();
			if(l.isLogin) {
				listClient=new ListeClients();
				window.close();
			}
			else {
				lblError.setText("Information incorrect !");
			}

		});
		
		listProduits.setOnAction(event ->{
			Login l =new Login();
			if(l.isLogin) {
				listProduit= new ListeProduits();
				window.close();
			}
			else {
				lblError.setText("Information incorrect !");
			}
			
		});
		
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
			window.getIcons().add(new Image("css/logo_icon.png"));
			window.show();
		
	}
	

	public static void main(String[] args) {
		launch(args);
		
		
	}
}
