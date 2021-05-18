package application;

import java.time.LocalDate;

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

public class GestionPaiements {

	
		NouveauProduit ajoutProduit;
		ListeProduits listProduit;
		NouveauClient ajoutClient;
		
		VBox root =new VBox();
		HBox hboxCenter=new HBox();
		VBox vboxLeft = new VBox();
		VBox vboxRight = new VBox();
		VBox vboxR1 = new VBox();
		VBox vboxR2 = new VBox();
		HBox hboxTop=new HBox();
		HBox hboxBtn = new HBox();
		HBox hboxBottom=new HBox();
		GridPane grid1 = new GridPane();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		TableColumn<Reglement,Long> numReglemntColumn;
		TableColumn<Reglement,String> montantPayéColumn;
		TableColumn<Reglement,Double> dateColumn;
		TableColumn<Reglement,Integer> typeColumn;
		TableColumn<Reglement,LocalDate> numChequeColumn;
		TableColumn<Reglement,LocalDate> nomPropreColumn;
		TableColumn<Reglement,LocalDate> banqueColumn;

		TableView <Reglement> reglementList;
		

		
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
		
		Label lblClient;
		Label lblNumVente;
		Label lblDate;
		Label lblTotal;
		Label lblTotalPayé;
		Label lblReste;
		
		Label lblClientVal;
		Label lblNumVenteVal;
		Label lblDateVal;
		Label lblTotalVal;
		Label lblTotalPayéVal;
		Label lblResteVal;
		
		Label lblNumReglement;
		Label lblDateReglement;
		Label lblMontant;
		Label lblType;
		Label lblNumCheque;
		Label lblBanque;
		Label lblNom;
		
		TextField NumReglementInput;
		TextField DateReglementInput;
		TextField MontantInput;
		TextField TypeInput;
		TextField NumChequeInput;
		TextField BanqueInput;
		TextField NomInput;

		Button ajouterBtn;
		
		Button nouveauBtn;
		Button supprimerBtn;
		Button annulerBtn;
		
		
		Font font;
		
		private void createCompnents() {
			
			
			hboxCenter.setSpacing(5);

			vboxLeft.setPrefWidth(1400);
			vboxLeft.setPrefHeight(800);
			vboxLeft.setSpacing(20);
			
			vboxRight.setPrefWidth(450);
			vboxRight.setPrefHeight(800);
			vboxRight.setSpacing(20);
				
			vboxR1.setSpacing(15);
			vboxR2.setSpacing(15);
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);
			
			hboxTop.setSpacing(650);
			hboxBottom.setPrefHeight(50);
			

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
			
			
			lblClient= new Label("Client: ");
			lblNumVente= new Label("N°: ");
			lblDate= new Label("Date: ");
			lblTotal= new Label("Total: ");
			lblTotalPayé= new Label("Total payé: ");
			lblReste= new Label("Reste: ");
			
			lblClientVal= new Label("Jihane");
			lblNumVenteVal= new Label("1");
			lblDateVal= new Label("1/2/2020");
			lblTotalVal= new Label("65852");
			lblTotalPayéVal= new Label("22502");
			lblResteVal= new Label("40000");
			
			
			lblNumReglement=new Label("N°: ");
			lblDateReglement=new Label("Date: ");
			lblMontant=new Label("Montant: ");
			lblType=new Label("Type: ");
			lblNumCheque=new Label("N° chéque: ");
			lblBanque=new Label("Banque: ");
			lblNom=new Label("Nom: ");
			
			NumReglementInput= new TextField();
			DateReglementInput= new TextField();
			MontantInput= new TextField();
			TypeInput= new TextField();
			NumChequeInput= new TextField();
			BanqueInput= new TextField();
			NomInput= new TextField();
			
		    ajouterBtn = new Button("Ajouter");
		    nouveauBtn= new Button("Nouveau");
			supprimerBtn= new Button("Supprimer");
			annulerBtn= new Button("Annuler");
		    
			
			numReglemntColumn=new TableColumn<>("N°");
			montantPayéColumn=new TableColumn<>("Montant");
			dateColumn=new TableColumn<>("Date");
			typeColumn=new TableColumn<>("Type");
			nomPropreColumn= new TableColumn<>("Proprétaire");
			numChequeColumn=new TableColumn<>("N°Chéque");
			banqueColumn=new TableColumn<>("Banque");
			
			numReglemntColumn.setPrefWidth(100);
			montantPayéColumn.setPrefWidth(400);
			dateColumn.setPrefWidth(200);
			typeColumn.setPrefWidth(140);
			nomPropreColumn.setPrefWidth(100);
			numChequeColumn.setPrefWidth(240);
			banqueColumn.setPrefWidth(240);
			
			reglementList=new TableView<>();
			reglementList.setPrefSize( 0, 800);			
			reglementList.getColumns().addAll(numReglemntColumn,
			montantPayéColumn,dateColumn,typeColumn,numChequeColumn,nomPropreColumn,banqueColumn);
			
			
			grid1.add(lblClient, 0, 0); 
		    grid1.add(lblClientVal, 1, 0); 
		    grid1.add(lblNumVente, 0, 1);       
		    grid1.add(lblNumVenteVal, 1, 1); 
		    grid1.add(lblDate, 0, 2);
		    grid1.add(lblDateVal, 1, 2);
		    grid1.add(lblTotal, 0, 3);
		    grid1.add(lblTotalVal, 1, 3);
		    grid1.add(lblTotalPayé, 0, 4);
		    grid1.add(lblTotalPayéVal, 1, 4);
		    grid1.add(lblReste, 0, 5);
		    grid1.add(lblResteVal, 1, 5);
		    grid1.setVgap(10);
		     
			
		}
		
		private void addNodestoPane() {
			
		      
			hboxBottom.getChildren().addAll(lblCopyright);
			hboxTop.getChildren().addAll(lblTitle);
			hboxCenter.getChildren().addAll(vboxLeft,vboxRight);
			hboxBtn.getChildren().addAll(nouveauBtn,supprimerBtn,annulerBtn);		
			vboxRight.getChildren().addAll(vboxR1,vboxR2,ajouterBtn);
			vboxR1.getChildren().addAll(lblNumReglement,NumReglementInput,lblDateReglement,DateReglementInput,lblMontant,MontantInput,lblType,TypeInput);
//			vboxR2.getChildren().addAll(lblNumCheque,NumChequeInput,lblBanque,BanqueInput,lblNom,NomInput);
			vboxLeft.getChildren().addAll(grid1,reglementList);
			
			root.getChildren().addAll(menuBar,hboxTop,hboxCenter,hboxBtn,hboxBottom);
			
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
			vboxR2.getStyleClass().add("border");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().add("padding2");
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
			
			lblClient.getStyleClass().addAll("fontListe","inputFont");
			lblNumVente.getStyleClass().addAll("fontListe","inputFont");
			lblDate.getStyleClass().addAll("fontListe","inputFont");
			lblTotal.getStyleClass().addAll("fontListe","inputFont");
			lblTotalPayé.getStyleClass().addAll("fontListe","inputFont");
			lblReste.getStyleClass().addAll("fontListe","inputFont");
			
			lblClientVal.getStyleClass().addAll("fontListe","inputFont");
			lblNumVenteVal.getStyleClass().addAll("fontListe","inputFont");
			lblDateVal.getStyleClass().addAll("fontListe","inputFont");
			lblTotalVal.getStyleClass().addAll("fontListe","inputFont");
			lblTotalPayéVal.getStyleClass().addAll("fontListe","inputFont");
			lblResteVal.getStyleClass().addAll("fontListe","inputFont");
			
			lblNumReglement.getStyleClass().add("fontListe");
			lblDateReglement.getStyleClass().add("fontListe");
			lblMontant.getStyleClass().add("fontListe");
			lblType.getStyleClass().add("fontListe");
			lblNumCheque.getStyleClass().add("fontListe");
			lblBanque.getStyleClass().add("fontListe");
			lblNom.getStyleClass().add("fontListe");
			
			
			NumReglementInput.getStyleClass().addAll("fontListe","inputFont");
			DateReglementInput.getStyleClass().addAll("fontListe","inputFont");
			MontantInput.getStyleClass().addAll("fontListe","inputFont");
			TypeInput.getStyleClass().addAll("fontListe","inputFont");
			NumChequeInput.getStyleClass().addAll("fontListe","inputFont");
			BanqueInput.getStyleClass().addAll("fontListe","inputFont");
			NomInput.getStyleClass().addAll("fontListe","inputFont");
			
			
			ajouterBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
			
			nouveauBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
			supprimerBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
			annulerBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
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
			
		}
		
		
		public GestionPaiements(){
			
			initWindow();
			createCompnents();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}




	
	
	

