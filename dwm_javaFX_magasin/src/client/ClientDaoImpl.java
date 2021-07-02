package client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.AbstractDAO;

public class ClientDaoImpl extends AbstractDAO implements IClientDAO {

	@Override
	public void add(Client obj) {
		PreparedStatement pst=null;
		String query="insert into client (nom,prenom,tel,email) values(?,?,?,?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getPrenom());
			pst.setString(3, obj.getTel());
			pst.setString(4,obj.getEmail());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Client obj) {
		PreparedStatement pst=null;
		String query="UPDATE client set nom=?,prenom=?,tel=?,email=? WHERE id_client=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getPrenom());
			pst.setString(3, obj.getTel());
			pst.setString(4,obj.getEmail());
			pst.setLong(5, obj.getId_client());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		
		PreparedStatement pst=null;
		ResultSet rs;
		String query="delete from client where id_client =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Client getOne(long id) {
		List<Client> list =new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from client where id_client =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Client(rs.getLong("id_client"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Client> getAll() {
		
		List<Client> list =new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from client";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				
				list.add(new Client(rs.getLong("id_client"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	@Override
	public List<Client> getAll(String text) {
		List<Client> list =new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from client where nom like ?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, text+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Client(rs.getLong("id_client"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
	

}
