package Paiement;

import java.time.LocalDate;

public class Paiement {
	
	private long id_paiement;
	private String type;
	private double montant;
	private double total_paye;
	private double reste;
	private int num_cheque;
	private String proprietaire;
	private String banque;
	private long id_vente;
	private LocalDate date;
	public long getId_paiement() {
		return id_paiement;
	}
	public void setId_paiement(long id_paiement) {
		this.id_paiement = id_paiement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getTotal_paye() {
		return total_paye;
	}
	public void setTotal_paye(double total_paye) {
		this.total_paye = total_paye;
	}
	public double getReste() {
		return reste;
	}
	public void setReste(double reste) {
		this.reste = reste;
	}
	public int getNum_cheque() {
		return num_cheque;
	}
	public void setNum_cheque(int num_cheque) {
		this.num_cheque = num_cheque;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public long getId_vente() {
		return id_vente;
	}
	public void setId_vente(long id_vente) {
		this.id_vente = id_vente;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Paiement(long id_paiement, LocalDate date, String type, double montant, double total_paye, double reste, int num_cheque,
			String proprietaire, String banque, long id_vente) {
		super();
		this.id_paiement = id_paiement;
		this.type = type;
		this.montant = montant;
		this.total_paye = total_paye;
		this.reste = reste;
		this.num_cheque = num_cheque;
		this.proprietaire = proprietaire;
		this.banque = banque;
		this.id_vente = id_vente;
		this.date = date;
	}
	@Override
	public String toString() {
		return id_paiement + type + montant + total_paye + reste + num_cheque + proprietaire+ banque + id_vente + date;
	}
	
	

}




