package vente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.ListeClients;
import application.Main;
import client.Client;
import connection.AbstractDAO;
import javafx.scene.control.DatePicker;
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
	
	public List<Vente> getAllVente() {
		List<Vente> list =new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select v.id_vente,CONCAT(c.prenom, ' ', c.nom) as name,v.id_client,v.date,v.total,p.total_paye,p.reste from vente v ,client c ,paiement p where v.id_client=c.id_client";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Vente(rs.getLong("id_vente"),rs.getString("name"),date.toLocalDate(),rs.getDouble("total"),rs.getDouble("total_paye"),rs.getDouble("reste"),rs.getLong("id_client")));
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
	


	@Override
	public List<Vente> searchVente(long id_vente, String nom, Date date1, Date date2) {
		List<Vente> list =new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select DISTINCT v.id_vente,c.nom,v.id_client,v.date,v.total,p.total_paye,p.reste from vente v ,client c ,paiement p where (c.id_client=v.id_client) and (v.id_vente=? and c.nom=? and v.date BETWEEN ? and ?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1,id_vente);
			pst.setString(2, nom);
			pst.setDate(3, date1);
			pst.setDate(4, date2);
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Vente(rs.getLong("id_vente"),rs.getString("nom"),date.toLocalDate(),rs.getDouble("total"),rs.getDouble("total_paye"),rs.getDouble("reste"),rs.getLong("id_client")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
}
