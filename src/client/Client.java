package client;


public class Client {
	
	private long id_client;
	private String nom;
	private String prenom;
	private String tel;
	private String email;

	public long getId_client() {
		return id_client;
	}
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return  id_client + nom + prenom + tel + email;
	}
	public Client(long id_client, String nom, String prenom, String tel, String email) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		
	} 
	
	
	



	
}
