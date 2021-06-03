package vente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.NouveauVente;
import application.ListeClients;
import application.ListeProduits;
import application.ListeVentes;
import application.Main;
import client.Client;
import client.ClientHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import produit.IProduitDAO;
import produit.Produit;
import produit.ProduitDaoImpl;

public class VenteHandler {
	
	NouveauVente nouveauVente =null;
	ListeProduits listProduit=null;
	ListeVentes listVentes=null;
	
	IVenteDAO pdaoVente=new VenteDaoImpl();
	ILigneCommandeDAO pdaoCommande =new LigneCommandeDaoImpl();
	IProduitDAO pdaoProduit=new ProduitDaoImpl();
	
	public VenteHandler(NouveauVente nouveauVente) {
		this.nouveauVente=nouveauVente;		
	}
	
	public VenteHandler(ListeVentes listVentes) {
		this.listVentes=listVentes;		
	}
	
	public void addCommandeToTable() {	

		double sousTotal=0;
		long id_produit=Integer.valueOf(nouveauVente.id_produit.getText());
		long id_vente=Integer.valueOf(nouveauVente.numVenteInput.getText());
		String designation=nouveauVente.designationInput.getText();
		int qte=Integer.valueOf(nouveauVente.qteInput.getText());
		double prix=Double.valueOf(nouveauVente.prixInput.getText());
		sousTotal=qte*prix;
		 
		LigneCommande c=new LigneCommande(0,designation,prix,qte,sousTotal,id_produit,id_vente);
		nouveauVente.commandeObservableList.addAll(c);
		calculerTotal();
		
	}
	
	public void calculerTotal() {
		
		double total=0;
		for(LigneCommande c:nouveauVente.commandeObservableList) {
			total+=c.getSous_total();	
		}	
		nouveauVente.lblTotalVal.setText(total+"");
		
	}
	public void updateListCommande() {
		long id_vente=Integer.valueOf(nouveauVente.numVenteInput.getText());
		List<LigneCommande> list=pdaoCommande.getAllLigne(id_vente);
		nouveauVente.commandeObservableList.addAll(list);
		calculerTotal();
	}
	

	
	public void addVente() {

		calculerTotal();
		double total=0;
		total=Double.valueOf(nouveauVente.lblTotalVal.getText());
		long id_client=Integer.valueOf(nouveauVente.id_client.getText());
		LocalDate date=nouveauVente.dateInput.getValue();
		Vente v = new Vente(0,date,total,id_client);
		pdaoVente.add(v);
		if(v.isAdded) {
			addListCommandeToDb();			
		}
		
		
//			double sousTotal=0;
//			long id_vente=Integer.valueOf(nouveauVente.numVenteInput.getText());
//			long id_produit=Integer.valueOf(nouveauVente.id_produit.getText());
//			String designation=nouveauVente.designationInput.getText();
//			int qte=Integer.valueOf(nouveauVente.qteInput.getText());
//			double prix=Double.valueOf(nouveauVente.prixInput.getText());
//			sousTotal=qte*prix;
//			 
//			LigneCommande c=new LigneCommande(0,designation,prix,qte,sousTotal,id_produit,id_vente);
//			pdaoCommande.add(c);
		
	}
	
	public void addListCommandeToDb(){
		
		double sousTotal=0;
		for(LigneCommande c:nouveauVente.commandeObservableList) {
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
	
	public void updateListLigneCommande() {
		
		long id_vente=Integer.valueOf(nouveauVente.numVenteInput.getText());
		List<LigneCommande> list=pdaoCommande.getAllLigne(id_vente);
		nouveauVente.commandeObservableList.addAll(list);
		calculerTotal();

	}
		
		public void selectItemCmd() {
			LigneCommande c = nouveauVente.commandeList.getSelectionModel().getSelectedItem();
			long id_cmd=c.getId_commande();
			long id_produit=c.getId_produit();
			String designation =c.getDesignation();
			double prix = c.getPrix();
			int qte = c.getQte();
			
			
			nouveauVente.codeCmdInput.setText(id_cmd+"");
			nouveauVente.designationInput.setText(designation);
			nouveauVente.prixInput.setText(prix+"");
			nouveauVente.qteInput.setText(qte+"");
			nouveauVente.id_produit.setText(id_produit+"");
		}
		
		public void removeCmd() {
			
			LigneCommande c = nouveauVente.commandeList.getSelectionModel().getSelectedItem();
			long id=c.getId_commande();
			pdaoCommande.delete(id);
			calculerTotal();
			updateListLigneCommande();
		}
		
		public void modifyCmd() {
			double sousTotal=0;
			long id_cmd=Integer.valueOf(nouveauVente.codeCmdInput.getText());
			long id_produit=Integer.valueOf(nouveauVente.id_produit.getText());
			String designation=nouveauVente.designationInput.getText();
			int qte=Integer.valueOf(nouveauVente.qteInput.getText());
			double prix=Double.valueOf(nouveauVente.prixInput.getText());
			sousTotal=qte*prix;
				
			LigneCommande c=new LigneCommande(id_cmd,designation,prix,qte,sousTotal,id_produit);
			pdaoCommande.update(c);
			calculerTotal();
			updateListLigneCommande();			
		}
		public void updateListVente() {			
			List<Vente> list=pdaoVente.getAllVente();
			listVentes.VenteObservableList.addAll(list);
		}
		
		public void selectItemVente() {
			Vente v = listVentes.VenteList.getSelectionModel().getSelectedItem();
			double total=v.getTotal();
			double total_paye=v.getTotal_paye();
			double reste =v.getReste();
						
			listVentes.lblTotalVal.setText(total+"");
			listVentes.lblTotalPayéVal.setText(total_paye+"");
			listVentes.lblResteVal.setText(reste+"");
		
		}
		
		public void searchVente() {
			long id_vente=Integer.valueOf(listVentes.NumVenteInput.getText());
			String nom=listVentes.NomInput.getText();
			LocalDate date1 =listVentes.Date1Input.getValue();
			LocalDate date2=listVentes.Date2Input.getValue();
			List<Vente> list=pdaoVente.searchVente(id_vente,nom,Date.valueOf(date1),Date.valueOf(date2));
			listVentes.VenteObservableList.addAll(list);
			System.out.println(list);
		}
		
		public void displayVente() {
			nouveauVente=new NouveauVente();
			
			Vente v = listVentes.VenteList.getSelectionModel().getSelectedItem();
			long id_vente=v.getId_vente();
			long id_client=v.getId_client();
			String nom_client =v.getNom_client();
			double total = v.getTotal();
			LocalDate date = v.getDate();
			
			nouveauVente.numVenteInput.setText(id_vente+"");
			nouveauVente.lblClientInput.setText(nom_client);
			nouveauVente.dateInput.setValue(date);
			nouveauVente.lblTotalVal.setText(total+"");
			
			
			LigneCommande list=pdaoCommande.getOne(id_vente);
			nouveauVente.commandeObservableList.addAll(list);
			System.out.println(list);
		}
		


	
	
	
}
