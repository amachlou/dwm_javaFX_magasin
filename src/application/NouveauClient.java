package application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class NouveauClient {
	
		
		ListeProduits listProduit;
		NouveauProduit ajoutProduit;
		ListeClients listClient;

		VBox root =new VBox();
		HBox hboxTop=new HBox();
		HBox hboxBottom=new HBox();
		VBox vboxCenter = new VBox();
		HBox hboxBtn = new HBox();
		Scene scene = new Scene(root);
		Stage window =new Stage();
		
		MenuBar menuBar;
		
		Menu produitsMenu;
		Menu clientsMenu;
		Menu ventesMenu;
		Menu paimentsMenu;
		Menu inventaireMenu;
		Menu helpMenu;
		
		Label Produits;
		Label Clients;
		Label Ventes;
		Label Paiments;
		Label Inventaire;
		Label Help;
		
		MenuItem newProduit;
		MenuItem listProduits;	
		MenuItem newClient;
		MenuItem listClients;	
		MenuItem helpItem;
		
		Label lblTitle;
		Label lblCopyright;
		Label lblNumClient;
		Label lblNom;
		Label lblPrenom;
		Label lblTel;
		Label lblEmail;
		
		TextField NumClientInput;
		TextField NomInput;
		TextField PrenomInput;
		TextField TelInput;
		TextField EmailInput;
		
		Button ajouterProduitBtn;
		Button annulerBtn;
		
		Font font;
		
	private void createCompnents() {
		
			
			hboxBottom.setMaxHeight(200);
			
			vboxCenter.setMinHeight(540);
			vboxCenter.setSpacing(13);
			
			hboxBtn.setMinHeight(70);
			hboxBtn.setSpacing(250);
			
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

			
			lblTitle = new Label("Nouveau Client");
			
			font = Font.font("Brush Script MT", FontWeight.BOLD,
			FontPosture.REGULAR,30);
			lblTitle.setFont(font);
			lblTitle.setTextFill(Color.WHITE);
				
			
			lblCopyright= new Label("Copyright © 2021, Gestion Magasin");
			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);
			lblCopyright.setFont(font);
			lblCopyright.setTextFill(Color.WHITE);
			lblCopyright.setTranslateX(450);
			
			
			lblNumClient=new Label("N° : ");
			lblNom=new Label("Nom : ");
			lblPrenom=new Label("Prenom : ");
			lblTel=new Label("Telephone : ");
			lblEmail =new Label("Email : ");
			
			NumClientInput= new TextField();
			NomInput= new TextField();
			PrenomInput= new TextField();
			TelInput= new TextField();
			EmailInput= new TextField();
			
			ajouterProduitBtn=new Button("Ajouter");
			annulerBtn=new Button("Annuler");
			
			ajouterProduitBtn.setMinWidth(400);
			annulerBtn.setMinWidth(400);
			
			ajouterProduitBtn.setMaxHeight(40);
			annulerBtn.setMaxHeight(40);
			
		}
		
		private void addNodestoPane() {
			
			hboxBtn.getChildren().addAll(ajouterProduitBtn,annulerBtn);
			vboxCenter.getChildren().addAll(lblNumClient,NumClientInput,
			lblNom,NomInput,lblPrenom,PrenomInput,lblTel,TelInput,lblEmail,EmailInput);
			hboxTop.getChildren().addAll(lblTitle);
			hboxBottom.getChildren().addAll(lblCopyright);
			root.getChildren().addAll(menuBar,hboxTop,vboxCenter,hboxBtn,hboxBottom);
		}
		
		public void initWindow(){
			
			window.setScene(scene);
			window.setMaximized(true);
			window.setTitle("Gestion de Magasin  -  Nouveau Client");
			window.getIcons().add(new Image("css/logo_icon.png"));
			window.show();
			
		}
		
		private void addStyleToNodes(){
			
			scene.getStylesheets().add("css/application.css");
			
			hboxTop.getStyleClass().addAll("hbox","padding");
			hboxBottom.getStyleClass().addAll("menuStyle","padding");
			hboxBtn.getStyleClass().add("padding");
			vboxCenter.getStyleClass().addAll("centerLeft","padding");
			
			lblNumClient.getStyleClass().addAll("font");
			lblNom.getStyleClass().addAll("font"); 
			lblPrenom.getStyleClass().addAll("font"); 
			lblTel.getStyleClass().addAll("font");
			lblEmail.getStyleClass().addAll("font");
			
			NumClientInput.getStyleClass().addAll("font","inputFont"); 
			NomInput.getStyleClass().addAll("font","inputFont"); 
			PrenomInput.getStyleClass().addAll("font","inputFont"); 
			TelInput.getStyleClass().addAll("font","inputFont"); 
			EmailInput.getStyleClass().addAll("font","inputFont"); 
			
			ajouterProduitBtn.getStyleClass().addAll("font","btn","cursor"); 
			annulerBtn.getStyleClass().addAll("font","btn","cursor");
			
			lblCopyright.getStyleClass().add("center");
			
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
			listProduits.setOnAction(event ->{
				listProduit= new ListeProduits();
				window.close();
			});
			
			newProduit.setOnAction(event ->{
				ajoutProduit= new NouveauProduit();
				window.close();
			});
			
			listClients.setOnAction(event ->{
				listClient= new ListeClients();
				window.close();
			});
			
			
		}
		
		
		
		public NouveauClient() {
			
			initWindow();
			createCompnents();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
		}
		
		
	}



