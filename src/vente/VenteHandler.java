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
	VenteDaoImpl pdaoVente=new VenteDaoImpl();
	IProduitDAO pdaoProduit=new ProduitDaoImpl();
	
	
	public VenteHandler(GestionVentes gsetionVente) {
		this.gestionVente=gestionVente;
		
	}



	
	
	
}
