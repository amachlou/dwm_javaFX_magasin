package interfaces;

import java.time.LocalDate;

import Paiement.Paiement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

public class NouveauPaiement {

	
	ListeProduits listProduit;
	ListeClients listClient;
	NouveauVente nouveauVente;
	ListeVentes listeVentes;

		
		VBox root =new VBox();
		HBox hbox1=new HBox();
		VBox vboxL = new VBox();
		VBox vboxR = new VBox();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		HBox hboxTitle=new HBox();
		HBox hboxBtn = new HBox();
		GridPane grid1 = new GridPane();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		TableColumn<Paiement,Long> numReglemntColumn;
		TableColumn<Paiement,String> montantPayéColumn;
		TableColumn<Paiement,Double> dateColumn;
		TableColumn<Paiement,Integer> typeColumn;
		TableColumn<Paiement,LocalDate> numChequeColumn;
		TableColumn<Paiement,LocalDate> nomPropreColumn;
		TableColumn<Paiement,LocalDate> banqueColumn;

		TableView <Paiement> paiementList;
		
		ListView<String> listType = new ListView<String>();
		ObservableList<String> Typeitems =FXCollections.observableArrayList ("ESPECE","CHEQUE");
		
		ListView<String> listBanque = new ListView<String>();
		ObservableList<String> Banqueitems =FXCollections.observableArrayList ("ATW","BP","CIH","BA","BB","SG");
		
		ObservableList<String> options = FXCollections.observableArrayList("1","5","23");
			final ComboBox numVenteList = new ComboBox(options);
			
		
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
		
		Label lblClient;
		Label lblNumVente;
		Label lblDate;
		Label lblTotal;
		Label lblTotalPayé;
		Label lblReste;
		
		Label lblIdClientVal;
		Label lblClientVal;
		Label lblNumVenteVal;
		Label lblDateVal;
		Label lblTotalVal;
		Label lblTotalPayéVal;
		Label lblResteVal;
		
		Label lblNumPaiement;
		Label lblDatePaiement;
		Label lblMontant;
		Label lblType;
		Label lblNumCheque;
		Label lblBanque;
		Label lblNom;
		
		TextField NumPaiementInput;
		DatePicker DatePaiementInput;
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
			
			
			hbox1.setSpacing(5);

			vboxL.setPrefWidth(1400);
			vboxL.setPrefHeight(800);
			vboxL.setSpacing(20);
			
			vboxR.setPrefWidth(450);
			vboxR.setPrefHeight(850);
			vboxR.setSpacing(20);
				
			vbox1.setSpacing(15);
			vbox2.setSpacing(15);
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);
			
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
			
			
			listVentes=new MenuItem("Liste");
			
			listPaiements=new MenuItem("Liste");
			
			helpItem=new MenuItem("?");


			ventesMenu.getItems().addAll(listVentes);
			paimentsMenu.getItems().addAll(listPaiements);
			
			helpMenu.getItems().addAll(helpItem);
			
			
			lblTitle = new Label("Nouveau Paiement");
			lblTitle.setTranslateX(800);


			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);

			
			lblClient= new Label("Client: ");
			lblNumVente= new Label("N°vente: ");
			lblDate= new Label("Date: ");
			lblTotal= new Label("Total: ");
			lblTotalPayé= new Label("Total payé: ");
			lblReste= new Label("Reste: ");
			
			lblIdClientVal=new Label("1");
			lblClientVal= new Label("-");
			lblNumVenteVal= new Label("1");
			lblDateVal= new Label("-");
			lblTotalVal= new Label("0");
			lblTotalPayéVal= new Label("0");
			lblResteVal= new Label("0");
			
			
			lblNumPaiement=new Label("N°: ");
			lblDatePaiement=new Label("Date: ");
			lblMontant=new Label("Montant: ");
			lblType=new Label("Type: ");
			lblNumCheque=new Label("N° chéque: ");
			lblBanque=new Label("Banque: ");
			lblNom=new Label("Nom: ");
			
			NumPaiementInput= new TextField();
			DatePaiementInput= new DatePicker();
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
			
			paiementList=new TableView<>();
			paiementList.setPrefSize( 0, 800);			
			paiementList.getColumns().addAll(numReglemntColumn,
			montantPayéColumn,dateColumn,typeColumn,numChequeColumn,nomPropreColumn,banqueColumn);
			
			
			grid1.add(lblClient, 0, 0); 
		    grid1.add(lblClientVal, 1, 0); 
		    grid1.add(lblNumVente, 0, 1);       
		    grid1.add(numVenteList, 1, 1);
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
		    
		    lblNumVenteVal.setVisible(false);
		    numVenteList.setVisible(false);
		    
			listType.setItems(Typeitems);
			listBanque.setItems(Banqueitems);
			
			listType.setPrefHeight(300);
			listBanque.setPrefHeight(300);
			
			numVenteList.setPromptText("N°vente");
			numVenteList.setEditable(true);			
			numVenteList.setPrefWidth(110);

		}
		
		private void addNodestoPane() {
			
		      
			hboxTitle.getChildren().addAll(lblTitle);
			hbox1.getChildren().addAll(vboxR,vboxL);
			hboxBtn.getChildren().addAll(nouveauBtn,ajouterBtn,supprimerBtn,annulerBtn);		
			vboxR.getChildren().addAll(vbox1,vbox2);
			vbox1.getChildren().addAll(lblNumPaiement,NumPaiementInput,lblDatePaiement,DatePaiementInput,lblMontant,MontantInput,lblType,listType);
			vbox2.getChildren().addAll(lblNumCheque,NumChequeInput,lblBanque,listBanque,lblNom,NomInput);
			vboxL.getChildren().addAll(paiementList);
			
			root.getChildren().addAll(menuBar,hboxTitle,hbox1,hboxBtn);
			
		}
		
		
		public void initWindow(){
			window.setScene(scene);
			window.setTitle("Gestion de Magasin  -  Nouveau Paiement");
			window.setMaximized(true);
			window.show();
			
		}
		
		private void addStyleToNodes(){
			scene.getStylesheets().add("css/style.css");
			hboxTitle.getStyleClass().addAll("hbox","padding");

			vboxL.getStyleClass().add("padding");
			vboxR.getStyleClass().add("padding");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().add("padding2");
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
			
			lblNumPaiement.getStyleClass().add("fontListe");
			lblDatePaiement.getStyleClass().add("fontListe");
			lblMontant.getStyleClass().add("fontListe");
			lblType.getStyleClass().add("fontListe");
			lblNumCheque.getStyleClass().add("fontListe");
			lblBanque.getStyleClass().add("fontListe");
			lblNom.getStyleClass().add("fontListe");
			
			
			NumPaiementInput.getStyleClass().addAll("fontListe","inputFont");
			DatePaiementInput.getStyleClass().addAll("fontListe","inputFont");
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
			annulerBtn.setOnAction(event ->{
				window.close();
				
			});
		
			Produits.setOnMouseClicked((mouseEvent) -> {
				listProduit= new ListeProduits();
				window.close();
		    });
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
			
		}
		
		
		public NouveauPaiement(){
			
			initWindow();
			createCompnents();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}




	
	
	

