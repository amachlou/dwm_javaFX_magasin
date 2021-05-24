package vente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.GestionVentes;
import application.ListeClients;
import application.ListeProduits;
import application.Main;
import client.Client;
import client.ClientHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import produit.IProduitDAO;
import produit.Produit;
import produit.ProduitDaoImpl;

public class VenteHandler {
	
	GestionVentes gestionVente =null;
	ListeProduits listProduit=null;
	IVenteDAO pdaoVente=new VenteDaoImpl();
	ILigneCommandeDAO pdaoCommande =new LigneCommandeDaoImpl();
	IProduitDAO pdaoProduit=new ProduitDaoImpl();
	
	public VenteHandler(GestionVentes gestionVente) {
		this.gestionVente=gestionVente;
		
	}
	
	public void addCommandeToTable() {	

		double sousTotal=0;
		long id_produit=Integer.valueOf(gestionVente.id_produit.getText());
		long id_vente=Integer.valueOf(gestionVente.numVenteInput.getText());
		String designation=gestionVente.designationInput.getText();
		int qte=Integer.valueOf(gestionVente.qteInput.getText());
		double prix=Double.valueOf(gestionVente.prixInput.getText());
		sousTotal=qte*prix;
		 
		LigneCommande c=new LigneCommande(0,designation,prix,qte,sousTotal,id_produit,id_vente);
		gestionVente.commandeObservableList.addAll(c);
		calculerTotal();
		
	}
	
	public void calculerTotal() {
		
		double total=0;
		for(LigneCommande c:gestionVente.commandeObservableList) {
			total+=c.getSous_total();	
		}	
		gestionVente.lblTotalVal.setText(total+"");
		
	}
	public void updateListCommande() {
		long id_vente=Integer.valueOf(gestionVente.numVenteInput.getText());
		List<LigneCommande> list=pdaoCommande.getAllLigne(id_vente);
		gestionVente.commandeObservableList.addAll(list);
		calculerTotal();
	}
	

	
	public void addVente() {

		calculerTotal();
		double total=0;
		total=Double.valueOf(gestionVente.lblTotalVal.getText());
		long id_client=Integer.valueOf(gestionVente.id_client.getText());
		LocalDate date=gestionVente.dateInput.getValue();
		Vente v = new Vente(0,date,total,id_client);
		pdaoVente.add(v);
		if(v.isAdded) {
			addListCommandeToDb();
		}
		
		
//			double sousTotal=0;
//			long id_vente=Integer.valueOf(gestionVente.numVenteInput.getText());
//			long id_produit=Integer.valueOf(gestionVente.id_produit.getText());
//			String designation=gestionVente.designationInput.getText();
//			int qte=Integer.valueOf(gestionVente.qteInput.getText());
//			double prix=Double.valueOf(gestionVente.prixInput.getText());
//			sousTotal=qte*prix;
//			 
//			LigneCommande c=new LigneCommande(0,designation,prix,qte,sousTotal,id_produit,id_vente);
//			pdaoCommande.add(c);
		
	}
	
	public void addListCommandeToDb(){
		double sousTotal=0;
		for(LigneCommande c:gestionVente.commandeObservableList) {
			long id_produit=c.getId_produit();
			long id_vente=c.getId_vente();
			String designation=c.getDesignation();
			int qte=c.getQte();
			double prix=c.getPrix();
			sousTotal=qte*prix;
			System.out.println(c);
			pdaoCommande.add(c);
	}
}
		
		public void selectItemCmd() {
			LigneCommande c = gestionVente.commandeList.getSelectionModel().getSelectedItem();
			long id_cmd=c.getId_commande();
			long id_produit=c.getId_produit();
			String designation =c.getDesignation();
			double prix = c.getPrix();
			int qte = c.getQte();
			
			gestionVente.codeCmdInput.setText(id_cmd+"");
			gestionVente.designationInput.setText(designation);
			gestionVente.prixInput.setText(prix+"");
			gestionVente.qteInput.setText(qte+"");
			gestionVente.id_produit.setText(id_produit+"");
		}
		
		


	
	
	
}
