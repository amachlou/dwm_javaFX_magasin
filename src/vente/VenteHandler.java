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
	
	public void addCommande() {	
		double sousTotal=0;
		long id_cmd=Integer.valueOf(gestionVente.codeCmdInput.getText());
		String designation=gestionVente.designationInput.getText();
		int qte=Integer.valueOf(gestionVente.qteInput.getText());
		double prix=Double.valueOf(gestionVente.prixInput.getText());
		sousTotal=prix*qte;
		LigneCommande c=new LigneCommande(id_cmd,designation,prix,qte,sousTotal);
		gestionVente.commandeObservableList.addAll(c);
		calculerTotal();
		
	}
	public void calculerTotal() {
		
		double total=0;
		for(LigneCommande c:gestionVente.commandeObservableList) {
			total+=c.getSous_total();	
		}
		System.out.println(total);		
		gestionVente.lblTotalVal.setText(total+"");
		
	}
	

	
//	public void addVente() {
//		double sousTotal=0;
//		long id_produit=Integer.valueOf(gestionVente.numVenteInput.getText());
//		long id_vente=Integer.valueOf(gestionVente.id_produit.getText());
//		String designation=gestionVente.designationInput.getText();
//		int qte=Integer.valueOf(gestionVente.qteInput.getText());
//		double prix=Double.valueOf(gestionVente.prixInput.getText());
//		sousTotal=qte*prix;
//		 
//		LigneCommande c=new LigneCommande(0,designation,prix,qte,sousTotal,id_produit,id_vente);
//		pdaoCommande.add(c);
//		
//	}


	
	
	
}
