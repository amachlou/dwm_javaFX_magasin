package produit;

import java.time.LocalDate;

public class Produit{
	
	private long id_produit;
	private String designation;
	private int qte;
	private double prix;
	private LocalDate date;
	
	
	public Long getId_produit() {
		return id_produit;
	}
	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return  id_produit + designation + qte + prix+ date;
	}
	public Produit(long id_produit,String designation,int qte,double prix,LocalDate date) {
		
		this.id_produit=id_produit;
		this.designation=designation;
		this.qte=qte;
		this.prix=prix;
		this.date=date;

	}
	
	
	

}