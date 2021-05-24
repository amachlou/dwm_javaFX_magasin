package vente;

import java.time.LocalDate;

public class Vente {
	
	private long id_vente;
	private LocalDate date;
	private double total;
	private long id_client;
	public static boolean isAdded=false;
	
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public long getId_client() {
		return id_client;
	}
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}
	
	
	public Vente(long id_vente, LocalDate date, double total,long id_client) {
		super();
		this.id_vente = id_vente;
		this.date = date;
		this.total = total;
		this.id_client=id_client;
	}
	@Override
	public String toString() {
		return id_vente +""+ date +  total +  id_client ;
	}
	
	
	
	

}
