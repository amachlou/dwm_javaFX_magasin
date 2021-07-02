package User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.Client;
import interfaces.ListeClients;
import interfaces.Main;
import javafx.stage.Stage;

public class LoginHandler {
	
	Main main=null;
	LoginDaoImpl pdao=new LoginDaoImpl();
	ListeClients listClient;
	
	public LoginHandler(Main main) {
		this.main=main;
	}
	

	public void login(Stage window) {
		Login l =new Login();
		List<Client> list =new ArrayList<Client>();
		String user=main.userInput.getText();
		String password=main.passwordInput.getText();
		pdao.getOne(user, password);
		if(l.isLogin) {
			listClient=new ListeClients();
			window.close();
		}
	
		
		
	}

}
