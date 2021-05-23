package client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.GestionVentes;
import application.ListeClients;
import application.ListeClients;
import javafx.scene.control.Label;

public class ClientHandler {
	
	ListeClients listClient=null;
	IClientDAO pdao=new ClientDaoImpl();

	public ClientHandler(ListeClients listClient) {
		this.listClient=listClient;
	}
	
	public void updateListClients() {
		
		
		List<Client> list=pdao.getAll();
		listClient.clientObservableList.addAll(list);

	}
	
	
	public void addClick() {
		
		String nom=listClient.NomInput.getText();
		String prenom=listClient.PrenomInput.getText();
		String tel=listClient.TelInput.getText();
		String email=listClient.EmailInput.getText();
		Client c=new Client(0,nom,prenom,tel,email);
		pdao.add(c);
		
	}
	
	public void remove() {
	
	Client p = listClient.clientList.getSelectionModel().getSelectedItem();
	long id=p.getId_client();
	pdao.delete(id);
	}

	public void selectItem() {
		Client c = listClient.clientList.getSelectionModel().getSelectedItem();
		long id=c.getId_client();
		String nom=c.getNom();
		String prenom=c.getPrenom();
		String tel=c.getTel();
		String email=c.getEmail();
		
		listClient.lblIdClient.setText(id+"");
		listClient.NomInput.setText(nom);
		listClient.PrenomInput.setText(prenom);
		listClient.TelInput.setText(tel);
		listClient.EmailInput.setText(email);
		
	}
	public void modify() {
		
		String id=listClient.lblIdClient.getText();
		String nom=listClient.NomInput.getText();
		String prenom=listClient.PrenomInput.getText();
		String tel=listClient.TelInput.getText();
		String email=listClient.EmailInput.getText();
		Client c=new Client(0,nom,prenom,tel,email);
		pdao.update(c);
		
	}
	
	public void search() {
		
		String designation=listClient.rechercheInput.getText();
		List<Client> list=pdao.getAll(designation);
		listClient.clientObservableList.addAll(list);
		
	}
	

}
