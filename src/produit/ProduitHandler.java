package produit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.GestionVentes;
import application.ListeProduits;
import javafx.scene.control.Label;

public class ProduitHandler {
	
	ListeProduits listProduit=null;
	GestionVentes gestionVente=null;
	IProduitDAO pdao=new ProduitDaoImpl();

	public ProduitHandler(ListeProduits listProduit) {
		this.listProduit=listProduit;
	}
	public ProduitHandler(GestionVentes gestionVente) {
		this.gestionVente=gestionVente;
	}
	

	public void updateListProduits() {
		
		List<Produit> list=pdao.getAll();
		listProduit.produitObservableList.addAll(list);
		calculerTotal();
	}
	
	public void updateListVente() {
		List<Produit> list=pdao.getAll();
		gestionVente.produitObservableList.addAll(list);
		
	}
	
	

	public void calculerTotal() {
	
		double total=0;
		for(Produit p:listProduit.produitObservableList) {
			total+=p.getPrix();	
		}
		System.out.println(total);		
		listProduit.lblNumTotal.setText(total+"");
		
	}
	
	public void addClick() {
		
		String designation=listProduit.designationInput.getText();
		int qte=Integer.valueOf(listProduit.qteInput.getText());
		double prix=Double.valueOf(listProduit.prixInput.getText());
		LocalDate date=listProduit.dateInput.getValue();	
		Produit p=new Produit(0,designation,qte,prix,date);
		pdao.add(p);
		
	}
	
	public void remove() {
	
	Produit p = listProduit.produitList.getSelectionModel().getSelectedItem();
	long id=p.getId_produit();
	pdao.delete(id);
	}

	public void selectItem() {
		Produit p = listProduit.produitList.getSelectionModel().getSelectedItem();
		long id=p.getId_produit();
		String designation = p.getDesignation();
		int qte = p.getQte();
		double prix = p.getPrix();
		LocalDate date = p.getDate();
		
		listProduit.titleInput.setText(id+"");
		listProduit.designationInput.setText(designation);
		listProduit.qteInput.setText(qte+"");
		listProduit.prixInput.setText(prix+"");
		listProduit.dateInput.setValue(date);
		
	}
	
	public void selectItemVente() {
		Produit p = gestionVente.produitList.getSelectionModel().getSelectedItem();
		long id_produit=p.getId_produit();
		String designation = p.getDesignation();
		double prix = p.getPrix();
		
		gestionVente.designationInput.setText(designation);
		gestionVente.prixInput.setText(prix+"");
		gestionVente.id_produit.setText(id_produit+"");
		
	}
	public void modify() {
		
		long id=Integer.valueOf(listProduit.titleInput.getText());
		String designation=listProduit.designationInput.getText();
		int qte=Integer.valueOf(listProduit.qteInput.getText());
		double prix=Double.valueOf(listProduit.prixInput.getText());
		LocalDate date=listProduit.dateInput.getValue();	
		Produit p=new Produit(id,designation,qte,prix,date);
		pdao.update(p);
		
	}
	
	public void search() {
		
		String designation=listProduit.rechercheInput.getText();
		List<Produit> list=pdao.getAll(designation);
		listProduit.produitObservableList.addAll(list);
		calculerTotal();
	}
	

}
