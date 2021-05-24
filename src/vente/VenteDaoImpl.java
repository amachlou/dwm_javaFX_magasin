package vente;

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

public class VenteDaoImpl extends AbstractDAO implements IVenteDAO{

	@Override
	public void add(Vente obj) {
		
		PreparedStatement pst=null;
		String query="insert into vente (date,total,id_client) values(?,?,?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(1,date);
			pst.setDouble(2, obj.getTotal());
			pst.setLong(3, obj.getId_client());
			int rowsInserted =pst.executeUpdate();
			if (rowsInserted == 1) {
				obj.isAdded=true;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Vente obj) {
		PreparedStatement pst=null;
		String query="UPDATE vente set date=?,total=?,id_client=?  WHERE id_vente=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(1,date);
			pst.setDouble(2, obj.getTotal());
			pst.setLong(3, obj.getId_client());
			pst.setLong(4, obj.getId_vente());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String query="delete from vente where id_vente =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Vente getOne(long id) {
		List<Vente> list =new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from vente where id_vente =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Date date =rs.getDate("date");
				return new Vente(rs.getLong("id_vente"),date.toLocalDate(),rs.getDouble("total"),rs.getLong("id_client"));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Vente> getAll() {
		List<Vente> list =new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from vente";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Vente(rs.getLong("id_vente"),date.toLocalDate(),rs.getDouble("total"),rs.getLong("id_client")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public List<Vente> getAll(String text) {
		List<Vente> list =new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from vente where nom like ?";
//		(select * from vente v,client c where v.id_client=c.id_client and date BETWEEN '5/5/2008' and '4/4/2008' or c.nom like 'mohamed' or id_vente=1)
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, text+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Vente(rs.getLong("id_vente"),date.toLocalDate(),rs.getDouble("total"),rs.getLong("id_client")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
}
