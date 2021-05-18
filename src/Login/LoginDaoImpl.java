package Login;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ListeClients;
import application.Main;
import client.Client;
import connection.AbstractDAO;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import produit.Produit;

public class LoginDaoImpl extends AbstractDAO implements ILoginDAO{

	@Override
	public String getOne(String user,String password) {
		Login l =new Login();
		List<Client> list =new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from login where admin=? and password=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if (rs.next()) {
				l.isLogin=true;
            } 
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	
}
